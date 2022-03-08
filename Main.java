import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Menu mainMenu =  new Menu("Menu Principal", Arrays.asList("Conta", "Cliente", "Operacoes", "Sair"));

		int opc = mainMenu.getSelection();

		System.out.println(opc + " foi selecionada");
		System.out.println("Fim");
	}

}
