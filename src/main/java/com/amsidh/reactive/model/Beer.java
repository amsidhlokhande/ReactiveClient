package com.amsidh.reactive.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Beer {
	private String id;
	private String beerName;
	private String beerStyle;
	private String upc;
	private Double price;
	private String quantityOnHand;
	private Date createdDate;
	private Date lastUpdatedDate;
}
