package settings;

import org.openqa.selenium.WebDriver;
import org.testng.IAnnotationTransformer;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class TestListener implements ITestListener, IAnnotationTransformer {

    @Override
    public void onTestStart(ITestResult iTestResult) {
        // код который выполняется перед запуском теста
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        // код который выполняется после успешного прохождения теста
     /*   WebDriver driver = BaseTest.getDriver();
        driver.close();
        driver.quit();  */
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        // код который выполняется если тест упал
        System.out.println("Something is wrong...");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        // код который выполняется если тест пропущен
    }

    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        // код для изменения аннотаций теста перед запуском
    }

}