package com.payconiq.assignment.stock.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The Stock DTO class of the application.
 * @author rtbrt2009@gmail.com
 *
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StockDTO {

	private String name;
    private double currentPrice; 
}
