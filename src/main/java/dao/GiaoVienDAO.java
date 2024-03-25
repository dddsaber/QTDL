package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Diem;
import model.GiaoVien;
import model.GiaoVien;
import util.HibernateUtil;

public class GiaoVienDAO implements DAOInterface<GiaoVien> {

	@Override
	public List<GiaoVien> selectAll() {
		List<GiaoVien> resultList = new ArrayList<GiaoVien>();
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if(sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction transaction = session.beginTransaction();
				
				
				String sql = "SELECT * FROM giaovien";
				SQLQuery query = session.createSQLQuery(sql);
				query.addEntity(GiaoVien.class);		
				resultList = query.list();
				
//				String hql = "from GiaoVien";
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
	public GiaoVien selectById(String id) {
		List<GiaoVien> resultList = new ArrayList<GiaoVien>();
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if(sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction transaction = session.beginTransaction();
				
				String sql = "SELECT * FROM GiaoVien ts WHERE ts.id = :id";
				SQLQuery query = session.createSQLQuery(sql);
				query.addEntity(GiaoVien.class);		
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
	public boolean saveOrUpdate(GiaoVien element) {
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
	public boolean insert(GiaoVien element) {
		// TODO Auto-generated method stub
		return saveOrUpdate(element);
	}

	@Override
	public boolean update(GiaoVien element) {
		// TODO Auto-generated method stub
		return saveOrUpdate(element);
	}

	@Override
	public boolean delete(GiaoVien element) {
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
	
	public boolean deleteAnyway(GiaoVien element) {
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if(sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction transaction = session.beginTransaction();
				
				Query query = session.createSQLQuery("call Xoa_Giao_Vien(:maGV);");
				query.setParameter("maGV", element.getMaGV());
				query.executeUpdate();
				
				transaction.commit();
				session.close();
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public List<GiaoVien> selectOnQuery(String id, String hoten, String diachi) {
		List<GiaoVien> resultList = new ArrayList<GiaoVien>();
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if(sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction transaction = session.beginTransaction();
				
				
				String sql = "SELECT * FROM giaovien gv WHERE gv.hoten LIKE '%:hoten%' AND gv.diachi LIKE '%:diachi%'";
				SQLQuery query = session.createSQLQuery(sql);
				query.addEntity(GiaoVien.class);	
				query.setParameter("hoten", hoten);
				query.setParameter("diachi", diachi);
				
				resultList = query.list();
				
//				String hql = "from GiaoVien";
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
}
