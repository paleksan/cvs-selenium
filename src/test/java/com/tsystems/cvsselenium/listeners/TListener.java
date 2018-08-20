package com.tsystems.cvsselenium.listeners;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import static org.testng.Reporter.log;

public class TListener extends TestListenerAdapter {
    private int m_count = 0;

    @Override
    public void onTestFailure(ITestResult testResult){
        log(testResult.getName() + "--Test method failed\n");
    }

    @Override
    public void onTestSkipped(ITestResult testResult) {
        log(testResult.getName() + "--Test method skipped\n");
    }

    @Override
    public void onTestSuccess(ITestResult testResult) {
        log(testResult.getName() + "--Test method success\n");
    }

    private void log(String string){
        System.out.println(string);
        if (++m_count % 40 == 0) {
            System.out.println("");
        }
    }
}
