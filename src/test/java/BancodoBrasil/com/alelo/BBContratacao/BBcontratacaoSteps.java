package BancodoBrasil.com.alelo.BBContratacao;
import BancodoBrasil.com.alelo.BrasilClass;
import BancodoBrasil.com.alelo.params.BrasilParams;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class BBcontratacaoSteps {
    BrasilClass brasilclass = new BrasilClass();
    BrasilParams brasilparams = new BrasilParams();

    @Dado("que eu desejo criar um Pagamento para um {string}")
    public void que_eu_desejo_criar_um_pagamento_para_um(String ec) {

        brasilparams.setEstabelecimento(ec);
    }

    @Quando("eu informo minhas informaçoes de acessos solicitados")
    public void eu_informo_minhas_informaçoes_de_acessos_solicitados() {

        brasilclass.GerarToken(brasilparams);

    }

    @Quando("envio a simulação de pagamento")
    public void envio_a_simulação_de_pagamento() {

        brasilclass.SimulacaoPagamento(brasilparams);
    }

    @Quando("recebo uma chave temporaria")
    public void recebo_uma_chave_temporaria() {

        brasilclass.TokenGet(brasilparams);
    }

    @Quando("informo a confirmação de termos do pagamento")
    public void informo_a_confirmação_de_termos_do_pagamento() {

        brasilclass.GerarAceite(brasilparams);
    }

    @Entao("faço a assinatura de contrato")
    public void faço_a_assinatura_de_contrato() {

        brasilclass.GerarSignature(brasilparams);
    }

    @Entao("recebo o numero de contratação criada")
    public void recebo_o_numero_de_contratação_criada() {

        brasilclass.ReturnContrato();
    }
}
