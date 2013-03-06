package com.groupdocs;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;

import com.groupdocs.sdk.api.SignatureApi;
import com.groupdocs.sdk.common.ApiException;
import com.groupdocs.sdk.common.ApiInvoker;
import com.groupdocs.sdk.common.GroupDocsRequestSigner;
import com.groupdocs.sdk.model.SignatureSignDocumentDocumentSettings;
import com.groupdocs.sdk.model.SignatureSignDocumentInfo;
import com.groupdocs.sdk.model.SignatureSignDocumentSettings;
import com.groupdocs.sdk.model.SignatureSignDocumentSignerSettings;
import com.groupdocs.sdk.model.SignatureSignDocumentsResponse;
import com.groupdocs.sdk.model.SignatureSignDocumentsResult;

@RunWith(JUnit4ClassRunner.class)
public class Sample06 extends Base {
	{
		sampleName = "Sample 6";
	}

	@Test
	public void start() throws ApiException, IOException {
		ApiInvoker.getInstance().setRequestSigner(
				new GroupDocsRequestSigner(IConfig.PKEY));

		File documentFile = new File(IConfig.DOCUMENT_TO_SIGN);
		File signatureFile = new File(IConfig.SIGNATURE);

		String document = ApiInvoker.readAsDataURL(documentFile);
		String signature = ApiInvoker.readAsDataURL(signatureFile);

		SignatureSignDocumentDocumentSettings doc = new SignatureSignDocumentDocumentSettings();
		doc.setName(documentFile.getName());
		doc.setData(document);

		Double width = 100d;
		Double height = 100d;
		Double top = 300d;
		Double left = 10d;
		String placeSignatureOn = "";

		SignatureSignDocumentSignerSettings sig = new SignatureSignDocumentSignerSettings();
		sig.setName(signatureFile.getName());
		sig.setData(signature);
		sig.setWidth(width);
		sig.setHeight(height);
		sig.setTop(top);
		sig.setLeft(left);
		sig.setPlaceSignatureOn(placeSignatureOn);

		SignatureSignDocumentSettings signDocumentSettings = new SignatureSignDocumentSettings();
		signDocumentSettings.setDocuments(Arrays.asList(doc));
		signDocumentSettings.setSigners(Arrays.asList(sig));

		SignatureApi signatureApi = new SignatureApi();
		signatureApi.setBasePath(IConfig.BASE_PATH);

		SignatureSignDocumentsResponse response = signatureApi.SignDocument(
				IConfig.CID, signDocumentSettings);
		if (isValid(response)) {
			SignatureSignDocumentsResult result = response.getResult();
			List<SignatureSignDocumentInfo> documentInfos = result
					.getDocuments();
			System.out
					.println("Signed document count: " + documentInfos.size());
			if (documentInfos.size() > 0) {
				SignatureSignDocumentInfo info = documentInfos.get(0);
				System.out.println("Signed document ID: "
						+ info.getDocumentId());
			}
		}
	}
}
