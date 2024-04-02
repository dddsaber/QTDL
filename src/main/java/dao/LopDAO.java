package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.GiaoVien;
import model.Lop;
import util.HibernateUtil;

public class LopDAO implements DAOInterface<Lop> {

	@Override
	public List<Lop> selectAll() {
		List<Lop> resultList = new ArrayList<Lop>();
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if(sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction transaction = session.beginTransaction();
				
				
				String sql = "SELECT * FROM Lop";
				SQLQuery query = session.createSQLQuery(sql);
				query.addEntity(Lop.class);		
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
	public Lop selectById(String MaLop) {
		List<Lop> resultList = new ArrayList<Lop>();
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if(sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction transaction = session.beginTransaction();
				
				String sql = "SELECT * FROM Lop ts WHERE ts.MaLop = :MaLop";
				SQLQuery query = session.createSQLQuery(sql);
				query.addEntity(Lop.class);		
				query.setParameter("MaLop", MaLop);
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
	public boolean saveOrUpdate(Lop element) {
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
	public boolean insert(Lop element) {
		// TODO Auto-generated method stub
		return saveOrUpdate(element);
	}

	@Override
	public boolean update(Lop element) {
		// TODO Auto-generated method stub
		return saveOrUpdate(element);
	}

	@Override
	public boolean delete(Lop element) {
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
	
	public boolean deleteAnyway(Lop element) {
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if(sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction transaction = session.beginTransaction();
				
				Query query = session.createSQLQuery("call Xoa_Lop(:maLop);");
				query.setParameter("maLop", element.getMaLop());
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
	
	public int laySoHS(Lop element) {
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if(sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction transaction = session.beginTransaction();
				
				Query query = session.createSQLQuery("select tinhSoHS(:maLop);");
				query.setParameter("maLop", element.getMaLop());
				Float sohs = (Float) query.uniqueResult();
	            
	            // Kiểm tra nếu kết quả là null
	            int soHocSinh = sohs != null ? Math.round(sohs) : 0;
				
				transaction.commit();
				session.close();
				return soHocSinh;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}