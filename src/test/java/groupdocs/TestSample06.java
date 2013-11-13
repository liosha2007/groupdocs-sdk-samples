package groupdocs;

import com.groupdocs.sdk.api.SignatureApi;
import com.groupdocs.sdk.common.ApiException;
import com.groupdocs.sdk.common.ApiInvoker;
import com.groupdocs.sdk.common.GroupDocsRequestSigner;
import com.groupdocs.sdk.common.MimeUtils;
import com.groupdocs.sdk.model.*;
import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

@RunWith(JUnit4ClassRunner.class)
public class TestSample06 extends Base {
	{
		sampleName = "Sample 6";
	}

	@Test
	public void start() throws ApiException, IOException {
		ApiInvoker.getInstance().setRequestSigner(
				new GroupDocsRequestSigner(IConfig.PKEY));

		File documentFile = new File(IConfig.DOCUMENT_TO_SIGN);
		File signatureFile = new File(IConfig.SIGNATURE);

		String document = MimeUtils.readAsDataURL(documentFile);
		String signature = MimeUtils.readAsDataURL(signatureFile);

		SignatureSignDocumentDocumentSettingsInfo doc = new SignatureSignDocumentDocumentSettingsInfo();
		doc.setName(documentFile.getName());
		doc.setData(document);

		Double width = 100d;
		Double height = 100d;
		Double top = 300d;
		Double left = 10d;
		String placeSignatureOn = "";

		SignatureSignDocumentSignerSettingsInfo sig = new SignatureSignDocumentSignerSettingsInfo();
		sig.setName(signatureFile.getName());
		sig.setData(signature);
		sig.setWidth(width);
		sig.setHeight(height);
		sig.setTop(top);
		sig.setLeft(left);
		sig.setPlaceSignatureOn(placeSignatureOn);

        SignatureSignDocumentSettingsInfo signDocumentSettings = new SignatureSignDocumentSettingsInfo();
		signDocumentSettings.setDocuments(Arrays.asList(doc));
		signDocumentSettings.setSigners(Arrays.asList(sig));

		SignatureApi signatureApi = new SignatureApi();
		signatureApi.setBasePath(IConfig.BASE_PATH);

		SignatureSignDocumentResponse response = signatureApi.SignDocument(
				IConfig.CID, signDocumentSettings);
		if (isValid(response)) {
			SignatureSignDocumentResult result = response.getResult();
			String jonId = result.getJobId();
			System.out.println("Job ID: " + jonId);
		}
	}
}
