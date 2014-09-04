package com.paranoia.entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class MyOrder {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) private int orderId;
		private int orderPrice;
		
	@ManyToMany
	@JoinTable(name="TourOrder", joinColumns={@JoinColumn(name="orderId")},
						  inverseJoinColumns={@JoinColumn(name="tourId")})
	private List<Tour> tour2;
	
	@ManyToOne
	@JoinColumn(name="uid")
	private Users users;
	
	public MyOrder(){}
	public MyOrder(int id){orderId = id;}
	
	public List<Tour> getTour2(){
		return tour2;
	}
	public void setTour2(List<Tour> tour2){
		this.tour2=tour2;
	}
	public int getOrderPrice() {
		return orderPrice;
	}
	public void setOrderPrice(int orderPrice) {
		this.orderPrice = orderPrice;
	}
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	
	/**
	 * equals and hashcode
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + orderPrice;
		result = prime * result + ((tour2 == null) ? 0 : tour2.hashCode());
		result = prime * result + ((users == null) ? 0 : users.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyOrder other = (MyOrder) obj;
		if (orderPrice != other.orderPrice)
			return false;
		if (tour2 == null) {
			if (other.tour2 != null)
				return false;
		} else if (!tour2.equals(other.tour2))
			return false;
		if (users == null) {
			if (other.users != null)
				return false;
		} else if (!users.equals(other.users))
			return false;
		return true;
	}
	
	
}
