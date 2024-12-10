package UtilitiesForAndroid;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
    private int retryCount = 0;
    private static final int maxRetryCount = 1;

    @Override
    public boolean retry(ITestResult result)
    {
        if (retryCount < maxRetryCount) {
            retryCount++;
            System.out.println("Retrying test " + result.getName() + " with status " +
                    getResultStatusName(result.getStatus()) + " for the " + retryCount + " time(s).");
            try {
                Thread.sleep(60000); // Cooldown time if required
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return true;
        }
        return false;
    }

    private String getResultStatusName(int status)
    {
        switch (status) {
            case 1:
                return "SUCCESS";
            case 2:
                return "FAILURE";
            case 3:
                return "SKIP";
            default:
                return "UNKNOWN";
        }
    }

}

