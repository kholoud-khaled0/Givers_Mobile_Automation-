package listeners;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.common.LogsUtils;
import utils.common.PropertiesUtils;




public class TestResultListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        LogsUtils.info("Test passed: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        LogsUtils.info("Test failed: " + result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        LogsUtils.info("Test skipped: " + result.getName());
    }

    @Override
    public void onStart(ITestContext context) {
        LogsUtils.info("Test run started");
        PropertiesUtils.loadProperties(context.getCurrentXmlTest().getParameter("platformName"));
    }

    @Override
    public void onFinish(ITestContext context) {
        LogsUtils.info("Test run finished");
        PropertiesUtils.clearProperties();
    }
}
