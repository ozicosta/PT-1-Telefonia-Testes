package App;

import java.util.Scanner;

public class Telefonia {

	private int numPrePagos;
	private PrePago[] prePagos;
	private int numPosPagos;
	private PosPago[] posPagos;

	static Scanner input = new Scanner(System.in);

	public Telefonia() {

	}

	public static void cadastrarAssinante() {
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

			PosPago assinantePosPago = new PosPago(inputCpf, inputNome, inputNumero, inputAssinatura);
			System.out.println(assinantePosPago.toString());
		}
		if (plano == 2) {
			PrePago assinantePrePago = new PrePago(12345678910L, "Fulana de Lá", 1399166778);
			System.out.println(assinantePrePago.toString());
		}

	}

	public void listarAssinantes() {

	}

	public void fazerChamada() {

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

	}

	public static void main(String[] args) {

		cadastrarAssinante();
	}
}
