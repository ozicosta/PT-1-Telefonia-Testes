package App;

import java.util.GregorianCalendar;
import java.util.Scanner;

public class Telefonia {

	private int numPrePagos;
	private PrePago[] prePagos;
	private int numPosPagos;
	private PosPago[] posPagos;

	Assinante[] assinantes = new Assinante[10];
	private int cadastro = 0;

	private static Scanner input = new Scanner(System.in);

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
			input.nextLine(); // consumir o \n do nextLong anterior
			String inputNome = input.nextLine();

			System.out.println("Digite o numero desejado: ");
			int inputNumero = input.nextInt();

			System.out.println("Digite o valor do plano: ");
			float inputAssinatura = input.nextFloat();

			assinantes[cadastro] = new Assinante(inputCpf, inputNome, inputNumero);
			cadastro++;

			for (int i = 0; i < posPagos.length; i++) {
				if (posPagos[i] == null) {
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
			input.nextLine(); // consumir o \n do nextLong anterior
			String inputNome = input.nextLine();

			System.out.println("Digite o numero desejado: ");
			int inputNumero = input.nextInt();

			System.out.println("Digite o valor do plano: ");
			float inputAssinatura = input.nextFloat();

			for (int i = 0; i < prePagos.length; i++) {
				if (prePagos[i] == null) {
					this.prePagos[i] = new PrePago(inputCpf, inputNome, inputNumero, inputAssinatura);
					numPosPagos += 1;
					break;
				}
			}

		}
	}

	public void listarAssinantes() {
		System.out.println("Assinantes:");

		for (int i = 0; i < assinantes.length; i++) {
			if (assinantes[i] != null) {
				System.out.println(assinantes[i].toString());
			}
		}

	}

	public void fazerChamada() {
		    // Localiza o assinante pós-pago pelo CPF
		    PosPago  localizarPosPago ( long  cpf ) {
			for ( int  i = 0 ; i < posPagos . length ; i ++)
			{
			    if ( posPagos [ i ] . getCpf () == cpf )
			    {
				return  posPagos [ i ];
			    }
			}
			retornar  nulo ;
		    }

		    // Localiza o assinante pré-pago pelo CPF
		    PrePago  localizarPrePago ( long  cpf ) {
			for ( int  i = 0 ; i < prePagos . length ; i ++)
			{
			    if ( prePagos [ i ]. getCpf () == cpf )
			    {
				return  prePagos [ i ];
			    }
			}
			retornar  nulo ;
	 }

		System.out.println("Qual é o tipo do assinante?\n1 - Pos pago\n2 - Pre pago\n");
		int plano = input.nextInt();
		System.out.println("Digite o CPF: ");
		long inputCpf = input.nextLong();

		if (plano == 1) {
			for (int i = 0; i < posPagos.length; i++) {
				if (posPagos[i].getCpf() == inputCpf) {
					System.out.println("Qual a duracao da chamada?");
					int inputDuracao = input.nextInt();
					GregorianCalendar dataChamada = new GregorianCalendar();
					posPagos[i].fazerChamada(dataChamada, inputDuracao);
					break;
				}
			}
		}

		if (plano == 2) {
			for (int i = 0; i < prePagos.length; i++) {
				if (prePagos[i].getCpf() == inputCpf) {
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
		// Retorna o método imprimirFatura em posições não vazias do vetor posPagos

		System.out.println("Informe o número do mês da fatura");
		int inputMes = input.nextInt() - 1;// o mês no GregorianCalendar conta a partir de 0

		for (int i = 0; i < posPagos.length; i++) {
			if (posPagos[i] != null) {
				posPagos[i].imprimirFatura(inputMes);
			}
		}
	}

	public static void main(String[] args) {
		Telefonia telefonia = new Telefonia();

		int opcao;

		do {
			System.out.println("Escolha uma opção:");
			System.out.println("1 - Cadastrar Assinante");
			System.out.println("2 - Listar Assinantes");
			System.out.println("3 - Fazer Chamada");
			System.out.println("4 - Fazer Recarga");
			System.out.println("5 - Localizar Pre Pago");
			System.out.println("6 - Localizar Pos Pago");
			System.out.println("7 - Imprimir Fatura");
			System.out.println("0 - Sair");
			opcao = input.nextInt();

			switch (opcao) {
				case 1:
					telefonia.cadastrarAssinante();
					break;
				case 2:
					telefonia.listarAssinantes();
					break;
				case 3:
					telefonia.fazerChamada();
					break;
				case 4:
					System.out.println("Opção ainda nao criada!");
					break;
				case 5:
					System.out.println("Opção ainda nao criada!");
					break;
				case 6:
					System.out.println("Opção ainda nao criada!");
					break;
				case 7:
					telefonia.imprimirFaturas();
					break;
				case 0:
					System.out.println("Saindo...");
					break;
				default:
					System.out.println("Opção inválida!");
					break;
			}

		} while (opcao != 0);

		input.close();

	}
}
