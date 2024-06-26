package entidades;


public class Books {
	 String title;
	 String isbn;
	 int publisher_id;
	 double price; 
	 
	 public Books(String atitle, String aisbn, int apublisher_id, double aprice) {
		 this.title = atitle;
		 this.isbn= aisbn;
		 this.publisher_id= apublisher_id;
		 this.price= aprice; 
	 }
	 
	 public String getTitle() {
		 return this.title;
	 }
	 
	 public String getIsbn() {
		 return this.isbn;
	 }
	 
	 public int getPublisher_id() {
		 return this.publisher_id;
	 }
	 
	 public double getPrice() {
		 return this.price;
	 }
	 
	 @Override
	 public String toString() {
		String res = "classe " + this.getClass() + "\n";
		res += "title: " + this.title + "\n";
		res += "isbn: " + this.isbn + "\n";
		res += "publisher_id: " + this.publisher_id + "\n";
		res += "price: " + this.price + "\n";
		
		return res;
	 }
}