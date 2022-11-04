package entidades;

public class Booksauthors {
	 String isbn;
	 int author_id;
	 int seq_no;
	 
	 public Booksauthors(String aisbn, int aAuthor_id, int aseq_no) {
		 this.isbn = aisbn;
		 this.author_id = aAuthor_id;
		 this.seq_no = aseq_no;
	 }
	 
	 public String getisbn() {
		 return this.isbn;
	 }
	 
	 public int getauthor_id() {
		 return this.author_id;
	 }
	 
	 public int getseq_no() {
		 return this.seq_no;
	 }
	 
	 @Override
	    public String toString(){
	        String res = "classe " + this.getClass() + "\n";
	        res += "isbn: " + this.isbn + "\n";
	        res += "authors_id: " + this.author_id + "\n";
	        res += "seq_no: " + this.seq_no + "\n";
	        return res;
	    }
}
