package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.ChuNhiem;
import model.GiaoVien;
import util.HibernateUtil;

public class ChuNhiemDAO implements DAOInterface<ChuNhiem> {

	@Override
	public List<ChuNhiem> selectAll() {
		List<ChuNhiem> resultList = new ArrayList<ChuNhiem>();
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if(sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction transaction = session.beginTransaction();
				
				
				String sql = "SELECT * FROM chunhiem";
				SQLQuery query = session.createSQLQuery(sql);
				query.addEntity(ChuNhiem.class);		
				resultList = query.list();
				
				
				transaction.commit();
				session.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultList;
	}

	@Override
	public ChuNhiem selectById(String id) {
		List<ChuNhiem> resultList = new ArrayList<ChuNhiem>();
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if(sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction transaction = session.beginTransaction();
				
				String sql = "SELECT * FROM ChuNhiem ts WHERE ts.id = :id";
				SQLQuery query = session.createSQLQuery(sql);
				query.addEntity(ChuNhiem.class);		
				query.setParameter("id", id);
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
	public boolean saveOrUpdate(ChuNhiem element) {
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
	public boolean insert(ChuNhiem element) {
		// TODO Auto-generated method stub
		return saveOrUpdate(element);
	}

	@Override
	public boolean update(ChuNhiem element) {
		// TODO Auto-generated method stub
		return saveOrUpdate(element);
	}

	@Override
	public boolean delete(ChuNhiem element) {
		// TODO Auto-generated method stub
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if(sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction transaction = session.beginTransaction();
				
				session.delete(element);
				
				transaction.commit();
				session.close();
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}