import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

import java.io.File;
import java.util.Collections;
import java.util.List;

public class ReportGenerator {
    public static void main(String[] args) {
        File reportOutputDirectory = new File("build/cucumber-html-report");
        List<String> jsonFiles = Collections.singletonList("build/cucumber-report/cucumber.json");

        Configuration config = new Configuration(reportOutputDirectory, "SauceDemo Test Report");
        config.addClassifications("Platform", System.getProperty("os.name"));
        config.addClassifications("Browser", "Chrome");
        config.addClassifications("Java", System.getProperty("java.version"));

        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, config);
        reportBuilder.generateReports();
    }
}
