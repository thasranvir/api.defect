package com.cognizant.defect.report;

import java.util.List;

import com.cognizant.defect.model.Defect;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.CellStyle;

public class FillManager {

	/**
	 * Fills the report with content
	 * 
	 * @param worksheet
	 * @param startRowIndex starting row offset
	 * @param startColIndex starting column offset
	 * @param datasource the data source
	 */
	public static void fillReport(HSSFSheet worksheet, int startRowIndex, int startColIndex, List<Defect> datasource) {
		// Row offset
		startRowIndex += 2;
		
		// Create cell style for the body
		HSSFCellStyle bodyCellStyle = worksheet.getWorkbook().createCellStyle();
		bodyCellStyle.setAlignment(CellStyle.ALIGN_CENTER);
		bodyCellStyle.setWrapText(true);
		
		// Create body
		for (int i=startRowIndex; i+startRowIndex-2< datasource.size()+2; i++) {
			// Create a new row
			HSSFRow row = worksheet.createRow((short) i+1);

			// Retrieve the id value
			HSSFCell cell1 = row.createCell(startColIndex+0);
			cell1.setCellValue(datasource.get(i-2).getId());
			cell1.setCellStyle(bodyCellStyle);

			// Retrieve the description value
			HSSFCell cell2 = row.createCell(startColIndex+1);
			cell2.setCellValue(datasource.get(i-2).getDescription());
			cell2.setCellStyle(bodyCellStyle);

			// Retrieve the date raised value
			HSSFCell cell3 = row.createCell(startColIndex+2);
			cell3.setCellValue(datasource.get(i-2).getDateRaised());
			cell3.setCellStyle(bodyCellStyle);

			// Retrieve the date delivered power value
			HSSFCell cell4 = row.createCell(startColIndex+3);
			cell4.setCellValue(datasource.get(i-2).getDateDelivered());
			cell4.setCellStyle(bodyCellStyle);

			// Retrieve the priority value
			HSSFCell cell5 = row.createCell(startColIndex+4);
			cell5.setCellValue(datasource.get(i-2).getPriority());
			cell5.setCellStyle(bodyCellStyle);
		
			// Retrieve the comment value
			HSSFCell cell6 = row.createCell(startColIndex+5);
			cell6.setCellValue(datasource.get(i-2).getComments());
			cell6.setCellStyle(bodyCellStyle);
			
			HSSFCell cell7 = row.createCell(startColIndex+6);
			cell7.setCellValue(datasource.get(i-2).getStatus());
			cell7.setCellStyle(bodyCellStyle);
			
			HSSFCell cell8 = row.createCell(startColIndex+7);
			cell8.setCellValue(datasource.get(i-2).getAssignedTo());
			cell8.setCellStyle(bodyCellStyle);
			
			HSSFCell cell9 = row.createCell(startColIndex+8);
			cell9.setCellValue(datasource.get(i-2).getEta());
			cell9.setCellStyle(bodyCellStyle);
			
			HSSFCell cell10 = row.createCell(startColIndex+9);
			cell10.setCellValue(datasource.get(i-2).getCategory());
			cell10.setCellStyle(bodyCellStyle);
		}
	}
}
