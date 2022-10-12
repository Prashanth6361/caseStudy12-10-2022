package com.gl.springBootAssignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.gl.springBootAssignment.bean.CompanyShare;
import com.gl.springBootAssignment.service.CompanyService;

@RestController
public class ShareController {
	@Autowired
	private CompanyService service;
	
	@GetMapping("/index")
	public ModelAndView showIndexPage() {
		ModelAndView mv=new ModelAndView("index");
		List<CompanyShare> companyList=service.findAll();
		mv.addObject("companyList",companyList);
		return mv;
	}
	
	@GetMapping("/company-enlist")
	public ModelAndView showEnlistPage() {
		CompanyShare cs=new CompanyShare();
		ModelAndView mv=new ModelAndView("companyEnlistPage");
		mv.addObject("companyRecord",cs);
		return mv;
	}
	
	@PostMapping("/companyShare")
	public ModelAndView saveNewCompany(@ModelAttribute("companyRecord") CompanyShare cs) {
		long id=service.generateCompanyId();
		cs.setCompanyId(id);
		service.save(cs);
		return new ModelAndView("redirect:/index");
	}
	
	@GetMapping("/delete-company/{id}")
	public ModelAndView deleteACompany(@PathVariable long id) {
		service.delete(id);
		return new ModelAndView("redirect:/index"); 
	}
	
	@GetMapping("/edit-company/{id}")
	public ModelAndView showEditPage(@PathVariable long id) {
		CompanyShare cs=service.findById(id);
		ModelAndView mv=new ModelAndView("companyEditPage");
		mv.addObject("companyRecord",cs);
		return mv;
	}
	
	@PostMapping("/edit-company/{id}")
	public ModelAndView editCompany(@ModelAttribute("companyRecord") CompanyShare cs) {
		service.save(cs);
		return new ModelAndView("redirect:/index"); 
	}

}
