package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import model.Diem;
import model.GiaoVien;
import model.HocSinh;
import model.MonHoc;
import util.HibernateUtil;

public class DiemDAO implements DAOInterface<Diem> {
	@Override
	public List<Diem> selectAll() {
		List<Diem> resultList = new ArrayList<Diem>();
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction transaction = session.beginTransaction();

				String sql = "SELECT * FROM diem";
				SQLQuery query = session.createSQLQuery(sql);
				query.addEntity(Diem.class);

//				Query query = session.createSQLQuery("call Bang_Diem_TB('AV10');");
//				((SQLQuery) query).addEntity(Diem.class);		
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

	
	public List<Diem> selectByMaHS(String id) {
		List<Diem> resultList = new ArrayList<Diem>();
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction transaction = session.beginTransaction();

				String sql = "SELECT * FROM Diem ts WHERE ts.maHS = :maHS";
				SQLQuery query = session.createSQLQuery(sql);
				query.addEntity(Diem.class);
				query.setParameter("maHS", id);
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
	public boolean saveOrUpdate(Diem element) {
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) {
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
	public boolean insert(Diem element) {
		// TODO Auto-generated method stub
		return saveOrUpdate(element);
	}

	@Override
	public boolean update(Diem element) {
		// TODO Auto-generated method stub
		return saveOrUpdate(element);
	}

	@Override
	public boolean delete(Diem element) {
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) {
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

	public List<Diem> selectOnConditions(String maLop, String maMon) {
		List<Diem> resultList = new ArrayList<Diem>();
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction transaction = session.beginTransaction();

//				String sql = "SELECT * FROM diem";
//				SQLQuery query = session.createSQLQuery(sql);
//				query.addEntity(Diem.class);	

				Query query = session.createSQLQuery("call Bang_Nhap_Diem;");
				((SQLQuery) query).addEntity(Diem.class);
				query.executeUpdate();

				if (maMon.equals("All")) {
					maMon = "";
				}

				Query query2 = session.createSQLQuery("call LayDiemTheoMonLop(:maMon, :maLop);");
				((SQLQuery) query2).addEntity(Diem.class);
				query2.setParameter("maLop", maLop);
				query2.setParameter("maMon", maMon);
				resultList = query2.list();

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

	

	public List TimDSDiem(String maMon, String MaHS) {
		List<Diem> resultList = new ArrayList<Diem>();
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction transaction = session.beginTransaction();
				
				if (maMon.equals("All")) {
					maMon = "";
				}
				
				String sql = "SELECT * FROM diem \r\n"
						+ "WHERE (MaMonHoc like concat('%', :MaMonHoc, '%')) and (MaHS like concat('%', :MaHS, '%'));	";
				SQLQuery query = session.createSQLQuery(sql);
				query.addEntity(Diem.class);
				query.setParameter("MaMonHoc", maMon);
				query.setParameter("MaHS", MaHS);
				resultList = query.list();

				transaction.commit();
				session.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultList;
	}

	public List<Diem> getDSXepHangTheoMon(String maMon, String lop) {
		List<Diem> resultList = new ArrayList<Diem>();
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if(sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction transaction = session.beginTransaction();
				
				if (maMon.equals("All")) {
					maMon = "";
				}
				
				String sql = "CALL getDSHSXepHangTheoMon(:maMon, :lop)";
				SQLQuery query = session.createSQLQuery(sql);
				query.setParameter("maMon", maMon);
				query.setParameter("lop", lop);
				query.addEntity(Diem.class);	
					
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
	public Diem selectById(String id) {
		// TODO Auto-generated method stub
		return null;
	}
}
