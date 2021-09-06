package BrokerEc.alelo.com.br.requests;

import BrokerEc.alelo.com.br.params.Brokerparams;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class BrokerContratar {

    public String key;
    public String numeroContrato;


    public void GerarToken(Brokerparams brokerparams){

        RestAssured.useRelaxedHTTPSValidation();

        Response response = RestAssured
                                    .given()
                                        .contentType(ContentType.URLENC.withCharset("UTF-8"))
                                        .accept("application/json")
                                        .params(brokerparams.Token())
                                        .expect()
                                        .statusCode(200)
                                    .when()
                                        .post(brokerparams.getUrlToken())
                                    .then()
                                        .extract()
                                        .response();

        key = response.getBody().path("access_token").toString();

    }

    public void Simulacao(Brokerparams brokerparams){

        brokerparams.Simulacao();

        Response resp = RestAssured
                                .given()
                                    .contentType(ContentType.JSON)
                                    .headers(brokerparams.parametros())
                                    .body(brokerparams.getBodySimulacao())
                                .when()
                                    .post(brokerparams.getUrlSimulacao())
                                .then()
                                    .extract()
                                    .response();

        brokerparams.setSimulationid(resp.getBody().path("simulationId").toString());
        brokerparams.setSimulationNumber(resp.getBody().path("simulationNumber"));
    }


    public void GetToken(Brokerparams brokerparams){

        Response response = RestAssured
                                    .given()
                                        .contentType(ContentType.JSON)
                                        .header("Authorization","Bearer "+key)
                                        .headers(brokerparams.TokenGet())
                                    .when()
                                        .get(brokerparams.getUrlTokenget())
                                    .then()
                                        .extract()
                                        .response();

       brokerparams.setKeyToken(response.getBody().path("accessToken").toString());

    }

    public void AceiteContrato(Brokerparams brokerparams){

        brokerparams.GerarAceite();

        Response response = RestAssured
                                .given()
                                    .contentType(ContentType.JSON)
                                    .body(brokerparams.getBodyAceite())
                                .when()
                                    .post(brokerparams.getUrlAceite())
                                .then()
                                    .extract()
                                    .response();

    }
    public void GerarAssinatura(Brokerparams brokerparams){
        brokerparams.Assinatura();

        Response resposta = RestAssured
                                    .given()
                                        .contentType(ContentType.JSON)
                                        .body(brokerparams.getBodyAssinatura())
                                    .when()
                                        .post(brokerparams.getUrlAssinatura())
                                    .then()
                                        .assertThat()
                                        .statusCode(201)
                                        .extract()
                                        .response();

       numeroContrato = resposta.getBody().path("contractId").toString();

    }

    public void RespostaContrato(){

        System.out.println("O numero de contrato gerado para o Ec é"+" "+ numeroContrato);

    }
}
