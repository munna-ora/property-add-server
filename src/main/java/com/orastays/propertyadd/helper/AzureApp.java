package com.orastays.propertyadd.helper;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.blob.BlobContainerPublicAccessType;
import com.microsoft.azure.storage.blob.BlobRequestOptions;
import com.microsoft.azure.storage.blob.CloudBlobClient;
import com.microsoft.azure.storage.blob.CloudBlobContainer;
import com.microsoft.azure.storage.blob.CloudBlockBlob;

@Component
public class AzureApp  {

	private static final Logger logger = LogManager.getLogger(AzureApp.class);
	
	@Autowired
	private MessageUtil messageUtil;
	
	public String uploadFile(MultipartFile multipartFile, String fileName) throws Exception {
		
		if (logger.isInfoEnabled()) {
			logger.info("uploadFile -- START");
		}
		
		String azureKey = messageUtil.getBundle("azure.key");
		String azureContainer = messageUtil.getBundle("azure.container");
		
		// Parse the connection string and create a blob client to interact with Blob storage
		CloudStorageAccount storageAccount = CloudStorageAccount.parse(azureKey);
		CloudBlobClient blobClient = storageAccount.createCloudBlobClient();
		CloudBlobContainer container = blobClient.getContainerReference(azureContainer);

		// Create the container if it does not exist with public access.
		System.out.println("Creating container: " + container.getName());
		container.createIfNotExists(BlobContainerPublicAccessType.CONTAINER, new BlobRequestOptions(), new OperationContext());		    

		//Getting a blob reference
		CloudBlockBlob blob = container.getBlockBlobReference(fileName);

		blob.upload(multipartFile.getInputStream(), multipartFile.getSize());

		String url = messageUtil.getBundle("azure.link") + messageUtil.getBundle("azure.container") + "/" + fileName;
		System.err.println("url ==>> "+url);
		
		if (logger.isInfoEnabled()) {
			logger.info("uploadFile -- END");
		}

		return url;
	}
}