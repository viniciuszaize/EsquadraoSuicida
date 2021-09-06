package BancodoBrasil.com.alelo.BBCancelar;
import BancodoBrasil.com.alelo.BBCancelarClass;
import BancodoBrasil.com.alelo.params.BrasilParams;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class BBcancelarSteps {

    BrasilParams brasilParams = new BrasilParams();
    BBCancelarClass bbCancelarClass = new BBCancelarClass();


    @Dado("uma simulação de pagamento para o {string}")
    public void uma_simulação_de_pagamento_para_o(String ec) {

         brasilParams.setEstabelecimento(ec);
    }
    @Quando("eu informo minhas informaçoes de acessos")
    public void eu_informo_minhas_informaçoes_de_acessos() {

         bbCancelarClass.GerarToken(brasilParams);

    }
    @Quando("faço um envio de simulação de pagamento")
    public void faço_um_envio_de_simulação_de_pagamento() {

        bbCancelarClass.SimulacaoPagamento(brasilParams);

    }
    @Quando("recebo uma chave temporaria para realizar a confirmação do processo")
    public void recebo_uma_chave_temporaria_para_realizar_a_confirmação_do_processo() {

        bbCancelarClass.TokenGetRequest(brasilParams);

    }
    @Quando("informo as informaçoes de simulação de pagamento feita")
    public void informo_as_informaçoes_de_simulação_de_pagamento_feita() {

        bbCancelarClass.GerarAceite(brasilParams);

    }
    @Quando("faço o cancelamento de contratação")
    public void faço_o_cancelamento_de_contratação() {
        bbCancelarClass.CancelamentoContrato(brasilParams);

    }
    @Entao("recebo o status do cancelamento de contratação")
    public void recebo_o_status_do_cancelamento_de_contratação() {

        bbCancelarClass.StatusdeCancelamento();

    }

}
