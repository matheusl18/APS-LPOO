package dao;


import java.util.List;

import entidades.Authors;
import entidades.Books;
import entidades.Booksauthors;
import entidades.Publishers;

public interface Dao {
	
	public void addPublishers(Publishers publishers);
	public void delPublishers(int id);
	public void updatePublishers(Publishers publisher);
	public List<Publishers> getPublishers();
	public List<Publishers> buscaPublishers(String nomeKey);
	
	public void addAuthors(Authors authors);
	public void delAuthors(int authors_id);
	public void updateAuthors(Authors authors);
	public List<Authors> getAuthors();
	public List<Authors> buscaAuthors(String name, String fname);
	
	public void addBooks(Books books);
	public void delBooks(String isbn);
	public void updateBooks(Books books);
	public List<Books> getBooks();
	public List<Books> buscaBooks(String titleKey);
	
	public void addBooksauthors(Booksauthors booksauthors);
	public void delBooksauthors(int id);
	public void updateBooksauthors(Booksauthors booksauthors);
	public List<Booksauthors> getBooksauthors();
	public List<Booksauthors> buscaBooksauthors(String isbnKey);
	
	

}