package it.unibo.oop.jcf.ex4;

import java.util.TreeSet;
import java.util.Set;

import it.unibo.oop.jcf.ex3.Product;
import it.unibo.oop.jcf.ex3.WarehouseImpl;

public class OrderWarehouse extends WarehouseImpl{
	
	@Override
	public Set<Product> allProducts(){
		Set<Product> products = new TreeSet<>();
		products.addAll(super.allProducts()); 
		
		return products;
	}
}
