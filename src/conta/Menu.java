package conta;

import java.util.Scanner;
import conta.model.Conta;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.util.Colors;

public class Menu {

	public static void main(String[] args) {
		
		Conta c1 = new Conta(1,123,1,"Adriana",1000.0f);
		c1.visualizar();
		c1.sacar(1200.0f);
		c1.visualizar();
		c1.depositar(5000.0f);
		c1.visualizar();
		
		ContaCorrente cc1 = new ContaCorrente(2,123,1,"Mariana",1700.0f,1000.0f);
		cc1.visualizar();
		cc1.sacar(1800.0f);
		cc1.visualizar();
		cc1.depositar(5000.0f);
		cc1.visualizar();
		
		ContaPoupanca cp1 = new ContaPoupanca(3,123,2,"Victor",1100.0f,15);
		cp1.visualizar();
		cp1.sacar(1000.0f);
		cp1.visualizar();
		cp1.depositar(5000.0f);
		cp1.visualizar();
		
		Scanner leia = new Scanner(System.in);

		int opcao;

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
			
			System.out.println(Colors.TEXT_YELLOW_BOLD_BRIGHT);
			System.out.print("\nEntre com a opção desejada: "+Colors.TEXT_RESET);
			opcao = leia.nextInt();

			if (opcao == 9) {
				System.out.println("\nAgradecemos seu contato, até mais! :D");
				leia.close();
				System.exit(0);
			}

			switch (opcao) {
				case 1:
					System.out.println("Criar Conta\n\n");

					break;
				case 2:
					System.out.println("Listar todas as Contas\n\n");

					break;
				case 3:
					System.out.println("Consultar dados da Conta (por número)\n\n");

					break;
				case 4:
					System.out.println("Atualizar dados da Conta\n\n");

					break;
				case 5:
					System.out.println("Apagar a Conta\n\n");

					break;
				case 6:
					System.out.println("Saque\n\n");

					break;
				case 7:
					System.out.println("Depósito\n\n");

					break;
				case 8:
					System.out.println("Transferência entre Contas\n\n");

					break;
				default:
					System.out.println("\nOpção Inválida!\n");
					break;
			}
		}
	}

}
