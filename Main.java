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
									"Transferir dinheiro para conta poupanca", "Listar contas correntes",
									"Listar contas poupancas"));
					switch (menuOperacoes.getSelection()) {
						case 1:
							// transferir dinheiro entre duas contas correntes
							System.out.print("Numero da conta de saida de dinheiro: ");
							Long cc1 = scan.nextLong();
							System.out.print("Numero da conta de entrada de dinheiro: ");
							Long cc2 = scan.nextLong();
							System.out.print("Valor da transferencia: ");
							Double valorTransferenciaCorrente = scan.nextDouble();

							if (cc1 == cc2)
								System.out.println("Voce nao pode transferir dinheiro para sua própria conta.");
							else {
								Cliente cliente1 = Cliente.buscaCliente(cc1, Clientes);
								Cliente cliente2 = Cliente.buscaCliente(cc2, Clientes);

								if (cliente1 == null || cliente2 == null) {
									System.out.println("Nao foi possivel encontrar um dos clientes");
									break;
								}

								if (cliente1.getConta().getClass() != cliente2.getConta().getClass())
									System.out.println("So eh permitido transferencia entre contas do mesmo tipo");
								else {
									if (cliente1.getConta().remover(valorTransferenciaCorrente))
										cliente2.getConta().adicionar(valorTransferenciaCorrente);
									else
										System.out.println("A conta de saida não tem saldo suficiente!");
								}
							}
							break;
						case 2:
							// transferir dinheiro entre duas contas poupanca
							System.out.print("Numero da conta de saida de dinheiro: ");
							Long cp1 = scan.nextLong();
							System.out.print("Numero da conta de entrada de dinheiro: ");
							Long cp2 = scan.nextLong();
							System.out.print("Valor da transferencia: ");
							Double valorTransferenciaPoupanca = scan.nextDouble();

							if (cp1 == cp2)
								System.out.println("Voce nao pode transferir dinheiro para sua própria conta.");
							else {
								Cliente cliente1 = Cliente.buscaCliente(cp1, Clientes);
								Cliente cliente2 = Cliente.buscaCliente(cp2, Clientes);

								if (cliente1 == null || cliente2 == null) {
									System.out.println("Nao foi possivel encontrar um dos clientes");
									break;
								}

								if (cliente1.getConta().getClass() != cliente2.getConta().getClass())
									System.out.println("So eh permitido transferencia entre contas do mesmo tipo");
								else {
									if (cliente1.getConta().remover(valorTransferenciaPoupanca))
										cliente2.getConta().adicionar(valorTransferenciaPoupanca);
									else
										System.out.println("A conta de saida não tem saldo suficiente!");
								}
							}
							break;
						case 3:
							System.out.println("Contas Correntes: ");
							// listar contas correntes
							for (int i = 0; i < Clientes.size(); i++) {
								if (Clientes.get(i).getConta().getClass() == new ContaCorrente(0, 0).getClass())
									System.out.println(
											"Nome: " + Clientes.get(i).getNome() + " - CPF: " + Clientes.get(i).getCpf()
													+ " - Conta: " + Clientes.get(i).getConta().getConta()
													+ " - Caixa: "
													+ Clientes.get(i).getConta().getCaixa());
							}
							break;
						case 4:
							// listar contas poupanças
							for (int i = 0; i < Clientes.size(); i++) {
								if (Clientes.get(i).getConta().getClass() == new ContaPoupanca(0, 0).getClass())
									System.out.println(
											"Nome: " + Clientes.get(i).getNome() + " - CPF: " + Clientes.get(i).getCpf()
													+ " - Conta: " + Clientes.get(i).getConta().getConta()
													+ " - Caixa: "
													+ Clientes.get(i).getConta().getCaixa());
							}
							break;
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
