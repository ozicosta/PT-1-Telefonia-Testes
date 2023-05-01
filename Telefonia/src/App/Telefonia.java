package App;

import java.util.GregorianCalendar;
import java.util.Scanner;

public class Telefonia {

	private int numPrePagos;
	private PrePago[] prePagos;
	private int numPosPagos;
	private PosPago[] posPagos;

	private Scanner input = new Scanner(System.in);

	public Telefonia() {
		numPrePagos = 0;
		prePagos = new PrePago[20];
		numPosPagos = 0;
		posPagos = new PosPago[20];
	}

	public void cadastrarAssinante() {
		// criar um novo objeto Assinante
		System.out.println("Qual tipo de assinatura você deseja:");
		System.out.println("1 - Pos pago\n2 - Pre pago\n");

		int plano = input.nextInt();
		if (plano == 1) {

			System.out.println("Digite o CPF: ");
			long inputCpf = input.nextLong();

			System.out.println("Digite seu Nome: ");
			String inputNome = input.next();

			System.out.println("Digite o numero desejado: ");
			int inputNumero = input.nextInt();

			System.out.println("Digite o valor do plano: ");
			float inputAssinatura = input.nextFloat();

			for(int i = 0; i < posPagos.length; i++) {
				if(posPagos[i] == null) {
					this.posPagos[i] = new PosPago(inputCpf, inputNome, inputNumero, inputAssinatura);
					numPosPagos += 1;
					break;
				}
			}
			 
		}
		if (plano == 2) {
			System.out.println("Digite o CPF: ");
			long inputCpf = input.nextLong();

			System.out.println("Digite seu Nome: ");
			String inputNome = input.next();

			System.out.println("Digite o numero desejado: ");
			int inputNumero = input.nextInt();

			System.out.println("Digite o valor do plano: ");
			float inputAssinatura = input.nextFloat();

			for(int i = 0; i <prePagos.length; i++) {
				if(prePagos[i] == null) {
					this.prePagos[i] = new PrePago(inputCpf, inputNome, inputNumero, inputAssinatura);
					numPosPagos += 1;
					break;
				}
		}

	}
}

	public void listarAssinantes() {

	}

	public void fazerChamada()
	{
		System.out.println("Qual é o tipo do assinante?\n1 - Pos pago\n2 - Pre pago\n");
		int plano = input.nextInt();
		System.out.println("Digite o CPF: ");
		long inputCpf = input.nextLong();
		
		if(plano == 1)
		{
			for(int i = 0; i < posPagos.length; i++)
			{
				if(posPagos[i].getCpf() == inputCpf)
				{
					System.out.println("Qual a duracao da chamada?");
					int inputDuracao = input.nextInt();
					GregorianCalendar dataChamada = new GregorianCalendar();
					posPagos[i].fazerChamada(dataChamada, inputDuracao);
					break;
				}
			}
		}

		if(plano == 2)
		{
			for(int i = 0; i < prePagos.length; i++)
			{
				if(prePagos[i].getCpf() == inputCpf)
				{
					System.out.println("Qual a duracao da chamada?");
					int inputDuracao = input.nextInt();
					GregorianCalendar dataChamada = new GregorianCalendar();
					prePagos[i].fazerChamada(dataChamada, inputDuracao);
					break;
				}
			}
		}












	}

	public void fazerRecarga() {

	}

	private PrePago localizarPrePago(long cpf) {
		return null;
	}

	private PosPago localizarPosPago(long cpf) {
		return null;
	}

	public void imprimirFaturas() {
	//Retorna o método imprimirFatura em posições não vazias do vetor posPagos
		for(int i = 0; i < posPagos.length; i++) {
			if(posPagos[i] != null) {
				posPagos[i].imprimirFatura(1);
			}
		}
	}

	public static void main(String[] args) {
		Telefonia telefonia = new Telefonia();
		
		telefonia.cadastrarAssinante();
		telefonia.fazerChamada();
		
		telefonia.imprimirFaturas();
	}
}
