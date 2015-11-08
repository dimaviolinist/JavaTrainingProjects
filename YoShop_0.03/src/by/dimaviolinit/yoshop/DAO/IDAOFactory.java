package by.dimaviolinit.yoshop.DAO;

public interface IDAOFactory {

	public ICategoryDAO getCategoryDAO();

	public IModelDAO getModelDAO();

	public IUserDAO getUserDAO();

}
