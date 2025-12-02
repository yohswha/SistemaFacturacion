package com.conexion;

import com.cliente.Cliente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ConnectionSql {

	String url = "jdbc:sqlserver://DESKTOP-KJ1MTKH\\SQLEXPRESS:1433;"
			+ "databaseName=Almacenes;"
			+ "integratedSecurity=true;"+"encrypt=true;"
			+ "trustServerCertificate=true;";

	public void add(Cliente cliente) {

		String sqlQuery="INSERT INTO CLIENTES(Codigo,nombres,apellidos,direccion,provincia,genero)"+"VALUES(?,?,?,?,?,?)";
		try {

		Connection conn =DriverManager.getConnection(url);
		PreparedStatement stmt =conn.prepareStatement(sqlQuery);
		
		stmt.setInt(1, cliente.getCodigo());
		stmt.setString(2, cliente.getNombre());
		stmt.setString(3, cliente.getApellido());
		stmt.setString(4, cliente.getDireccion());
		stmt.setString(5,cliente.getProvincia());
		stmt.setString(6, cliente.getGenero());
		
		stmt.execute();
		System.out.println("Cliente Agregado exitosamente"+cliente.getNombre());
		}catch(Exception e) {e.printStackTrace();
		}
	}
	public void put(Cliente newCliente) {
		
		String sql="UPDATE CLIENTES SET Nombres=?,Apellidos=?, Direccion=?,Provincia=?,Genero=? WHERE Codigo=?";
		try {
			Connection conn=DriverManager.getConnection(url);
			PreparedStatement stmt=conn.prepareStatement(sql);
			stmt.setString(1, newCliente.getNombre());
			stmt.setString(2, newCliente.getApellido());
			stmt.setString(3, newCliente.getDireccion());
			stmt.setString(4, newCliente.getProvincia());
			stmt.setString(5, newCliente.getGenero());
			stmt.setInt(6, newCliente.getCodigo());
			
			int rowsAffected=stmt.executeUpdate();
			if(rowsAffected==1) {
				System.out.println("Cliente actualizado exitosamente!");

			}
			else {System.out.println("Cliente no encontrado!\n :(");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void delete(Cliente cliente) {
		String sql="DELETE FROM CLIENTES WHERE CODIGO =?";
		try {
			Connection conn =DriverManager.getConnection(url);
			PreparedStatement stmt=	conn.prepareStatement(sql);
			stmt.setInt(1, cliente.getCodigo());
			int rowsAffected=stmt.executeUpdate();
			
			if(rowsAffected>0) {System.out.println("Registro Eliminado con exito!");}
			else {System.out.println("Codigo no encontrado");}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public void GetAll() {
	try {
		
		Connection conn =DriverManager.getConnection(url);
		//Execute query
		Statement stmt=conn.createStatement();
		ResultSet rs =stmt.executeQuery("SELECT TOP 10 * FROM DBO.CLIENTES");

		while(rs.next()) {
			System.out.println("ID:"+ rs.getInt("Codigo")+"Nombres:"+rs.getString("Nombres")+"Apellidos:"+rs.getString("Apellidos"));
		}

		//Close Connection
		conn.close();
	}catch(Exception e){
		e.printStackTrace();
	}
}
}

