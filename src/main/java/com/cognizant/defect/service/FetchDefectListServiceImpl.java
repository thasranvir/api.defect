/**
 * 
 */
package com.cognizant.defect.service;

import java.util.List;

import com.cognizant.defect.dao.FetchDefectListDao;
import com.cognizant.defect.entity.Defect;
import com.cognizant.defect.model.FetchDefectListResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 256624
 *
 */
@Service
public class FetchDefectListServiceImpl implements FetchDefectListService {
	
	@Autowired
	FetchDefectListDao fetchDefectListDao;
	/* (non-Javadoc)
	 * @see com.cognizant.defect.service.FetchDefectListService#getDefectList()
	 */
	@Override
	public FetchDefectListResponse getDefectList() {
		List<Defect> defectList = fetchDefectListDao.fetchDefectList();
		FetchDefectListResponse list = new FetchDefectListResponse();
		if(defectList.size()>0){
			list.setDefects(defectList);
		}
		return list;
	}
}
