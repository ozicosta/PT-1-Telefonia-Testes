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
	//Checa se há espaço no vetor de chamadas
		if(this.numChamadas == this.chamadas.length) {
			System.out.println("Não é possível realizar novas chamadas!");
		}
	//Procura uma posição vazia no vetor chamadas para inserir uma nova chamada
		for(int i = 0; i < this.chamadas.length; i++) {
			if(this.chamadas[i] == null) {
				this.chamadas[i] = new Chamada(data,duracao);
				this.numChamadas += 1; //Atualiza numChamadas
				break;
			}
		}
	}

	public void imprimirFatura(int mes) {
		float valorChamada, totalFatura = 0;
		
		System.out.println(this.toString());
		
		for(int i = 0; i < chamadas.length; i++) {
			if(chamadas[i] != null) {
				System.out.print(chamadas[i].toString());
				valorChamada = chamadas[i].getDuracao()*1.04f;
				totalFatura += valorChamada;
				System.out.println(" R$ " + String.format("%.2f", valorChamada));
			}
		}
		
		System.out.println("Total da fatura = R$ "+ String.format("%.2f", totalFatura));
	}
}
