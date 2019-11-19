package design.bookfiltering;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class BookService {
	
	BookRepository repository;
	
	public List<Book> getBooksCriteria(Criteria<Book> criteria) {
		List<Book> allBooks = repository.getAllBooks();
		return allBooks.stream().filter(criteria::matches).collect(Collectors.toList());
	}
	
	public List<Book> getBooksByPredicate(Predicate<Book> predicate) {
		List<Book> allBooks = repository.getAllBooks();
		return allBooks.stream().filter(predicate::test).collect(Collectors.toList());
	}

}
