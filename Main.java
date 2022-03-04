import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		int opc = 0;
		do {
			Menu mainMenu = new Menu("Menu Principal", Arrays.asList("Conta", "Cliente", "Operacoes", "Sair"));

			opc = mainMenu.getSelection();

			switch (opc) {
				case 1:
					// chama classe de contas
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
		} while (opc != 4);

		System.out.println("Fim");
	}

}
