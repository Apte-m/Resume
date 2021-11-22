import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class DivisionAndMultiplicationTest {
    @BeforeClass
    public void beforeClass() {
        System.out.println("Запуск перед тестом");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("Подчищаем после тестов");
    }

    @Description("Аргументы для позитива")
    @DataProvider
    public Object[][] inputArgumentPositive() {
        return new Object[][]{

                {13, 52, 4},

        };
    }

    @Description("Проверка деления аргументов")
    @Test(dataProvider = "inputArgumentPositive")
    public void divisionTestPositive(int result, int one, int two) {
        Assert.assertEquals(result, new Math().divisionTest(one, two), "Значения равны");
    }

    @Description("Проверка умножения аргументов")
    @Test(dataProvider = "inputArgumentPositive")
    public void multiplicationTestPositive(int result, int one, int two) {
        Assert.assertEquals(one, new Math().multiplicationTest(result, two), "Значения равны");
    }

    @Description("Аргументы для  негативной проверки")
    @DataProvider
    public Object[][] inputArgumentNegative() {
        return new Object[][]{
                {4, 2, 0},


        };
    }

    @Description("Проверка деления аргументов")
    @Test(dataProvider = "inputArgumentNegative")
    public void divisionTestTestNegative(int result, int one, int two)  {
        try {
            Assert.assertNotEquals(result, new Math().divisionTest(one, two), "Значения не равны");
        }
        catch (ArithmeticException e) {
            e.printStackTrace();
        }
    }

    @Description("Проверка деления аргументов")
    @Test(dataProvider = "inputArgumentNegative")
    public void multiplicationTestNegative(int result, int one, int two) {
        try {
            Assert.assertNotEquals(result, new Math().multiplicationTest(one, two), "Значения не равны");
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
    }

    @Description("Аргументы для  граничных значений")
    @DataProvider
    public Object[][] inputArgumentBoundary() {
        return new Object[][]{
                {-2, -4, 2},
        };
    }

    @Description("Проверка деления аргументов")
    @Test(dataProvider = "inputArgumentBoundary")
    public void divisionTestTestBoundary(int result, int one, int two) {
        Assert.assertNotEquals(one, new Math().divisionTest(one, two), "Значения равны");
    }

    @Description("Проверка умножения аргументов")
    @Test(dataProvider = "inputArgumentBoundary")
    public void multiplicationTestBoundary(int result, int one, int two) {
        Assert.assertEquals(one, new Math().multiplicationTest(result, two), "Значения равны");
    }


}

