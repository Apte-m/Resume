package ru.simbir.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;
import org.springframework.test.annotation.DirtiesContext;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@Configuration
@ComponentScan(lazyInit = true, basePackages = "ru.simbir")
@Profile("local-chrome")
@Import({DBBeanConfig.class, PropertiesConfig.class})
@DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
public class LocalChromeWebdriverBeanConfig {

    private WebDriver webDriver;


    @Bean
    @Qualifier("webDriver")
    public WebDriver webDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();
        opt.setExperimentalOption("w3c", true);
        webDriver = new ChromeDriver(opt);
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        return webDriver;
    }


}