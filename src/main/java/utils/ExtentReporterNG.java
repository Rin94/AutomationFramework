package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ExtentReporterNG {

    public static ExtentReports getReportObject() throws IOException {
        Properties properties = new Properties();
        FileInputStream fis = new FileInputStream(GlobalVariables.SYSTEM_DIR_PATH+GlobalVariables.PROPERTIES_PATH);
        properties.load(fis);

        String path = GlobalVariables.SYSTEM_DIR_PATH + "//reports//index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName(properties.getProperty("reportName"));
        reporter.config().setDocumentTitle(properties.getProperty("reportDocumentTitle"));
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester",properties.getProperty("tester"));
        fis.close();

        return extent;
    }
}
