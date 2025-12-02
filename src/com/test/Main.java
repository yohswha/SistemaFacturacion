package com.test;

import com.cliente.Cliente;
import com.conexion.ConnectionSql;

public class Main {

	public static void main(String[] args) {
		ConnectionSql dao=new ConnectionSql();
		Cliente cliente=new Cliente(83,"Jorge","Castro","Calle 5 #20","Barahona","H");
		dao.add(cliente);
	//	dao.Delete();
	//	dao.Update(32);
		
		dao.GetAll();

	}

}
