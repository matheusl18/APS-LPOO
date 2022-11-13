package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dao.Dao;
import entidades.Authors;
import entidades.Books;
import entidades.Booksauthors;
import entidades.Publishers;
import view.janela.ViewJFrame;

public class ControllerJanela {
    
    Dao model;
    ViewJFrame view;
    
    public ControllerJanela(Dao model, ViewJFrame view){
        this.model = model;
        this.view = view;
    }
    
    public void init(){
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
