package by.dimaviolinit.yoshop.DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.dimaviolinit.yoshop.DAO.ICategoryDAO;
import by.dimaviolinit.yoshop.DAO.connectionpool.ConnectionPool;
import by.dimaviolinit.yoshop.domain.Category;
import by.dimaviolinit.yoshop.exception.ConnectionPoolException;

public class SQLCategoryDAO implements ICategoryDAO {

	private static ConnectionPool connectionPool;
	private static SQLCategoryDAO instance;

	private static final String ADDCATEGORYQUERY = "INSERT INTO categories (id,name,imageId,parentId) VALUES (?,?,?,?)";
	private static final String GETCATEGORYQUERY = "SELECT * FROM categories WHERE id = ?";
	private static final String ROOTCATEGORIESQUERY = "SELECT * FROM categories WHERE parentId = 0 ORDER BY id";
	private static final String GETSUBSATEGORIESQUERY = "SELECT * FROM categories WHERE parentId = ? ORDER BY id";

	private SQLCategoryDAO() {

	}

	public static SQLCategoryDAO getInstance(ConnectionPool pool) {
		if (instance == null) {
			connectionPool = pool;
			instance = new SQLCategoryDAO();
		}
		return instance;
	}

	@Override
	public boolean addCategory(Category category) throws SQLException {

		int result = 0;
		try (Connection connection = connectionPool.takeConnection();
				PreparedStatement pStmt = connection.prepareStatement(ADDCATEGORYQUERY)) {
			pStmt.setInt(1, category.getId());
			pStmt.setString(2, category.getName());
			pStmt.setInt(3, category.getImageId());
			if (category.getParentId() == 0) {
				pStmt.setNull(4, java.sql.Types.INTEGER);
			} else {
				pStmt.setInt(4, category.getParentId());
			}
			result = pStmt.executeUpdate();
		} catch (ConnectionPoolException e) {
			e.printStackTrace();

		}
		if (result > 0) {
			return true;
		}
		return false;
	}

	@Override
	public Category getCategory(int categoryId) throws SQLException {

		// First attempt

		// Category category = new Category();
		// Connection connection;
		// try {
		// connection = connectionPool.takeConnection();
		// PreparedStatement pStmt = connection.prepareStatement("SELECT * FROM
		// categories WHERE id = ?");
		// pStmt.setInt(1, categoryId);
		// ResultSet rs = pStmt.executeQuery();
		// rs.next();
		// category = DataReaderEx.toCategory(rs);
		// connection.close();
		//
		// } catch (ConnectionPoolException e) {
		//
		// e.printStackTrace();
		// }
		// return category;

		// Second attempt

		// Category category = new Category();
		// try {
		// try (Connection connection = connectionPool.takeConnection()) {
		// try (PreparedStatement pStmt = connection.prepareStatement("SELECT *
		// FROM categories WHERE id = ?")) {
		// pStmt.setInt(1, categoryId);
		// ResultSet rs = pStmt.executeQuery();
		// rs.next();
		// category = DataReaderEx.toCategory(rs);
		// }
		// }
		// } catch (ConnectionPoolException e) {
		// e.printStackTrace();
		// }
		// return category;

		Category category = new Category();
		try (Connection connection = connectionPool.takeConnection();
				PreparedStatement pStmt = connection.prepareStatement(GETCATEGORYQUERY)) {
			pStmt.setInt(1, categoryId);
			try (ResultSet rs = pStmt.executeQuery()) {
				rs.next();
				category = DataReaderEx.toCategory(rs);
			}
		} catch (ConnectionPoolException e) {
			e.printStackTrace();

		}
		return category;
	}

	@Override
	public List<Category> rootCategories() throws SQLException {

		List<Category> categories = new ArrayList<Category>();
		try (Connection connection = connectionPool.takeConnection();
				PreparedStatement pStmt = connection.prepareStatement(ROOTCATEGORIESQUERY)) {
			try (ResultSet rs = pStmt.executeQuery()) {
				while (rs.next()) {
					categories.add(DataReaderEx.toCategory(rs));
				}
			}
		} catch (ConnectionPoolException e) {
			e.printStackTrace();
		}
		return categories;
	}

	@Override
	public List<Category> getSubCategories(int categoryId) throws SQLException {

		List<Category> categories = new ArrayList<Category>();
		try (Connection connection = connectionPool.takeConnection();
				PreparedStatement pStmt = connection.prepareStatement(GETSUBSATEGORIESQUERY)) {
			pStmt.setInt(1, categoryId);
			try (ResultSet rs = pStmt.executeQuery()) {
				while (rs.next()) {
					categories.add(DataReaderEx.toCategory(rs));
				}
			}
		} catch (ConnectionPoolException e) {
			e.printStackTrace();
		}
		return categories;
	}

	@Override
	public List<Category> getAllSubCategories(int categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countModels(int categoryId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean updateCategory(Category category) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteCategory(int categoryId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Category> pathToRoot(int categoryId) {
		// TODO Auto-generated method stub
		return null;
	}
}
