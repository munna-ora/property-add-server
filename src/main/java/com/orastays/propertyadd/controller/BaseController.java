package com.orastays.propertyadd.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.orastays.propertyadd.helper.MessageUtil;
import com.orastays.propertyadd.service.PropertyService;
import com.orastays.propertyadd.service.ReportService;

public class BaseController {

	@Autowired
	protected HttpServletRequest request;
	
	@Autowired
	protected HttpServletResponse response;
	
	@Autowired
	protected PropertyService propertyService;
	
	@Autowired
	protected ReportService reportService;
	
	@Autowired
	protected MessageUtil messageUtil;
}
