package ItacaDAM.SQL_practica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		
 Connection conn = null;
 String laData;
		 
		 try {
			 conn =  DriverManager . getConnection ( "jdbc:mysql://localhost:3306/jardineria?serverTimezone=UTC","admin","4DM1n4DM1n" );
			 Scanner reader = new Scanner(System.in);
			 System.out.println("1-Añadir un cliente" +"\n"+ "2-Buscar un cliente por ID" +"\n"+ "3-Mostrar todos los clientes" +"\n"+ "4-Buscar por NombreCliente, NombreContacto o ApellidoContacto"
			 		+"\n"+ "5-Actualizar un producto" +"\n"+ "0-Para salir");
			 
			 int opcion=0;
			 opcion = reader.nextInt();
			 
			 while(opcion!=0){
				 
			 switch(opcion)
				{
				   
				   case 1 :		
					   
						 
						   laData= "Insert INTO cliente  VALUES"
									+ "(" + AñadeCliente() +");";
					 						   
					
						   Statement stmt3 = conn . prepareStatement (laData);
						   stmt3.executeUpdate(laData);	
						   
						
						
					    break;
				   case 2 :		
					   laData= "select * from cliente where codigo_cliente=' "+ BuscarClienteID() + "';";
					   
					   Statement stmt = conn . prepareStatement (laData);
						 ResultSet resultSet = stmt.executeQuery(laData);
						 
						  while (resultSet.next()) {
						    	 
						    	 String name = resultSet.getString("nombre_cliente");
						    	 System.out.println(name);
						    	 
						    	
						     } 
						
					    break;
				   case 3 :		
					   Statement stmt1 = conn . prepareStatement (MostrarTodosLosClientes());
						 ResultSet resultSet1 = stmt1.executeQuery(MostrarTodosLosClientes());
						 
						 
						  while (resultSet1.next()) {
						    	 
						    	 String name = resultSet1.getString("nombre_cliente");
						    	 System.out.println(name);
						    	 
						    	
						     } 
						
					    break;
					    
					    
				   case 4 :
					   
					   	String ElNombreBuscar = Buscar_Ncliente_Ncontacto_AContacto();
					    stmt1 = conn . prepareStatement (ElNombreBuscar);
						  resultSet1 = stmt1.executeQuery(ElNombreBuscar);
						 
						 
						  while (resultSet1.next()) {
							  
								 int id = resultSet1.getInt("codigo_cliente");
						    	 System.out.print(id +"--> ");
						    	 
						    	 String name = resultSet1.getString("nombre_cliente");
						    	 System.out.println(name);
						    	 
						    	
						     } 
					   
					   break;
					   
				   case 5:
					   
					   
					   String idProducto;
					   System.out.println("Dime el id del producto a modificar: ");
					   idProducto= reader.next();
					  
					 
					   laData= "select * from producto where codigo_producto='"+ idProducto +"';";
					   
					    stmt = conn . prepareStatement (laData);
						  resultSet = stmt.executeQuery(laData);					 
					
						  while (resultSet.next()) { 	 
						    	 String name = resultSet.getString("nombre");
						    	 String dimensiones = resultSet.getString("dimensiones");
						    	 String proveedor = resultSet.getString("proveedor");
						    	 String descripcion = resultSet.getString("descripcion");
						    	 int cantidad_en_stock = resultSet.getInt("cantidad_en_stock");
						    	 int precio_venta = resultSet.getInt("precio_venta");
						    	 int precio_proveedor = resultSet.getInt("precio_proveedor");
						    	 
						  
						    	 Productos unProducto = new Productos(name, dimensiones,proveedor,descripcion,cantidad_en_stock,precio_venta,precio_proveedor);
						  
						  
						    	 
						    	
						     
					   
					   String elDato;
					
					   
				 elDato= "UPDATE producto SET " + ModificarProducto(unProducto)  +" where codigo_producto='"+idProducto +"'; ";

				   stmt3 = conn . prepareStatement (elDato);
					  stmt3.executeUpdate(elDato);	
						  
						  }
					
					   
					   break;
				}
			 
			 System.out.println("1-Añadir un cliente" +"\n"+ "2-Buscar un cliente por ID" +"\n"+ "3-Mostrar todos los clientes" +"\n"+ "4-Buscar por NombreCliente, NombreContacto o ApellidoContacto"
				 		+"\n"+ "5-Actualizar un producto" +"\n"+ "0-Para salir");
			 
			 opcion = reader.nextInt();

		
			 }
			 
		
	      

			 
			
	
		     
		    
		     
		     conn.close();
		     reader.close();
	
		    
		 } catch (SQLException ex) {
		     // handle any errors
		     System.out.println("SQLException: " + ex.getMessage());
		     System.out.println("SQLState: " + ex.getSQLState());
		     System.out.println("VendorError: " + ex.getErrorCode());
		 }
		 
		 
		 
		 
		 
		

	}
	
	public static String AñadeCliente(){
		
		String miDato;
		 Scanner reader = new Scanner(System.in);
			 int codigo_cliente;
			 String  nombre_cliente; 
			 String  nombre_contacto; 
			 String  apellido_contacto; 
			 int  telefono;
			 String  fax;
			 String  linea_direccion1; 
			 String  linea_direccion2; 
			 String  ciudad;
			 String  region;
			 String  pais; 
			 int  codigo_postal; 
			 int  codigo_empleado_rep_ventas;
			 int  limite_credito;
			 
		System.out.println("Vamos a crear un Cliente." +"\n"+" Dame su ID:");
		codigo_cliente = reader.nextInt();
		System.out.println("Dime su nombre:");
		nombre_cliente= reader.nextLine();
		nombre_cliente= reader.nextLine();
		System.out.println("Dime el nombre del contacto");
		nombre_contacto= reader.nextLine();
		System.out.println("Dime el apellido: ");
		apellido_contacto= reader.nextLine();
		System.out.println("Dime tu telefono: ");
		telefono = reader.nextInt();
		System.out.println("Dime tu fax");
		fax= reader.nextLine();
		fax= reader.nextLine();
		System.out.println("Digame su 1ºDirección: " );
		linea_direccion1= reader.nextLine();
		System.out.println("Digame su 2ºDirección: ");
		linea_direccion2= reader.nextLine();
		System.out.println("Digame su  Ciudad: ");
		ciudad= reader.nextLine();
		System.out.println("Digame su Región: ");
		region= reader.nextLine();
		System.out.println("Digame su Pais: ");
		pais= reader.nextLine();
		System.out.println("Digame su codigo postal: ");
		codigo_postal = reader.nextInt();
		System.out.println("Digame el codigo del empleado: ");
		codigo_empleado_rep_ventas = reader.nextInt();
		System.out.println("Digame el limite de credito: ");
		limite_credito = reader.nextInt();

		Cliente unCliente = new Cliente(codigo_cliente, nombre_cliente, nombre_contacto, apellido_contacto, telefono, fax, linea_direccion1, linea_direccion2, ciudad, region, pais, codigo_postal, codigo_empleado_rep_ventas, limite_credito);
	
	

		
		
			return miDato=unCliente.toString();
		
	}
	
	
	public static int BuscarClienteID() {
		System.out.println("Dime el ID del Cliente que quieres buscar");
		 Scanner reader = new Scanner(System.in);
		 int numero=0;
		 numero = reader.nextInt();
		
	
		
		return  numero;
			
	}
	
	public static String MostrarTodosLosClientes() {
		
		String Eldato ="select * from cliente ORDER BY nombre_cliente ASC;";
		
		
		
		return Eldato;
	}
	
	
	public static String Buscar_Ncliente_Ncontacto_AContacto(){
		
		 Scanner reader = new Scanner(System.in);
		 String Nombre;
		String Eldato;
		 System.out.println("Dime el Nombre o apellido: ");		
		 Nombre = reader.next();
		
		 Eldato ="select * from cliente where nombre_cliente='"+ Nombre +"' or nombre_contacto= '"+Nombre+"' or apellido_contacto= '"+Nombre +"'; ";
		return Eldato;
		
	}
	
	public static String ModificarProducto( Productos elProducto ) {
		
		 Scanner reader = new Scanner(System.in);
		
		  String  nombre; 			
		  String  dimensiones; 
		  String  proveedor; 
		  String  descripcion; 
		  int  cantidad_en_stock; 
		  int  precio_venta; 
		  int  precio_proveedor;
		  
		  System.out.println("Dime el nuevo nombre del producto: ");
		  nombre= reader.nextLine();
		  if(nombre.equalsIgnoreCase("")) {
			  
			 nombre= elProducto.getNombre();
		  }
		  System.out.println("Dime las nuevas dimensiones: ");
		  dimensiones= reader.nextLine();
		  if(dimensiones.equalsIgnoreCase("")) {
			  dimensiones=  elProducto.getDimensiones();
			  
		  }
		  System.out.println("Dime el nuevo proveedor: ");
		  proveedor= reader.nextLine();
		
		  if(proveedor.equalsIgnoreCase("")) {
			  
			  proveedor= elProducto.getProveedor();
			  }
		  System.out.println("Dime la nueva descripción: ");
		  descripcion= reader.nextLine();
		  if(descripcion.equalsIgnoreCase("")) {
			  
			  descripcion= elProducto.getDescripcion();
			  }
		  System.out.println("Dime la nueva cantidad de stock(0 para no cambiar nada): ");
		  cantidad_en_stock= reader.nextInt();
		  if(cantidad_en_stock== 0) {
			  cantidad_en_stock=  elProducto.getCantidad_en_stock();
		  }
		  
		  System.out.println("Dime el nuevo precio de venta(0 para no cambiar nada): ");
		  precio_venta= reader.nextInt();
		  if(precio_venta== 0) {
			  precio_venta=  elProducto.getPrecio_venta();
		  }
		  System.out.println("Dime el nuevo precio de proveedor(0 para no cambiar nada): ");
		  precio_proveedor= reader.nextInt();
		  if(precio_proveedor== 0) {
			  precio_proveedor=  elProducto.getPrecio_proveedor();
		  }
		Productos unProducto = new Productos( nombre, dimensiones, proveedor, descripcion, cantidad_en_stock, precio_venta, precio_proveedor);
		
	
		
		
		
		return unProducto.toString();
	}
	
	
	

}
