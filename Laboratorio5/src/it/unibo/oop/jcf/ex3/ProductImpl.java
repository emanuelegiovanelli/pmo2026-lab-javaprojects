package it.unibo.oop.jcf.ex3;

import java.util.Objects;

public class ProductImpl implements Product{
	
	/* fields */
	private final String name;
	private double quantity;
	
	/* constructors */
	public ProductImpl(final String name, final double quantity) {
		this.name = name;
		this.quantity = quantity;
	}
	
	/* methods */
	public String getName() {
		return this.name;
	}
	
	public double getQuantity() {
		return this.quantity;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductImpl other = (ProductImpl) obj;
		return Objects.equals(name, other.name);
	}
	
	
}
