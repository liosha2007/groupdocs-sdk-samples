package com.groupdocs;

import java.io.IOException;

import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;

import com.groupdocs.sdk.api.DocApi;
import com.groupdocs.sdk.common.ApiException;
import com.groupdocs.sdk.common.ApiInvoker;
import com.groupdocs.sdk.common.GroupDocsRequestSigner;
import com.groupdocs.sdk.model.GetDocumentInfoResponse;
import com.groupdocs.sdk.model.GetDocumentInfoResult;

@RunWith(JUnit4ClassRunner.class)
public class Sample09 extends Base {
	{
		sampleName = "Sample 9";
	}

	@Test
	public void start() throws ApiException, IOException {
		ApiInvoker.getInstance().setRequestSigner(
				new GroupDocsRequestSigner(IConfig.PKEY));
		
		DocApi docApi = new DocApi();
		docApi.setBasePath(IConfig.BASE_PATH);
		
		GetDocumentInfoResponse response = docApi.GetDocumentMetadata(IConfig.CID, IConfig.GUID);
		if (isValid(response)) {
			GetDocumentInfoResult result = response.getResult();
			System.out.println("File ID: " + result.getId());
			System.out.println("File GUID: " + result.getGuid());
			System.out.println("File pages: " + result.getPage_count());
			System.out.println("File views: " + result.getViews_count());
		}
	}
}
