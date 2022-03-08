import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// lista que guarda todas as contas cadastradas
		ArrayList<Conta> Contas = new ArrayList<Conta>();

		// opção de controle do menu principal
		int opc = 0;
		do {
			Menu mainMenu = new Menu("Menu Principal", Arrays.asList("Conta", "Cliente", "Operacoes", "Sair"));

			opc = mainMenu.getSelection();

			switch (opc) {
				case 1:
					// chama classe de contas
					Menu menuContas = new Menu("Menu Contas",
							Arrays.asList("Criar conta corrente", "Criar conta poupanca"));
					if (menuContas.getSelection() == 1) {
						// criar conta corrente
						System.out.print("Quanto de caixa inicial: ");
						Scanner s = new Scanner(System.in);
						
						ContaCorrente conta = new ContaCorrente(new Date().getTime(), s.nextDouble());
						Contas.add(conta);
					}else if (menuContas.getSelection() == 2) {
						// criar conta poupança
						System.out.print("Quanto de caixa inicial: ");
						Scanner s = new Scanner(System.in);
						
						Random random = new Random();
						ContaPoupanca conta = new ContaPoupanca(random.nextInt(1000), s.nextDouble());
						Contas.add(conta);
					}
					break;
				case 2:
					// chama classe de clientes
					break;
				case 3:
					// chama classe de operações
					break;
				case 4:
					continue;
				default:
					System.out.println("Opção inválida para o menu principal...");
					break;
			}

			System.out.println("contas: ");
			for(int i = 0; i < Contas.size(); i++){
				System.out.println("Conta: " + Contas.get(i).getConta() + " - caixa: " + Contas.get(i).getCaixa());
			}
		} while (opc != 4);

		System.out.println("Fim");
	}

}
