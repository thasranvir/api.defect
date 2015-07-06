/**
 * 
 */
package com.cognizant.defect.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.cognizant.defect.dao.FetchDefectListDao;
import com.cognizant.defect.model.Defect;
import com.cognizant.defect.report.DefectTrackerLayout;
import com.cognizant.defect.report.FillManager;
import com.cognizant.defect.report.Writer;
import com.cognizant.defect.util.DateUtil;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 409942
 *
 */
@Service
@Transactional
public class DownloadAsExcelServiceImpl implements DownloadAsExcelService {
	@Autowired
	FetchDefectListDao fetchDefectListDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.cognizant.defect.service.DownloadAsExcelService#downloadAsExcel
	 * (javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void downloadAsExcel(HttpServletResponse response) {
		// 1. Create new workbook
		HSSFWorkbook workbook = new HSSFWorkbook();

		// 2. Create new worksheet
		HSSFSheet worksheet = workbook.createSheet("Defect Tracker Worksheet");

		// 3. Define starting indices for rows and columns
		int startRowIndex = 0;
		int startColIndex = 0;

		// 4. Build layout Build title, date, and column headers
		DefectTrackerLayout.buildReport(worksheet, startRowIndex, startColIndex);

		// 5. Fill report 
		FillManager.fillReport(worksheet, startRowIndex, startColIndex,getDatasource());

		// 6. Set the response properties
		String fileName = "DefectTracker_"+Calendar.getInstance().getTimeInMillis()+".xls";
		response.setHeader("Content-Disposition", "inline; filename="+ fileName);
		// Make sure to set the correct content type
		response.setContentType("application/vnd.ms-excel");

		// 7. Write to the output stream
		Writer.write(response, worksheet);
	}

	private List<Defect> getDatasource() {
		List<com.cognizant.defect.entity.Defect> defectListEntity = fetchDefectListDao.fetchDefectList();
		List<Defect> defectList = null;
		Defect defect  = null;
		if(defectListEntity.size()>0){
			defectList = new ArrayList<Defect>();
		}
		for(com.cognizant.defect.entity.Defect local : defectListEntity){
			defect  = new Defect();
			defect.setAssignedTo(local.getAssignedTo());
			defect.setCategory(local.getCategory());
			defect.setComments(local.getComments());
			defect.setDateDelivered(DateUtil.dateFormat(local.getDateDelivered()));
			defect.setDateRaised(DateUtil.dateFormat(local.getDateRaised()));
			defect.setDescription(local.getDescription());
			defect.setEta(DateUtil.dateFormat(local.getEta()));
			defect.setId(local.getId());
			defect.setPriority(local.getPriority());
			defect.setStatus(local.getStatus());
			defectList.add(defect);
		}
		return defectList;
	}

}