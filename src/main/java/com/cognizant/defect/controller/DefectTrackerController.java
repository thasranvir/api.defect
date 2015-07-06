/**
 * 
 */
package com.cognizant.defect.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.defect.model.Defect;
import com.cognizant.defect.model.DefectResponse;
import com.cognizant.defect.model.FetchDefectListResponse;
import com.cognizant.defect.service.AddDefectService;
import com.cognizant.defect.service.DownloadAsExcelService;
import com.cognizant.defect.service.FetchDefectListService;
import com.cognizant.defect.service.UpdateDefectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 256624
 *
 */
@Controller
@RequestMapping("/")
public class DefectTrackerController {
	
	@Autowired
	AddDefectService addDefectService;
	
	@Autowired
	UpdateDefectService updateDefectService;
	/*
	@Autowired
	DeleteDefectService deleteDefectService;
	*/
	@Autowired
	DownloadAsExcelService downloadAsExcelService;
	
	@Autowired
	FetchDefectListService fetchDefectListService;
	
	@RequestMapping(value = "addDefect.json", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public DefectResponse addDefect(@RequestBody Defect defect)throws Exception {
		DefectResponse response = addDefectService.addDefect(defect);
		return response;
	}
	
	@RequestMapping(value = "updateDefect.json", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public DefectResponse updateDefect(@RequestBody Defect defect) {
		DefectResponse response = updateDefectService.updateDefect(defect);
		return response;
	}
	
	@RequestMapping(value = "deleteDefect.json", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String deleteDefect() {
		return "";
	}
	
	@RequestMapping(value = "fetchDefectList.json", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public FetchDefectListResponse fetchDefectList(HttpServletRequest request, HttpServletResponse response) {
		FetchDefectListResponse fetchDefectListResponse = fetchDefectListService.getDefectList();
		return fetchDefectListResponse;
	}
	
	@RequestMapping(value = "downloadAsExcel.json", method = RequestMethod.GET)
	@ResponseBody
	public void downloadAsExcel(HttpServletResponse response) {
		downloadAsExcelService.downloadAsExcel(response);
	}
	
}
