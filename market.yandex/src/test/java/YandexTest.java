import org.testng.annotations.Test;
import utils.Settings;

public class YandexTest extends Settings {

    @Test
    public void runTest() {
        paige.goTo()
                .clickCatalog()
                .navigateAnimalsProductsAndClick()
                .installFilters()
                .goToFirstProductAndCompare()
                .chanceFilters()
                .compareProduct()
                .compareNameAndPrice();
    }

}
