package com.payconiq.assignment.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.payconiq.assignment.stock.model.Stock;

/**
 * The Stock repository for the application.
 * @author rtbrt2009@gmail.com
 *
 */

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer>{

}
