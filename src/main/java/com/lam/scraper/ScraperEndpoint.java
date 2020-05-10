package com.lam.scraper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ScraperEndpoint {

	@Autowired
	ScraperService scraperService;

	public static void main(String[] args) {
		SpringApplication.run(ScraperEndpoint.class, args);
	}

	@GetMapping("/autotrader")
	public String autotraderEndpoint(@RequestParam(value = "make") String make,
			@RequestParam(value = "model") String model, @RequestParam(value = "minPrice") Integer minPrice,
			@RequestParam(value = "maxPrice") Integer maxPrice) {

		String autoTraderResponse = scraperService.scrapeAutotrader(make, model, minPrice, maxPrice);

		return autoTraderResponse;
	}
}