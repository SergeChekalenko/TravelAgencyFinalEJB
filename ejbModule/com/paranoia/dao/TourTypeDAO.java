package com.paranoia.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import com.paranoia.entity.TourType;

@Stateless
public class TourTypeDAO {

	@PersistenceContext(unitName="TravelAgencyFinalEJB") 
	EntityManager em;
	
	public TourType findTourType(int id){
		return em.find(TourType.class, id);
	}
	
	public void createNewTourType(String name){
		
		TourType tt = new TourType();
		tt.setTourName(name);
			em.persist(tt);
	}
	
	public TourType updateTourType(TourType type){
		return em.merge(type);
	}
	
	public void deleteTourType(TourType type){
		em.remove(em.merge(type));
	}
	
	
//	public void deleteTourType(String name){
//		String s = "DELETE FROM Country c WHERE c.tourTypeName = :" + name;
//		em.createQuery(s).executeUpdate();
		
//		TourType tt;
//		tt = tt.setTourName(name);
		
		
//	}
	
//	public void updateTour(){}
	
	public List<TourType> getAllTourTypes(){
		TypedQuery<TourType> query = em.createQuery(
				"SELECT c FROM TourType c", 
				TourType.class);
				List<TourType> results = query.getResultList();
				return results;
	}
	
}
