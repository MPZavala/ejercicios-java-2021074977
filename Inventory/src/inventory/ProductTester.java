package inventory;

import java.util.Scanner;

public class ProductTester {

	public static void main(String[] args) {
		
		//seccion6
		Scanner in = new Scanner(System.in);
		int maxSize = -1, menuChoice;
		
		
		maxSize=getNumProducts(in);
		if(maxSize ==0) {
			System.out.println("No se requieren productos");
		} else {
			Product products[] = new Product[maxSize];
			addToInventory(products,in);
			do {
				menuChoice = getMenuOption(in);
				executeMenuChoice(menuChoice, products, in);
			} while (menuChoice!=0);
		}
		/*Seccion6
		
		do {
			try {
				System.out.print("¿Cuántos items desea ingresar? Si no desea agregar productos ingrese un 0 (cero) ");
				maxSize = in.nextInt();
				
				if (maxSize < 0) {
					System.out.println("El valor introducido es incorrecto");
					
				} else {
					Product products[] = new Product[maxSize];
					
					addToInventory(products, in);
					
					getMenuOption(in);
					
					
				}
				
			} catch (Exception e) {
				System.out.println("El tipo de dato introducido es incorrecto");
				in.next();
				
			}
			
		}
		while (maxSize != 0);
		System.out.println("No se requieren productos");
		final seccion 6 */
		
		/*seccion4
		Product producto1 = new Product(1,"Reproductor DVD",30,109.80);
		Product producto2 = new Product();
		Product producto3 = new Product();
		Product producto4 = new Product(4,"Tostador",76,89.95);
		Product producto5 = new Product(5,"Televisor",103,1299.99);
		Product producto6 = new Product(6,"Molino de café",60,85.15);
		
		
		
		
		producto2.setNumelemento(2);
		producto2.setProducto("Ventilador de mesa");
		producto2.setExistencia(46);
		producto2.setPrecio(78.50);
		producto3.setNumelemento(3);
		producto3.setProducto("Telefono inalámbrico");
		producto3.setExistencia(15);
		producto3.setPrecio(200.00);*/
		
		/*seccion5
		System.out.println("Por favor, ingrese la información del producto:");
		System.out.print("Nombre del producto: ");
		tempName = in.next();
		System.out.print("Valor del producto: ");
		tempPrice = in.nextDouble();
		System.out.print("Número del producto: ");
		tempNumber = in.nextInt();
		System.out.print("Cantidad de producto en stock: ");
		tempQty = in.nextInt();*/
		
		/*seccion5
		Product producto7 = new Product(tempNumber,tempName,tempQty,tempPrice);*/
		
		/*seccion5
		in.nextLine();
		System.out.println("Por favor, ingrese la información de un segundo producto:");
		System.out.print("Nombre del producto: ");
		tempName = in.next();
		System.out.print("Valor del producto: ");
		tempPrice = in.nextDouble();
		System.out.print("Número del producto: ");
		tempNumber = in.nextInt();
		System.out.print("Cantidad de producto en stock: ");
		tempQty = in.nextInt();
		Product producto8 = new Product(tempNumber,tempName,tempQty,tempPrice);
		in.close();
		producto6.setEstado(false);*/
		
		/*seccion4
		System.out.println("\n"+producto1+"\n");
		System.out.println(producto2+"\n");
		System.out.println(producto3+"\n");
		System.out.println(producto4+"\n");
		System.out.println(producto5+"\n");
		System.out.println(producto6+"\n");*/
		
		/*seccion5
		System.out.println(producto7+"\n");
		System.out.println(producto8+"\n");*/

	}
	
	static void DisplayInventory (Product[] products) {
		for (Product product:products)
			System.out.println("\n"+product);
	}
	
	static void addToInventory(Product[] products, Scanner in) {
		
		//seccion5
				String tempName;
				int tempNumber, tempQty;
				double tempPrice;
				
		for(int i = 0; i<products.length; i++) {
			//in.next();
			System.out.print("Nombre del producto " + (i+1) +": ");
			tempName = in.next();
			System.out.print("Valor del producto " + (i+1) +": ");
			tempPrice = in.nextDouble();
			System.out.print("Número del producto " + (i+1) +": ");
			tempNumber = in.nextInt();
			System.out.print("Cantidad de producto " + (i+1) +" en stock: ");
			tempQty = in.nextInt();
			System.out.println("");
			
		
			products[i]= new Product(tempNumber,tempName,tempQty,tempPrice);
		}
	}
	
