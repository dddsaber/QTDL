package dao;

import java.util.List;

public interface DAOInterface<T> {
	
	public List<T> selectAll();
	
	public T selectById(String id);
	
	public boolean saveOrUpdate(T element);
	
	public boolean insert(T element);
	
	public boolean update(T element);
	
	public boolean delete(T element);
}
