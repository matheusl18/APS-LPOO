package aps;

import java.util.List;

public class Teste {
	public static void main(String[] args) {
		AcessoBancodeDados.testaConnection();
		//new AcessoBancodeDados().addBooks(new Books("Turma da Monica", "0-13020608-5", 13, 40));
		//new AcessoBancodeDados().addBooksauthors(new Booksauthors("0-13020608-5", 8980, 4));
		//new AcessoBancodeDados().addPublishers(new Publishers(0, "Panini", "https://panini.com.br"));
		//new AcessoBancodeDados().addAuthors(new Authors(0, "Mauricio de Souza", "Osamu Tezuka"));
		
		AcessoBancodeDados  ABD = new AcessoBancodeDados();
		
		//List<Publishers> publishers = ABD.getpublishers();
		
		//for(Publishers publisher: publishers) {
		//	System.out.println(publisher);
		//}
		
		//List<Books> books = ABD.getBooks();
		
		//for(Books book: books) {
		//	System.out.println(book);
		//}
		
		//List<Authors> authors = ABD.getAuthors();
		
		//for(Authors author: authors) {
		//	System.out.println(author);
		//}
		
		//List<Booksauthors> booksauthors = ABD.getBooksauthors();
		
		//for(Booksauthors booksauthor: booksauthors) {
			//System.out.println(booksauthor);
		//}
	}

}
