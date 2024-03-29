package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.HocSinh;
import model.ThongKeHS;
import util.HibernateUtil;

public class ThongKeDAO implements DAOInterface<ThongKeHS>{

	@Override
	public List<ThongKeHS> selectAll() {
		
		return null;
	}
	
	public List<ThongKeHS> layDSThongKe(String lop){
		List<ThongKeHS> resultList = new ArrayList<ThongKeHS>();
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if(sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction transaction = session.beginTransaction();
				
				
				String sql = "CALL LayDSThongKe(:lop);";
				SQLQuery query = session.createSQLQuery(sql);
				query.addEntity(ThongKeHS.class);	
				query.setParameter("lop", lop);
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
	public ThongKeHS selectById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean saveOrUpdate(ThongKeHS element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insert(ThongKeHS element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(ThongKeHS element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(ThongKeHS element) {
		// TODO Auto-generated method stub
		return false;
	}

	
}