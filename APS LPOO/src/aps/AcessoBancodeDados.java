package aps;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class AcessoBancodeDados {
	
	static private String USER = "root";
	static private String PASS = "root";
	static private String DATABASE = "livraria";
	static private String URL = "jdbc:mysql://localhost:3306/" + DATABASE;
	
	static void testaConnection() {
		
		try(Connection c = DriverManager.getConnection(URL, USER, PASS)){
			System.out.println("Conexao Estabelecida");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
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
	
	public void delPublishers(String name) {
		final String query = "DELETE FROM publishers WHERE name = (?)";
		
		try(Connection c = DriverManager.getConnection(URL, USER, PASS)){
			
			PreparedStatement pstm = c.prepareStatement(query);
			
			pstm.setString(1, name);
		   

		    int result = pstm.executeUpdate();

		    System.out.println("Resultado de remover o publishers " + name + ": " + result);


		  }catch(Exception e) {
		    e.printStackTrace();
		  }
			
		}
	
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
}
