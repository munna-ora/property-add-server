package com.orastays.propertyadd.service.impl;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.orastays.propertyadd.helper.MessageUtil;
import com.orastays.propertyadd.service.FileCopyService;

@Service
@Transactional
public class FileCopyServiceImpl implements FileCopyService {

	private static final Logger logger = LogManager.getLogger(FileCopyServiceImpl.class);
	
	@Autowired
	private MessageUtil messageUtil;
	
	@Override
	public void copyFiles(ServletContextEvent arg0) {
		
		if (logger.isInfoEnabled()) {
			logger.info("copyFiles - Start");
		}
		
		ServletContext context = arg0.getServletContext();
		String appPath = context.getRealPath("");
		
		Map<String, List<File>> fileNamesWithPath = new LinkedHashMap<String, List<File>>();
		List<File> fileNames = new ArrayList<File>();
		
		try {
			
			String innerBannerPath = appPath + "resources" + File.separator + "banner";
			//System.out.println("innerBannerPath ==>> "+innerBannerPath);
			
			String outsideBannerPath = System.getProperty( "catalina.base") + File.separator + "banner";
			//System.out.println("outsideBannerPath ==>> "+outsideBannerPath);
			
			File folder = new File(outsideBannerPath);
			File[] listOfFiles = folder.listFiles();
			if(Objects.nonNull(listOfFiles)) {
				fileNames.addAll(Arrays.asList(listOfFiles));
				fileNamesWithPath.put(innerBannerPath, fileNames);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			
			String innerLogoPath = appPath + "resources" + File.separator + messageUtil.getBundle("logo.upload.foldername");
			System.out.println("innerLogoPath ==>> "+innerLogoPath);
			
			String outsideLogoPath = System.getProperty( "catalina.base") + File.separator + messageUtil.getBundle("logo.upload.foldername");
			System.out.println("outsideLogoPath ==>> "+outsideLogoPath);
			
			File folder = new File(outsideLogoPath);
			File[] listOfFiles = folder.listFiles();
			if(Objects.nonNull(listOfFiles)) {
				fileNames.addAll(Arrays.asList(listOfFiles));
				fileNamesWithPath.put(innerLogoPath, fileNames);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			
			String innerFilePath = appPath + "resources" + File.separator + messageUtil.getBundle("userfile.upload.foldername");
			//System.out.println("innerFilePath ==>> "+innerFilePath);
			
			String outsideFilePath = System.getProperty( "catalina.base") + File.separator + messageUtil.getBundle("userfile.upload.foldername");
			//System.out.println("outsideFilePath ==>> "+outsideFilePath);
			
			File folder = new File(outsideFilePath);
			File[] listOfFiles = folder.listFiles();
			if(Objects.nonNull(listOfFiles)) {
				fileNames.addAll(Arrays.asList(listOfFiles));
				fileNamesWithPath.put(innerFilePath, fileNames);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(fileNamesWithPath.size() > 0) {
			
			copyFiles(fileNamesWithPath);
		}
		
		if (logger.isInfoEnabled()) {
			logger.info("copyFiles - End");
		}
	}
	
	@Override
	public void copyFiles(Map<String, List<File>> fileNamesWithPath) {
		
		if (logger.isInfoEnabled()) {
			logger.info("copyFiles - Start");
		}
		
		try{
			
			for(Map.Entry<String, List<File>> map:fileNamesWithPath.entrySet()) {
				
				//System.out.println("Destination ==>> "+map.getKey());
				//System.out.println("map.getValue() ==>> "+map.getValue());
				List<File> fileNames = map.getValue();
				for(File file:fileNames) {
					//System.out.println("Current Location ==>> "+file.getAbsolutePath());
					
					Path source = Paths.get(file.getAbsolutePath());
				    Path destination = Paths.get(map.getKey() + File.separator + file.getName());
				    
				   // System.out.println("Source=>>"+source+"  destination==>"+destination);
				 
				    FileUtils.copyFile(new File(source.toString()), new File(destination.toString()));
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (logger.isInfoEnabled()) {
			logger.info("copyFiles - End");
		}
	}
	
	@Override
	public void copyFiles(File file, String fileType) {
		
		if (logger.isInfoEnabled()) {
			logger.info("copyFiles - Start");
		}
		
		try{
			
			String destinationPath = "";
			if(fileType.equalsIgnoreCase(messageUtil.getBundle("logo.upload.foldername"))) { // For Logo
				
				destinationPath = System.getProperty( "catalina.base") + File.separator + messageUtil.getBundle("logo.upload.foldername");
				
			} else if(fileType.equalsIgnoreCase(messageUtil.getBundle("userfile.upload.foldername"))) { // For User Files
				
				destinationPath = System.getProperty( "catalina.base") + File.separator + messageUtil.getBundle("userfile.upload.foldername");
			} else {
				
				destinationPath = System.getProperty( "catalina.base") + File.separator + "banner";
			}
			
			Path source = Paths.get(file.getAbsolutePath());
			
			File dir = new File(destinationPath);
			if(!dir.exists()){
				dir.mkdir();
			}
			
		    Path destination = Paths.get(destinationPath + File.separator + file.getName());
		    Files.copy(source, destination, StandardCopyOption.COPY_ATTRIBUTES);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (logger.isInfoEnabled()) {
			logger.info("copyFiles - End");
		}
	}
}
