package web;

import java.util.List;
.....
import model.Book;
import service.BookService;

import com.opensymphony.xwork2.ActionSupport;

public class BookAction extends ActionSupport {
	private List<Book> books;
	private BookService BookService = new BookService();
	private Book Book;
	private int ISBN;
	private String Name;//ËÑË÷´«Öµ
	public String ShowAll() throws Exception {
		books = BookService.ShowAll();
		return SUCCESS;
	}
	public String list() throws Exception {
		books = BookService.list(Name);
		return SUCCESS;
	}
	public String delete() {
		BookService.deleteById(ISBN);
		return SUCCESS;
	}
	public String ShowDetail() {
		Book=BookService.ShowDetail(ISBN);
		return SUCCESS;
	}


	public String getName() {
		return Name;
	}
	public void setName(String Name) {
		this.Name = Name;
	}


	public List<Book> getbooks() {
		return books;
	}
	public void setbooks(List<Book> books) {
		this.books = books;
	}

	public BookService getBookService() {
		return BookService;
	}
	public void setBookService(BookService BookService) {
		this.BookService = BookService;
	}

	public Book getBook() {
		return Book;
	}
	public void setBook(Book Book) {
		this.Book = Book;
	}

	public int getISBN() {
		return ISBN;
	}
	public void setISBN(int ISBN) {
		this.ISBN = ISBN;
	}
}
