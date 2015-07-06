/**
 * 
 */
package com.cognizant.defect.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.cognizant.defect.Exception.Error;
import com.cognizant.defect.entity.Defect;
import com.cognizant.defect.model.DefectResponse;
import com.cognizant.defect.util.DefectTracker;

import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 409942
 *
 */

public class AddDefectDaoImpl implements AddDefectDao {

	@PersistenceContext
	private EntityManager entityManager;
	/* (non-Javadoc)
	 * @see com.cognizant.defect.dao.AddDefectDao#addDefect(java.util.List)
	 */
	@Transactional
	@Override
	public DefectResponse addDefect(Defect defect) {
		DefectResponse response = new DefectResponse();
		try{
			entityManager.persist(defect);
			entityManager.flush();
			response.setStatus(DefectTracker.SUCCESS_CODE);
		}catch(Exception exception){
			exception.printStackTrace();
			Error error = new Error();
			error.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR);
			error.setErrorMessage(exception.getLocalizedMessage());
			response.setError(error);
		}
		return response;
	}

}
