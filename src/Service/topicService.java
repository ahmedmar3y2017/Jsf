package Service;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import Entities.HibernateUtil;
import Entities.Topics;

public class topicService {

	// public static void main(String[] args) {
	//
	//// new topicService().insert(new Topics("10", "ahmed", "ahmed"));
	//// new topicService().delete(new Topics("10", "ahmed", "ahmed"));
	//// new topicService().update(new Topics("99", "mohamed", "eslam"));
	//
	//// new topicService().getAll();
	// }

	public void update(Topics topics) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();

		session.saveOrUpdate(topics);
		session.getTransaction().commit();

		session.close();
	}

	public  List<Topics> getAll() {
		// TODO Auto-generated method stub

		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();
		Query q = session.createQuery("From Topics ");

		List<Topics> resultList = q.list();
		System.out.println("num of Topics :" + resultList.size());
		for (Topics next : resultList) {
			System.out.println(next.getUsername());
		}

		session.getTransaction().commit();

		session.close();

		return resultList;

	}

	public void insert(Topics topics) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();

		session.save(topics);

		session.getTransaction().commit();

		session.close();

	}

	public void delete(Topics topics) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();

		Query query = session.createQuery("From Topics where id=:id");
		query.setParameter("id", topics.getId());
		Topics oo = (Topics) query.uniqueResult();

		if (oo != null) {

			System.out.println("Done");
			Query query1 = session.createQuery("delete from Topics where id=:id");
			query1.setParameter("id", oo.getId());

			query1.executeUpdate();

		}

		session.getTransaction().commit();

		session.close();

	}

}
