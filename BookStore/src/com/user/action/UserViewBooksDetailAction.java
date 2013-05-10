package com.user.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.model.Book;
import com.opensymphony.xwork2.ActionSupport;
import com.service.BookService;

public class UserViewBooksDetailAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5528713309701737345L;
	private BookService bookServiceImpl;
	private Book book;
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpSession session = request.getSession();
	String id = (String) request.getParameter("id");
	private Integer bookId;
	private String imgPath;

	// private Map<Integer,Book>books = new HashMap<Integer,Book>();
	// private List<Book>books = new ArrayList<Book>();

	@Override
	public String execute() throws Exception {
		bookId = Integer.parseInt(id);
		setBookId(bookId);
		book = bookServiceImpl.queryByBookId(bookId);
		// books.add(book);
		// books.put(bookId, book);
		// session.setAttribute("books", books);
		imgPath = "../images/" + book.getBookImage();
		setImgPath(imgPath);

		return SUCCESS;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public BookService getBookServiceImpl() {
		return bookServiceImpl;
	}

	public void setBookServiceImpl(BookService bookServiceImpl) {
		this.bookServiceImpl = bookServiceImpl;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

}
