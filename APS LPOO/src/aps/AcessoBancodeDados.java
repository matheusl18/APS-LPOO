package aps;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class AcessoBancodeDados {
	
	static private String USER = "root";
	static private String PASS = "root";
	static private String DATABASE = "livraria";
	static private String URL = "jdbc:mysql://localhost3306/" + DATABASE;
	
	static void testaConnection() {
		
		try(Connection c = DriverManager.getConnection(URL, USER, PASS)){
			System.out.println("Conexao Estabelecida");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addPublishers(Publishers publishers) {
		final String query = "INSERT INTO publisher VALUES(?,?,?)";
		
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
	
	public static void main(String[] args) {
		AcessoBancodeDados.testaConnection();
		new AcessoBancodeDados().addPublishers(new Publishers(0, "Panini", "https://panini.com.br"));
		new AcessoBancodeDados().addAuthors(new Authors(0, "Mauricio de Souza", "Osamu Tezuka"));
	}
}