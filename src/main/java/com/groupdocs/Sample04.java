package com.groupdocs;

import java.io.IOException;

import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;

import com.groupdocs.sdk.api.StorageApi;
import com.groupdocs.sdk.common.ApiException;
import com.groupdocs.sdk.common.ApiInvoker;
import com.groupdocs.sdk.common.FileStream;
import com.groupdocs.sdk.common.GroupDocsRequestSigner;

@RunWith(JUnit4ClassRunner.class)
public class Sample04 extends Base {
	{
		sampleName = "Sample 4";
	}

	@Test
	public void start() throws ApiException, IOException {
		ApiInvoker.getInstance().setRequestSigner(
				new GroupDocsRequestSigner(IConfig.PKEY));
		StorageApi storageApi = new StorageApi();
		storageApi.setBasePath(IConfig.BASE_PATH);

		FileStream fileStream = storageApi.GetFile(IConfig.CID, IConfig.GUID);
		if (fileStream == null) {
			System.err.println("fileStream is null");
		}
		System.out.println("Download file name: " + fileStream.getFileName());
		System.out.println("Download file size: " + fileStream.getSize());
		System.out.println("Available: "
				+ fileStream.getInputStream().available());
	}
}
