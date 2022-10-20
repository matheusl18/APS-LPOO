package aps;

public class Authors {
	 int authors_id;
	 String nome;
	 String fname;
	 
	 public Authors(int aid, String anome, String aFnome) {
		 this.authors_id = aid;
		 this.nome = anome;
		 this.fname = aFnome;
	 }
	 
	 public int getAuthors_id() {
		 return this.authors_id;
	 }
	 
	 public String getNome() {
		 return this.nome;
	 }
	 
	 public String getFname() {
		 return this.fname;
	 }
}