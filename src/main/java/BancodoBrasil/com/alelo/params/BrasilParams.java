package BancodoBrasil.com.alelo.params;

import org.json.JSONObject;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Random;


public class BrasilParams {

    private String UrlCancelamento = "https://apidev.homologacaoalelo.com.br/alelo/sb/bank-loans/v2/cancellations";
    private String urlToken = "https://apisec-hml.alelo-cloud.com/mga/sps/oauth/oauth20/token";
    private String UrlTokenGet = "https://apidev.homologacaoalelo.com.br/alelo/sb/bank-loans/v2/tokens";
    private String UrlSimulation = "https://apidev.homologacaoalelo.com.br/alelo/sb/bank-loans/v2/simulations";
    private String UrlSignature = "https://apidev.homologacaoalelo.com.br/alelo/sb/bank-loans/v2/signatures";
    private String UrlAgreements = "https://apidev.homologacaoalelo.com.br/alelo/sb/bank-loans/v2/agreements";

    String data = LocalDate.now().plusMonths(1).toString();


    private String proposalNumber;
    private  String ec;
    private String dadosAceite;
    private String keyToken;
    private String simulacaoCorpo;
    private String simulationid;
    private Integer simulationNumber;
    private String signaturecorpo;
    private String bodyCancelar;


    int ContractNumber = new Random().nextInt(900000) + 100000;
    int UniqueNumber = new Random().nextInt(900000) + 100000;

    public String getBodyCancelar() {return bodyCancelar;}
    public void setEstabelecimento(String ec) {this.ec = ec;}
    public void setProposalNumber(String proposalNumber) {this.proposalNumber = proposalNumber;}
    public String getDadosAceite() {
        return dadosAceite;
    }
    public void setKeyToken(String keyToken) {
        this.keyToken = keyToken;
    }
    public String getSignaturecorpo() {
        return signaturecorpo;
    }
    public void setSimulationid(String simulationid) {
        this.simulationid = simulationid;
    }
    public void setSimulationNumber(Integer simulationNumber) {
        this.simulationNumber = simulationNumber;
    }

    public String getSimulacaoCorpo() {
        return simulacaoCorpo;
    }
    public String getUrlAgreements() {return UrlAgreements;}
    public String getUrlSignature() {return UrlSignature;}
    public String getUrlTokenGet() {return UrlTokenGet;}
    public String getUrlSimulation() {return UrlSimulation;}
    public String getUrlToken() {
        return urlToken;
    }
    public String getUrlCancelamento() {return UrlCancelamento;}


    public HashMap<String, String> Token() {

        HashMap<String, String> json = new HashMap<>();
        json.put("client_id", "4e1452ad-fa20-45e2-886d-00f6712b200a");
        json.put("client_secret", "A6xE1fC5vG0bV4rW0tO8iY6dT2yY2aW1rH6qS1aO7vX0nH0aC7");
        json.put("grant_type", "password");
        json.put("username", "52964332894");
        json.put("password", "Alel0_529");

        return json;
    }


    public HashMap<String, String> Credencials() {

        HashMap<String, String> body = new HashMap<>();
        body.put("isAccepted","true");
        body.put("X-IBM-Client-Id","4e1452ad-fa20-45e2-886d-00f6712b200a");
        body.put("X-IBM-Client-Secret","A6xE1fC5vG0bV4rW0tO8iY6dT2yY2aW1rH6qS1aO7vX0nH0aC7");
        body.put("Content-Type","application/json");
        body.put("APIm-Debug", "true");

        return body;
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

    public void DadosSimulacao(){

        JSONObject json = new JSONObject();

        json.put("ecNumber",this.ec);
        json.put("idPersonUnit",0);
        json.put("value",100000);
        json.put("numberOfInstallments",12);
        json.put("firstInstallmentDate",data);
        json.put("interestRate",0.972);
        json.put("firstInstallmentValue",9337.72);
        json.put("lastInstallmentValue",8414.37);

        simulacaoCorpo = json.toString();
    }


    public void DadosAceite(){

        JSONObject json = new JSONObject();

        json.put("token",this.keyToken);
        json.put("simulationNumber",this.simulationNumber);
        json.put("simulationId",this.simulationid);
        json.put("ecNumber",this.ec);

        dadosAceite = json.toString();
    }


    public void DadosSignature(){

        JSONObject json = new JSONObject();

        json.put("ecNumber",this.ec);
        json.put("simulationId", this.simulationid);
        json.put("contractNumber",this.ContractNumber);
        json.put("uniqueNumber",this.UniqueNumber);

        signaturecorpo = json.toString();
    }

    public HashMap<String, String> CredentialsAgrements() {

        HashMap<String, String> body = new HashMap<>();

        body.put("X-IBM-Client-Id","4e1452ad-fa20-45e2-886d-00f6712b200a");
        body.put("X-IBM-Client-Secret","A6xE1fC5vG0bV4rW0tO8iY6dT2yY2aW1rH6qS1aO7vX0nH0aC7");
        body.put("Content-Type","application/json");
        body.put("APIm-Debug", "true");

        return body;
    }

    public void CancelarBody(){

        JSONObject json = new JSONObject();

        json.put("simulationId",this.simulationid);
        json.put("proposalNumber",this.proposalNumber);
        json.put("token",this.keyToken);

        bodyCancelar = json.toString();
    }
}