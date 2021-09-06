package br.com.alelo.steps;


import io.cucumber.java.pt.*;
import br.com.alelo.services.Cart;
import br.com.alelo.utils.GeraCpfCnpj;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;

public class Steps {

    private String cnpj;
    private String accept;

    @Dado("que eu desejo criar um carrinho para o CNPJ {string}")
    public void queEuDesejoCriarUmCarrinhoParaOCNPJ(String cnpj) {
        this.cnpj = cnpj;
    }

    @Quando("eu informo que desejo aceitar os cookies")
    public void euInformoQueDesejoAceitarOsCookies() {
        this.accept = "true";
    }

    @E("envio a requisicao")
    public void envioARequisicao() {
        Cart.action().postWithoutPojo(cnpj, accept);
    }

    @Entao("eu recebo o status code {int}")
    public void euReceboOStatusCode(int statusCode) {
        assertEquals(statusCode, Cart.statusCode);
    }

    @E("o id do carrinho com o status {string}")
    public void oIdDoCarrinhoComOStatus(String cartStatus) {
        assertEquals(cartStatus, Cart.status);
    }


    @Dado("que eu desejo criar um carrinho com um CNPJ valido")
    public void queEuDesejoCriarUmCarrinhoComUmCNPJValido() {
        this.cnpj = GeraCpfCnpj.cnpj(false);
    }

    @E("eu desejo aceitar os cookies")
    public void euDesejoAceitarOsCookies() {
        accept = "true";
    }

    @Quando("eu envio a requisicao")
    public void euEnvioARequisicao() {
        Hooks.scenario.log(
                "\nResponse: \n" +
                        Cart.action()
                                .post(cnpj, accept)
                                .jsonPath().peek().prettify()
        );
    }

    @E("recebo o status code {int} para a requisicao de Carts")
    public void receboOStatusCodeParaARequisicaoDeCarts(int statusCode) {
        assertEquals(statusCode, Cart.statusCode);
    }

    @Entao("o ID do carrinho deve ser exibido junto com o status {string}")
    public void oIDDoCarrinhoDeveSerExibidoJuntoComOStatus(String status) {
        assertNotNull(Cart.cartResponse.getId());
        assertEquals(status, Cart.cartResponse.getStatus());
    }
}
