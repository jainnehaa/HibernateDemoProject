package implementation;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import valueobjects.Product;
import constants.ProductConstants;

public class SelectQueryHQL {

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

			// all columns of table and hence full vo
			queryStr = "from Product order by productId desc";
			query = session.createQuery(queryStr);
			resultSet = query.list();

			if (!resultSet.isEmpty()) {
				it = resultSet.iterator();
				while (it.hasNext()) {
					obj = it.next();
					p = (Product) obj;
					System.out.println(p.getProductId() + "--" + p.getProName()
							+ "--" + p.getPrice());

				}
			}

			// selecting more than one column but not all
			queryStr = "select productId, proName from Product order by productId";
			query = session.createQuery(queryStr);
			resultSet = query.list();

			it = resultSet.iterator();
			while (it.hasNext()) {
				objArr = (Object[]) it.next();
				System.out.println("1st col : " + objArr[0] + "--"
						+ "2nd col : " + objArr[1]);
			}

			// only one column
			queryStr = "select productId from Product";
			query = session.createQuery(queryStr);
			resultSet = query.list();
			it = resultSet.iterator();
			while (it.hasNext()) {
				Integer intVar = (Integer) it.next();
				System.out.println(intVar);
			}
			// closing all connections
			session.close();
			factory.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private static Query createQuery(String string) {
		// TODO Auto-generated method stub
		return null;
	}

}
