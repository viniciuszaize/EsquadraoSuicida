package br.com.alelo.pojos.shopping.cart.request;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Shopping-cart",
        "cookiesAccepted"
})
public class CartRequest {

    @JsonProperty("Shopping-cart")
    private ShoppingCart shoppingCart;

    @JsonProperty("cookiesAccepted")
    private CookiesAccepted cookiesAccepted;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public static CartRequest builder(){
        return new CartRequest();
    }

    @JsonProperty("Shopping-cart")
    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    @JsonProperty("Shopping-cart")
    public CartRequest withShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
        return this;
    }

    @JsonProperty("cookiesAccepted")
    public CookiesAccepted getCookiesAccepted() {
        return cookiesAccepted;
    }

    @JsonProperty("cookiesAccepted")
    public CartRequest withCookiesAccepted(CookiesAccepted cookiesAccepted) {
        this.cookiesAccepted = cookiesAccepted;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public CartRequest withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}