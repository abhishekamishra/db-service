package com.test.dbservice.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.dbservice.entity.Quotes;
import com.test.dbservice.model.QuotesModel;
import com.test.dbservice.repository.QuotesRepository;

@RestController
@RequestMapping("/rest/db")
public class DBServiceResource {

	@Autowired
	private QuotesRepository quotesRepository;

	@GetMapping("/{username}")
	List<String> getQuotes(@PathVariable("username") final String userName) {

		return getQuotesByUserName(userName);
	}

	List<String> getQuotesByUserName(@PathVariable("username") final String userName) {

		return quotesRepository.findByUserName(userName).stream().map(quote -> quote.getQuote())
				.collect(Collectors.toList());
	}

	@PostMapping("/add")
	public List<String> add(@RequestBody final QuotesModel quotesModel) {

		quotesModel.getQuotes().stream().map(quote -> new Quotes(quotesModel.getUserName(), quote))
				.forEach(quote -> quotesRepository.saveAndFlush(quote));

		return getQuotesByUserName(quotesModel.getUserName()+" added.");
	}
	
	@PostMapping("/{username}")
	List<String> deleteQuotes(@PathVariable("username") final String userName) {

		List<String> quotes = getQuotesByUserName(userName);
//		quotesRepository.delete(quotes);
		return getQuotesByUserName(userName+" deleteed.");
	}
}
