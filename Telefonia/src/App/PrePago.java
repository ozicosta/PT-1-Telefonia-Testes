package App;

import java.util.GregorianCalendar;

public class PrePago extends Assinante {

	private int numRecargas;
	private float creditos;
	private Recarga[] recargas;

	public PrePago(long cpf, String nome, int numero) {
		super(cpf, nome, numero);
		this.recargas = new Recarga[10];//iniciei o array com dez espaços de inicio mas podemos alterar depois
	}


	public void fazerChamada(GregorianCalendar data, int duracao) {

		//caso todos espaços do array estejam preechidos(sem credito)
		if(this.numChamadas == this.chamadas.length) {
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

	}
}
