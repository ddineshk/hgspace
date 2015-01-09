package com.crabapp.spring.mvc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.crabapp.spring.obj.Employee;

@Controller
public class SpringTilesController {

	@RequestMapping(value="index")
	public String index(){
		return "index";
	}
	
	@RequestMapping(value="viewEmployee")
	public ModelAndView viewEmployee(){
		Map<String, List<Employee>> employees = new HashMap<String, List<Employee>>();
		employees.put("employees", Employee.createEmployees());
		return new ModelAndView("employeeList",employees);
	}
	
	@RequestMapping(value="distance")
	public ModelAndView distance(Model model){
		return new ModelAndView("distance");
	}
	
	@RequestMapping(value="distanceSubmit")
	public ModelAndView distanceSubmit(Model model){
		return new ModelAndView("distance");
	}
	
}
