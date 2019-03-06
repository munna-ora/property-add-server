/**
 * @formatter:off
 * @author Avirup
 */
package com.orastays.propertyadd.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.orastays.propertyadd.service.DatabaseService;

import springfox.documentation.annotations.ApiIgnore;

@Controller
@ApiIgnore
public class DatabaseController {  

	private static final Logger logger = LogManager.getLogger(DatabaseController.class);

	@Autowired
	private DatabaseService databaseService;
	
	@RequestMapping(value = "/check-api", method = RequestMethod.GET)
	public ModelAndView CheckAPIPage(Model model) {

		if (logger.isInfoEnabled()) {
			logger.info("CheckAPIPage -- START");
		}
		
		if (logger.isInfoEnabled()) {
			logger.info("CheckAPIPage -- END");
		}
		
		return new ModelAndView("check-api");
	}
	
	@RequestMapping(value = "/database-operation", method = RequestMethod.GET)
	public String databaseOperationPage(Model model) {

		if (logger.isInfoEnabled()) {
			logger.info("databaseOperationPage -- START");
		}
		
		if (logger.isInfoEnabled()) {
			logger.info("databaseOperationPage -- END");
		}
		
		return "database-operation";
		
	}
	
	@RequestMapping(value = "/database-operation", method = RequestMethod.POST)
	public String databaseOperation(Model model, @RequestParam(value="query", required=false) String query) {

		if (logger.isInfoEnabled()) {
			logger.info("databaseOperation -- START");
		}
		
		try{
			model.addAttribute("query", query);
			String result = databaseService.databaseOperation(query);
			model.addAttribute("result", result);
			
		} catch (Exception e) {
			
			e.getMessage();
		}
		
		
		if (logger.isInfoEnabled()) {
			logger.info("databaseOperation -- END");
		}
		
		return "database-operation";
	}
}