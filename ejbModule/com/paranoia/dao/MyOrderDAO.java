package com.paranoia.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.paranoia.entity.MyOrder;
import com.paranoia.entity.Tour;
import com.paranoia.entity.Users;


@Stateless
public class MyOrderDAO {
	
	@PersistenceContext(unitName="TravelAgencyFinalEJB") 
	EntityManager em;
	
	public MyOrder findMyOrder(int id){
		return em.find(MyOrder.class, id);
	}

	public void createMyOrder(int orderPrice, List<Tour> tour2, Users user){
		
		MyOrder order = new MyOrder();
		
		order.setOrderPrice(orderPrice);
		order.setTour2(tour2);
		//order.setUsers(user);
		
		em.persist(order);
	}
	
	public void deleteMyOrder(){}
	
	public void updateMyOrder(){}
}
