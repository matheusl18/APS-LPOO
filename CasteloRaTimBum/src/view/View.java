package view;

import entidades.Authors;
import entidades.Books;
import entidades.Booksauthors;
import entidades.Publishers;

public interface View {
	
	Opcao menu();
	
	void listarPublishers(Publishers publishers);
	void listarAuthors(Authors authors);
	void listarBooks(Books books);
	void listarBooksauthors(Booksauthors booksauthors);
	
	Publishers addPublishers();
	Authors addAuthors();
	Books addBooks();
	Booksauthors addBooksauthors();
	
	int delPublishers();
	int delAuthors();
	String delBooks();
	int delBooksauthors();
	
	String updateString();
	int updateInt();
	double updateDouble();
	

}
