/*
 * Author RK
 */
package com.sbr.datafilter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.sbr.model.Product;

@Component
public class DataFilter {
     /*
      * This Method filter the data based on condition is cost should be below or equal to 3000.
      * this method accepts List as a input
      * this method returns List 
      */
	public List<Product> doDataFilter(List<Product> list) {
		
		return (List) list.stream().filter(product -> product.getProductCost() <= 3000).collect(Collectors.toList());
	}
}
