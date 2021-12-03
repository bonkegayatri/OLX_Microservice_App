package com.olx.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.olx.dto.Advertise;
import com.olx.entity.AdvertiseEntity;
import com.olx.exception.InvalidAuthTokenException;
import com.olx.exception.InvalidCategoryIdException;
import com.olx.repo.OlxAdvertiseRepo;

@Service
public class AdvertisementServiceImp implements AdvertisementService {

	@Autowired
	EntityManager entityManager;
	
	@Autowired
	MasterDataDelegate masterDataDelegate;
	
	@Autowired
	LoginDelegate loginDelegate;
	
	@Autowired
	OlxAdvertiseRepo olxAdvertiseRepo;
	
	@Autowired
	ModelMapper modelMapper;

	@Bean
	public ModelMapper modelMapper() {
	 return new ModelMapper();
	}
	
	@Override
	public Collection<Advertise> searchAdvertisementByFilter(String title, Double price, String status, LocalDate createdDate) {
		/*
		 * if(title != null) { if(price != null) { if(status != null) { if(createdDate
		 * != null) { List<AdvertiseEntity> listAdvertiseEntity =
		 * olxAdvertiseRepo.findByTitleAndPriceAndStatusAndCreatedDate(title, price,
		 * status, createdDate); return
		 * getAdvertiseDtoListFromEntity(listAdvertiseEntity); }
		 * 
		 * List<AdvertiseEntity> listAdvertiseEntity =
		 * olxAdvertiseRepo.findByTitleAndPriceAndStatus(title, price, status); return
		 * getAdvertiseDtoListFromEntity(listAdvertiseEntity); }
		 * 
		 * List<AdvertiseEntity> listAdvertiseEntity =
		 * olxAdvertiseRepo.findByTitleAndPrice(title, price); return
		 * getAdvertiseDtoListFromEntity(listAdvertiseEntity);
		 * 
		 * }
		 * 
		 * List<AdvertiseEntity> listAdvertiseEntity =
		 * olxAdvertiseRepo.findByTitle(title); return
		 * getAdvertiseDtoListFromEntity(listAdvertiseEntity);
		 * 
		 * }
		 * 
		 * return null;
		 */
        
		 CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		    CriteriaQuery<AdvertiseEntity> cq = cb.createQuery(AdvertiseEntity.class);

		    Root<AdvertiseEntity> advertiseEntity = cq.from(AdvertiseEntity.class);
		    List<Predicate> predicates = new ArrayList<>();
		    
		    if (title != null) {
		        predicates.add(cb.equal(advertiseEntity.get("title"), title));
		    }
		    if (price != null) {
		        predicates.add(cb.equal(advertiseEntity.get("price"), price));
		    }
		    if (status != null) {
		        predicates.add(cb.like(advertiseEntity.get("status"), status));
		    }
		    
		    if (createdDate != null) {
		        predicates.add(cb.equal(advertiseEntity.<LocalDate>get("createdDate"), createdDate));
		    }
		    
		    cq.where(predicates.toArray(new Predicate[0]));
		    TypedQuery<AdvertiseEntity> query = entityManager.createQuery(cq);
		    List<AdvertiseEntity> listAdvertiseEntity = query.getResultList(); 
		    return getAdvertiseDtoListFromEntity(listAdvertiseEntity);
		   		          
	}
	
	
	@Override
	public List<Advertise> searchAdvertisementBySearchText(String searchText) {
		// TODO Auto-generated method stub
//		List<Map> listCategory = masterDataDelegate.getAllCategories();
		
		if (searchText != null) {
			List<AdvertiseEntity> listAdvertiseEntity = olxAdvertiseRepo.search(searchText);
			return getAdvertiseDtoListFromEntity(listAdvertiseEntity); 
        }
		
        return null;
	}
	
