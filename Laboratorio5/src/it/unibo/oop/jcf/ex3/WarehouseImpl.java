package it.unibo.oop.jcf.ex3;

import java.util.Set;
import java.util.LinkedHashSet;
import java.util.Iterator;

public class WarehouseImpl implements Warehouse {

	/* fields */
	private final Set<Product> products;
	
	/* constructors */
	public WarehouseImpl() {
		this.products = new LinkedHashSet<>();
	}
	
	/* methods */
	public void addProduct(Product p) {
		this.products.add(p);
	}
	
	public Set<String> allNames(){
		Set<String> names = new LinkedHashSet<>();
		Iterator<Product> it = this.products.iterator();
		while (it.hasNext()) {
			names.add(it.next().getName());
		}
		
		return names;
	}
	
	public Set<Product> allProducts(){
		Set<Product> products = new LinkedHashSet<>();
		Iterator<Product> it = this.products.iterator();
		while (it.hasNext()) {
			products.add(it.next());
		}
		
		return products;
	}
	
	public boolean containsProduct(final Product p) {
		return this.products.contains(p);
	}
	
	public double getQuantity(final String name) {
		double quantity = -1;
		Iterator<Product> it = this.products.iterator();
		while (it.hasNext()) {
				Product p = it.next();
				if (p.getName().equals(name)) {
					quantity = p.getQuantity();
				}
			}
		
		return quantity;
	}
}
