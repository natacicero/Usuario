package br.estudo.teste;

import java.util.List;

import br.estudo.dao.UsuarioDao;
import br.estudo.modelo.Usuario;

public class TesteMostrarTodosUsuarios {

	public static void main(String[] args) {

		UsuarioDao usuarioDao = new UsuarioDao();
		List<Usuario> usuariosDoBanco = usuarioDao.mostrarTodosUsuarios();
		
		for(Usuario usuario:usuariosDoBanco) {
			
			System.out.println(usuario.getId() + "-" +
								usuario.getNome() + "-"+
								usuario.getLogin() + "-"+	
								usuario.getSenha());
		}
		
	}	
	
}
