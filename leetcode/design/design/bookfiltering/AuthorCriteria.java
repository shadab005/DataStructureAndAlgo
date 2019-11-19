package design.bookfiltering;

public class AuthorCriteria implements Criteria<Book> {
	
	private String authorName;
	
	AuthorCriteria(String authorName) {
	  this.authorName = authorName;	
	}

	@Override
	public boolean matches(Book candidate) {
		return candidate.author.equals(authorName);
	}

}
