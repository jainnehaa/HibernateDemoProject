package implementation;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import valueobjects.Product;
import constants.ProductConstants;

public class ParameterizedSelectHQL {

	public static void main(String[] args) {
		try {

			Configuration cfg = new Configuration();
			cfg.configure(ProductConstants.HIBERNATE_CFG);
			SessionFactory factory = cfg.buildSessionFactory();
			Session session = factory.openSession();

			Product p = new Product();
			Object obj;
			Query query;
			List resultSet;
			Iterator it;
			String queryStr;
			Object[] objArr;
			String prodName;
			int prodId = 0;
			
			// using labels
			queryStr = "select proName from Product where productId= :prodId";
			query = session.createQuery(queryStr);
			query.setInteger("prodId", ProductConstants.DUMMY_PROD_ID);
			resultSet = query.list();
			it = resultSet.iterator();
			if (it != null) {
				while (it.hasNext()) {
					prodName = it.next().toString();
					System.out.println(prodName);
				}
			}
			
			// using question mark
			queryStr = "select proName from Product where price =?";
			query = session.createQuery(queryStr);
			query.setParameter(0,new Float(ProductConstants.DUMMY_PRICE));
			resultSet = query.list();
			it = resultSet.iterator();
			if (it != null) {
				while (it.hasNext()) {
					prodName = it.next().toString();
					System.out.println(prodName);
				}
			}
			// closing all connections
			session.close();
			factory.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
