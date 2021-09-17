package qts.locadora.service;

import qts.locadoraa.Cliente;
import qts.locadoraa.Jogo;
import qts.locadoraa.Locacao;
import qts.locadora.util.DataUtil;

import java.util.Date;


public class LocacaoService {
	private final int diasPadrao = 5;
    public int testePublic;
    int testeDefault;

    public Locacao alugarJogo(Cliente cliente, Jogo jogo) throws Exception {

        if (jogo.getQtestoque() == 0) {
            throw new qts.locador.exception.JogoSemEstoqueException();
        }

        if (jogo.getValor() <= 0) {
            throw new qts.locador.exception.ValorInvalidoException();
        }

        Locacao locacao = new Locacao();
        locacao.setCliente(cliente);
        locacao.setJogo(jogo);
        locacao.setValor(jogo.getValor());
        locacao.setRetirada(new Date());

        Date devolucao = new DataUtil().addDias(new Date(), diasPadrao);
        locacao.setDevolucao(devolucao);

        return locacao;
    }
}
