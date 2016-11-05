package ua.tickets.utils.report;

import com.codeborne.selenide.Screenshots;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;


public class CustomWatcher extends TestWatcher {

    private final HTMLTemplate report = new HTMLTemplate();

    private boolean onSucceededTest = false;

    public CustomWatcher onSucceededTest() {
        this.onSucceededTest = true;
        return this;
    }

    @Override
    protected void starting(Description test) {
        Screenshots.startContext(test.getClassName(), test.getMethodName());
        report.start();
    }

    @Override
    protected void succeeded(Description description) {
        if (onSucceededTest) {
            AllureReportUtil.attachScreenshot();
            report.finish();
        }
    }

    @Override
    protected void failed(Throwable e, Description description) {
        AllureReportUtil.attachScreenshot();
        report.finish();
    }

    @Override
    protected void finished(Description description) {
        report.clean();
    }

}
