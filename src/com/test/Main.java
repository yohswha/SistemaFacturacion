package com.test;

import com.cliente.Cliente;
import com.conexion.ConnectionSql;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		Scanner entry=new Scanner(System.in);
		ConnectionSql dao=new ConnectionSql();
		int opt=0;
		System.out.println("Elige que quieres hacer \n 1.Agregar clientes\n 2. Eliminar\n 3. Actualizar \n 4.Ver Clientes = ");
		opt= entry.nextInt();
		Cliente cliente=new Cliente(2,"Jorge","Castro","Calle 5 #20","Barahona","H");
		switch (opt) {
		case 1:
			dao.add(cliente);
		break;
		case 2:
			cliente.setCodigo(3);
			dao.delete(cliente);
		break;
		case 3:
			Cliente infoUpdated=new Cliente(4,"Juana","Castro","Calle 5 #20","Barahona","M");
			dao.put(infoUpdated);
		break;
		case 4: dao.GetAll();
		break;

		}
		entry.close();

		

		

	}

}