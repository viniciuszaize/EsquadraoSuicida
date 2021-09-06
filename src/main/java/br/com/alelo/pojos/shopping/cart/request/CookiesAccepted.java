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
        "datetime",
        "accept"
})
public class CookiesAccepted {

    @JsonProperty("datetime")
    private String datetime;
    @JsonProperty("accept")
    private String accept;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public static CookiesAccepted builder() {
        return new CookiesAccepted();
    }

    @JsonProperty("datetime")
    public String getDatetime() {
        return datetime;
    }

    @JsonProperty("datetime")
    public CookiesAccepted withDatetime(String datetime) {
        this.datetime = datetime;
        return this;
    }

    @JsonProperty("accept")
    public String getAccept() {
        return accept;
    }

    @JsonProperty("accept")
    public CookiesAccepted withAccept(String accept) {
        this.accept = accept;
        return this;

    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public CookiesAccepted withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}