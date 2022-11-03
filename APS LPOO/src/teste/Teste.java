package teste;

import java.util.List;

import dao.AcessoBancodeDados;
import entidades.Authors;
import entidades.Books;
import entidades.Publishers;
import entidades.Booksauthors;

public class Teste {
	public static void main(String[] args) {
		AcessoBancodeDados.testaConnection();
		//new AcessoBancodeDados().addBooks(new Books("Turma da Monica", "0-13020608-5", 13, 40));
		//new AcessoBancodeDados().addPublishers(new Publishers(0, "Panini", "https://panini.com.br"));
		//new AcessoBancodeDados().addAuthors(new Authors(0, "Mauricio de Souza", "Osamu Tezuka"));
		//new AcessoBancodeDados().addBooksauthors(new Booksauthors("0-13020608-5", 8980, 4));
		//new AcessoBancodeDados().delPublishers("Panini");
		//new AcessoBancodeDados().delBooks("Turma da Monica");
		//new AcessoBancodeDados().delBooksauthors(8980);
		//new AcessoBancodeDados().updatePublishers("Pononi", "https://pononi.com.br", "Panini");
		//new AcessoBancodeDados().updateBooks("Galinha Pintadinha", 13.00, "0-7434-1146-3");
		//new AcessoBancodeDados().updateBooksauthors("0-13-020601-6", 3, 8980);
		
		AcessoBancodeDados  ABD = new AcessoBancodeDados();
		
		//List<Publishers> publishers = ABD.getpublishers();
		
		//for(Publishers publisher: publishers) {
			//System.out.println(publisher);
		//}
		
//	 	publishers = ABD.buscaPublishers("Panini");
//		
//		System.out.println();
//		for(Publishers publisher: publishers) {
//			System.out.println(publisher);
//		}
		
//		List<Books> books = ABD.getBooks();
		
		//for(Books book: books) {
				//	System.out.println(book);
				//}
//		
//		books = ABD.buscaBooks("Galinha Pintadinha");
//		
//		System.out.println();
//		for(Books book: books) {
//			System.out.println(book);
//		}
//		
		
		//List<Authors> authors = ABD.getAuthors();
		
		//for(Authors author: authors) {
		//	System.out.println(author);
		//}
		
		//List<Booksauthors> booksauthors = ABD.getBooksauthors();
		
		//for(Booksauthors booksauthor: booksauthors) {
			//System.out.println(booksauthor);
		//}
		
//		booksauthors = ABD.buscaBooksauthors("0-13-020601-6");
//		
//		System.out.println();
//		for(Booksauthors bookauthor: booksauthors) {
//			System.out.println(bookauthor);
//		}
	}

}