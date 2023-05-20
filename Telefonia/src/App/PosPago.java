package App;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class PosPago extends Assinante {
	// valor fixo
	private float assinatura;

	public PosPago(long cpf, String nome, int numero, float assinatura) {

		super(cpf, nome, numero);
		this.assinatura = assinatura;
	}

	public void fazerChamada(GregorianCalendar data, int duracao) {
		// Checa se há espaço no vetor de chamadas
		if (this.numChamadas == this.chamadas.length) {
			System.out.println("Não é possível realizar novas chamadas!");
		} else {
			this.chamadas[numChamadas] = new Chamada(data, duracao);
			this.numChamadas += 1; // Atualiza numChamadas
		}
	}

	public void imprimirFatura(int mes) {
		float valorChamada, totalFatura = 0;

		// Imprimindo dados do Assinante
		System.out.println(this.toString());

		// Checando existência de chamadas e calculando o valor das chamadas e total
		// fatura
		for (int i = 0; i < this.numChamadas; i++) {

			if (chamadas[i].getData().get(Calendar.MONTH) == mes) {// Comparando o mes inserido
				System.out.print(chamadas[i].toString());
				valorChamada = chamadas[i].getDuracao() * 1.04f;
				totalFatura += valorChamada;
				System.out.println(" Custo: R$ " + String.format("%.2f", valorChamada));
			}
		}

		totalFatura = totalFatura + this.assinatura;

		System.out.println("Total da fatura = R$ " + String.format("%.2f", totalFatura));
	}
}
