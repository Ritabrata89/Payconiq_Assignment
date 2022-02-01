package com.payconiq.assignment.stock.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import static com.payconiq.assignment.stock.config.DBConstants.ID;
import static com.payconiq.assignment.stock.config.DBConstants.NAME;
import static com.payconiq.assignment.stock.config.DBConstants.CURRENTPRICE;
import static com.payconiq.assignment.stock.config.DBConstants.LASTUPDATE;

/**
 * Stock Entity class for storage of stock data in Repository
 ** @author rtbrt2009@gmail.com
 */

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Stock {
	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = ID)
    private int id;
    
    @Column(name = NAME, nullable = false)
    private String name;
    
    @Column(name = CURRENTPRICE)
    private double currentPrice; 
    
    @Column(name = LASTUPDATE)
    private String lastUpdate;

}
