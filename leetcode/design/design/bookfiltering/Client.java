package design.bookfiltering;

import java.util.List;
import java.util.function.Predicate;

public class Client {

	public static void main(String[] args) {
		testBookFilteringUsingCriteria();
		testBookFilteringUsingPredicate();

	}
	
	private static void testBookFilteringUsingCriteria() {
		BookService bookService = new BookService();
		// Filtering book by two criteria
		List<Book> books = bookService.getBooksCriteria(new AuthorCriteria("Dan Brown").and(new CategoryCriteria("Fiction")));
		System.out.println(books);
	}

	private static void testBookFilteringUsingPredicate() {
		BookService bookService = new BookService();
		// Filtering book by two criteria
		List<Book> books = bookService.getBooksByPredicate((getAuthorPredicate("Dan Brown")).and(getCategoryPredicate("Fiction")));
		System.out.println(books);

	}
	
	private static Predicate<Book> getAuthorPredicate(String authorName) {
		return b -> b.author.equals(authorName);
	}
	
	private static Predicate<Book> getCategoryPredicate(String category) {
		return b->b.category.equals(category);
	}

}
