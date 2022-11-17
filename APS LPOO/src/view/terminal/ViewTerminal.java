package view.terminal;


import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import controller.ControllerTerminal;
import dao.AcessoBancodeDados;
import entidades.Authors;
import entidades.Books;
import entidades.Booksauthors;
import entidades.Publishers;

public class ViewTerminal implements View{

	@Override
	public Opcao menu() {
		try {
			
			System.out.println("Entre com uma das opcoes:");
			for(Opcao o: Opcao.values()) {
				System.out.println("" + o.codigo + " - " + o.descricao);
			}
			
			@SuppressWarnings("resource")
			Scanner in = new Scanner(System.in);
			try {
				String entrada = in.nextLine();
				int opcaoCodigo = Integer.parseInt(entrada);
				
				if(!ControllerTerminal.opcoesByCodigos.keySet().contains(opcaoCodigo)) {
					throw new InputMismatchException("Opcao nao corresponde a nenhum codigo listado");
				}
				return ControllerTerminal.opcoesByCodigos.get(opcaoCodigo);
				
			}catch(NumberFormatException e) {
				throw new InputMismatchException("Opcao entrada nao eh um numero inteiro");
			}
		}catch(InputMismatchException e) {
			System.out.println(e.getMessage());
			menu();
		}
		return null;
			
	}
	AcessoBancodeDados  ABD = new AcessoBancodeDados();
	List<Publishers> publishers = ABD.getPublishers();
	List<Authors> authors = ABD.getAuthors();
	List<Books> books = ABD.getBooks();
	List<Booksauthors> booksauthors = ABD.getBooksauthors();
	

	@Override
	public void listarPublishers(Publishers publisher) {
		System.out.println("Todos os Publishers:");
		for(Publishers p: publishers) {
			System.out.println(p);
		}
	}

	@Override
	public void listarAuthors(Authors author) {
		System.out.println("Todos os listarAuthors:");
		for(Authors a: authors) {
			System.out.println(a);
		}
	}
	@Override
	public void listarBooks(Books book) {
		System.out.println("Todos os books:");
		for(Books b: books) {
			System.out.println(b);
		}
	}
	@Override
	public void listarBooksauthors(Booksauthors booksauthor) {
		System.out.println("Todos os booksauthors:");
		for(Booksauthors ba: booksauthors) {
			System.out.println(ba);
		}
	}
	

	

	@Override
	public Publishers addPublishers() {
		return getNewPublishers();
	}
	@Override
	public Authors addAuthors() {
		return getNewAuthors();
	}
	@Override
	public Books addBooks() {
		return getNewBooks();
	}
	@Override
	public Booksauthors addBooksauthors() {
		return getNewBooksauthors();
	}
	
	
	
	@Override
	public int delPublishers() {
		return removePublishers();
	}
	@Override
	public int delAuthors() {
		return removeAuthors();
	}
	@Override
	public String delBooks() {
		return removeBooks();
	}
	@Override
	public int delBooksauthors() {
		return removeBooksauthors();
	}
	
	@Override
	public String updateString() {
		return getString();
	}
	@Override
	public double updateDouble() {
		return getDouble();
	}
	@Override
	public int updateInt() {
		return getInt();
	}
	


	public Publishers getNewPublishers() {
		System.out.println("Entre com os dados do Publishers");
		int id = 0;
		String nome = getNomePublishers();
		String url = getURLPublishers();
		return new Publishers(id, nome, url);
	}
	
	
	public int getIdPublishers() {
		System.out.println("Entre com o id do Publishers");
		return getInt();
	}
	
	public String getNomePublishers() {
		System.out.println("Entre com a nome do Publishers");
		return getString();
	}
	public String getURLPublishers() {
		System.out.println("Entre com a URL do Publishers");
		return getString();
	}
	
	
	
	public Authors getNewAuthors() {
		System.out.println("Entre com os dados do Authors");
		int id = 0;
		String nome = getNomeAuthors();
		String fnome = getFnomeAuthors();
		return new Authors(id, nome, fnome);
	}
	
	public int getIdAuthors() {
		System.out.println("Entre com o id do Author");
		return getInt();
	}
	public String getNomeAuthors() {
		System.out.println("Entre com o nome do Authors");
		return getString();
	}
	
