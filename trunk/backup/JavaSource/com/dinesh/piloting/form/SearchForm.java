package com.dinesh.piloting.form;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.dinesh.piloting.obj.Employee;

public class SearchForm extends ActionForm {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6664010289500266694L;
	private String name = null;
	private String ssNum = null;
	private List<Employee> results = null;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the ssNum
	 */
	public String getSsNum() {
		return ssNum;
	}

	/**
	 * @param ssNum
	 *            the ssNum to set
	 */
	public void setSsNum(String ssNum) {
		this.ssNum = ssNum;
	}

	/**
	 * @return the results
	 */
	public List<Employee> getResults() {
		return results;
	}

	/**
	 * @param results
	 *            the results to set
	 */
	public void setResults(List<Employee> results) {
		this.results = results;
	}

	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		name = null;
		ssNum = null;
		results = null;
	}

	@Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();
		boolean nameEntered = false;
		boolean ssNumEntered = false;
		// Determine if name has been entered.
		if (name != null && name.length() > 0) {
			nameEntered = true;
		}
		// Determine if social security number has been entered.
		if (ssNum != null && ssNum.length() > 0) {
			ssNumEntered = true;
		}
		/* Validate that either name or social security numberhas been entered. */
		if (!nameEntered && !ssNumEntered) {
			errors.add(null, new ActionMessage("error.search.criteria.missing"));
		}
		/* Validate format of social security number ifit has been entered. */
		if (ssNumEntered && !isValidSsNum(ssNum.trim())) {
			errors.add("ssNum", new ActionMessage("error.search.ssNum.invalid"));
		}

		return errors;
	}

	// Validate format of social security number.
	private static boolean isValidSsNum(String ssNum) {
		if (ssNum.length() < 11) {
			return false;
		}
		for (int i = 0; i < 11; i++) {
			if (i == 3 || i == 6) {
				if (ssNum.charAt(i) != '-') {
					return false;
				}
			} else if ("0123456789".indexOf(ssNum.charAt(i)) == -1) {
				return false;
			}
		}
		return true;
	}
}
