package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.nio.file.Path;
import java.nio.file.Paths;

public class HtmlReport {
    private static ExtentHtmlReporter reporter;
    private static ExtentReports reports;

    private HtmlReport() {
        Path path = Paths.get("/test-output/report.html");
        reporter = new ExtentHtmlReporter(System.getProperty("user.dir")+path.toFile());
        reporter.config().setTheme(Theme.DARK);
        reports = new ExtentReports();
        reports.attachReporter(reporter);
    }

    public static ExtentReports getReportInstance(){
        if(reporter==null){
            new HtmlReport();
        }
        return reports;
    }
}
