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
	
	
	public List<Books> getTodosBooks() {

	  List<Books> books = new ArrayList<>();

	  final String query = "SELECT * FROM Books;";
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
	

}
