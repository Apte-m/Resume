import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class AdditionAndDeductionTest {

    @BeforeClass
    public void beforeClass() {
        System.out.println("Запуск перед тестом");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("Подчищаем после тестов");
    }

    @Description("Аргументы для позитивной проверки")
    @DataProvider
    public Object[][] inputArgumentPositive() {
        return new Object[][]{

                {90, 45, 45},

        };
    }

    @Description("Проверка сложения аргументов")
    @Test(dataProvider = "inputArgumentPositive")
    public void additionArgumentPositive(int result, int one, int two) {
        Assert.assertEquals(result, new Math().sumTest(one, two), "Значения равны");
    }


    @Description("Проверка вычитания аргументов")
    @Test(dataProvider = "inputArgumentPositive")
    public void deductionArgumentPositive(int result, int one, int two) {
        Assert.assertEquals(one, new Math().deductionTest(result, one), "Значения равны");
    }

    @Description("Аргументы для  негативной проверки")
    @DataProvider
    public Object[][] inputArgumentNegative() {
        return new Object[][]{
                {0, -45, "s"},


        };
    }

    @Description("Проверка сложения аргументов негатив")
    @Test(dataProvider = "inputArgumentNegative")
    public void additionArgumentNegative(Object result, Object one, Object two) {
        try {
            Assert.assertNotEquals(result, new Math().sumTest(one, two));
        }catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Description("Проверка вычитания аргументов негатив")
    @Test(dataProvider = "inputArgumentNegative")
    public void deductionArgumentNegative(int result, Object one, Object two) {

        try {
            Assert.assertEquals(result, new Math().deductionTest(one, two), "Значения равны");
        }catch (Exception e)
        {e.printStackTrace();}

    }

    @Description("Аргументы для  граничных значений")
    @DataProvider
    public Object[][] inputArgumentBoundary() {
        return new Object[][]{
                {0, -1, 1},
        };

    }

    @Description("Проверка сложения аргументов граничные значения")
    @Test(dataProvider = "inputArgumentBoundary")
    public void additionArgumentBoundary(int result, int one, int two) {
        Assert.assertEquals(result, new Math().sumTest(one, two), "Значения с нулевым аргументов складыввать нельзя");
    }

    @Description("Проверка вычитания аргументов граничные значения")
    @Test(dataProvider = "inputArgumentBoundary")
    public void deductionArgumentBoundary(int result, int one, int two) {
        Assert.assertNotEquals(result, new Math().deductionTest(one, two), "Значения равны");
    }


}

