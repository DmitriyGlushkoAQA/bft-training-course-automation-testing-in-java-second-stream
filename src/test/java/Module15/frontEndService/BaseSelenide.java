package Module15.frontEndService;

import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Selenide.open;

public class BaseSelenide {

    public static int timeOut = 60000;

    public static void openUrl(String url) {
        Configuration.browserSize = "maximize";
        Configuration.pageLoadTimeout = timeOut;
        open(url);
    }
}

