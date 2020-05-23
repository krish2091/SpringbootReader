package com.sbr.datareader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*
 * Author RK
 */
import com.sbr.datafilter.DataFilter;
import com.sbr.model.Product;

@Component
public class DataReader {
	
	  @Autowired
      private DataFilter dFilter;
	  
	  /*
	   * This method read the data from text file
	   * store in to list 
	   * call filter method to filter data
	   * returns List
	   */
	  public List<Product> doDataRead() throws IOException {
		  List<Product> list = new ArrayList();
		  
		  FileReader fReader = new FileReader("src/main/resources/products.txt");
		  
		  BufferedReader bReader = new BufferedReader(fReader);
		  
		  String data = bReader.readLine();
		  
		  while(data !=null) {
			  String split[]=data.split(",");
			  Product product = new Product();
			  product.setProductId(Integer.parseInt(split[0]));
			  product.setProductName(split[1]);
			  product.setProductCost(Integer.parseInt(split[2]));
			  
			  list.add(product);
			  data=bReader.readLine();
		  }
		  
		  return dFilter.doDataFilter(list);
	  }
}
