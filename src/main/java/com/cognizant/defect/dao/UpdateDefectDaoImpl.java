/**
 * 
 */
package com.cognizant.defect.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.cognizant.defect.Exception.Error;
import com.cognizant.defect.model.Defect;
import com.cognizant.defect.model.DefectResponse;
import com.cognizant.defect.util.DateUtil;
import com.cognizant.defect.util.DefectTracker;

import org.springframework.http.HttpStatus;

/**
 * @author 409942
 *
 */
public class UpdateDefectDaoImpl implements UpdateDefectDao {
	@PersistenceContext
	EntityManager entityManager;
	/* (non-Javadoc)
	 * @see com.cognizant.defect.dao.UpdateDefectDao#updateDefect(int)
	 */
	@Override
	public DefectResponse updateDefect(Defect defect) {
		DefectResponse response = new DefectResponse();
		try{
			Query qry = entityManager.createNamedQuery("Defect.updateDefect");
			qry.setParameter("id", defect.getId());
			qry.setParameter("assignedTo",defect.getAssignedTo());
			qry.setParameter("category",defect.getCategory());
			qry.setParameter("comments",defect.getComments());
			qry.setParameter("dateDelivered",DateUtil.convertStringToDate(defect.getDateDelivered()));
			qry.setParameter("dateRaised",DateUtil.convertStringToDate(defect.getDateRaised()));
			qry.setParameter("description",defect.getDescription());
			qry.setParameter("eta",DateUtil.convertStringToDate(defect.getEta()));
			qry.setParameter("priority",defect.getPriority());
			qry.setParameter("status",defect.getStatus());
			
			int result = qry.executeUpdate();
			if(result>0){
				response.setStatus(DefectTracker.SUCCESS_CODE);
			}else{
				response.setStatus(DefectTracker.FAILURE_CODE);
				Error error = new Error();
				error.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR);
				error.setErrorMessage("Exception occured while executing update");
				response.setError(error);
			}
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
