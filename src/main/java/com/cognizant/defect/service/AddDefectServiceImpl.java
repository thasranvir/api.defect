/**
 * 
 */
package com.cognizant.defect.service;

import com.cognizant.defect.dao.AddDefectDao;
import com.cognizant.defect.model.Defect;
import com.cognizant.defect.model.DefectResponse;
import com.cognizant.defect.util.DateUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 256624
 *
 */
@Service
@Transactional
public class AddDefectServiceImpl implements AddDefectService {

	@Autowired
	AddDefectDao addDefectDao;
	/* (non-Javadoc)
	 * @see com.cognizant.defect.service.AddDefectService#addDefect(com.cognizant.defect.model.Defect)
	 */
	@Override
	public DefectResponse addDefect(Defect defect) {
		com.cognizant.defect.entity.Defect defectEntity = new com.cognizant.defect.entity.Defect();
		defectEntity.setAssignedTo(defect.getAssignedTo());
		defectEntity.setCategory(defect.getCategory());
		defectEntity.setComments(defect.getComments());
		defectEntity.setDateDelivered(DateUtil.convertStringToDate(defect.getDateDelivered()));
		defectEntity.setDateRaised(DateUtil.convertStringToDate(defect.getDateRaised()));
		defectEntity.setDescription(defect.getDescription());
		defectEntity.setEta(DateUtil.convertStringToDate(defect.getEta()));
		defectEntity.setPriority(defect.getPriority());
		defectEntity.setStatus(defect.getStatus());
		DefectResponse defectResponse = addDefectDao.addDefect(defectEntity);
		return defectResponse;
	}

}
