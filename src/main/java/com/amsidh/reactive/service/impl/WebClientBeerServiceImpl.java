/**
 * 
 */
package com.amsidh.reactive.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.amsidh.reactive.model.Beer;
import com.amsidh.reactive.service.WebClientService;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author amsid
 *
 */
@Data
@Service
@Slf4j
public class WebClientBeerServiceImpl implements WebClientService {

	@Autowired
	private WebClient webclient;

	@Value("${bear.baseUrl:http://localhost:8080}")
	private String baseUrl;
	@Value("${beer.getbeers:/api/v1/beer}")
	private String getBeersUrl;

	@Override
	public Mono<Beer> getBeerById(String beerId) {
		log.info("Calling rest api through webclient for getting beer by id");
		return webclient.get().uri(baseUrl + getBeersUrl + "/" + beerId).accept(MediaType.APPLICATION_JSON).retrieve()
				.bodyToMono(Beer.class);

	}

	@Override
	public Flux<Object> getBeers() {
		log.info("Calling rest api through webclient for getting all beers");
		return webclient.get().uri(baseUrl + getBeersUrl).accept(MediaType.APPLICATION_JSON).retrieve()
				.bodyToFlux(Object.class);
	}

}
