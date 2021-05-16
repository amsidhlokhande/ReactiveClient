package com.amsidh.reactive.service;

import com.amsidh.reactive.model.Beer;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface WebClientService {

	Mono<Beer> getBeerById(String beerId);

	Flux<Object> getBeers();
}
