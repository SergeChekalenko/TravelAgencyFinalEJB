package com.paranoia.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.paranoia.entity.Tour;
import com.paranoia.entity.TourType;

@Stateless
public class TourDAO {

	@PersistenceContext(unitName="TravelAgencyFinalEJB") 
	EntityManager em;
		
	public Tour findTour(int id){
		return em.find(Tour.class, id);
	}
	
	public void createTour(TourType type, int tourPrice){
		
		Tour tour = new Tour();
		
		tour.setTourPrice(tourPrice);
		tour.setTypeId(type);

//		em.merge(type);
		em.persist(tour);
		
	}
	
	public void deleteTour(Tour tour){
		em.remove(tour);
	}
	
	public void updateTour(Tour tour){
		em.merge(tour);
	}
	
	public List<Tour> getAllTours(){
		TypedQuery<Tour> query = em.createQuery(
				"SELECT c FROM Tour c", 
				Tour.class);
				List<Tour> results = query.getResultList();
				return results;
	}
	
}
