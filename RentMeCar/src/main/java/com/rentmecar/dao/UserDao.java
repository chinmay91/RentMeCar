package com.rentmecar.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.BatchSize;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.rentmecar.dao.entity.users.Credentials;
import com.rentmecar.dao.entity.users.CustomerProfile;

@Scope("singleton")
@Repository("UserDao")
public class UserDao implements IUserDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public String signup(CustomerProfile custProf) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.save(custProf);
		return null;
	}
	
	@Override
	public Credentials findUserByUsername(String username){
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Credentials.class);
		criteria.add(Restrictions.eq("username", username));
		Credentials credentials = (Credentials) criteria.list().get(0);  // Here create criteria query to get the user
		return credentials;
	}

	@Override
	public int getUId(String name) {
		// TODO Auto-generated method stub
		//int uId = jdbcTemplate.execute("select u_id from credentials where username = " + name);
		int uId = jdbcTemplate.queryForInt("select u_id from credentials where username = '" + name + "'");
		//jdbcTemplate.query("select u_id from credentials where username = ?" , {name}, String.class, int.class);
		if(uId < 1)
			return -1;
		
		return uId;
	}

	@Override
	public CustomerProfile getUserProfile(int uId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(CustomerProfile.class);
		criteria.add(Restrictions.eq("uId", uId));
		CustomerProfile cp = (CustomerProfile)criteria.list().get(0);
		if(cp == null)
			return null;
		return cp;
	}
}