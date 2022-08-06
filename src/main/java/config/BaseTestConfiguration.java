package config;

import com.codeborne.selenide.Configuration;
import helpfiles.PropertiesFile;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import static com.codeborne.selenide.Selenide.open;

public class BaseTestConfiguration extends AllureSetup{
    private final Logger logger = LogManager.getLogger(BaseTestConfiguration.class.getName());

    @Step("Open browser and application")
    @BeforeEach
    public void openApplication(){
        PropertiesFile propertiesFile = new PropertiesFile();
        propertiesFile.getBrowser();
        Configuration.browserSize = propertiesFile.getBrowserSize();
        Configuration.timeout = 8000;
        Configuration.headless = false;

        open(propertiesFile.getApplicationUrl());
    }
}
