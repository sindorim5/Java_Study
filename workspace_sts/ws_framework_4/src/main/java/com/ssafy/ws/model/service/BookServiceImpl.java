package com.ssafy.ws.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.ibatis.session.SqlSession;
import com.ssafy.ws.dto.Book;
import com.ssafy.ws.model.repo.BookRepo;

/**
 * 빈으로 등록될 수 있도록 @Service를 선언한다.
 *
 */
@Service
public class BookServiceImpl implements BookService {
	/**
	 * has a 관계로 사용할 BookRepo 타입의 repo를 선언한다.
	 */
	private BookRepo repo;
	
	/**
	 * setter를 통해 BookRepo를 주입받는다.
	 * @Autowired를 통해 BookRepo 타입의 빈을 주입 받는다.
	 * @param repo
	 */
	@Autowired
	public void setBookRepo(BookRepo repo) {
		this.repo = repo;
	}

	public BookRepo getBookRepo() {
		return repo;
	}

	@Override
	public int insert(Book book) {
	    return repo.insert(book);
	}

	@Override
	public int update(Book book) {
	    return repo.update(book);
	}

	@Override
	public int delete(String isbn) {
	    return repo.delete(isbn);
	}

	@Override
	public Book select(String isbn) {
	    return repo.select(isbn);
	}

	@Override
	public List<Book> search() {
	    return repo.search();
	}

}
