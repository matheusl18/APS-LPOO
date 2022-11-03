package view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import controller.Controller;
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
				
				if(!Controller.opcoesByCodigos.keySet().contains(opcaoCodigo)) {
					throw new InputMismatchException("Opcao nao corresponde a nenhum codigo listado");
				}
				return Controller.opcoesByCodigos.get(opcaoCodigo);
				
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
	List<Publishers> publishers = ABD.getpublishers();
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

	

	
	
	public Publishers getNewPublishers() {
		System.out.println("Entre com os dados do funcionario");
		int id = getIdPublishers();
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
	
	
	
	public Departamento getNewDepartamento() {
		System.out.println("Entre com os dados do departamento");
		String nome = getNomeDepartamento();
		String cidade = getCidadeDepartamento();
		return new Departamento(nome, cidade);
	}
	
	public String getNomeDepartamento() {
		System.out.println("Entre com o nome do departamento");
		return getString();
	}
	
	public String getCidadeDepartamento() {
		System.out.println("Entre com a cidade do departamento");
		return getString();
	}
	
	private Departamento escolherDepartamento(Cadastro cadastro) {
		String nome = escolherNomesDepartamentos(cadastro);
		String cidade = escolherCidadesDepartamentos(cadastro);
		return new Departamento(nome, cidade);
	}
	
	private String escolherCidadesDepartamentos(Cadastro cadastro) {
		Set<String> cidades = new TreeSet<>();
		for(Departamento d: cadastro.getDepartamentos()) {
			cidades.add(d.getCidade());
		}
		System.out.println("Escolha uma das cidades");
		for(String cidade: cidades) {
			System.out.println(cidade);
		}
		System.out.println("Entre com a cidade escolhida:");
		return getString();
	}
	
	private String escolherNomesDepartamentos(Cadastro cadastro) {
		Set<String> nomes = new TreeSet<>();
		for(Departamento d: cadastro.getDepartamentos()) {
			nomes.add(d.getNome());
		}
		System.out.println("Escolha um dos nomes");
		for(String nome: nomes) {
			System.out.println(nome);
		}
		System.out.println("Entre com o nome escolhido:");
		return getString();
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
}
