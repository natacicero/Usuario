package br.estudo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.estudo.jdbc.Conexao;
import br.estudo.modelo.Usuario;

public class UsuarioDao {
	
	public void cadastrar(Usuario usuario) {
		
		//1º) Pedir uma conexão com o Banco de Dados
				Connection con = Conexao.receberConexao();
				
				//2º) Colocar o comando SQL dentro de uma String
				String sql = "INSERT INTO usuario(nome,login.senha) VALUES (?,?,?)";
				
				try {
					//3º) Preparar a linha de instrução ou Statement
					PreparedStatement preparador = con.prepareStatement(sql);
					preparador.setString(1, usuario.getNome());
					preparador.setString(2, usuario.getLogin());
					preparador.setString(3, usuario.getSenha());
					
					//4º) Execute a linha preparada no Banco de Dados
					preparador.execute();
					
					//5º) Fechar o Banco de dados
					con.close();
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
		
	}

	public List<Usuario> mostrarTodosUsuarios(){

		

		Connection con = Conexao.receberConexao();
		String sql = "SELECT * from usuario";
		List<Usuario> usuarios = new ArrayList<>();
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			ResultSet resultado = preparador.executeQuery();
			
			while(resultado.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(resultado.getInt("id"));
				usuario.setNome(resultado.getString("nome"));
				usuario.setLogin(resultado.getString("login"));
				usuario.setSenha(resultado.getString("senha"));
				
				usuarios.add(usuario);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		return null;
				
	}

	public Usuario buscarPorId(int id) {
		
		Connection con = Conexao.receberConexao();
		String sql = "SELECT * from usuario WHERE id = ?";
		Usuario usuario = null;
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setInt(1, id);
			
			ResultSet resultado = preparador.executeQuery();

			if(resultado.next()) {
				usuario = new Usuario();
				usuario.setId(resultado.getInt("id"));
				usuario.setNome(resultado.getString("nome"));
				usuario.setLogin(resultado.getString("login"));
				usuario.setSenha(resultado.getString("senha"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return usuario;
		
		
	}

	public Connection excluir (int id) {
		
		Connection con = Conexao.receberConexao();
		
		String sql = "DELETE from Usuario WHERE id =?";
		
		try {
			
		PreparedStatement preparador = con.prepareStatement(sql);
		preparador.setInt(1, id);
				
	preparador.execute();
	
	con.close();
	
	}catch (SQLException e) {
		e.printStackTrace();
	}
	
	return con;
	
	}

	public void alterar(Usuario usuario) {
		Connection con = Conexao.receberConexao();
		
		String sql "UPDATE usuario SET nome=?,login=?,senha=? WHERE id=?";
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, usuario.getNome());
			preparador.setString(2, usuario.getLogin());
			preparador.setString(3, usuario.getSenha());
			preparador.setInt(4, usuario.getId());
			
			preparador.execute();
			
			con.close();
		}catch (SQLException e) {
		e.printStackTrace();
	}
	

}

}
