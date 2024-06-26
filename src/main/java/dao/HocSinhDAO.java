package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.GiaoVien;
import model.HocSinh;
import model.MonHoc;
import util.HibernateUtil;

public class HocSinhDAO implements DAOInterface<HocSinh>{

	@Override
	public List<HocSinh> selectAll() {
		List<HocSinh> resultList = new ArrayList<HocSinh>();
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if(sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction transaction = session.beginTransaction();
				
				
				String sql = "SELECT * FROM hocsinh";
				SQLQuery query = session.createSQLQuery(sql);
				query.addEntity(HocSinh.class);		
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
	public HocSinh selectById(String id) {
		List<HocSinh> resultList = new ArrayList<HocSinh>();
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if(sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction transaction = session.beginTransaction();
				
				String sql = "SELECT * FROM HocSinh hs WHERE hs.maHS = :id";
				SQLQuery query = session.createSQLQuery(sql);
				query.addEntity(HocSinh.class);		
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
	public boolean saveOrUpdate(HocSinh element) {
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
	public boolean insert(HocSinh element) {
		// TODO Auto-generated method stub
		return saveOrUpdate(element);
	}

	@Override
	public boolean update(HocSinh element) {
		// TODO Auto-generated method stub
		return saveOrUpdate(element);
	}

	@Override
	public boolean delete(HocSinh element) {
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
	
	public boolean deleteAnyway(HocSinh element) {
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if(sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction transaction = session.beginTransaction();
				
				Query query = session.createSQLQuery("call Xoa_Hoc_Sinh(:maHS);");
				query.setParameter("maHS", element.getMaHS());
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
	
	public List<HocSinh> getDSXepHangTheoMon(String maMon, String lop) {
		List<HocSinh> resultList = new ArrayList<HocSinh>();
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if(sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction transaction = session.beginTransaction();
				
				
				String sql = "CALL getDSHSXepHangTheoMon(:maMon, :lop);";
				SQLQuery query = session.createSQLQuery(sql);
				query.setParameter("maMon", maMon);
				query.setParameter("lop", lop);
				query.addEntity(HocSinh.class);		
				resultList = query.list();

				transaction.commit();
				session.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultList;
	}
	
	
	public List<HocSinh> getDSHSDuDienKienXetHocLuc(String lop) {
		List<HocSinh> resultList = new ArrayList<HocSinh>();
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if(sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction transaction = session.beginTransaction();
				
				
				String sql = "CALL getDSHSDuDienKienXetHocLuc(:lop)";
				SQLQuery query = session.createSQLQuery(sql);
				query.setParameter("lop", lop);
				query.addEntity(HocSinh.class);		
				resultList = query.list();

				transaction.commit();
				session.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultList;
	}

	public List<HocSinh> selectAllAsc() {
		List<HocSinh> resultList = new ArrayList<HocSinh>();
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if(sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction transaction = session.beginTransaction();
				
				
				String sql = "SELECT * FROM hocsinh ORDER BY SUBSTRING_INDEX(HoTenHS, ' ', -1) ASC";
				SQLQuery query = session.createSQLQuery(sql);
				query.addEntity(HocSinh.class);		
				resultList = query.list();

				transaction.commit();
				session.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultList;
	}

	public List<HocSinh> selectAllDesc() {
		List<HocSinh> resultList = new ArrayList<HocSinh>();
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if(sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction transaction = session.beginTransaction();
				
				
				String sql = "SELECT * FROM hocsinh ORDER BY SUBSTRING_INDEX(HoTenHS, ' ', -1) DESC";
				SQLQuery query = session.createSQLQuery(sql);
				query.addEntity(HocSinh.class);		
				resultList = query.list();

				transaction.commit();
				session.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultList;
	}
}