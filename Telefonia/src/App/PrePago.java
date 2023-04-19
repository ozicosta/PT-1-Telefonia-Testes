package App;

import java.util.GregorianCalendar;

public class PrePago extends Assinante {

	private int numRecargas;
	private float creditos;
	private Recarga[] recargas;

	public PrePago(long cpf, String nome, int numero) {
		super(cpf, nome, numero);

	}

	public void fazerChamada(GregorianCalendar data, int duracao) {

	}

	public void recarregar(GregorianCalendar data, float valor) {

	}

	public void imprimirFatura(int mes) {

	}
}
