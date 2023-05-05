package App;

public class Assinante {
	private long cpf;
	private String nome;
	private int numero;
	protected int numChamadas;
	protected Chamada[] chamadas;

	public Assinante(long cpf, String nome, int numero) {
		this.cpf = cpf;
		this.nome = nome;
		this.numero = numero;
		this.numChamadas = 0;
	}

	public long getCpf() {
		return cpf;
	}

	@Override
	public String toString() {
		return "Assinante [cpf=" + cpf + ", nome=" + nome + ", numero=" + numero+ "]";
	}

}
