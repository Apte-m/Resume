Создать свой класс с названием типа HomeTaskApiTest и добавить в него аналогичные разделу PET (пример проекта: https://github.com/ViktoriaScotch/Lesson-8.git) проверки методов для раздела STORE из https://petstore.swagger.io/#/store. 
То есть также создать заказ, получить, удалить и попытаться снова получить.
Для эндпоинта /store/inventory сохранить тело ответа виде Map.class и с помощью Assert провалидировать какое-либо её значение. Например:
Assert.assertTrue(inventory.containsKey("sold"), "Inventory не содержит статус sold" );
