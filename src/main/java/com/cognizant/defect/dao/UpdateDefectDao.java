/**
 * 
 */
package com.cognizant.defect.dao;

import com.cognizant.defect.model.Defect;
import com.cognizant.defect.model.DefectResponse;

/**
 * @author 409942
 *
 */
public interface UpdateDefectDao {
	DefectResponse updateDefect(Defect defect);

}
