package settings;

import org.testng.IRetryAnalyzer;
import org.testng.ITestNGListener;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
    // IRetryAnalyzer
    private int retryCount = 0;
    private static final int maxRetryCount = 2; // Максимальное количество попыток перезапуска

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            return true; // Перезапустить тест
        }
        return false; // Не перезапускать тест
    }
}
