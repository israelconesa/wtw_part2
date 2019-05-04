package com.company;

import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.runner.JUnitCore.runClasses;

public class JUnitTestRunner {

    public static void main(String[] args) {
        Result result = runClasses(JUnitTests.class);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println(result.wasSuccessful());
    }
}
