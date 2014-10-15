package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.DB;
import model.Book;

public class BookService {

	public List<Book> list(String Name) throws SQLException {
		String sql;

		Connection conn = DB.createConn();
		if( Name !="")
		sql = "SELECT book.ISBN AS ISBN,book.Title AS Title,author.Name AS Name FROM book JOIN author  ON author.AuthorID=book.AuthorID where Name LIKE '%"+Name+"%'";
		else
		sql = "	SELECT book.ISBN AS ISBN,book.Title AS Title,author.Name AS Name FROM book JOIN author  ON author.AuthorID=book.AuthorID ";
		PreparedStatement ps = DB.prepare(conn, sql);
		List<Book> books = new ArrayList<Book>();
		try {
			ResultSet rs = ps.executeQuery();
			Book c = null;
			while(rs.next()) {
				c = new Book();
				c.setISBN(rs.getInt("ISBN"));
				c.setTitle(rs.getString("Title"));
				c.setName(rs.getString("Name"));
				books.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw(e);
		}
		DB.close(ps);
		DB.close(conn);
		return books;
	}
	public void add(Book c) {
		Connection conn = DB.createConn();
		String sql = "insert into book values (null, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = DB.prepare(conn, sql);
		try {
			ps.setInt(1, c.getISBN());
			ps.setString(2, c.getTitle());
			ps.setInt(3, c.getAuthorID());
			ps.setString(4, c.getPublisher());
			ps.setString(5, c.getPublishDate());
			ps.setString(6, c.getPrice());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DB.close(ps);
		DB.close(conn);
	}



	public void deleteById(int ISBN) {
		Connection conn = DB.createConn();
		String sql = "delete from book where ISBN = ?";
		PreparedStatement ps = DB.prepare(conn, sql);
		try {
			ps.setInt(1, ISBN);
			ps.executeUpdate();
		 } catch (SQLException e) {
			e.printStackTrace();
		}
		DB.close(ps);
		DB.close(conn);
	}

	public Book ShowDetail(int ISBN) {
		Connection conn = DB.createConn();
		Book c = null;
		c = new Book();
		String sql = "SELECT book.ISBN AS ISBN,book.Title AS Title,book.Publisher AS Publisher,book.PublishDate AS PublishDate,book.Price AS Price,author.Name AS Name,author.Age AS Age,author.Country AS Country FROM book JOIN author  ON author.AuthorID=book.AuthorID  where book.ISBN =?";
		PreparedStatement ps = DB.prepare(conn, sql);
		try {
			ps.setInt(1, ISBN);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				c.setISBN(rs.getInt("ISBN"));
				c.setTitle(rs.getString("Title"));
				c.setPublisher(rs.getString("Publisher"));
				c.setPublishDate(rs.getString("PublishDate"));
				c.setPrice(rs.getString("Price"));
				c.setName(rs.getString("Name"));
				c.setAge(rs.getInt("Age"));
				c.setCountry(rs.getString("Country"));
				}
			} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(c.getTitle());
		DB.close(ps);
		DB.close(conn);
		return c;
	}
	public List<Book> ShowAll() throws SQLException {
		String sql;

		Connection conn = DB.createConn();
		sql = "	SELECT book.ISBN AS ISBN,book.Title AS Title,author.Name AS Name FROM book JOIN author  ON author.AuthorID=book.AuthorID ";
		PreparedStatement ps = DB.prepare(conn, sql);
		List<Book> books = new ArrayList<Book>();
		try {
			ResultSet rs = ps.executeQuery();
			Book c = null;
			while(rs.next()) {
				c = new Book();
				c.setISBN(rs.getInt("ISBN"));
				c.setTitle(rs.getString("Title"));
				c.setName(rs.getString("Name"));
				books.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw(e);
		}
		DB.close(ps);
		DB.close(conn);
		return books;
	}
}
