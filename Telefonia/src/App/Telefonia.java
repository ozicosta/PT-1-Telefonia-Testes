package App;

import java.util.GregorianCalendar;
import java.util.Scanner;

public class Telefonia {

	private int numPrePagos;
	private PrePago[] prePagos;
	private int numPosPagos;
	private PosPago[] posPagos;

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
		System.out.println("1 - Pós-pago\n2 - Pré-pago\n");

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


			if(localizarPosPago(inputCpf) != null){
				System.out.println("CPF já cadastrado como pós-pago!");
			} else {
				this.posPagos[numPosPagos] = new PosPago(inputCpf, inputNome, inputNumero, inputAssinatura);
				numPosPagos += 1;
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

			if(localizarPrePago(inputCpf) != null){
				System.out.println("CPF já cadastrado como pré-pago!");
			} else {
				this.prePagos[numPrePagos] = new PrePago(inputCpf, inputNome, inputNumero);
				numPrePagos += 1;
				System.out.println("Cadastro realizado!");
			}

		}
	}

	public void listarAssinantes() {
		System.out.println("Assinantes:");
		System.out.println("========== PÓS-PAGOS =================");
		for (int i = 0; i < this.numPosPagos; i++) {
			System.out.println(this.posPagos[i].toString());
		}
		System.out.println("========== PRÉ-PAGOS =================");
		for (int i = 0; i < this.numPrePagos; i++) {
			System.out.println(this.prePagos[i].toString());
		}
	}

	public void fazerChamada() {
		
		System.out.println("Qual é o tipo do assinante?\n1 - Pós-pago\n2 - Pré-pago\n");
		int plano = input.nextInt();
		System.out.println("Digite o CPF: ");
		long inputCpf = input.nextLong();

		if (plano == 1) {
			PosPago posPago = localizarPosPago(inputCpf);
				if (posPago != null) {
			    System.out.println("Qual a duração da chamada?");
			    int inputDuracao = input.nextInt();
			    GregorianCalendar dataChamada = new GregorianCalendar();
			    posPago.fazerChamada(dataChamada, inputDuracao);
				System.out.println("Chamada realizada!");
			} else {
			    System.out.println("Assinante não encontrado.");
			}
		}else if (plano == 2) {
			PrePago prePago = localizarPrePago(inputCpf);
			if (prePago != null) {
			    System.out.println("Qual a duração da chamada?");
			    int inputDuracao = input.nextInt();
			    GregorianCalendar dataChamada = new GregorianCalendar();
			    prePago.fazerChamada(dataChamada, inputDuracao);
			} else {
			    System.out.println("Assinante não encontrado.");
			}
		} else {
			System.out.println("Plano inválido.");
		}
	}

	public void fazerRecarga() {
		System.out.println("Informe o CPF do assinante: ");
		long inputCpf = input.nextLong();

		PrePago assinantePrePago = localizarPrePago(inputCpf);
		if(assinantePrePago == null) {
			System.out.println("Assinante pré-pago não encontrado");
		} else {
			System.out.println("Qual o valor da recarga? ");
			float valorRecarga = input.nextFloat();
			GregorianCalendar dataRecarga = new GregorianCalendar();
			assinantePrePago.recarregar(dataRecarga, valorRecarga);
			System.out.println("Recarga realizado!");
		}
	}

	private PrePago localizarPrePago(long cpf) {
		for (int i = 0; i < numPrePagos; i++) {
		   if (prePagos[i].getCpf() == cpf) {
			return prePagos[i];
			}
		}
		return null;
	}

	private PosPago localizarPosPago(long cpf) {
		for (int i = 0; i < numPosPagos; i++) {
		   if (posPagos[i].getCpf() == cpf) {
			return posPagos[i];
			}
		}
		return null;
	}

	public void imprimirFaturas() {
		// Retorna o método imprimirFatura em posições não vazias do vetor posPagos

		System.out.println("Informe o número do mês da fatura");
		int inputMes = input.nextInt() - 1;// o mês no GregorianCalendar conta a partir de 0

		System.out.println("========== PÓS-PAGOS =================");
		for (int i = 0; i < this.numPosPagos; i++) {
			this.posPagos[i].imprimirFatura(inputMes);
		}

		System.out.println("========== PRÉ-PAGOS =================");
		for (int i = 0; i < this.numPrePagos; i++) {
			this.prePagos[i].imprimirFatura(inputMes);
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
			System.out.println("5 - Imprimir Fatura");
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
					telefonia.fazerRecarga();
					break;
				case 5:
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
