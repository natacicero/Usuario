package br.estudo.teste;

import java.util.List;
import java.util.Scanner;

import br.estudo.dao.UsuarioDao;
import br.estudo.modelo.Usuario;

public class TesteExcluirUsuario {

	public static void main(String[] args) {
		
		Scanner leitor = new Scanner(System.in);
		
		System.out.print("Digite o id do usuário que deseja excluir");
		int id = leitor.nextInt();
		
		UsuarioDao usuarioDao = new UsuarioDao();
		usuarioDao.excluir(id);
		
		//Mostrar todos os usuarios após exclusão
		List<Usuario> usuarios = usuarioDao.mostrarTodosUsuarios();
		
		for(Usuario usuario:usuarios) {
			System.out.println(usuario.getId() + usuario.getNome() + usuario.getLogin() + usuario.getSenha());
		
		}
	
		leitor.close();
		
	}

}
