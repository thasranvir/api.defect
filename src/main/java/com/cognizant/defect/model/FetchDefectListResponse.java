/**
 * 
 */
package com.cognizant.defect.model;

import java.io.Serializable;
import java.util.List;
import com.cognizant.defect.entity.Defect;

/**
 * @author 256624
 *
 */
public class FetchDefectListResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 208339199648666620L;
	private List<Defect> defects;
	/**
	 * @return the defects
	 */
	public List<Defect> getDefects() {
		return defects;
	}
	/**
	 * @param defects the defects to set
	 */
	public void setDefects(List<Defect> defects) {
		this.defects = defects;
	}
}
