package view.janela;


import java.awt.event.ActionListener;

import entidades.Authors;
import entidades.Books;
import entidades.Booksauthors;
import entidades.Publishers;

public interface ViewJFrame {
	
	void listarPublishers(Publishers publishers);
	void listarAuthors(Authors authors);
	void listarBooks(Books books);
	void listarBooksauthors(Booksauthors booksauthors);
	
	public void addActionAdicionarPublishers(ActionListener al);
	Publishers addPublishers();
	public void addActionAdicionarAuthors(ActionListener al);
	Authors addAuthors();
	public void addActionAdicionarBooks(ActionListener al);
	Books addBooks();
	public void addActionAdicionarBooksauthors(ActionListener al);
	Booksauthors addBooksauthors();
	
	public void addActionDeletarPublishers(ActionListener al);
	int delPublishers();
	public void addActionDeletarAuthors(ActionListener al);
	int delAuthors();
	public void addActionDeletarBooks(ActionListener al);
	String delBooks();
	public void addActionDeletarBooksauthors(ActionListener al);
	int delBooksauthors();
	
	public void addActionUpdatePublishers(ActionListener al);
	Publishers updatePublishers();
	public void addActionUpdateAuthors(ActionListener al);
	Authors updateAuthors();
	public void addActionUpdateBooks(ActionListener al);
	Books updateBooks();
	public void addActionUpdateBooksauthors(ActionListener al);
	Booksauthors updateBooksauthors();
	String updateString();
	int updateInt();
	double updateDouble();
	

}