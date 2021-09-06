package br.com.alelo.pojos.shopping.cart.response;

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
        "id",
        "code",
        "status",
        "company",
        "printedProposal",
        "max_card_pme"
})
public class CartResponse {

    @JsonProperty("id")
    private String id;
    @JsonProperty("code")
    private Integer code;
    @JsonProperty("status")
    private String status;
    @JsonProperty("company")
    private Company company;
    @JsonProperty("printedProposal")
    private Boolean printedProposal;
    @JsonProperty("max_card_pme")
    private String maxCardPme;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("code")
    public Integer getCode() {
        return code;
    }

    @JsonProperty("code")
    public void setCode(Integer code) {
        this.code = code;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("company")
    public Company getCompany() {
        return company;
    }

    @JsonProperty("company")
    public void setCompany(Company company) {
        this.company = company;
    }

    @JsonProperty("printedProposal")
    public Boolean getPrintedProposal() {
        return printedProposal;
    }

    @JsonProperty("printedProposal")
    public void setPrintedProposal(Boolean printedProposal) {
        this.printedProposal = printedProposal;
    }

    @JsonProperty("max_card_pme")
    public String getMaxCardPme() {
        return maxCardPme;
    }

    @JsonProperty("max_card_pme")
    public void setMaxCardPme(String maxCardPme) {
        this.maxCardPme = maxCardPme;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}