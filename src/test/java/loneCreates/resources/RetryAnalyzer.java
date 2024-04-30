package loneCreates.resources;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer{

    private int retryCount = 0;
    private static final int maxRetryCount = 1; // Maximum number of retries

 
    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            System.out.println("Retrying test: " + result.getName() + ", attempt " + retryCount);
            return true;
        }
        return false;
    }
}
