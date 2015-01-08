package com.crabapp.spring.mvc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.crabapp.spring.obj.Person;

@Controller
public class SpringTilesController {

	@RequestMapping(value="index")
	public String index(){
		return "index";
	}
	
	@RequestMapping(value="viewPerson")
	public ModelAndView viewPerson(){
		Map<String, List<Person>> persons = new HashMap<String, List<Person>>();
		persons.put("persons", Person.createPersons());
		return new ModelAndView("personList",persons);
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
