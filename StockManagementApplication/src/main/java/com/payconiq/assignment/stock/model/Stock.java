package com.payconiq.assignment.stock.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import static com.payconiq.assignment.stock.config.DBConstants.COLUMN_NAME_IDENTIFIER_ID;
import static com.payconiq.assignment.stock.config.DBConstants.COLUMN_NAME_IDENTIFIER_NAME;
import static com.payconiq.assignment.stock.config.DBConstants.COLUMN_NAME_IDENTIFIER_CURRENTPRICE;
import static com.payconiq.assignment.stock.config.DBConstants.COLUMN_NAME_IDENTIFIER_LASTUPDATE;

/**
 * Stock Entity class for storage of stock data in Repository
 ** @author rtbrt2009@gmail.com
 */

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({ "id", "name", "currentPrice", "lastUpdate" })
public class Stock {
	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = COLUMN_NAME_IDENTIFIER_ID)
	@NotNull
    private int id;
    
    @Column(name = COLUMN_NAME_IDENTIFIER_NAME, nullable = false)
    private String name;
    
    @Column(name = COLUMN_NAME_IDENTIFIER_CURRENTPRICE)
    private double currentPrice; 
    
    @Column(name = COLUMN_NAME_IDENTIFIER_LASTUPDATE)
    private String lastUpdate;

}
