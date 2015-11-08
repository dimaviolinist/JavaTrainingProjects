package by.dimaviolinit.yoshop.DAO;

import java.sql.SQLException;
import java.util.List;

import by.dimaviolinit.yoshop.domain.Model;

public interface IModelDAO {

	public boolean addModel(Model model) throws SQLException;

	public boolean updateModel(Model model);

	public boolean deleteModel(int modelId);

	public Model getModel(int modelId) throws SQLException;

	public List<Model> getModels(int categoryId) throws SQLException;

	public List<Model> getModels(int categoryId, int from, int pageSize);

}
