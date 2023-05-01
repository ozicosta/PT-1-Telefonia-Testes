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
	//o laço percorre o array em procura de créditos
		for(int i =0;i<chamadas.length;i++)
		{
			if (chamadas[i]==null)//caso o array esteja vazio(sem credito)
			{	//printa esta mensagem
				System.out.println("Não possui créditos suficientes para completar esta ligação.");
			}else
				//do contrário ele atualiza chamadas para +1 e creditos para -1.45(preço por minutos de ligação)
				//chamadas[i] = ++;//eu não entendo o porquê de estar com este erro no ponto e virgula
				creditos -= 1.45;
			numRecargas += numChamadas +1;
			duracao += duracao +1; //só consegui pensar em adicionar um minuto a mais na chamada dando a entender que sempre são feitas chamadas de 1m apenas
			data.get(GregorianCalendar.DAY_OF_MONTH);//aqui eu não sei pra quem eu atribuo a data
		}
	}

	public void recarregar(GregorianCalendar data, float valor) {

	}

	public void imprimirFatura(int mes) {

	}
}
