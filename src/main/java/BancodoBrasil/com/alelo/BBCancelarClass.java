package BancodoBrasil.com.alelo;
import BancodoBrasil.com.alelo.params.BrasilParams;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

public class BBCancelarClass {

    public boolean status;
    public String key;

    public void GerarToken(BrasilParams brasilParams){


        RestAssured.useRelaxedHTTPSValidation();

        Response response = RestAssured
                .given()
                .contentType(ContentType.URLENC.withCharset("UTF-8"))
                .accept("application/json")
                .params(brasilParams.Token())
                .expect()
                .statusCode(200)
                .when()
                .post(brasilParams.getUrlToken())
                .then()
                .extract()
                .response();

        key = response.getBody().path("access_token").toString();


    }

    public void SimulacaoPagamento(BrasilParams brasilParams){

        brasilParams.DadosSimulacao();


        Response resp = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .header("Authorization","Bearer "+key)
                .headers(brasilParams.Credencials())
                .body(brasilParams.getSimulacaoCorpo())
                .when()
                .post(brasilParams.getUrlSimulation())
                .then()
                .extract()
                .response();

        brasilParams.setSimulationid(resp.getBody().path("simulationId").toString());
        brasilParams.setSimulationNumber(resp.getBody().path("simulationNumber"));

    }

    public void TokenGetRequest(BrasilParams brasilParams){

        RestAssured.useRelaxedHTTPSValidation();

        Response response = RestAssured
                                .given()
                                    .contentType(ContentType.JSON)
                                    .header("Authorization","Bearer "+key)
                                    .headers(brasilParams.TokenGet())
                                    .expect()
                                    .statusCode(200)
                                .when()
                                    .get(brasilParams.getUrlTokenGet())
                                .then()
                                    .extract()
                                    .response();

        brasilParams.setKeyToken(response.getBody().path("accessToken").toString());


    }
    public void GerarAceite(BrasilParams brasilParams){

        brasilParams.DadosAceite();

        RestAssured.useRelaxedHTTPSValidation();


        Response response = RestAssured
                                    .given()
                                        .contentType(ContentType.JSON)
                                        .header("Authorization","Bearer "+ key)
                                        .headers(brasilParams.CredentialsAgrements())
                                        .body(brasilParams.getDadosAceite())
                                    .when()
                                        .post(brasilParams.getUrlAgreements())
                                    .then()
                                        .extract()
                                        .response();

        brasilParams.setProposalNumber(response.getBody().path("proposalNumber").toString());


    }

    public void CancelamentoContrato(BrasilParams brasilParams){

        brasilParams.CancelarBody();

        Response resp = RestAssured
                                    .given()
                                        .contentType(ContentType.JSON)
                                        .header("Authorization","Bearer "+ key)
                                        .headers(brasilParams.CredentialsAgrements())
                                        .body(brasilParams.getBodyCancelar())
                                    .when()
                                        .post(brasilParams.getUrlCancelamento())
                                    .then()
                                        .assertThat()
                                        .statusCode(200)
                                        .extract()
                                        .response();

       status = resp.getBody().path("cancellationIndicator");

    }

    public void StatusdeCancelamento(){

    System.out.println("O status do cancelamento de contratação do EC foi " +" "+ status);
    }
}