	@Override
	public Boolean deleteAdvertisementById(int stockId, String auth_token) {
		if(loginDelegate.validateToken(auth_token)) {
//		advertiseMap.remove(stockId);
//		return true;
			
			Optional<AdvertiseEntity> opStockEntity =  olxAdvertiseRepo.findById(stockId);
			if(opStockEntity.isPresent()) {
				AdvertiseEntity stockEntity = opStockEntity.get();
				olxAdvertiseRepo.delete(stockEntity);
				
				return true;
			}
			
			return false;
		
		} else {
			throw new InvalidAuthTokenException("InValid Token");
		}
	}

	
	@Override
	public Advertise getAdvertisementById(int advertiseId, String auth_token) {
		if(loginDelegate.validateToken(auth_token)) {
//			if( advertiseMap.get(advertiseId) != null) {
//				return  advertiseMap.get(advertiseId);
//			} else {
//				 throw new InvalidCategoryIdException(""+advertiseId);
//		    }
			
			Optional<AdvertiseEntity> opAdvertiseEntity =  olxAdvertiseRepo.findById(advertiseId);
			if(opAdvertiseEntity.isPresent()) {
				AdvertiseEntity stockEntity = opAdvertiseEntity.get();
				return getAdvertiseDtoFromEntity(stockEntity);
			}
			throw new InvalidCategoryIdException("" + advertiseId);
			
		} else {
				throw new InvalidAuthTokenException("InValid Token");
		}
		
	}

	@Override
	public Collection<Advertise> getAllAdvertisement() {
//		return advertiseMap.values();
		
		List<AdvertiseEntity> listadvertiseEntity = olxAdvertiseRepo.findAll();
		return getAdvertiseDtoListFromEntity(listadvertiseEntity);
		
	}
	
	private List<Advertise> getAdvertiseDtoListFromEntity(List<AdvertiseEntity> stockEntityList) {
		List<Advertise> stockDtoList = new ArrayList<Advertise>();
		for(AdvertiseEntity stockEntity: stockEntityList) {
			stockDtoList.add(getAdvertiseDtoFromEntity(stockEntity));
		}
		return stockDtoList;
		
	}

	@Override
	public Advertise updateAdvertiseByID(int id, Advertise newAdvertise, String auth_token) {
		if(loginDelegate.validateToken(auth_token)) {
//		Advertise old = advertiseMap.get(id);
//		old.setTitle(newAdvertise.getTitle());
//		old.setPrice(newAdvertise.getPrice());
//		old.setDescription(newAdvertise.getDescription());
//
//		return old;
		
			Optional<AdvertiseEntity> opAdvertiseEntity =  olxAdvertiseRepo.findById(id);
			if(opAdvertiseEntity.isPresent()) {
				AdvertiseEntity advertiseEntity = opAdvertiseEntity.get();
				advertiseEntity.setTitle(newAdvertise.getTitle());
				advertiseEntity.setDescription(newAdvertise.getDescription());
				advertiseEntity.setPrice(newAdvertise.getPrice());
				advertiseEntity.setStatus(newAdvertise.getStatus());

				olxAdvertiseRepo.save(advertiseEntity);
				
				return getAdvertiseDtoFromEntity(advertiseEntity);
			}
			
			throw new InvalidCategoryIdException("" + id);
			
		
		} else {
			throw new InvalidAuthTokenException("InValid Token");
		}
	}


	@Override
	public Advertise createNewAdvertise(Advertise advertise, String auth_token) {
		System.out.print("response ::" + loginDelegate.validateToken(auth_token));
		if(loginDelegate.validateToken(auth_token)) {
//			LastCategoryId++;
//			advertise.setCategoryId(LastCategoryId);
//			advertiseMap.put(LastCategoryId, advertise);
//			return advertise;
			
			AdvertiseEntity olxLoginEntity = getOlxAdvertiseEntityFromDto(advertise);
			olxLoginEntity = olxAdvertiseRepo.save(olxLoginEntity);
			return getAdvertiseDtoFromEntity(olxLoginEntity);
			
		} else {
			 throw new InvalidAuthTokenException("InValid Token");
		}
				
	}
	
	private AdvertiseEntity getOlxAdvertiseEntityFromDto(Advertise olxLoginDetails) {
		AdvertiseEntity olxLoginEntity = this.modelMapper.map(olxLoginDetails, AdvertiseEntity.class);
		return olxLoginEntity;
	}

	private Advertise getAdvertiseDtoFromEntity(AdvertiseEntity olxLoginEntity) {	
		Advertise olxLoginDetails = this.modelMapper.map(olxLoginEntity, Advertise.class);
		return olxLoginDetails;
	}

	

}
