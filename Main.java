import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// lista que guarda todos os clientes
		ArrayList<Cliente> Clientes = new ArrayList<Cliente>();

		// opção de controle do menu principal
		int opc = 0;

		do {
			Scanner scan = new Scanner(System.in);

			Menu mainMenu = new Menu("Menu Principal", Arrays.asList("Conta", "Cliente", "Operacoes", "Sair"));

			opc = mainMenu.getSelection();

			switch (opc) {
				case 1:
					// chama classe de contas
					Menu menuContas = new Menu("Menu Contas",
							Arrays.asList("Criar conta corrente", "Criar conta poupanca"));
					if (menuContas.getSelection() == 1) {
						// criar conta corrente
						System.out.print("Nome do cliente: ");
						String nomeCliente = scan.nextLine(); // corrigir essa linha (ele ta pulando o cadastro)
						System.out.print("CPF do cliente: ");
						String cpfCliente = scan.nextLine();
						System.out.print("Quanto de caixa inicial: ");
						Double caixaInicial = scan.nextDouble();

						ContaCorrente conta = new ContaCorrente(new Date().getTime(), caixaInicial);
						Cliente cliente = new Cliente(nomeCliente, cpfCliente, conta);
						Clientes.add(cliente);
					} else if (menuContas.getSelection() == 2) {
						// criar conta poupança
						System.out.print("Nome do cliente: ");
						String nomeCliente = scan.nextLine(); // corrigir essa linha (ele ta pulando o cadastro)
						System.out.print("CPF do cliente: ");
						String cpfCliente = scan.nextLine();
						System.out.print("Quanto de caixa inicial: ");
						Double caixaInicial = scan.nextDouble();

						ContaPoupanca conta = new ContaPoupanca(new Date().getTime(), caixaInicial);
						Cliente cliente = new Cliente(nomeCliente, cpfCliente, conta);
						Clientes.add(cliente);
					}
					break;

				case 2:
					// chama classe de clientes
					Menu menuClientes = new Menu("Menu clientes",
							Arrays.asList("Listar clientes"));
					if (menuClientes.getSelection() == 1) {
						// listar clientes
						for (int i = 0; i < Clientes.size(); i++) {
							System.out.println(
									"Nome: " + Clientes.get(i).getNome() + " - CPF: " + Clientes.get(i).getCpf()
											+ " - Conta: " + Clientes.get(i).getConta().getConta() + " - Caixa: "
											+ Clientes.get(i).getConta().getCaixa());
						}
					}
					break;

				case 3:
					// chama classe de operações
					Menu menuOperacoes = new Menu("Menu operacoes",
							Arrays.asList("Transferir dinheiro para conta corrente",
									"Transferir dinheiro para conta poupanca"));
					if (menuOperacoes.getSelection() == 1) {
						// transferir dinheiro entre duas contas correntes
						System.out.print("Numero da conta de saida de dinheiro: ");
						Long conta1 = scan.nextLong();
						System.out.print("Numero da conta de entrada de dinheiro: ");
						Long conta2 = scan.nextLong();
						System.out.print("Valor da transferencia: ");
						Double valorTransferencia = scan.nextDouble();

						if (conta1 == conta2)
							System.out.println("Voce nao pode transferir dinheiro para sua própria conta.");
						else {
							Cliente cliente1 = Cliente.buscaCliente(conta1, Clientes);
							Cliente cliente2 = Cliente.buscaCliente(conta2, Clientes);

							if (cliente1 == null || cliente2 == null) {
								System.out.println("Nao foi possivel encontrar um dos clientes");
								break;
							}

							if (cliente1.getConta().getClass() != cliente2.getConta().getClass())
								System.out.println("So eh permitido transferencia entre contas do mesmo tipo");
							else {
								if (cliente1.getConta().remover(valorTransferencia))
									cliente2.getConta().adicionar(valorTransferencia);
								else
									System.out.println("A conta de saida não tem saldo suficiente!");
							}
						}
					} else if (menuOperacoes.getSelection() == 2) {
						// transferir dinheiro entre duas contas poupanca
						System.out.print("Numero da conta de saida de dinheiro: ");
						Long conta1 = scan.nextLong();
						System.out.print("Numero da conta de entrada de dinheiro: ");
						Long conta2 = scan.nextLong();
						System.out.print("Valor da transferencia: ");
						Double valorTransferencia = scan.nextDouble();

						if (conta1 == conta2)
							System.out.println("Voce nao pode transferir dinheiro para sua própria conta.");
						else {
							Cliente cliente1 = Cliente.buscaCliente(conta1, Clientes);
							Cliente cliente2 = Cliente.buscaCliente(conta2, Clientes);

							if (cliente1 == null || cliente2 == null) {
								System.out.println("Nao foi possivel encontrar um dos clientes");
								break;
							}

							if (cliente1.getConta().getClass() != cliente2.getConta().getClass())
								System.out.println("So eh permitido transferencia entre contas do mesmo tipo");
							else {
								if (cliente1.getConta().remover(valorTransferencia))
									cliente2.getConta().adicionar(valorTransferencia);
								else
									System.out.println("A conta de saida não tem saldo suficiente!");
							}
						}
					}
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
