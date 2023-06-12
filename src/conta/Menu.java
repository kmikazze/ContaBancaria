package conta;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.util.Colors;
import conta.controller.ContaController;
public class Menu {

	public static void main(String[] args) {
		ContaController contas = new ContaController();
		
		Scanner leia = new Scanner(System.in);

		int opcao,numero,agencia,tipo,aniversario,numeroDestino;
		String titular;
		float saldo,limite,valor;
		
		System.out.println("\nCriar contas\n");
		ContaCorrente cc1 = new ContaCorrente(contas.gerarNumero(),123,1,"João da Silva",1000f,100.0f);
		contas.cadastrar(cc1);
		ContaCorrente cc2 = new ContaCorrente(contas.gerarNumero(),124,1,"Maria da Silva",2000f,100.0f);
		contas.cadastrar(cc1);
		ContaPoupanca cp1 = new ContaPoupanca(contas.gerarNumero(),125,2,"Mariana dos Santos",4000f,12);
		contas.cadastrar(cp1);
		ContaPoupanca cp2 = new ContaPoupanca(contas.gerarNumero(),125,2,"Juliana Ramos",8000f,15);
		contas.cadastrar(cp2);
		
		contas.listarTodas();

		while (true) {
			
			System.out.println(Colors.TEXT_YELLOW_BOLD);
			System.out.println("\t  ======================================== ");
			System.out.println("\t |                                        |");
			System.out.println("\t |            BANCO KMIKAZZE              |");
			System.out.println("\t |                                        |");
			System.out.println("\t |========================================|");
			System.out.println("\t |                                        |");
			System.out.println("\t |   1 - Criar Conta                      |");
			System.out.println("\t |   2 - Listar todas as Contas           |");
			System.out.println("\t |   3 - Buscar Conta por Numero          |");
			System.out.println("\t |   4 - Atualizar Dados da Conta         |");
			System.out.println("\t |   5 - Apagar Conta                     |");
			System.out.println("\t |   6 - Sacar                            |");
			System.out.println("\t |   7 - Depositar                        |");
			System.out.println("\t |   8 - Transferir valores entre Contas  |");
			System.out.println("\t |   9 - Sair                             |");
			System.out.println("\t |                                        |");
			System.out.println("\t  ======================================== ");
			
			System.out.print(Colors.TEXT_YELLOW_BOLD+"\nEntre com a opção desejada: ");
			
			try {
				opcao = leia.nextInt();
			}catch (InputMismatchException e) {
				System.out.println(Colors.TEXT_RED_BOLD_BRIGHT+"\nDigite valores inteiros!");
				leia.nextLine();
				opcao = 0;
			}

			if (opcao == 9) {
				System.out.println("\nAgradecemos seu contato, até mais! :D");
				leia.close();
				System.exit(0);
			}

			switch (opcao) {
				
				case 1:
					System.out.println(Colors.TEXT_YELLOW_BOLD_BRIGHT+"Criar Conta\n");
					System.out.println("Digite o número da Agência: ");
					agencia=leia.nextInt();
					System.out.println("Digite o nome do titular: ");
					leia.skip("\\R?");
					titular = leia.nextLine();
				
					do {
					System.out.println("Digite o tipo da Conta (1-CC ou 2-CP): ");
					tipo=leia.nextInt();
					}while(tipo<1 && tipo >2);
			
					System.out.println("Digite o saldo da conta (R$): ");
					saldo=leia.nextFloat();
				
					switch(tipo) {
					case 1 ->{
					System.out.println("Digite o limite de crédito (R$): ");
					limite=leia.nextFloat();
					contas.cadastrar(new ContaCorrente(contas.gerarNumero(),agencia,tipo,titular,saldo,limite));
					}
					case 2 ->{
					System.out.println("Digite o dia do aniversário da conta: ");
					aniversario=leia.nextInt();
					contas.cadastrar(new ContaPoupanca(contas.gerarNumero(),agencia,tipo,titular,saldo,aniversario));
					}
					}
				keyPress();
					break;
				
				case 2:
					System.out.println(Colors.TEXT_YELLOW_BOLD_BRIGHT+"Listar todas as Contas\n");
					contas.listarTodas();
				keyPress();
					break;
				
				case 3:
					System.out.println(Colors.TEXT_YELLOW_BOLD_BRIGHT+"Consultar dados da Conta (por número)\n");
					System.out.println("Digite o número da conta: ");
					numero = leia.nextInt();
					contas.procurarPorNumero(numero);
				keyPress();
					break;
				
				case 4:
					System.out.println(Colors.TEXT_YELLOW_BOLD_BRIGHT+"Atualizar dados da Conta\n");
					System.out.println("Digite o número da conta: ");
					numero=leia.nextInt();
					
					if(contas.buscarNaCollection(numero)!=null) {
						System.out.println("Digite o número da Agência: ");
						agencia=leia.nextInt();
						System.out.println("Digite o nome do Titular: ");
						leia.skip("\\R?");
						titular = leia.nextLine();
						System.out.println("Digite o Saldo da Conta (R$): ");
						saldo=leia.nextFloat();
						tipo=contas.retornaTipo(numero);
						
						switch(tipo) {
						case 1 ->{
							System.out.println("Digite o limite de crédito (R$): ");
							limite=leia.nextFloat();
							contas.atualizar(new ContaCorrente(numero,agencia,tipo,titular,saldo,limite));
						}
						case 2 ->{
							System.out.println("Digite o dia do aniversário da conta: ");
							aniversario=leia.nextInt();
							contas.atualizar(new ContaPoupanca(numero,agencia,tipo,titular,saldo,aniversario));
						}
						default ->{
							System.out.println(Colors.TEXT_RED_BOLD_BRIGHT+"Tipo de conta inválido!");
						}
						}
						}else {
							System.out.println(Colors.TEXT_RED_BOLD_BRIGHT+"\nConta não encontrada!");
						}
				keyPress();
					break;
				
				case 5:
					System.out.println(Colors.TEXT_YELLOW_BOLD_BRIGHT+"Apagar a Conta\n");
					System.out.println("Digite o número da conta: ");
					numero=leia.nextInt();
					contas.deletar(numero);
				keyPress();
					break;
				
				case 6:
					System.out.println(Colors.TEXT_YELLOW_BOLD_BRIGHT+"Saque\n");
					System.out.println("Digite o número da Conta: ");
					numero=leia.nextInt();
					
					do {
						System.out.println("Digite o valor do saque (R$): ");
						valor=leia.nextFloat();
					}while(valor<=0);
					contas.sacar(numero, valor);
				keyPress();
					break;
				
				case 7:
					System.out.println(Colors.TEXT_YELLOW_BOLD_BRIGHT+"Depósito\n\n");
					System.out.println("Digite o número da Conta: ");
					numero=leia.nextInt();
					
					do {
						System.out.println("Digite o valor do depósito (R$): ");
						valor=leia.nextFloat();
					}while(valor<=0);
					contas.depositar(numero, valor);
				keyPress();
					break;
				case 8:
					System.out.println(Colors.TEXT_YELLOW_BOLD_BRIGHT+"Transferência entre Contas\n\n");
					System.out.println("Digite o número da Conta de Origem: ");
					numero=leia.nextInt();
					System.out.println("Digite o número da Conta de Destino: ");
					numeroDestino=leia.nextInt();
					do {
						System.out.println("Digite o valor da transferência (R$): ");
						valor=leia.nextFloat();
					}while(valor<=0);
					contas.transferir(numero, numeroDestino, valor);
				keyPress();
					break;
					default:
					System.out.println(Colors.TEXT_RED_BOLD_BRIGHT+"\nOpção Inválida!\n");
				keyPress();
					break;
			}
		}
	}
	public static void keyPress() {
		try {
			System.out.println(Colors.TEXT_YELLOW_BOLD_BRIGHT+"\nPressione"+Colors.TEXT_YELLOW+" Enter "+Colors.TEXT_YELLOW_BOLD_BRIGHT+"para continuar...");
			System.in.read();
			
		}catch(IOException e) {
			System.out.println(Colors.TEXT_RED_BOLD_BRIGHT+"Você pressionou uma tecla diferente de Enter!");
		}
	}

}
