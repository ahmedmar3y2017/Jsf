package Service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import Entities.HibernateUtil;
import Entities.Topics;

public class topicService {
	
//	public static void main(String [] args) {
//		
//		new topicService().getAll();
//		
//	}
private List<Topics>  getAll() {
	// TODO Auto-generated method stub

	 Session session = HibernateUtil.getSessionFactory().openSession();
	    
     session.beginTransaction();
     Query q = session.createQuery("From Topics ");
     
     List<Topics> resultList = q.list();
     System.out.println("num of Topics :" + resultList.size());
     for (Topics next : resultList) {
         System.out.println( next.getUsername());
     }
		
   
     session.getTransaction().commit();

session.close();
		
return resultList;
	
}

}
