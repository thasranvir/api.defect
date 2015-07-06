/**
 * 
 */
package com.cognizant.defect.service;

import java.util.List;

import com.cognizant.defect.model.DefectResponse;


/**
 * @author 256624
 *
 */
public interface DeleteDefectService {

	public DefectResponse deleteDefect(List<Integer> id);
}
