package qts.locadora;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;

import qts.locador.exception.JogoSemEstoqueException;
import qts.locador.exception.JogoValorZeroException;
import qts.locadora.service.LocacaoService;
import qts.locadora.util.DataUtil;
import qts.locadoraa.Cliente;
import qts.locadoraa.Jogo;
import qts.locadoraa.Locacao;

public class LocacaoTestService {
	@Test
    public void alugarJogo() throws Exception {

        Cliente cliente = new Cliente("Antonio");
        Jogo jogo = new Jogo("Harry Potter", 15.00, 1);

        LocacaoService locacaoService = new LocacaoService();
        Locacao locacao;

        locacao = locacaoService.alugarJogo(cliente, jogo);

        assertEquals(locacao.getJogo().getNome(), jogo.getNome());
        assertEquals(locacao.getCliente().getNome(), cliente.getNome());
        assertEquals("Erro no valor do jogo", locacao.getValor(), jogo.getValor(), 0.0);
        assertTrue(new DataUtil().verificarDatasIguais(locacao.getRetirada(), new Date()));
    }

    @Test(expected = JogoSemEstoqueException.class)
    public void testeSemEstoque() throws Exception {

        Cliente cliente = new Cliente("Antônio");
        Jogo jogo = new Jogo("Harry Potter", 15.00, 0);

        LocacaoService locacaoService = new LocacaoService();
        Locacao locacao;
        locacao = locacaoService.alugarJogo(cliente, jogo);
    }

    @Test(expected = JogoValorZeroException.class)
    public void testValorZero() throws Exception {

        Cliente cliente = new Cliente("Antônio");
        Jogo jogo = new Jogo("Carrinhos", 0, 10);

        LocacaoService locacaoService = new LocacaoService();
        Locacao locacao;
        locacao = locacaoService.alugarJogo(cliente, jogo);
    }
}
