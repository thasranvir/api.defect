/**
 * 
 */
package com.cognizant.defect.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.cognizant.defect.entity.Defect;

/**
 * @author 409942
 *
 */
public class FetchDefectListDaoImpl implements FetchDefectListDao {
	@PersistenceContext
	private EntityManager entityManager;
	/* (non-Javadoc)
	 * @see com.cognizant.defect.dao.FetchDefectListDao#fetchDefectList()
	 */
	@Override
	public List<Defect> fetchDefectList() {
		List<Defect> defectList = null;
		try {
			if(entityManager!=null){
				System.out.println("Entity Manager");
			}else{
				System.out.println("entityManager is null");
			}
			Query query = entityManager.createNamedQuery("Defect.findAll");
			@SuppressWarnings("unchecked")
			List<Defect> queryList = query.getResultList();
			System.out.println("RESULT LIST :::: "+ queryList);
			if(queryList.size()>0){
				 defectList = new ArrayList<Defect>();
				for (Defect local : queryList) {
					defectList.add(local);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return defectList;
	}

}
