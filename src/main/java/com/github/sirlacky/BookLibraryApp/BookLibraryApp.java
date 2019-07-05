package com.github.sirlacky.BookLibraryApp;
import java.io.PrintWriter;
import org.junit.platform.launcher.listeners.TestExecutionSummary;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class BookLibraryApp {

    public static void main(String[] args) {
        SpringApplication.run(BookLibraryApp.class, args);


//        TODO Fix PreconditionViolationException!
//        RunTests testsRunner = new RunTests();
//        testsRunner.runAll();
//
//        TestExecutionSummary testSummary = testsRunner.listener.getSummary();
//        testSummary.printTo(new PrintWriter(System.out));

    }
}
