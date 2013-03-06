package com.groupdocs;

import java.io.IOException;

import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;

import com.groupdocs.sdk.api.DocApi;
import com.groupdocs.sdk.api.StorageApi;
import com.groupdocs.sdk.common.ApiException;
import com.groupdocs.sdk.common.ApiInvoker;
import com.groupdocs.sdk.common.GroupDocsRequestSigner;
import com.groupdocs.sdk.model.FileMoveResponse;
import com.groupdocs.sdk.model.FileMoveResult;
import com.groupdocs.sdk.model.GetDocumentInfoResponse;
import com.groupdocs.sdk.model.GetDocumentInfoResult;

@RunWith(JUnit4ClassRunner.class)
public class Sample05 extends Base {
	{
		sampleName = "Sample 5";
	}

	@Test
	public void start() throws ApiException, IOException {
		ApiInvoker.getInstance().setRequestSigner(
				new GroupDocsRequestSigner(IConfig.PKEY));

		DocApi docApi = new DocApi();
		docApi.setBasePath(IConfig.BASE_PATH);
		GetDocumentInfoResponse response = docApi.GetDocumentMetadata(
				IConfig.CID, IConfig.GUID);
		if (isValid(response)) {
			GetDocumentInfoResult result = response.getResult();

			StorageApi storageApi = new StorageApi();
			storageApi.setBasePath(IConfig.BASE_PATH);

			String mode = null;

			FileMoveResponse response2 = storageApi.MoveFile(IConfig.CID,
					IConfig.COPY_TO_PATH, mode,
					null, Long.toString(result.getId().longValue()));
			if (isValid(response2)) {
				FileMoveResult result2 = response2.getResult();
				System.out.println("Copied document path: "
						+ result2.getDst_file().getDocument_path());
				System.out.println("Copied document type: "
						+ result2.getDst_file().getFile_type());
			}
		}
	}
}
