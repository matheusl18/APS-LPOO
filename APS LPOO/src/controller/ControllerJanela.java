package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import dao.Dao;
import entidades.Authors;
import entidades.Booksauthors;
import entidades.Publishers;
import entidades.Books;
import view.janela.ViewJFrame;

public class ControllerJanela {
    
    Dao model;
    ViewJFrame view;
    private Publishers publishers;
	private Authors authors;
	private Books books;
	private Booksauthors booksauthors;
    
    public ControllerJanela(Dao model, ViewJFrame view){
        this.model = model;
        this.view = view;
    }
    
    public void init(){
    	view.addActionListarPublishers(new AcaoListarPublishers());
    	view.addActionListarAuthors(new AcaoListarAuthors());
        view.addActionListarBooks(new AcaoListarBooks());
        view.addActionListarBooksauthors(new AcaoListarBooksauthors());
    	
    	view.addActionAdicionarPublishers(new AcaoAdicionaPublishers());
        view.addActionAdicionarAuthors(new AcaoAdicionaAuthors());
        view.addActionAdicionarBooks(new AcaoAdicionaBooks());
        view.addActionAdicionarBooksauthors(new AcaoAdicionaBooksauthors());
        
        view.addActionDeletarPublishers(new AcaoDeletaPublishers());
        view.addActionDeletarAuthors(new AcaoDeletaAuthors());
        view.addActionDeletarBooks(new AcaoDeletaBooks());
        view.addActionDeletarBooksauthors(new AcaoDeletaBooksauthors());
        
        view.addActionUpdatePublishers(new AcaoUpdatePublishers());
        view.addActionUpdateAuthors(new AcaoUpdateAuthors());
        view.addActionUpdateBooks(new AcaoUpdateBooks());
        view.addActionUpdateBooksauthors(new AcaoUpdateBooksauthors());
        
        view.addActionBuscaPublishers(new AcaoBuscaPublishers());
        view.addActionBuscaAuthors(new AcaoBuscaAuthors());
        view.addActionBuscaBooks(new AcaoBuscaBooks());
        view.addActionBuscaBooksauthors(new AcaoBuscaBooksauthors());
    }
    
    class AcaoListarPublishers implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
        	List<Publishers> publishers;
        	publishers = model.getPublishers();
        	view.listarPublishers(publishers);
        }
    }
    class AcaoListarAuthors implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
        	List<Authors> authors;
        	authors = model.getAuthors();
        	view.listarAuthors(authors);
        }
    }
    class AcaoListarBooks implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
        	List<Books> books;
        	books = model.getBooks();
        	view.listarBooks(books);
        }
    }
    class AcaoListarBooksauthors implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
        	List<Booksauthors> booksauthors;
        	booksauthors = model.getBooksauthors();
        	view.listarBooksauthors(booksauthors);
        }
    }
    
    class AcaoBuscaPublishers implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
	         String nome = view.getKeyPublishersBusca();
	       	 
	       	 List<Publishers> publishers = model.getPublishers();
	       	 publishers = model.buscaPublishers(nome);
	       	 
	       	 view.srcPublishers(publishers);
        }
    }
    class AcaoBuscaAuthors implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
        	 String nome = view.getKeyNameAuthorsBusca();
        	 String fnome = view.getKeyFnameAuthorsBusca();
        	 
        	 List<Authors> authors ;
        	 authors = model.buscaAuthors(nome, fnome);
        	 
        	 view.srcAuthors(authors);
        }
    }
    class AcaoBuscaBooks implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
	         String title = view.getKeyBooksBusca();
	       	 
	       	 List<Books> books = model.getBooks();
	       	 books = model.buscaBooks(title);
	       	 
	       	 view.srcBooks(books);
        }
    }
    class AcaoBuscaBooksauthors implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
	         String isbn = view.getKeyBooksauthorsBusca();
	       	 
	       	 List<Booksauthors> booksauthorsauthors = model.getBooksauthors();
	       	 booksauthorsauthors = model.buscaBooksauthors(isbn);
	       	 
	       	 view.srcBooksauthors(booksauthorsauthors);
        }
    }
    
    
    
    class AcaoAdicionaPublishers implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
        	Publishers publisher = view.addPublishers();
        	model.addPublishers(publisher);
        }
    }
    class AcaoAdicionaAuthors implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
        	Authors author = view.addAuthors();
        	model.addAuthors(author);
        }
    }
    class AcaoAdicionaBooks implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
        	Books book = view.addBooks();
        	model.addBooks(book);
        }
    }
    class AcaoAdicionaBooksauthors implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
        	Booksauthors booksauthor = view.addBooksauthors();
        	model.addBooksauthors(booksauthor);
        }
    }
    
    
    class AcaoDeletaPublishers implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
        	int id = view.delPublishers();
        	model.delPublishers(id);
        }
    }
    class AcaoDeletaAuthors implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
        	int id = view.delAuthors();
        	model.delAuthors(id);
        }
    }
    class AcaoDeletaBooks implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
        	String isbn = view.delBooks();
        	model.delBooks(isbn);
        }
    }
    class AcaoDeletaBooksauthors implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
        	int id = view.delBooksauthors();
        	model.delBooksauthors(id);
        }
    }
    
    
    class AcaoUpdatePublishers implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
        	Publishers publisher = view.updatePublishers();
        	model.updatePublishers(publisher);;
        }
    }
    class AcaoUpdateAuthors implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
        	Authors author = view.updateAuthors();
        	model.updateAuthors(author);;
        }
    }
    class AcaoUpdateBooks implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
        	Books book = view.updateBooks();
        	model.updateBooks(book);;
        }
    }
    class AcaoUpdateBooksauthors implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
        	Booksauthors booksauthor = view.updateBooksauthors();
        	model.updateBooksauthors(booksauthor);;
        }
    }

}
