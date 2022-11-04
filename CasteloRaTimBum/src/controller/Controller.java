package controller;


import java.util.Map;
import java.util.TreeMap;

import dao.Dao;
import entidades.Authors;
import entidades.Booksauthors;
import entidades.Publishers;
import entidades.Books;
import view.Opcao;
import view.View;


public class Controller {
	
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

public Controller(View view, Dao model) {
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
	String nome = view.updateString();
	String url  = view.updateString();
	int id = view.updateInt();
	this.model.updatePublishers(nome, url, id);;
}
private void updateAuthors() {
	String nome = view.updateString();
	String fnome = view.updateString();
	int id = view.updateInt();
	this.model.updateAuthors(nome, fnome, id);;
}
private void updateBooks() {
	String title = view.updateString();
	double price = view.updateDouble();
	String isbn = view.updateString();
	this.model.updateBooks(title, price, isbn);;
}
private void updateBooksauthors() {
	String isbn = view.updateString();
	int seq = view.updateInt();
	int id = view.updateInt();
	this.model.updateBooksauthors(isbn, seq, id);;
}


private void terminar() {
	
}



}
