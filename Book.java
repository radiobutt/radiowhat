package model;
123
public class Book {
	private int ISBN;
	private int AuthorID;
	private String Title;
	private String Publisher;
	private String PublishDate;
	private String Price;
	private String Name;
	private int Age;
	private String Country;
	public int getISBN() {
		return ISBN;
	}
	public void setISBN(int ISBN) {
		this.ISBN = ISBN;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String Title) {
		this.Title = Title;
	}
	public String getPublisher() {
		return Publisher;
	}
	public void setPublisher(String Publisher) {
		this.Publisher= Publisher;
	}
	public String getName() {
		return Name;
	}
	public void setPublishDate(String PublishDate) {
		this.PublishDate =PublishDate;
	}
	public String getPrice() {
		return Price;
	}
	public void setPrice(String Price) {
		this.Price = Price;
	}
	public int getAuthorID() {
		return AuthorID;
	}
	public void setAuthorID(int AuthorID) {
		this.AuthorID = AuthorID;
	}


	public void setName(String Name) {
		this.Name = Name;
	}
	public String getPublishDate() {
		return PublishDate;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int Age) {
		this.Age = Age;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String Country) {
		this.Country = Country;
	}

}
