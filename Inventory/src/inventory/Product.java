package inventory;

public class Product {
	
	//instancias a usar
	
	private int numelemento;
	private String Producto;
	private int existencia;
	private double precio;
	private boolean estado=true;
	
	public Product() {
		super();
	}

	public Product(int number, String name, int qty, double price) {
		super();
		this.numelemento = number;
		this.Producto = name;
		this.existencia = qty;
		this.precio = price;
	}
	
	

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public int getNumelemento() {
		return numelemento;
	}

	public void setNumelemento(int numelemento) {
		this.numelemento = numelemento;
	}

	public String getProducto() {
		return Producto;
	}

	public void setProducto(String producto) {
		Producto = producto;
	}

	public int getExistencia() {
		return existencia;
	}

	public void setExistencia(int existencia) {
		this.existencia = existencia;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	//seccion5
	public double value() {
		return precio * existencia;
	}
	
	public void addToInventory(int cantidad) {
		this.existencia += cantidad;
	}
	public void deductFromInventory(int cantidad) {
		this.existencia -= cantidad;
	}
	
	

	@Override
	public String toString() {
		return "Item number: " + numelemento + "\nName: " + Producto + "\nQuantity in stock: " + existencia
				+ "\nPrice: " + precio + "\nProduct Status: " + (this.estado ? "Active" : "Discontinued") + "\nProduct Status: " + this.value() ;
	}

	
	
	

}
