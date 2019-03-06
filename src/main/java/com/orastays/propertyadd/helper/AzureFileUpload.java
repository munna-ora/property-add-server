package com.orastays.propertyadd.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.blob.CloudBlobClient;
import com.microsoft.azure.storage.blob.CloudBlobContainer;
import com.microsoft.azure.storage.blob.CloudBlockBlob;
import com.orastays.propertyadd.exceptions.FormExceptions;

@Component
public class AzureFileUpload {

	private static final String FILE_UPLOAD_FAILED_MESSAGE = "file.upload.failed.message";
	public static final String FILE_UPLOAD_FAILED_CODE = "file.upload.failed.code";


	private static final Logger logger = LogManager.getLogger(AzureFileUpload.class);
	
	
	@Autowired
	protected MessageUtil messageUtil;
	
	public String uploadFileByAzure(MultipartFile multipartFileInput) throws FormExceptions {
		
		if (logger.isInfoEnabled()) {
			logger.info("uploadFileByAzure -- START");
		}
		
		
		Map<String, Exception> exceptions = new LinkedHashMap<>();	
		CloudStorageAccount storageAccount;
		String finalImageURL = StringUtils.EMPTY;
		// Parse the connection string and create a blob client to interact with Blob storage
		try {
			storageAccount = CloudStorageAccount.parse(messageUtil.getBundle("storage.connection.string"));
			File file = Util.convertMultipartToFile(multipartFileInput);
		    FileInputStream input = new FileInputStream(file);
		    String imageName =  uploadToAzureStorage(storageAccount, new MockMultipartFile("file",file.getName(), "text/plain", IOUtils.toByteArray(input)), file.getName());
		    finalImageURL = messageUtil.getBundle("azur.image.url") + File.separator + imageName;
		
		} catch(IOException  |  InvalidKeyException | URISyntaxException e){
			exceptions.put(messageUtil.getBundle(FILE_UPLOAD_FAILED_CODE), new Exception(messageUtil.getBundle(FILE_UPLOAD_FAILED_MESSAGE)));
		} 
		
		 if (exceptions.size() > 0){
				throw new FormExceptions(exceptions);
		    }
		 

		if (logger.isInfoEnabled()) {
			logger.info("uploadFileByAzure -- END");
		}
		
		return finalImageURL;
	}
	
	public String uploadToAzureStorage(CloudStorageAccount cloudStorageAccount, MultipartFile file, String fileName) throws FormExceptions{
	   
		if (logger.isInfoEnabled()) {
			logger.info("uploadToAzureStorage -- START");
		}
		
		
		Map<String, Exception> exceptions = new LinkedHashMap<>();
		
		String uri = null;
	    try {
	        CloudBlobClient blobClient = cloudStorageAccount.createCloudBlobClient();
			CloudBlobContainer container = blobClient.getContainerReference(messageUtil.getBundle("web.blob.dev.key"));
			    
				String newFileName = fileName+"_"+new Date().getTime();
	            
				CloudBlockBlob blob = container.getBlockBlobReference(newFileName);
	            blob.upload(file.getInputStream(), file.getSize());

	            uri = blob.getUri().getPath();
	    } catch (Exception e) {
	    	exceptions.put(messageUtil.getBundle(FILE_UPLOAD_FAILED_CODE), new Exception(messageUtil.getBundle(FILE_UPLOAD_FAILED_MESSAGE)));
	    }
	    
	    if (exceptions.size() > 0){
			throw new FormExceptions(exceptions);
	    }
	    
	    if (logger.isInfoEnabled()) {
			logger.info("uploadToAzureStorage -- END");
		}

	    return uri;
	}
}
