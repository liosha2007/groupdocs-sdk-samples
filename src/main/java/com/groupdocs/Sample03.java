package com.groupdocs;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;

import com.groupdocs.sdk.api.StorageApi;
import com.groupdocs.sdk.common.ApiException;
import com.groupdocs.sdk.common.ApiInvoker;
import com.groupdocs.sdk.common.FileStream;
import com.groupdocs.sdk.common.GroupDocsRequestSigner;
import com.groupdocs.sdk.model.UploadRequestResult;
import com.groupdocs.sdk.model.UploadResponse;

@RunWith(JUnit4ClassRunner.class)
public class Sample03 extends Base {
	{
		sampleName = "Sample 3";
	}

	@Test
	public void start() throws ApiException, FileNotFoundException {

		ApiInvoker.getInstance().setRequestSigner(
				new GroupDocsRequestSigner(IConfig.PKEY));
		StorageApi storageApi = new StorageApi();
		storageApi.setBasePath(IConfig.BASE_PATH);
		
		String path = "";
		String description = null;
		File uploadFile = new File(IConfig.FILE_TO_UPLOAD);
		System.out.println("File to upload: " + uploadFile.getAbsolutePath());
		FileStream body = new FileStream(new FileInputStream(uploadFile));

		UploadResponse response = storageApi.Upload(IConfig.CID, path, description, body);
		if (isValid(response)) {
			UploadRequestResult result = response.getResult();
			System.out.println("File type: " + result.getType());
			System.out.println("File GUID: " + result.getGuid());
		}
	}
}
