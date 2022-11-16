package view.janela;


import java.awt.event.ActionListener;
import java.util.List;

import entidades.Authors;
import entidades.Books;
import entidades.Booksauthors;
import entidades.Publishers;

public interface ViewJFrame {
	
	public void addActionListarPublishers(ActionListener al);
	void listarPublishers(List<Publishers> publishers);
	public void addActionListarAuthors(ActionListener al);
	void listarAuthors(List<Authors> authors);
	public void addActionListarBooks(ActionListener al);
	void listarBooks(List<Books> books);
	public void addActionListarBooksauthors(ActionListener al);
	void listarBooksauthors(List<Booksauthors> booksauthors);
	
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
	
	public void addActionBuscaPublishers(ActionListener al);
	public void srcPublishers(List<Publishers> publishers);
	public String getKeyPublishersBusca();
	public void addActionBuscaAuthors(ActionListener al);
	public void srcAuthors(List<Authors> authors);
	public String getKeyNameAuthorsBusca();
	public String getKeyFnameAuthorsBusca();
	public void addActionBuscaBooks(ActionListener al);
	public void srcBooks(List<Books> books);
	public String getKeyBooksBusca();
	public void addActionBuscaBooksauthors(ActionListener al);
	public void srcBooksauthors(List<Booksauthors> booksauthors);
	public String getKeyBooksauthorsBusca();
	
	public void addActionListarBoxAuthors(ActionListener al);
	public void boxAuthors(List<Authors> authors);
	public void addActionListarBoxPublishers(ActionListener al);
	public void boxPublishers(List<Publishers> publishers);
	public void addActionListarBoxBooks(ActionListener al);
	public void boxBooks(List<Books> books);
	

}
