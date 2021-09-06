package BrokerEc.alelo.com.br.params;

import io.cucumber.gherkin.internal.com.eclipsesource.json.Json;
import org.json.JSONObject;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Random;

public class Brokerparams {

    private String UrlCancelar = "http://10.40.89.132:7835/bankloan_api/v2/cancellations";
    private String UrlToken ="https://apisec-hml.alelo-cloud.com/mga/sps/oauth/oauth20/token";
    private String UrlTokenget = "https://apidev.homologacaoalelo.com.br/alelo/sb/bank-loans/v2/tokens";
    private String UrlSimulacao = "http://10.40.89.132:7835/bankloan_api/v2/simulations";
    private String UrlAceite = "http://10.40.89.132:7835/bankloan_api/v2/agreements";
    private String UrlAssinatura = "http://10.40.89.132:7835/bankloan_api/v2/signatures";


    private String bodyCancelar;
    private String proposalNumber;
    private String bodyAssinatura;
    private String bodyAceite;
    private String Simulationid;
    private Integer SimulationNumber;
    private String bodysimulacao;
    private String KeyToken;
    private String ec;
    private String cpf;

    String data = LocalDate.now().plusMonths(1).toString();
    int ContractNumber = new Random().nextInt(900000) + 100000;
    int UniqueNumber = new Random().nextInt(900000) + 100000;

    public String getBodyCancelar() {return bodyCancelar;}
    public void setProposalNumber(String proposalNumber) {this.proposalNumber = proposalNumber;}
    public String getBodyAssinatura() {return bodyAssinatura;}
    public String getBodyAceite() {return bodyAceite;}
    public void setEc(String ec) {this.ec = ec;}
    public void setCpf(String cpf) {this.cpf = cpf;}
    public void setKeyToken(String keyToken) {KeyToken = keyToken;}
    public String getBodySimulacao() {return bodysimulacao;}
    public void setSimulationid(String simulationid) {Simulationid = simulationid;}
    public void setSimulationNumber(Integer simulationNumber) {SimulationNumber = simulationNumber;}

    public String getUrlCancelar() {return UrlCancelar;}
    public String getUrlToken() {return UrlToken;}
    public String getUrlSimulacao() {return UrlSimulacao;}
    public String getUrlTokenget() {return UrlTokenget;}
    public String getUrlAceite() {return UrlAceite;}
    public String getUrlAssinatura() {return UrlAssinatura;}


    public HashMap<String, String> Token() {

        HashMap<String, String> json = new HashMap<>();
        json.put("client_id", "4e1452ad-fa20-45e2-886d-00f6712b200a");
        json.put("client_secret", "A6xE1fC5vG0bV4rW0tO8iY6dT2yY2aW1rH6qS1aO7vX0nH0aC7");
        json.put("grant_type", "password");
        json.put("username", "52964332894");
        json.put("password", "Alel0_529");

        return json;
    }

    public HashMap<String, String> TokenGet() {

        HashMap<String, String> json = new HashMap<>();
        json.put("x-ibm-client-id","4e1452ad-fa20-45e2-886d-00f6712b200a");
        json.put("x-ibm-client-secret","A6xE1fC5vG0bV4rW0tO8iY6dT2yY2aW1rH6qS1aO7vX0nH0aC7");
        json.put("Content-Type","application/json");
        json.put("APIm-Debug", "true");
        json.put("auth-code", "assassassas");

        return json;
    }

    public HashMap<String, String> parametros() {

        HashMap<String, String> body = new HashMap<>();
        body.put("isAccepted","true");
        body.put("Content-Type","application/json");

        return body;
    }

    public void Simulacao(){

        JSONObject json = new JSONObject();
        json.put("ecNumber",this.ec);
        json.put("idPersonUnit",0);
        json.put("value",100000);
        json.put("numberOfInstallments",12);
        json.put("firstInstallmentDate",data);
        json.put("interestRate",0.972);
        json.put("firstInstallmentValue",9337.72);
        json.put("lastInstallmentValue",8414.37);
        json.put("cpf",this.cpf);

        bodysimulacao = json.toString();
    }

    public void GerarAceite(){

        JSONObject json = new JSONObject();
        json.put("token",this.KeyToken);
        json.put("simulationNumber",this.SimulationNumber);
        json.put("simulationId",this.Simulationid);
        json.put("ecNumber",this.ec);
        json.put("cpf",this.cpf);

        bodyAceite = json.toString();
    }

    public void Assinatura(){
        JSONObject json = new JSONObject();
        json.put("cpf",this.cpf);
        json.put("ecNumber",this.ec);
        json.put("simulationId",this.Simulationid);
        json.put("contractNumber",ContractNumber);
        json.put("uniqueNumber",UniqueNumber);

        bodyAssinatura = json.toString();
    }

    public void DadosCancelar(){

        JSONObject json = new JSONObject();
        json.put("simulationId",this.Simulationid);
        json.put("token",this.KeyToken);
        json.put("proposalNumber",this.proposalNumber);
        json.put("cpf",this.cpf);

        bodyCancelar = json.toString();
    }
}
