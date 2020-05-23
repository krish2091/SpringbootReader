/*
 * Author RamaKrishna
 */
package com.sbr;

import java.io.IOException;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.sbr.datareader.DataReader;
import com.sbr.model.Product;

@SpringBootApplication
public class SpringbootReaderApplication {

	public static void main(String[] args) throws IOException {
		ConfigurableApplicationContext context = SpringApplication.run(SpringbootReaderApplication.class, args);
		DataReader dReader= context.getBean(DataReader.class);
		List<Product> list=dReader.doDataRead();
		
		list.forEach(product -> System.out.println("Product List :"+product.getProductId()+"|"+product.getProductName()+"|"+product.getProductCost()));
	}

}
