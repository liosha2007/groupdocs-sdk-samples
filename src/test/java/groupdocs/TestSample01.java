package groupdocs;

import com.groupdocs.sdk.api.MgmtApi;
import com.groupdocs.sdk.common.ApiInvoker;
import com.groupdocs.sdk.common.GroupDocsRequestSigner;
import com.groupdocs.sdk.model.UserInfo;
import com.groupdocs.sdk.model.UserInfoResponse;
import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;

@RunWith(JUnit4ClassRunner.class)
public class TestSample01 extends Base {
	{
		sampleName = "Sample 1";
	}

	@Test
	public void start() throws Exception {

		ApiInvoker.getInstance().setRequestSigner(
				new GroupDocsRequestSigner(IConfig.PKEY));

		MgmtApi mgmtApi = new MgmtApi();
		mgmtApi.setBasePath(IConfig.BASE_PATH);

		UserInfoResponse response = mgmtApi.GetUserProfile(IConfig.CID);
		if (isValid(response)) {
			UserInfo userInfo = response.getResult().getUser();
			System.out.println("Firstname: " + userInfo.getFirstname());
			System.out.println("Lastname: " + userInfo.getLastname());
			System.out.println("Nickname: " + userInfo.getNickname());
			System.out.println("Primary_email: " + userInfo.getPrimary_email());
		}
	}
}
