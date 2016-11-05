package ua.tickets.utils.report;

import ru.yandex.qatools.allure.annotations.Attachment;

import java.io.IOException;

import static com.codeborne.selenide.Screenshots.takeScreenShotAsFile;
import static com.google.common.io.Files.toByteArray;


class AllureReportUtil {

    @Attachment(value = "Screenshot", type = "image/png")
    static byte[] attachScreenshot() {
        try {
            return toByteArray(takeScreenShotAsFile());
        } catch (IOException e) {
            e.printStackTrace();
            return new byte[0];
        }
    }

    @Attachment(value = "Log for test", type = "text/html")
    static String attachLog(String text) {
        return text;
    }

}
