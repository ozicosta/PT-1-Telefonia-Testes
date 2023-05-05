package App;

import java.util.GregorianCalendar;

public class PrePago extends Assinante {

	private float assinatura;//apos declarar esta variavel o problema da linha 15 parou

	private int numRecargas;
	private float creditos;
	private Recarga[] recargas;

	public PrePago(long cpf, String nome, int numero,float assinatura) {
		super(cpf, nome, numero);
		this.assinatura = assinatura;
		this.recargas = new Recarga[10];//iniciei o array com dez espaços de inicio mas podemos alterar depois
	}


	public void fazerChamada(GregorianCalendar data, int duracao) {

		//caso todos espaços do array estejam preechidos(sem credito)
		if(this.numChamadas == this.chamadas.length) {

			//esta condiçãõ verifica também se há créditos disponiveis para executar a chamada
			if(creditos<=0){
				System.out.println("Não possui créditos suficientes para completar esta ligação.");
			} else 

			//caso haja creditos porém não tenha mais chamadas disponiveis, ele exibe a mensagem mesmo assim
			System.out.println("Não possui créditos suficientes para completar esta ligação.");
		}


		//do contrário passamos para o laço for que percorre o array a procura de créditos
		for(int i =0;i<this.chamadas.length;i++)
		{
			//ele procura créditos
			if (this.chamadas[i]==null)//caso o array tenha espaço(credito)
			{
				//quando acha creditos ele atualiza os dados
				this.chamadas[i] = new Chamada(data,duracao); //chamada recebe a data e a duração passadas pelo usuário
				this.numChamadas += 1; //numChamadas aumenta +1
				this.creditos -=  (float) ((float)duracao * 1.45); //aqui ele atualiza o valor de crédito cobrando de acordo com a duração da chamada(fiz o casting para float porque o valor provido é double porém o requerido é float
			}


		}
	}

	public void recarregar(GregorianCalendar data, float valor) {
		//o laço percorre o array procurando se há espaço para novas recargas
		for (int i = 0; i < recargas.length; i++) {
			if (recargas[i] != null)//caso o array esteja vazio(sem crédito) ele printa a mensagem abaixo
			{
				System.out.println("Você ainda não pode fazer recargas.");
			} else if (recargas[i] == null) {
				valor = recargas[i].getValor(); //do contrario o valor de recarga é atualizado
				data.get(GregorianCalendar.DAY_OF_MONTH); //esta linha registra o dia da recarga, minha duvida ainda é "que variavel recebe esta data?"
			}

		}
	}

	public void imprimirFatura(int mes) {
		float totalChamadas = 0; // variável para armazenar o total das chamadas do mês
		// laço for que percorre o array de chamadas do assinante e calcula o total de chamadas realizadas no mês
		for (int i = 0; i < this.numChamadas; i++) {
			Chamada chamada = this.chamadas[i];
			// verifica se a chamada foi realizada no mês desejado
			if (chamada.getData().get(GregorianCalendar.MONTH) == mes - 1) {
				totalChamadas += chamada.getDuracao() * 1.45; // adiciona o valor da chamada ao total
			}
		}
		float totalRecargas = 0; // variável para armazenar o total de recargas do mês
		
		// laço for que percorre o array de recargas do assinante e calcula o total de recargas realizadas no mês
		for (int i = 0; i < this.numRecargas; i++) {
			Recarga recarga = this.recargas[i];
			// verifica se a recarga foi realizada no mês desejado
			if (recarga.getData().get(GregorianCalendar.MONTH) == mes - 1) {
				totalRecargas += recarga.getValor(); // adiciona o valor da recarga ao total
			}
		}
		float total = this.assinatura + totalChamadas - totalRecargas;
		// imprime a fatura do assinante
		System.out.println("Fatura do assinante " + this.getNome() + " - Mês " + mes);
		System.out.println("Assinatura: R$ " + this.assinatura);
		System.out.println("Total em chamadas: R$ " + totalChamadas);
		System.out.println("Total em recargas: R$ " + totalRecargas);
		System.out.println("Total a pagar: R$ " + total);

	}
}
