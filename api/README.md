То есть также создать заказ, получить, удалить и попытаться снова получить.
Для эндпоинта /store/inventory сохранить тело ответа виде Map.class и с помощью Assert провалидировать какое-либо её значение. Например:
Assert.assertTrue(inventory.containsKey("sold"), "Inventory не содержит статус sold" );