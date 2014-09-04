package com.paranoia.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TourType {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) private int tourTypeId;
	private String tourTypeName;
	
	
	public int getTourTypeId() {
		return tourTypeId;
	}
	public void setTourTypeId(int tourTypeId) {
		this.tourTypeId = tourTypeId;
	}
	public String getTourTypeName() {
		return tourTypeName;
	}
	public void setTourTypeName(String tourTypeName) {
		this.tourTypeName = tourTypeName;
	}
	public TourType(){}
	public TourType(int id){tourTypeId = id;}
	
	public String getTourName() {
		return tourTypeName;
	}
	
	public void setTourName(String tourTypeName) {
		this.tourTypeName = tourTypeName;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((tourTypeName == null) ? 0 : tourTypeName.hashCode());
		return result;
	}
	
	
	/**
	 * equals and hashcode
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TourType other = (TourType) obj;
		if (tourTypeName == null) {
			if (other.tourTypeName != null)
				return false;
		} else if (!tourTypeName.equals(other.tourTypeName))
			return false;
		return true;
	}
	
	
	
	
}