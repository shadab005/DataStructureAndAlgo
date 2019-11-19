package design.bookfiltering;

public class CategoryCriteria implements Criteria<Book> {
	
	private String categoryName;
	
	public CategoryCriteria(String category) {
		categoryName = category;
	}

	@Override
	public boolean matches(Book candidate) {
		return categoryName.equals(candidate.category);
	}

}