	static int getNumProducts(Scanner in) {
		int maxSize=-1;
		
		try {
			System.out.print("¿Cuántos items desea ingresar? Si no desea agregar productos ingrese un 0 (cero) ");
			maxSize = in.nextInt();
			
			if (maxSize < 0) {
				System.out.println("El valor introducido es incorrecto");
				
			}
			
		} catch (Exception e) {
			System.out.println("El tipo de dato introducido es incorrecto");
			in.next();
			
		}
		return maxSize;
	}
	
	static int getMenuOption(Scanner in) {
		
		int menuChoice=-1;
		
		do {
			try {
				System.out.println("\nIngrese el numero de una de las siguientes opciones\n1.Ver Inventario\n2. Añadir producto\n3. Deducir producto\n4. Descontinuar producto\n0. Salir");
				menuChoice=in.nextInt();
			
			}
			catch(Exception e) {
				System.out.println(e);
				in.nextLine();
			}
		}
		while (menuChoice<0 || menuChoice>4);
		return menuChoice;
	}
	
	static int getProductNumber(Scanner in, Product[] products) {
		int cantidadProducto = -1;
		
		//for (int i=0; i<products.length;i++) {
			//System.out.println(products[i].getProducto());
			do {
				try {
					in.nextLine();
					System.out.println("\nIngrese el # del producto a actualizar");
					cantidadProducto = in.nextInt();
					if (cantidadProducto<0 /*|| cantidadProducto>products.length-1*/) {
						System.out.println("\nSolo se pueden ingresar numeros mayores a 0 (cero)");
					} else {
						for (int i=0; i<products.length;i++) {
							if (cantidadProducto==products[i].getNumelemento()){
								System.out.println("\nEl producto a actualizar es el #"+products[i].getNumelemento() +" - "+products[i].getProducto());
								cantidadProducto=i;
								i=products.length;
							} else if (cantidadProducto!=products[i].getNumelemento() && i==products.length){
								System.out.println("\nNumero de producto no encontrado");
								
							}
						}
					}
					
					} catch(Exception e) {
					
				}
			}
			while(cantidadProducto<0 /*|| cantidadProducto>products.length-1*/);
		//}
		return cantidadProducto;
	}
	
	static void addInventory(Product[] products, Scanner in) {
		int productChoice, updateValue =-1;
		
		productChoice = getProductNumber(in, products);
		System.out.println("\n¿Cuántos productos quiere agregar?");
		updateValue=in.nextInt();
		if (updateValue>0) {
			products[productChoice].addToInventory(updateValue);
			System.out.println("\nSu inventario ha sido actualizado");
		} else {
			System.out.println("\nEl valor ingresado es inválido");
		}
		
	}
	
	static void removeInventory(Product[] products, Scanner in) {
		int productChoice, updateValue =-1;
		
		productChoice = getProductNumber(in, products);
		System.out.println("\n¿Cuántos productos quiere remover?");
		updateValue=in.nextInt();
		if (updateValue>0 && updateValue<=products[productChoice].getExistencia()) {
			products[productChoice].deductFromInventory(updateValue);
			System.out.println("\nSu inventario ha sido actualizado");
		} else {
			System.out.println("\nEl valor ingresado es inválido");
		}
		
	}
	
	static void discontinueInventory(Product[] products, Scanner in) {
		int productChoice;
		
		productChoice = getProductNumber(in, products);
		products[productChoice].setEstado(false);
		System.out.println("\nEl producto se ha modificado");
	}
	
	static void executeMenuChoice(int menuChoice, Product[] products, Scanner in) {
		switch(menuChoice) {
		case(1):
			DisplayInventory(products);
			break;
		case(2):
			addInventory(products,in);
			break;
		case(3):
			removeInventory(products,in);
			break;
		case(4):
			discontinueInventory(products,in);
			break;
		
		}
	}

}
