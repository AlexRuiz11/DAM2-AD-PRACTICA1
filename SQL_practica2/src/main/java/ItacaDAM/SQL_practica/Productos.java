package ItacaDAM.SQL_practica;

public class Productos {

	
	
	 private String  nombre; 
	
	 private String  dimensiones; 
	 private String  proveedor; 
	 private String  descripcion; 
	 private int  cantidad_en_stock; 
	 private int  precio_venta; 
	 private int  precio_proveedor;
	public Productos( String nombre,  String dimensiones, String proveedor,
			String descripcion, int cantidad_en_stock, int precio_venta, int precio_proveedor) {
		super();
	
		this.nombre = nombre;
		
		this.dimensiones = dimensiones;
		this.proveedor = proveedor;
		this.descripcion = descripcion;
		this.cantidad_en_stock = cantidad_en_stock;
		this.precio_venta = precio_venta;
		this.precio_proveedor = precio_proveedor;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDimensiones() {
		return dimensiones;
	}
	public void setDimensiones(String dimensiones) {
		this.dimensiones = dimensiones;
	}
	public String getProveedor() {
		return proveedor;
	}
	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getCantidad_en_stock() {
		return cantidad_en_stock;
	}
	public void setCantidad_en_stock(int cantidad_en_stock) {
		this.cantidad_en_stock = cantidad_en_stock;
	}
	public int getPrecio_venta() {
		return precio_venta;
	}
	public void setPrecio_venta(int precio_venta) {
		this.precio_venta = precio_venta;
	}
	public int getPrecio_proveedor() {
		return precio_proveedor;
	}
	public void setPrecio_proveedor(int precio_proveedor) {
		this.precio_proveedor = precio_proveedor;
	}
	 
	 

	
	

	@Override
	public String toString() {
		return  "nombre='" + nombre + "'" +  ", dimensiones='" + dimensiones + "', proveedor='" + proveedor + "', descripcion='" + descripcion
				+ "', cantidad_en_stock=" + cantidad_en_stock + ", precio_venta=" + precio_venta + ", precio_proveedor="
				+ precio_proveedor + "";
	}
	
	  // UPDATE producto SET codigo_producto = 'Alfred Schmidt', nombre= 'Frankfurt', gama = 'Elpepe', dimensiones= '5', proveedor = 'Yo',descripcion = 'Muy', cantidad_en_stock= '45', precio_venta= '456', precio_proveedor= '200';										

	
}
