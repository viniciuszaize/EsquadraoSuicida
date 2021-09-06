package BancodoBrasil.com.alelo;
import BancodoBrasil.com.alelo.params.BrasilParams;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class BrasilClass {

    public String key;
    public String idContrato;

    public void GerarToken(BrasilParams brasilparams){

        RestAssured.useRelaxedHTTPSValidation();

        Response response = RestAssured
                            .given()
                                    .contentType(ContentType.URLENC.withCharset("UTF-8"))
                                    .accept("application/json")
                                    .params(brasilparams.Token())
                                    .expect()
                                    .statusCode(200)
                            .when()
                                    .post(brasilparams.getUrlToken())
                            .then()
                                    .extract()
                                    .response();

        key = response.getBody().path("access_token").toString();

    }

    public void SimulacaoPagamento(BrasilParams brasilparams){

        brasilparams.DadosSimulacao();


        Response resp = RestAssured
                            .given()
                                    .contentType(ContentType.JSON)
                                    .header("Authorization","Bearer "+key)
                                    .headers(brasilparams.Credencials())
                                    .body(brasilparams.getSimulacaoCorpo())
                            .when()
                                    .post(brasilparams.getUrlSimulation())
                            .then()
                                    .extract()
                                    .response();

        brasilparams.setSimulationid(resp.getBody().path("simulationId").toString());
        brasilparams.setSimulationNumber(resp.getBody().path("simulationNumber"));


    }

    public void TokenGet(BrasilParams brasilparams){

        RestAssured.useRelaxedHTTPSValidation();

        Response response = RestAssured
                            .given()
                                    .contentType(ContentType.JSON)
                                    .header("Authorization","Bearer "+key)
                                    .headers(brasilparams.TokenGet())
                                    .expect()
                                    .statusCode(200)
                            .when()
                                    .get(brasilparams.getUrlTokenGet())
                            .then()
                                    .extract()
                                    .response();

        brasilparams.setKeyToken(response.getBody().path("accessToken"));


    }
    public void GerarAceite(BrasilParams brasilparams){

        brasilparams.DadosAceite();

        RestAssured.useRelaxedHTTPSValidation();


         RestAssured
                    .given()
                        .contentType(ContentType.JSON)
                        .header("Authorization","Bearer "+ key)
                        .headers(brasilparams.CredentialsAgrements())
                        .body(brasilparams.getDadosAceite())
                    .when()
                        .post(brasilparams.getUrlAgreements())
                    .then()
                        .extract()
                        .response();

    }
    public void GerarSignature(BrasilParams brasilparams){

        brasilparams.DadosSignature();

        Response resposta = RestAssured
                            .given()
                                    .contentType(ContentType.JSON)
                                    .header("Authorization","Bearer "+key)
                                    .headers(brasilparams.Credencials())
                                    .body(brasilparams.getSignaturecorpo())
                            .when()
                                    .post(brasilparams.getUrlSignature())
                            .then()
                                    .extract()
                                    .response();

        idContrato = resposta.getBody().path("contractId").toString();
    }


    public void ReturnContrato(){

        System.out.println("numero de contratação do EC é " + " " + idContrato);
    }
}
