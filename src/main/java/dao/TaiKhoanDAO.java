package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.GiaoVien;
import model.TaiKhoan;
import util.HibernateUtil;

public class TaiKhoanDAO implements DAOInterface<TaiKhoan>{

	@Override
	public List<TaiKhoan> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TaiKhoan selectById(String tenTK) {
		List<TaiKhoan> resultList = new ArrayList<TaiKhoan>();
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if(sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction transaction = session.beginTransaction();
				
				String sql = "SELECT * FROM taikhoan tk WHERE tk.tenTK = :tenTK";
				SQLQuery query = session.createSQLQuery(sql);
				query.addEntity(TaiKhoan.class);		
				query.setParameter("tenTK", tenTK);
				resultList = query.list();
								
				transaction.commit();
				session.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultList.size() > 0 ? resultList.get(0) : null;
	}

	@Override
	public boolean saveOrUpdate(TaiKhoan element) {
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if(sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction transaction = session.beginTransaction();
				
				session.saveOrUpdate(element);
				
				transaction.commit();
				session.close();
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean insert(TaiKhoan element) {
		// TODO Auto-generated method stub
		return saveOrUpdate(element);
	}

	@Override
	public boolean update(TaiKhoan element) {
		// TODO Auto-generated method stub
		return saveOrUpdate(element);
	}

	@Override
	public boolean delete(TaiKhoan element) {
		// TODO Auto-generated method stub
		return false;
	}

}