	public String getFnomeAuthors() {
		System.out.println("Entre com o fname do Authors");
		return getString();
	}
	
	public Books getNewBooks() {
		System.out.println("Entre com os dados do Books");
		String title = getTitlesBooks();
		String isbn = getIsbnBooks();
		int id = getIdPublishers();
		int price = getPriceBooks();

		return new Books(title, isbn, id, price);
	}
	
	public String getTitlesBooks() {
		System.out.println("Entre com o title do Books");
		return getString();
	}
	public String getIsbnBooks() {
		System.out.println("Entre com a isbn do Books");
		return getString();
	}
	public int getPriceBooks() {
		System.out.println("Entre com o price do Books");
		return getInt();
	}
	
	public Booksauthors getNewBooksauthors() {
		System.out.println("Entre com os dados do Booksauthors");
		String isbn = getIsbnBooks();
		int id = getIdAuthors();
		int seq = getSeqBooks();

		return new Booksauthors(isbn, id, seq);
	}
	
	public int getSeqBooks() {
		System.out.println("Entre com o seq_no do Booksauthor");
		return getInt();
	}
		
	
	
	public int removePublishers() {
		System.out.println("Entre com o id do Authors que deseja remove");
		int id = getIdPublishers();
		System.out.println("Deletar essa editora ira remover todos os livros que ela tem, quer continuar?");
		int x = subMenu();
		switch (x) {
		case 1: ; 
		break;
		case 2: id = 0;
		break;
		}
		return id;
	}
	public int removeAuthors() {
		System.out.println("Entre com o id do Authors que deseja remover");
		int id = getIdAuthors();
		System.out.println("Deletar essa autor ira remover todos os livros que ela tem, quer continuar?");
		int x = subMenu();
		switch (x) {
		case 1: ; 
		break;
		case 2: id = 0;
		break;
		}
		return id;
	}
	public String removeBooks() {
		System.out.println("Entre com o isbn do Books que deseja remove");
		String isbn = getIsbnBooks();
		return isbn;
	}
	public int removeBooksauthors() {
		System.out.println("Entre com o id do Authors que deseja remove");
		int id = getIdAuthors();
		return id;
	}
	
	
	public int subMenu() {
		System.out.println("\n\n1 Sim\n2 Não");
		int x;
		x = getInt();
		if(!(x == 1 || x == 2 )) {
			System.out.println("Nao existe essa opcao");	
			}
		
		return x;
	}
	
	public String getString() {
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		return str.trim();
	}
	public int getInt() {
		int num;
		num = 0;
		try {
			Scanner in = new Scanner(System.in);
			num = in.nextInt();
		}catch(InputMismatchException e) {
			System.out.println("Caracter Invalido");
		}return num;
	}
	public double getDouble() {
		double num;
		num = 0;
		try {
			Scanner in = new Scanner(System.in);
			num = in.nextDouble();
		}catch(InputMismatchException e) {
			System.out.println("Caracter Invalido");
		}return num;
	}

	@Override
	public Publishers updatePublishers() {
		System.out.println("Entre com os dados do Publishers");
		int id = 0;
		String nome = getNomePublishers();
		String url = getURLPublishers();
		return new Publishers(id, nome, url);
	}

	@Override
	public Authors updateAuthors() {
		System.out.println("Entre com os dados do Authors que deseja atualizar");
		int id = 0;
		String nome = getNomeAuthors();
		String fnome = getFnomeAuthors();
		return new Authors(id, nome, fnome);
	}

	@Override
	public Books updateBooks() {
		System.out.println("Entre com os dados do Books que deseja atualizar");
		String title = getTitlesBooks();
		String isbn = getIsbnBooks();
		int id = getIdPublishers();
		int price = getPriceBooks();

		return new Books(title, isbn, id, price);
	}

	@Override
	public Booksauthors updateBooksauthors() {
		System.out.println("Entre com os dados do Booksauthors que deseja atualizar");
		String isbn = getIsbnBooks();
		int id = getIdAuthors();
		int seq = getSeqBooks();

		return new Booksauthors(isbn, id, seq);
	}
}

	