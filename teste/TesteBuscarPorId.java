package br.estudo.teste;

import java.util.Scanner;

import br.estudo.dao.UsuarioDao;
import br.estudo.modelo.Usuario;

public class TesteBuscarPorId {

	public static void main(String[] args) {

		Scanner leitor = new Scanner(System.in);
		UsuarioDao usuarioDao = new UsuarioDao();
		
		System.out.print("Digite o id do usúario que deseja buscar: ");
		int id = leitor.nextInt();
		
		Usuario usuario = usuarioDao.buscarPorId(id);
		System.out.println("Id: " + usuario.getId());
		System.out.println("Nome: " + usuario.getNome());
		System.out.println("Login: " + usuario.getLogin());
		System.out.println("Senha: " + usuario.getSenha());
		
		leitor.close();
		
	}

}
