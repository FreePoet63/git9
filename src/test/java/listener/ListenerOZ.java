package listener;

import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import settings.StartSettings;

import java.io.File;
import java.io.IOException;

public class ListenerOZ extends StartSettings implements ITestListener {
    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    @Attachment(value = "LogOZ")
    public static String saveLogOZ() throws IOException {
        return FileUtils.readFileToString(new File("target/application.log"));
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public static byte[] saveScreenshotPNG() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String message) {
        return message;
    }

    @Attachment(value = "{0}", type = "text/html")
    public static String attachHtml(String html) {
        return html;
    }

    @Override
    public void onStart(ITestContext context) {
        AllureLogger.info("I am in onStart method " + context.getName());
        context.setAttribute("WebDriver", driver);
    }

    @Override
    public void onFinish(ITestContext context) {
        AllureLogger.info("I am in onFinish method " + context.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        AllureLogger.info(getTestMethodName(result) + " test is skipped.");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        AllureLogger.info("Test failed but it is in defined success ratio " + getTestMethodName(result));
    }

    @Override
    public void onTestStart(ITestResult result) {
        AllureLogger.info(getTestMethodName(result) + " test is starting.");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        AllureLogger.info(getTestMethodName(result) + " test is succeed.");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        AllureLogger.info(getTestMethodName(result) + " test is failed.");
        if (driver != null) {
            System.out.println("Screenshot captured for test case:" + getTestMethodName(result));
        }
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
    }
}
