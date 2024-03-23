package cfprog;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public  class GenerateInfoFiles {
	static List<Product> listProducts = new ArrayList();
	static List<Sale> listSale = new ArrayList();
	static List<Seller> listSellers = new ArrayList();
	static String PathFiles ="files/";
	
	public static void main(String[] args) throws IOException {
		
		
		CreateDataSeller(5);
		CreateDataProduct();
		CreateDataSale();
		
	}

	
	public static  void CreateDataSeller(int records) throws FileNotFoundException, UnsupportedEncodingException {

		String[] names = { "Andrea", "David", "Baldomero", "Balduino", "Baldwin", "Baltasar", "Barry", "Bartolo",
				"Bartolomé", "Baruc", "Baruj", "Candelaria", "Cándida", "Canela", "Caridad", "Carina", "Carisa",
				"Caritina", "Carlota", "Baltazar"};
		String[] lastNames = { "Gomez", "Guerrero", "Cardenas", "Cardiel", "Cardona", "Cardoso", "Cariaga", "Carillo",
				"Carion", "Castiyo", "Castorena", "Castro", "Grande", "Grangenal", "Grano", "Grasia", "Griego",
				"Grigalva" };
		
		Random rnd = new Random();

		try {
	        for (int i = 0; i < records; i++) {            
	        	int numberRandom = 10000000 + rnd.nextInt(90000000);         
	        	Seller seller = new Seller();
	        	seller.TipoDocumento="CC";
	        	seller.NumeroDocumento= Integer.toString(numberRandom);
	        	seller.NombreVendedor=names[rnd.nextInt(names.length)];
	        	seller.ApellidoVendedor=lastNames[rnd.nextInt(lastNames.length)];
	        	listSellers.add(seller);
	          
	        }	   
		  	  	    
		    File file = new File(PathFiles+"Sellers.csv");
		    FileOutputStream outPutFile = new FileOutputStream(file); 
		    PrintWriter writer = new PrintWriter(new OutputStreamWriter(outPutFile, "Windows-1252"));
	
	        for (int i = 0; i < listSellers.size(); i++) {
	             String line = listSellers.get(i).TipoDocumento.toString()+";"+listSellers.get(i).NumeroDocumento.toString()+";"+
	            		 listSellers.get(i).NombreVendedor.toString()+";"+listSellers.get(i).ApellidoVendedor.toString()+'\n';
	             writer.print(line);
	             writer.flush(); 
	        }
	        writer.close();
	        
	        System.out.println("File Sellers Generated Successfully!!!");
		} 
		catch (Exception ex) {
            System.out.println("File Sellers: One or more errors were found, MSGERROR: "+ex.getMessage());
        }
	}
	
	public static  void CreateDataProduct() throws FileNotFoundException, UnsupportedEncodingException {
		
		String[] nameProduct= { "Cable Red", "USB 32GB", "USB 64GB", "Base Refrigerante", "Cable USB", "Disco SSD 1 TB", "Celular Xiaomi 13T",
				"Multifuncional HP 334", "Disco SSD 2 TB", "Vacuum Xiaomi"};
		int [] price = { 10000, 20000, 30000, 40000, 15000, 200000, 1600000, 750000,250000,1000000};
		
		Random rnd = new Random();

		try {
	        for (int i = 0; i < 10; i++) {            
	        	   
	        	Product product = new Product();
	        	product.IdProducto = i+1;
	        	product.NombreProducto = nameProduct[i];
	        	product.PrecioUnidad = price[i];	        
	        	listProducts.add(product);
	          
	        }	   
		  	  	     
		    File file = new File(PathFiles+"Products.csv");
		    FileOutputStream outPutFile = new FileOutputStream(file); 
		    PrintWriter writer = new PrintWriter(new OutputStreamWriter(outPutFile, "Windows-1252"));
	
	        for (int i = 0; i < listProducts.size(); i++) {
	             String line = listProducts.get(i).IdProducto+";"+listProducts.get(i).NombreProducto.toString()+";"+
	            		 listProducts.get(i).PrecioUnidad+'\n';
	             writer.print(line);
	             writer.flush(); 
	        }
	        writer.close();
	        
	        System.out.println("File Products Generated Successfully!!!");
		} 
		catch (Exception ex) {
            System.out.println("File Products: One or more errors were found, MSGERROR: "+ex.getMessage());
        }
	}
	
	public static  void CreateDataSale() throws FileNotFoundException, UnsupportedEncodingException {
		
		int [] quantity = { 5, 7, 4, 10, 2, 6, 8, 20,12,2};
		
		Random rnd = new Random();

		try {
	        for (int i = 0; i < 10; i++) {            
	        	   
	        	Sale sale = new Sale();	        	
	        	sale.Cantidad = quantity[i];	        
	        	listSale.add(sale);
	          
	        }	   
		  	  	     
		    File file = new File(PathFiles+"Sales.csv");
		    FileOutputStream outPutFile = new FileOutputStream(file); 
		    PrintWriter writer = new PrintWriter(new OutputStreamWriter(outPutFile, "Windows-1252"));
		    
		    for (int i = 0; i < listSellers.size(); i++) {
	             String line = listSellers.get(i).TipoDocumento.toString()+";"+listSellers.get(i).NumeroDocumento.toString()+'\n';
	             writer.print(line);
	             writer.flush(); 
	             for (int j = 0; j < listProducts.size(); j++) {
		             String linesale = listProducts.get(j).IdProducto+";"+listSale.get(j).Cantidad+'\n';		            		 
		             writer.print(linesale);
		             writer.flush(); 
		        }
	        }
	
	        
	        writer.close();
	        
	        System.out.println("File Sales Generated Successfully!!!");
		} 
		catch (Exception ex) {
            System.out.println("File Sales: One or more errors were found, MSGERROR: "+ex.getMessage());
        }
	}
	
	
	public static  class Seller {
		String TipoDocumento;
	  	String NumeroDocumento;
	  	String NombreVendedor;
	  	String ApellidoVendedor;
	}
	
	public static  class  Product {
		int IdProducto;
		String NombreProducto;
		int PrecioUnidad;		
	}
	
	public static  class  Sale {
		int Cantidad;		
	}

}
