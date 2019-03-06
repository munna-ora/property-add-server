package com.orastays.propertyadd.service;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContextEvent;

public interface FileCopyService {

	void copyFiles(ServletContextEvent arg0);

	void copyFiles(File file, String fileType);

	void copyFiles(Map<String, List<File>> fileNamesWithPath);

}
