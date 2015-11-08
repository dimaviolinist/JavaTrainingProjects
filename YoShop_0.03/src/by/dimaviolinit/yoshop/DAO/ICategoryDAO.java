package by.dimaviolinit.yoshop.DAO;

import java.sql.SQLException;
import java.util.List;

import by.dimaviolinit.yoshop.domain.Category;

public interface ICategoryDAO {

	public boolean addCategory(Category category) throws SQLException;

	public boolean updateCategory(Category category);

	public boolean deleteCategory(int categoryId);

	public Category getCategory(int categoryId) throws SQLException;

	public List<Category> rootCategories() throws SQLException;

	public List<Category> pathToRoot(int categoryId);

	public List<Category> getSubCategories(int categoryId) throws SQLException;

	public List<Category> getAllSubCategories(int categoryId);

	public int countModels(int categoryId);

}
