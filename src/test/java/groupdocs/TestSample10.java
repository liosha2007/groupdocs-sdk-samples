package groupdocs;

import java.io.IOException;
import java.util.Arrays;

import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;

import com.groupdocs.sdk.api.DocApi;
import com.groupdocs.sdk.common.ApiException;
import com.groupdocs.sdk.common.ApiInvoker;
import com.groupdocs.sdk.common.GroupDocsRequestSigner;
import com.groupdocs.sdk.model.GetDocumentInfoResponse;
import com.groupdocs.sdk.model.GetDocumentInfoResult;
import com.groupdocs.sdk.model.SharedUsersResponse;
import com.groupdocs.sdk.model.SharedUsersResult;

@RunWith(JUnit4ClassRunner.class)
public class TestSample10 extends Base {
	{
		sampleName = "Sample 10";
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
			
			SharedUsersResponse response2 = docApi.ShareDocument(IConfig.CID,
					result.getId().toString(), Arrays.asList(IConfig.EMAIL_TO_SHARE));
			if (isValid(response2)) {
				SharedUsersResult result2 = response2.getResult();
				System.out.println("Shared to: " + result2.getShared_users().get(0));
			}
		}
	}
}
