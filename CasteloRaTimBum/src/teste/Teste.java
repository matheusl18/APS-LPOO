package teste;

import java.util.List;

import controller.Controller;
import dao.AcessoBancodeDados;
import dao.Dao;
import entidades.Authors;
import entidades.Books;
import entidades.Publishers;
import view.View;
import view.ViewTerminal;
import entidades.Booksauthors;

public class Teste {
	public static void main(String[] args) {
		View view = new ViewTerminal();
		Dao model = new AcessoBancodeDados();
		
		new Controller(view, model).init();
	}

}
