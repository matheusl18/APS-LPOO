package controller;

import java.util.Map;
import java.util.TreeMap;

import dao.Dao;
import entidades.Authors;
import entidades.Booksauthors;
import entidades.Publishers;
import entidades.Books;
import view.terminal.Opcao;
import view.terminal.View;



public class ControllerTerminal {
	
	private View view;
	private Dao model;
	private Publishers publishers;
	private Authors authors;
	private Books books;
	private Booksauthors booksauthors;


public static Map<Integer, Opcao> opcoesByCodigos = new TreeMap<>();
{
	for(Opcao o: Opcao.values()) {
		opcoesByCodigos.put(o.codigo, o);
	}
}

public ControllerTerminal(View view, Dao model) {
	this.view = view;
	this.model = model;
}

public void init() {

	
	Opcao codigo = null;
	while(codigo!=Opcao.SAIR) {
		codigo = view.menu();
		switch (codigo) {
		case LISTA_PUBLISHERS: {listarPublishers(); break;}
		case LISTA_AUTHORS: {listarAuthors(); break;}
		case LISTA_BOOKS: {listarBooks(); break;}
		case LISTA_BOOKSAUTHORS: {listarBooksauthors(); break;}
		case ADICIONA_PUBLISHERS: {adicionarPublishers(); break;}
		case ADICIONA_AUTHORS: {adicionarAuthors(); break;}
		case ADICIONA_BOOKS: {adicionarBooks(); break;}
		case ADICIONA_BOOKSAUTHORS: {adicionarBooksauthors(); break;}
		case REMOVER_PUBLISHERS: {removerPublishers(); break;}
		case REMOVER_AUTHORS: {removerAuthors(); break;}
		case REMOVER_BOOKS: {removerBooks(); break;}
		case REMOVER_BOOKSAUTHORS: {removerBooksauthors(); break;}
		case UPDATE_PUBLISHERS: {updatePublishers(); break;}
		case UPDATE_AUTHORS: {updateAuthors(); break;}
		case UPDATE_BOOKS: {updateBooks(); break;}
		case UPDATE_BOOKSAUTHORS: {updateBooksauthors(); break;}
		case SAIR: {terminar(); break;}
		default:
			throw new IllegalArgumentException("Unexpected value: " + codigo);
		}
	}
}

private void listarPublishers() {
	view.listarPublishers(publishers);
}

private void listarAuthors() {
	view.listarAuthors(authors);
}
private void listarBooks() {
	view.listarBooks(books);
}
private void listarBooksauthors() {
	view.listarBooksauthors(booksauthors);
}

private void adicionarPublishers() {
	Publishers publisher = view.addPublishers();
	this.model.addPublishers(publisher);
}
private void adicionarAuthors() {
	Authors author = view.addAuthors();
	this.model.addAuthors(author);
}
private void adicionarBooks() {
	Books book = view.addBooks();
	this.model.addBooks(book);
}
private void adicionarBooksauthors() {
	Booksauthors booksauthor = view.addBooksauthors();
	this.model.addBooksauthors(booksauthor);
}

private void removerPublishers() {
	int id = view.delPublishers();
	this.model.delPublishers(id);
}
private void removerAuthors() {
	int id = view.delAuthors();
	this.model.delAuthors(id);
}
private void removerBooks() {
	String isbn = view.delBooks();
	this.model.delBooks(isbn);
}
private void removerBooksauthors() {
	int id = view.delBooksauthors();
	this.model.delBooksauthors(id);
}

private void updatePublishers() {
	System.out.println("Digite o nome a ser atualizado");
	String nome = view.updateString();
	System.out.println("Digite a URL a ser atualizado");
	String url  = view.updateString();
	System.out.println("Digite o id do publisher que deseja ser atualizado");
	int id = view.updateInt();
	Publishers publisher = view.updatePublishers();
	this.model.updatePublishers(publisher);;
}
private void updateAuthors() {
	System.out.println("Digite o nome a ser atualizado");
	String nome = view.updateString();
	System.out.println("Digite o fnome a ser atualizado");
	String fnome = view.updateString();
	System.out.println("Digite o id do author que deseja ser atualizado");
	int id = view.updateInt();
	Authors author = view.updateAuthors();
	this.model.updateAuthors(author);;
}
private void updateBooks() {
	System.out.println("Digite o titulo a ser atualizado");
	String title = view.updateString();
	System.out.println("Digite o preço a ser atualizado");
	double price = view.updateDouble();
	System.out.println("Digite o isbn do book que deseja ser atualizado");
	String isbn = view.updateString();
	int id = 1;
	Books book = view.updateBooks();
	this.model.updateBooks(book);;
}
private void updateBooksauthors() {
	System.out.println("Digite o isbn do book que deseja ser atualizado");
	String isbn = view.updateString();
	System.out.println("Digite o seq a ser atualizado");
	int seq = view.updateInt();
	System.out.println("Digite o id do author que deseja ser atualizado");
	int id = view.updateInt();
	Booksauthors booksauthor = view.updateBooksauthors();
	this.model.updateBooksauthors(booksauthor);;
}


private void terminar() {
	
}



}