package groupdocs;

import java.io.IOException;

import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;

import com.groupdocs.sdk.api.DocApi;
import com.groupdocs.sdk.api.StorageApi;
import com.groupdocs.sdk.common.ApiException;
import com.groupdocs.sdk.common.ApiInvoker;
import com.groupdocs.sdk.common.GroupDocsRequestSigner;
import com.groupdocs.sdk.model.GetImageUrlsResponse;
import com.groupdocs.sdk.model.GetImageUrlsResult;

@RunWith(JUnit4ClassRunner.class)
public class TestSample08 extends Base {
	{
		sampleName = "Sample 8";
	}

	@Test
	public void start() throws ApiException, IOException {
		ApiInvoker.getInstance().setRequestSigner(
				new GroupDocsRequestSigner(IConfig.PKEY));
		
		StorageApi storageApi = new StorageApi();
		storageApi.setBasePath(IConfig.BASE_PATH);
		
		DocApi docApi = new DocApi();
		docApi.setBasePath(IConfig.BASE_PATH);
		
		Integer firstPage = 1;
		Integer pageCount = 1;
		String dimension = "200x200";
		Integer quality = null;
		Boolean usePdf = null;
		String token = null;
		GetImageUrlsResponse response = docApi.GetDocumentPagesImageUrls(IConfig.CID, IConfig.GUID, firstPage , pageCount , dimension , quality, usePdf, token);
		if (isValid(response)) {
			GetImageUrlsResult result = response.getResult();
			System.out.println("Pages image size: " + result.getUrl().size());
			System.out.println("Image URL: " + result.getUrl().get(0));
		}
	}
}
