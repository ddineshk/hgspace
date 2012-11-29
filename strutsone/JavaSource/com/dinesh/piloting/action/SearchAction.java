package com.dinesh.piloting.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.dinesh.piloting.exp.MyException;
import com.dinesh.piloting.form.SearchForm;
import com.dinesh.piloting.obj.Employee;
import com.dinesh.piloting.service.SearchService;

public class SearchAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		SearchService service = new SearchService();
		ArrayList<Employee> results;

		SearchForm searchForm = (SearchForm) form;
		// Perform employee search based on what criteria was entered.

		String name = searchForm.getName();
		if (name != null && name.trim().length() > 0) {
			results = service.searchByName(name);
		} else {
			results = service.searchBySsNum(searchForm.getSsNum().trim());
		}
		// Place search results in SearchForm for access by JSP.
		searchForm.setResults(results);
		if(results.size()<1)
			throw new IOException();
		if(results.size()>0){
			throw new MyException();
		}
		// Forward control to this Action's input page.
		return mapping.getInputForward();
	}

}
