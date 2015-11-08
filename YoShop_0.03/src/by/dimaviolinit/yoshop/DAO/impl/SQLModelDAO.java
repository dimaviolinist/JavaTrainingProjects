package by.dimaviolinit.yoshop.DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.dimaviolinit.yoshop.DAO.IModelDAO;
import by.dimaviolinit.yoshop.DAO.connectionpool.ConnectionPool;
import by.dimaviolinit.yoshop.domain.Model;
import by.dimaviolinit.yoshop.exception.ConnectionPoolException;

public class SQLModelDAO implements IModelDAO {

	private static ConnectionPool connectionPool;
	private static SQLModelDAO instance;

	private static final String ADDMODELQUERY = "INSERT INTO models (id,imageId,price,warranty,title,description,delivery,availability,categoryId) VALUES (?,?,?,?,?,?,?,?,?)";
	private static final String GETMODELQUERY = "SELECT * FROM models WHERE id = ?";
	private static final String GETMODELSQUERY = "SELECT * FROM models WHERE categoryId = ? ORDER BY id";

	private SQLModelDAO() {

	}

	public static SQLModelDAO getInstance(ConnectionPool pool) {
		if (instance == null) {
			connectionPool = pool;
			instance = new SQLModelDAO();
		}
		return instance;
	}

	@Override
	public boolean addModel(Model model) throws SQLException {

		int result = 0;
		try (Connection connection = connectionPool.takeConnection();
				PreparedStatement pStmt = connection.prepareStatement(ADDMODELQUERY)) {
			pStmt.setInt(1, model.getId());
			pStmt.setInt(2, model.getImageId());
			pStmt.setDouble(3, model.getPrice());
			pStmt.setInt(4, model.getWarranty());
			pStmt.setString(5, model.getTitle());
			pStmt.setString(6, model.getDescription());
			pStmt.setString(7, model.getDelivery());
			pStmt.setString(8, model.getAvailability());
			pStmt.setInt(9, model.getCategoryId());
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
	public Model getModel(int modelId) throws SQLException {

		Model model = new Model();
		try (Connection connection = connectionPool.takeConnection();
				PreparedStatement pStmt = connection.prepareStatement(GETMODELQUERY)) {
			pStmt.setInt(1, modelId);
			try (ResultSet rs = pStmt.executeQuery()) {
				rs.next();
				model = DataReaderEx.toModel(rs);
			}
		} catch (ConnectionPoolException e) {
			e.printStackTrace();

		}
		return model;
	}

	@Override
	public List<Model> getModels(int categoryId) throws SQLException {

		List<Model> models = new ArrayList<Model>();
		try (Connection connection = connectionPool.takeConnection();
				PreparedStatement pStmt = connection.prepareStatement(GETMODELSQUERY)) {
			pStmt.setInt(1, categoryId);
			try (ResultSet rs = pStmt.executeQuery()) {
				while (rs.next()) {
					models.add(DataReaderEx.toModel(rs));
				}
			}
		} catch (ConnectionPoolException e) {
			e.printStackTrace();
		}
		return models;
	}

	@Override
	public List<Model> getModels(int categoryId, int from, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateModel(Model model) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteModel(int modelId) {
		// TODO Auto-generated method stub
		return false;
	}
}
