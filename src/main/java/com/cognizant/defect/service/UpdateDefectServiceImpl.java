/**
 * 
 */
package com.cognizant.defect.service;

import com.cognizant.defect.dao.UpdateDefectDao;
import com.cognizant.defect.model.Defect;
import com.cognizant.defect.model.DefectResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 256624
 *
 */
@Service
@Transactional
public class UpdateDefectServiceImpl implements UpdateDefectService {
@Autowired
UpdateDefectDao updateDefectDao;
	/* (non-Javadoc)
	 * @see com.cognizant.defect.service.UpdateDefectService#updateDefect(int)
	 */
	@Override
	public DefectResponse updateDefect(Defect defect) {
		DefectResponse response = updateDefectDao.updateDefect(defect);
		return response;
	}

}
