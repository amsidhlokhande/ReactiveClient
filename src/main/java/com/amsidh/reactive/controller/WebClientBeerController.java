package com.amsidh.reactive.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amsidh.reactive.model.Beer;
import com.amsidh.reactive.service.WebClientService;

import lombok.AllArgsConstructor;
import lombok.Data;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Data
@AllArgsConstructor
@RestController
@RequestMapping("/beers")
public class WebClientBeerController {

	private final WebClientService webClientService;

	@GetMapping
	public Flux<Object> allBears() {
		return this.webClientService.getBeers();
	}

	@GetMapping("/{beerId}")
	public Mono<Beer> getBeerById(@PathVariable String beerId) {
		return this.webClientService.getBeerById(beerId);
	}
}
