package aps;

public class Publishers {
	 int publishers_id;
	 String nome;
	 String URL;
	 
	 public Publishers(int aid, String anome, String aURL) {
		 this.publishers_id = aid;
		 this.nome = anome;
		 this.URL = aURL;
	 }
	 
	 public int getPublishers_id() {
		 return this.publishers_id;
	 }
	 
	 public String getNome() {
		 return this.nome;
	 }
	 
	 public String getURL() {
		 return this.URL;
	 }
}
	

