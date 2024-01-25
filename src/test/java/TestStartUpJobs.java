import org.testng.Assert;

import org.testng.annotations.Test;
import pages.MainPage;
import settings.BaseTest;
import settings.RetryAnalyzer;

public class TestStartUpJobs extends BaseTest {

    @Test(retryAnalyzer = RetryAnalyzer.class)
        public void TestNumber001(){
        int res=0;
        MainPage mainPage = new MainPage(getDriver());
         res = mainPage.searchItem("Java").locationItem("Canada").locationCount();
        System.out.println("RESULT : "+res);
        Assert.assertNotEquals(res, 0);

    }
}
