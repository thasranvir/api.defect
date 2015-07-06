/**
 * 
 */
package com.cognizant.defect.dao;

import com.cognizant.defect.entity.Defect;
import com.cognizant.defect.model.DefectResponse;

/**
 * @author 409942
 *
 */
public interface AddDefectDao {
	
	public DefectResponse addDefect(Defect defect);

}
