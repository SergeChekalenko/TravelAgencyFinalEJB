package com.paranoia.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.paranoia.entity.Users;


@Stateless
public class UserDAO {
	@PersistenceContext(unitName="TravelAgencyFinalEJB") 
	EntityManager em;
	Users user;
	
	public Users findUser(int id){
		return em.find(Users.class, id);
	}
	
	public void createUser(String name, String password,
			String adress, String type, int discount) {
		
		Users user = new Users();
		
		user.setUserName(name);
		user.setUserPassword(password);
		user.setUserAdress(adress);
		user.setUserType(type);
		user.setUserDiscont(discount);
		
		em.persist(user);
	}
	
	public void deleteUser(Users user){
		em.remove(em.merge(user));
	}
	
	public void updateUser(){}
	
	public List<Users> getAllUsers(){
		TypedQuery<Users> query = em.createQuery(
				"SELECT c FROM Users c", 
				Users.class);
				List<Users> results = query.getResultList();
				return results;
	}
}

