package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import model.ThiSinh;
import util.HibernateUtil;

public class ThiSinhDAO implements DAOInterface<ThiSinh> {

	@Override
	public List<ThiSinh> selectAll() {
		List<ThiSinh> resultList = new ArrayList<ThiSinh>();
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if(sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction transaction = session.beginTransaction();
				
				
				String sql = "SELECT * FROM THISINH";
				SQLQuery query = session.createSQLQuery(sql);
				query.addEntity(ThiSinh.class);		
				resultList = query.list();
				
//				String hql = "from ThiSinh";
//				Query query = session.createQuery(hql);
//				resultList = query.getResultList();
				
				transaction.commit();
				session.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultList;
	}

	@Override
	public ThiSinh selectById(String id) {
		List<ThiSinh> resultList = new ArrayList<ThiSinh>();
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if(sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction transaction = session.beginTransaction();
				
				String sql = "SELECT * FROM THISINH ts WHERE ts.id = :id";
				SQLQuery query = session.createSQLQuery(sql);
				query.addEntity(ThiSinh.class);		
				query.setParameter("id", id);
				resultList = query.list();
				
//				String hql = "from ThiSinh ts where ts.id = :id";
//				Query query = session.createQuery(hql);
//				
//				resultList = query.getResultList();
				
				transaction.commit();
				session.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultList.size() > 0 ? resultList.get(0) : null;
	}

	@Override
	public boolean saveOrUpdate(ThiSinh element) {
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
	public boolean insert(ThiSinh element) {
		// TODO Auto-generated method stub
		return saveOrUpdate(element);
	}

	@Override
	public boolean update(ThiSinh element) {
		// TODO Auto-generated method stub
		return saveOrUpdate(element);
	}

	@Override
	public boolean delete(ThiSinh element) {
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
