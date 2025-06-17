// src/test/java/testcases/APITest.java
package testcases;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/api",
        glue = "stepdefinitions.api",
        plugin = {"pretty", "json:build/cucumber-report/cucumber.json"}
)
public class APITest {
}
