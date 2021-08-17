package br.estudo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	public static Connection receberConexao() {
		
		Connection con = null;
		
		try {
			con= DriverManager.getConnection("jdbc:mysql://localhost/banco_teste","root","39934314");
		System.out.println("Banco de Dados Conectado com Sucesso!!!");
		} catch (SQLException e) {
			System.err.println("Não foi possivel conectar ao Banco de Dados!!!");
			e.printStackTrace();
		}
		
		return con;
	}
	

}
