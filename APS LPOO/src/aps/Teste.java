package aps;

import java.util.List;

public class Teste {
	public static void main(String[] args) {
		AcessoBancodeDados.testaConnection();
		//new AcessoBancodeDados().addBooks(new Books("O Medico e o Monstro", "0-13020608-5", 13, 40));
		
		AcessoBancodeDados ABD = new AcessoBancodeDados();
		
		List<Books> books = ABD.getTodosBooks();
		
		for(Books book: books) {
			System.out.println(book);
		}
		
		List<Authors> authors = ABD.getAuthors();
		
		for(Authors author: authors) {
			System.out.println(author);
		}
		

		//new AcessoBancodeDados().addPublishers(new Publishers(0, "Panini", "https://panini.com.br"));
		//new AcessoBancodeDados().addAuthors(new Authors(0, "Mauricio de Souza", "Osamu Tezuka"));
	}

}
