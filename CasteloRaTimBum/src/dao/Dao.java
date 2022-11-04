package dao;


import java.util.List;

import entidades.Authors;
import entidades.Books;
import entidades.Booksauthors;
import entidades.Publishers;

public interface Dao {
	
	public void addPublishers(Publishers publishers);
	public void delPublishers(int id);
	public void updatePublishers(String name, String url, int id);
	public List<Publishers> getpublishers();
	public List<Publishers> buscaPublishers(String nomeKey);
	
	public void addAuthors(Authors authors);
	public void delAuthors(int authors_id);
	public void updateAuthors(String nome, String fname, int authors_id);
	public List<Authors> getAuthors();
	public List<Authors> buscaAuthors(String authors_idKey);
	
	public void addBooks(Books books);
	public void delBooks(String isbn);
	public void updateBooks(String title, double price, String isbn);
	public List<Books> getBooks();
	public List<Books> buscaBooks(String titleKey);
	
	public void addBooksauthors(Booksauthors booksauthors);
	public void delBooksauthors(int id);
	public void updateBooksauthors(String isbn, int seq_no, int author_id);
	public List<Booksauthors> getBooksauthors();
	public List<Booksauthors> buscaBooksauthors(String isbnKey);
	
	

}
