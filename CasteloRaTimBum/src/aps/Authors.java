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
	 
	 @Override
	    public String toString(){
	        String res = "classe " + this.getClass() + "\n";
	        res += "authors_id: " + this.authors_id;
	        res += "nome: " + this.nome + "\n";
	        res += "fname: " + this.fname + "\n";
	        return res;
	    }
	 
	 
}