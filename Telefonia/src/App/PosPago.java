package App;

import java.util.Calendar;
import java.util.GregorianCalendar;

//MEU!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
public class PosPago extends Assinante {
	// valor fixo
	private float assinatura;

	public PosPago(long cpf, String nome, int numero, float assinatura) {
		
		super(cpf, nome, numero);
		this.assinatura = assinatura;
		int qtdChamadas = (int) (assinatura/1.04f);
		this.chamadas = new Chamada[qtdChamadas];
	}

	public void fazerChamada(GregorianCalendar data, int duracao) {
		if(this.numChamadas == this.chamadas.length) {
			System.out.println("Não é possível realizar novas chamadas!");
		}
		for(int i = 0; i < this.chamadas.length; i++) {
			if(this.chamadas[i] == null) {
				this.chamadas[i] = new Chamada(data,duracao);
				this.numChamadas += 1;
				break;
			}
		}
	}

	public void imprimirFatura(int mes) {

	}
}
