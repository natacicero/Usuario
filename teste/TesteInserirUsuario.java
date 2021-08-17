package br.estudo.teste;

import java.util.Scanner;

import br.estudo.dao.UsuarioDao;
import br.estudo.modelo.Usuario;

public class TesteInserirUsuario {

	public static void main(String[] args) {

		Scanner leitor = new Scanner(System.in);
		Usuario usuario = new Usuario();
		UsuarioDao usuarioDao = new UsuarioDao();
		
		System.out.println("Nome: ");
		usuario.setNome(leitor.nextLine());
		
		System.out.println("Login: ");
		usuario.setLogin(leitor.nextLine());
		
		System.out.println("Senha: ");
		usuario.setSenha(leitor.nextLine());
		
		usuarioDao.cadastrar(usuario);
		
		leitor.close();
		
	}

}
