package ru.test_pro.api;

import io.restassured.response.Response;

public interface CrudEntity {

    Response getId(String... values);

    void create(Object o, String... values);

    void update(Object o, String... values);

    void delete(String ...values);
}
