package qts.locadoraa;

public class Cliente {
	
	private String nome;
	
	public Cliente(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	public String toString() {
		return "Nome: " + nome;
	}
	
	public boolean equals(Object obj) {
		Cliente cli = (Cliente)obj;
		return nome.equals(cli.nome);
	}
}
