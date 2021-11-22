import org.testng.annotations.Test;
import paige.Category;
import settings.Settings;

public class AvitoTest extends Settings {

   
    @Test
    public void startEndpoint (){
        paige.goTo()   //перейти настраницу
                .searchCategory(Category.Оргтехника) // выбрать категорию
                .searchOnTheWord("Принтер") // выбрать товар
                .clickTheSearch() // клик на поиск города
                .setSearchCity("Владивосток") // поиск по городу
                .clickTheButton() // нажать на кнопку поиска города
                .scroll() // прокрутка до нужного елемента
                .clickPriceTheGeneral() // клик по общему пройсу
                .clickNeedPrice() // выбор определеннго прайса
                .info(3); // вывод последних n товаров




    }
}
