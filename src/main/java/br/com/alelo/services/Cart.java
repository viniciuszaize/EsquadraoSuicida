package br.com.alelo.services;

import br.com.alelo.pojos.shopping.cart.request.CartRequest;
import br.com.alelo.pojos.shopping.cart.request.ShoppingCart;
import br.com.alelo.pojos.shopping.cart.response.CartResponse;
import io.cucumber.messages.internal.com.google.gson.Gson;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import io.restassured.http.ContentType;
import br.com.alelo.pojos.shopping.cart.request.CookiesAccepted;

import static io.restassured.RestAssured.given;

public class Cart {

    private static final String URL = "https://ecommerce-frontend-hml.siteteste.inf.br/api/sales/shopping-cart";

    public static Response response;

    public static int statusCode;
    public static String status;
    public volatile static CartResponse cartResponse;

    public static Cart action() {
        return new Cart();
    }

    public Cart postWithoutPojo(String cnpj, String accept) {
        Map<String, Object> body = new HashMap<>();
        Map<String, Object> shoppingCart = new HashMap<>();
        Map<String, Object> cookiesAccepted = new HashMap<>();

        shoppingCart.put("document", cnpj);
        body.put("Shopping-cart", shoppingCart);

        cookiesAccepted.put("datetime", "123456749813516");
        cookiesAccepted.put("accept", accept);
        body.put("cookiesAccepted", cookiesAccepted);

        response = given()
                .contentType(ContentType.JSON)
                .urlEncodingEnabled(false).log().all(true)
                .body(new Gson().toJson(body))
                .post(URL)
                .then().extract().response();

        statusCode = response.getStatusCode();

        status = response.jsonPath().get("status");

        //        Valindando schema
        response.then().body(JsonSchemaValidator
                .matchesJsonSchema(new File("src/test/resources/schemas/shoppingCart/cartResponse.json")));

        return this;
    }

    public Response post(String cnpj, String accept) {
                response = given()
                .contentType(ContentType.JSON)
                .urlEncodingEnabled(false).log().all(true)
                .body(CartRequest.builder()
                        .withCookiesAccepted(
                                CookiesAccepted.builder()
                                        .withAccept(accept)
                                        .withDatetime("123456749813516")
                        ).withShoppingCart(
                                ShoppingCart.builder()
                                        .withDocument(cnpj)
                        ))
                .post(URL)
                .then().extract().response();

        statusCode = response.getStatusCode();

        cartResponse = response.as(CartResponse.class);
        
//        Valindando schema
        response.then().body(JsonSchemaValidator
                .matchesJsonSchema(new File("src/test/resources/schemas/shoppingCart/cartResponse.json")));

        return response;
    }

}
