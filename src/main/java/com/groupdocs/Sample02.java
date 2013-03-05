package com.groupdocs;

import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;

import com.groupdocs.sdk.api.StorageApi;
import com.groupdocs.sdk.common.ApiException;
import com.groupdocs.sdk.common.ApiInvoker;
import com.groupdocs.sdk.common.GroupDocsRequestSigner;
import com.groupdocs.sdk.model.FileSystemDocument;
import com.groupdocs.sdk.model.FileSystemFolder;
import com.groupdocs.sdk.model.ListEntitiesResponse;
import com.groupdocs.sdk.model.ListEntitiesResult;

@RunWith(JUnit4ClassRunner.class)
public class Sample02 extends Base {
	{
		sampleName = "Sample 2";
	}

	@Test
	public void start() throws ApiException {

		ApiInvoker.getInstance().setRequestSigner(
				new GroupDocsRequestSigner(IConfig.PKEY));
		
		StorageApi storageApi = new StorageApi();
		storageApi.setBasePath(IConfig.BASE_PATH);
		
		String path = "";
		Integer pageIndex = null;
		Integer pageSize = null;
		String orderBy = null;
		Boolean orderAsc = null;
		String filter = null;
		String fileTypes = null;
		Boolean extended = null;
		
		
		ListEntitiesResponse response = storageApi.ListEntities(IConfig.CID, path, pageIndex, pageSize, orderBy, orderAsc, filter, fileTypes, extended);
		if (isValid(response)) {
			ListEntitiesResult result = response.getResult();
			System.out.println("Folders:");
			for (FileSystemFolder folder : result.getFolders()) {
				System.out.println("  +" + folder.getName());
			}
			System.out.println("Documents:");
			for (FileSystemDocument document : result.getFiles()) {
				System.out.println("  -" + document.getName() + " [" + document.getGuid() + "]");
			}
		}
	}
}
