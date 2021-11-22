package avito;

import avito.avitoUp.WebDriverSettings;
import avito.avitoUp.AvitoPaige;
import org.testng.annotations.Test;
import org.openqa.selenium.support.PageFactory;


public class AvitoTest extends WebDriverSettings {


    @Test
    public void signUp() {
        AvitoPaige avitoPaige = PageFactory.initElements(webDriver, AvitoPaige.class);
        avitoPaige.openPaige()
                .searchCssSelector("#category", "Оргтехника и расходники")
                .clickTheSearch("Принтер")
                .clickTheProduct()
                .SearchCity("Владивосток")
                .searchSelector("[data-marker='popup-location/save-button']")
                .searchScrollXpath("(//span[@class='checkbox-label-OmC9T text-text-LurtD text-size-s-BxGpL text-color-default-_QyDA'])[6]")
                .searchXpath("//div[@class='index-topPanel-McfCA']//select[@class='select-select-IdfiC']")
                .searchXpath("//div[@class='index-topPanel-McfCA']//option[@value='2']")
                .info();


    }
}
