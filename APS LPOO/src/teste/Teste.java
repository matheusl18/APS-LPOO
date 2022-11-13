package teste;

import java.awt.EventQueue;
import java.util.List;

import controller.ControllerJanela;
import controller.ControllerTerminal;
import dao.AcessoBancodeDados;
import dao.Dao;
import entidades.Authors;
import entidades.Books;
import entidades.Publishers;
import view.janela.Janela;
import view.terminal.View;
import view.terminal.ViewTerminal;
import entidades.Booksauthors;

public class Teste {
	public static void main(String[] args) {
		AcessoBancodeDados.testaConnection();
		//View view = new ViewTerminal();
		//Dao model = new AcessoBancodeDados();
		
		//new ControllerTerminal(view, model).init();
	
	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Janela frame = new Janela();
					frame.setVisible(true);
					Dao model = new AcessoBancodeDados();
					new ControllerJanela(model, frame).init();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	
	
	
	
	}
	

}