package implementation;
import java.math.BigDecimal;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import valueobjects.Product;
import constants.ProductConstants;
 
public class ClientForSave {
 
    public static void main(String[] args)
    {
    	try
    	{
    	//to load all configuration files and xml files
        Configuration cfg = new Configuration();
        cfg.configure(ProductConstants.HIBERNATE_CFG);
 
        // to store the object at hibernate layer
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        
        Product p=new Product();
               
 
        // begin logical transaction in db
        Transaction tx = session.beginTransaction();
       String query ="";
        
        
        System.out.println("Object saved successfully.....!!");
        
        // closing all connections
        tx.commit();
        session.close();
        factory.close();
    	}
    	catch(Exception ex)
    	{
    		ex.printStackTrace();
    	}
    }
 
}

