package qts.locadoraa;

public class Jogo {
	private String nome;
    private double valor;
    private int qtestoque;

    public Jogo(String nome, double valor, int qtestoque) {
        this.nome = nome;
        this.valor = valor;
        this.qtestoque = qtestoque;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getQtestoque() {
        return qtestoque;
    }

    public void setQtestoque(int qtestoque) {
        this.qtestoque = qtestoque;
    }
}
