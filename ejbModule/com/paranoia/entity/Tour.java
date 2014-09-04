package com.paranoia.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


@Entity
public class Tour {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) private int tourId;
	private int tourPrice;
	
	
	@ManyToOne
	@JoinColumn(name="typeId")
	private TourType typeId;
	
	@ManyToMany(mappedBy="tour2")
	private List<MyOrder> myorder = new ArrayList<MyOrder>();
	
	public Tour(){}
	public Tour(int id){tourId = id;}
	
	public int getTourPrice() {
		return tourPrice;
	}
	public void setTourPrice(int tourPrice) {
		this.tourPrice = tourPrice;
		
	}
	public TourType getTypeId() {
		return typeId;
	}
	public void setTypeId(TourType type) {
		this.typeId = type;
	}
	public int getTourId() {
		return tourId;
	}
	public void setTourId(int tourId) {
		this.tourId = tourId;
	}
	public List<MyOrder> getMyOrder(){
		return myorder;
	}
	public void setMyOrder(MyOrder myorder) {
		this.myorder.add(myorder);
	}
	
	
	
	/**
	 * equals and hashcode
	 */
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((myorder == null) ? 0 : myorder.hashCode());
		result = prime * result + tourPrice;
		result = prime * result + ((typeId == null) ? 0 : typeId.hashCode());
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
		Tour other = (Tour) obj;
		if (myorder == null) {
			if (other.myorder != null)
				return false;
		} else if (!myorder.equals(other.myorder))
			return false;
		if (tourPrice != other.tourPrice)
			return false;
		if (typeId == null) {
			if (other.typeId != null)
				return false;
		} else if (!typeId.equals(other.typeId))
			return false;
		return true;
	}
		
}

