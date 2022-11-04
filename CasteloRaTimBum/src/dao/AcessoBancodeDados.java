package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import entidades.Authors;
import entidades.Books;
import entidades.Booksauthors;
import entidades.Publishers;


public class AcessoBancodeDados implements Dao{
	
	static private String USER = "root";
	static private String PASS = "root";
	static private String DATABASE = "livraria";
	static private String URL = "jdbc:mysql://localhost:3306/" + DATABASE;
	
	public static void testaConnection() {
		
		try(Connection c = DriverManager.getConnection(URL, USER, PASS)){
			System.out.println("Conexao Estabelecida");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void addPublishers(Publishers publishers) {
		final String query = "INSERT INTO publishers VALUES(?,?,?)";
		
		try(Connection c = DriverManager.getConnection(URL, USER, PASS)){
			
			PreparedStatement pstm = c.prepareStatement(query);
			
			pstm.setInt(1, publishers.getPublishers_id());
		    pstm.setString(2, publishers.getNome());
		    pstm.setString(3, publishers.getURL());

		    int result = pstm.executeUpdate();

		    System.out.println("Resultado de adicionar publishers " + publishers + ": " + result);



		  }catch(Exception e) {
		    e.printStackTrace();
		  }
			
		}
	
	@Override
	public void delPublishers(int id) {
		final String query = "DELETE FROM publishers WHERE id = (?)";
		
		try(Connection c = DriverManager.getConnection(URL, USER, PASS)){
			
			PreparedStatement pstm = c.prepareStatement(query);
			
			
			
			pstm.setInt(1, id);
		   

		    int result = pstm.executeUpdate();

		    System.out.println("Resultado de remover o publishers " + id + ": " + result);



		  }catch(Exception e) {
		    e.printStackTrace();
		  }
			
		}
	
	@Override
	public void updatePublishers(String name, String url, int id) {
		final String query = "UPDATE publishers SET name = (?), url = (?) WHERE publisher_id = (?)";
		
		try(Connection c = DriverManager.getConnection(URL, USER, PASS)){
			
			PreparedStatement pstm = c.prepareStatement(query);
			
			
			
			pstm.setString(1, name);
		    pstm.setString(2, url);
		    pstm.setInt(3, id);
		   

		    int result = pstm.executeUpdate();

		    System.out.println("Resultado de alterar o publishers "  + ": " + result);



		  }catch(Exception e) {
		    e.printStackTrace();
		  }
			
		}
	
	@Override
	public List<Publishers> getpublishers() {

		  List<Publishers> publishers = new ArrayList<>();

		  final String query = "SELECT * FROM publishers;";
		  try (Connection c = DriverManager.getConnection(URL, USER, PASS)){

		    Statement stm = c.createStatement();
		    ResultSet rs = stm.executeQuery(query);

		    while(rs.next()) {
		      int publishers_id = rs.getInt("publisher_id");
		      String nome = rs.getString("name");
		      String URL = rs.getString("URL");
		      Publishers publisher = new Publishers(publishers_id, nome, URL);
		      publishers.add(publisher);
		    }


		  }catch(Exception e) {
		    e.printStackTrace();
		  }

		  return publishers;
		}
	
	@Override
	public List<Publishers> buscaPublishers(String nomeKey) {
		
		List<Publishers> publishers = new ArrayList<>();
		
		final String query = "SELECT * FROM publishers WHERE LOWER(name) LIKE LOWER(?);";
		try (Connection c = DriverManager.getConnection(URL, USER, PASS)){
			
			PreparedStatement pstm = c.prepareStatement(query);
			
			pstm.setString(1, "%" + nomeKey + "%");
			
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()) {
				int publishers_id = rs.getInt("publisher_id");
				String nome = rs.getString("name");
				String URL = rs.getString("URL");
				Publishers publisher = new Publishers(publishers_id, nome, URL);
				publishers.add(publisher);
			}
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return publishers;
	}
	
	@Override
	public void addAuthors(Authors authors) {
		final String query = "INSERT INTO authors VALUES(?,?,?)";
		
		try(Connection c = DriverManager.getConnection(URL, USER, PASS)){
			
			PreparedStatement pstm = c.prepareStatement(query);
			
			pstm.setInt(1, authors.getAuthors_id());
		    pstm.setString(2, authors.getNome());
		    pstm.setString(3, authors.getFname());

		    int result = pstm.executeUpdate();

		    System.out.println("Resultado de adicionar authors " + authors + ": " + result);



		  }catch(Exception e) {
		    e.printStackTrace();
		  }
			
		}
	
	@Override
	public void delAuthors (int authors_id) {
		final String query = "DELETE FROM authors WHERE authors_id = (?)";
		
		try(Connection c = DriverManager.getConnection(URL, USER, PASS)){
			
			PreparedStatement pstm = c.prepareStatement(query);
			
			
			
			pstm.setInt(1, authors_id);
		   

		    int result = pstm.executeUpdate();

		    System.out.println("Resultado de remover o authors" + authors_id + ": " + result);



		  }catch(Exception e) {
		    e.printStackTrace();
		  }
			
	}


	@Override
	public void updateAuthors(String nome, String fname, int id) {
		final String query = "UPDATE authors SET fname = (?), name = (?) WHERE authors_id = (?)";
		
		try(Connection c = DriverManager.getConnection(URL, USER, PASS)){
			
			PreparedStatement pstm = c.prepareStatement(query);
			
			
			
			pstm.setString(1, nome);
		    pstm.setString(2, nome);
		    pstm.setInt(3, id);

		    int result = pstm.executeUpdate();

		    System.out.println("Resultado de alterar o authors"  + ": " + result);



		  }catch(Exception e) {
		    e.printStackTrace();
		  }
			
		}

	@Override
	public List<Authors> getAuthors() {

		  List<Authors> authors = new ArrayList<>();

		  final String query = "SELECT * FROM authors;";
		  try (Connection c = DriverManager.getConnection(URL, USER, PASS)){

		    Statement stm = c.createStatement();
		    ResultSet rs = stm.executeQuery(query);

		    while(rs.next()) {
		      int authors_id = rs.getInt("author_id");
		      String nome = rs.getString("name");
		      String fnome = rs.getString("fname");
		      Authors author = new Authors(authors_id, nome, fnome);
		      authors.add(author);
		    }



		  }catch(Exception e) {
		    e.printStackTrace();
		  }

		  return authors;
		}
	
	@Override
	public List<Authors> buscaAuthors(String authors_idKey) {
		
		List<Authors> authors = new ArrayList<>();
		
		final String query = "SELECT * FROM authors WHERE LOWER(authors_id) LIKE LOWER(?);";
		try (Connection c = DriverManager.getConnection(URL, USER, PASS)){
			
			PreparedStatement pstm = c.prepareStatement(query);
			
			pstm.setString(1, "%" + authors_idKey + "%");
			
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()) {
			    int authors_id = rs.getInt("authors_id");
			    String nome = rs.getString("nome"); 
			    String fnome = rs.getString("fnome");
				Authors author = new Authors (authors_id, nome, fnome);
				authors.add(author);
			}
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return authors;
	}
	
	@Override
	public void addBooks(Books books) {
		final String query = "INSERT INTO books VALUES(?,?,?,?)";
		
		try(Connection c = DriverManager.getConnection(URL, USER, PASS)){
			
			PreparedStatement pstm = c.prepareStatement(query);
			
			pstm.setString(1, books.getTitle());
		    pstm.setString(2, books.getIsbn());
		    pstm.setInt(3, books.getPublisher_id());
		    pstm.setInt(4, books.getPrice());

		    int result = pstm.executeUpdate();

		    System.out.println("Resultado de adicionar books " + books + ": " + result);



		  }catch(Exception e) {
		    e.printStackTrace();
		  }
			
	}
	
	@Override
	public void delBooks(String isbn) {
		final String query = "DELETE FROM books WHERE isbn = (?)";
		
		try(Connection c = DriverManager.getConnection(URL, USER, PASS)){
			
			PreparedStatement pstm = c.prepareStatement(query);
			
			
			
			pstm.setString(1, isbn);
		   

		    int result = pstm.executeUpdate();

		    System.out.println("Resultado de remover o book " + isbn + ": " + result);



		  }catch(Exception e) {
		    e.printStackTrace();
		  }
			
		}
	
	@Override
	public void updateBooks(String title, double price, String isbn) {
		final String query = "UPDATE books SET title = (?), price = (?) WHERE isbn = (?)";
		
		try(Connection c = DriverManager.getConnection(URL, USER, PASS)){
			
			PreparedStatement pstm = c.prepareStatement(query);
			
			
			
			pstm.setString(1, title);
		    pstm.setDouble(2, price);
		    pstm.setString(3, isbn);

		    int result = pstm.executeUpdate();

		    System.out.println("Resultado de alterar o book "  + ": " + result);



		  }catch(Exception e) {
		    e.printStackTrace();
		  }
			
		}
	
	@Override
	public List<Books> getBooks() {

	  List<Books> books = new ArrayList<>();

	  final String query = "SELECT * FROM books;";
	  try (Connection c = DriverManager.getConnection(URL, USER, PASS)){

	    Statement stm = c.createStatement();
	    ResultSet rs = stm.executeQuery(query);

	    while(rs.next()) {
	      String title = rs.getString("title");
	      String isbn = rs.getString("isbn");
	      int publisher_id = rs.getInt("publisher_id");
	      int price = rs.getInt("Price");
	      
	      
	      Books book = new Books(title, isbn, publisher_id, price);
	      books.add(book);
	    }



	  }catch(Exception e) {
	    e.printStackTrace();
	  }

	  return books;
	}
	
	@Override
	public List<Books> buscaBooks(String titleKey) {
		
		List<Books> books = new ArrayList<>();
		
		final String query = "SELECT * FROM books WHERE LOWER(title) LIKE LOWER(?);";
		try (Connection c = DriverManager.getConnection(URL, USER, PASS)){
			
			PreparedStatement pstm = c.prepareStatement(query);
			
			pstm.setString(1, "%" + titleKey + "%");
			
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()) {
				String title = rs.getString("title");
			    String isbn = rs.getString("isbn");
			    int publisher_id = rs.getInt("publisher_id");
			    int price = rs.getInt("Price");
				Books book = new Books(title, isbn, publisher_id, price);
				books.add(book);
			}
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return books;
	}
	
	@Override
	public void addBooksauthors(Booksauthors booksauthors) {
		final String query = "INSERT INTO booksauthors VALUES(?,?,?)";
		
		try(Connection c = DriverManager.getConnection(URL, USER, PASS)){
			
			PreparedStatement pstm = c.prepareStatement(query);
			
			pstm.setString(1, booksauthors.getisbn());
		    pstm.setInt(2, booksauthors.getauthor_id());
		    pstm.setInt(3, booksauthors.getseq_no());

		    int result = pstm.executeUpdate();

		    System.out.println("Resultado de adicionar Booksauthors " + booksauthors + ": " + result);



		  }catch(Exception e) {
		    e.printStackTrace();
		  }
			
		}
	
	@Override
	public void delBooksauthors(int id) {
		final String query = "DELETE FROM booksauthors WHERE author_id = (?)";
		
		try(Connection c = DriverManager.getConnection(URL, USER, PASS)){
			
			PreparedStatement pstm = c.prepareStatement(query);
			
			
			
			pstm.setInt(1, id);
		   

		    int result = pstm.executeUpdate();

		    System.out.println("Resultado de remover o booksauthors " + id + ": " + result);



		  }catch(Exception e) {
		    e.printStackTrace();
		  }
			
		}
	
	@Override
	public void updateBooksauthors(String isbn, int seq_no, int author_id) {
		final String query = "UPDATE booksauthors SET isbn = (?), seq_no = (?) WHERE author_id = (?)";
		
		try(Connection c = DriverManager.getConnection(URL, USER, PASS)){
			
			PreparedStatement pstm = c.prepareStatement(query);
			
			
			
			pstm.setString(1, isbn);
		    pstm.setInt(2, seq_no);
		    pstm.setInt(3, author_id);
		   

		    int result = pstm.executeUpdate();

		    System.out.println("Resultado de alterar o booksauthors "  + ": " + result);



		  }catch(Exception e) {
		    e.printStackTrace();
		  }
			
		}
	
	@Override
	public List<Booksauthors> getBooksauthors() {

		  List<Booksauthors> booksauthors = new ArrayList<>();

		  final String query = "SELECT * FROM booksauthors;";
		  try (Connection c = DriverManager.getConnection(URL, USER, PASS)){

		    Statement stm = c.createStatement();
		    ResultSet rs = stm.executeQuery(query);

		    while(rs.next()) {
		      String isbn = rs.getString("isbn");
		      int author_id = rs.getInt("author_id");
		      int seq_no = rs.getInt("seq_no");
		      Booksauthors booksauthor = new Booksauthors(isbn, author_id, seq_no);
		      booksauthors.add(booksauthor);
		    }
		    
		  }catch(Exception e) {
				e.printStackTrace();
			}
			
			return booksauthors;
		}
			  
	@Override		  
	public List<Booksauthors> buscaBooksauthors(String isbnKey) {
		
		List<Booksauthors> booksauthors = new ArrayList<>();
		
		final String query = "SELECT * FROM booksauthors WHERE LOWER(isbn) LIKE LOWER(?);";
		try (Connection c = DriverManager.getConnection(URL, USER, PASS)){
			
			PreparedStatement pstm = c.prepareStatement(query);
			
			pstm.setString(1, "%" + isbnKey + "%");
			
			ResultSet rs = pstm.executeQuery();
			
			
			while(rs.next()) {
				String isbn = rs.getString("isbn");
				int author_id = rs.getInt("author_id");
				int seq_no = rs.getInt("seq_no");
				Booksauthors booksauthor = new Booksauthors(isbn, author_id, seq_no);
				booksauthors.add(booksauthor);
			}
			


		  }catch(Exception e) {
		    e.printStackTrace();
		  }

		  return booksauthors;
		}
	
}
