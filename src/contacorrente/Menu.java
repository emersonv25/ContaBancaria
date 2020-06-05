/*
 *  Autor: Emerson de Jesus Santos
 *  Mat: 16017157
 *  Formando em Analise e desenvolvimento de sistemas
 *  Centro Universitário Maurício de Nassau
 *  
 */

package contacorrente;

import java.util.ArrayList;
//import java.util.Scanner;

import contacorrente.model.ContaCorrente;
import contacorrente.util.Keyboard;

public class Menu {
	//private static Scanner input; // inicializia o teclado
	private static int indice; // cria uma variavel para armazenar o indice retornado na função existe()
	private static int numConta1;
	private static int numConta2;

	
/**	public static void printMenu()
	{
		println("");
		println("------- MENU ------- \n"
				+ "Escolha uma Opção\n"
				+ "1 => Cadastrar Contas\n"
				+ "2 => Listar Contas \n"
				+ "3 => Excluir Contas \n"
				+ "4 => Efetuar Depósitos \n"
				+ "5 => Efetuar Saques \n"
				+ "6 => Consultar Conta \n"
				+ "7 => Terminar \n");
	}
**/	
	// CADASTRA UMA CONTA NO ARRAY
	public void cadastrar(ArrayList <ContaCorrente> contas)
	{
		String nome = Keyboard.readString("Digite o nome do cliente: ");
		
		int num = Keyboard.readInt("Digite o número da conta: ");
		
		if (num > 999 && num < 9999)
		{
			if (existe(contas, num) == false)
			{
				contas.add(new ContaCorrente(num, nome));
				println("Conta cadastrada com sucesso ! ");
			}
			
			else 
			{
				println("Número de conta já existente.");
			}
		}
		else
		{
			println("Número da conta precisa ter 4 digitos!");
		}
	}
	
	// LISTA TODAS AS CONTAS DO ARRAY
	public  void listar(ArrayList <ContaCorrente> contas)
	{
		println("Num Conta  Nome do Cliente                               Saldo");
		println("---------  ------------------------------               -------------- ");
		//println("xxxx     xxxxxxxxxxxxxxxxxxxxx              xxxx,xx ");
		for(int i=0; i < contas.size(); i++ )
		{
			System.out.printf("%5d  \t   %-40s \t %.2f  \n", contas.get(i).getNumConta(), contas.get(i).getNome(), contas.get(i).getSaldo());
		}
	}
	
	// Excluir uma conta
	public void excluir(ArrayList <ContaCorrente> contas)
	{
		int num = Keyboard.readInt("Digite o número da conta: ");
		
		if (existe(contas, num) == true)
		{
			contas.remove(indice);
			println("Conta excluida com sucesso! ");
		}
		else
		{
			println("Conta inexistente !");
		}
	}
	
	// DEPOSITOS
	public void depositos(ArrayList <ContaCorrente> contas)
	{
		int num = Keyboard.readInt("Digite o número da conta: ");
		
		if (existe(contas, num) == true)
		{
			contas.get(indice).extrato();
			double valor = Keyboard.readDouble("Digite o valor do Deposito: R$ ");
			
			if (valor > 0)
			{
				if (contas.get(indice).deposito(valor))
				{
					System.out.printf("Deposito de: R$%.2f Efetuado com sucesso !\n", valor);
					println("Novo Saldo: R$" + contas.get(indice).getSaldo());
				}
				else
				{
					println("OPS: Algo deu errado, Deposito não realizado! ");
				}

			}
			else
			{
				println("Valor Negativo !");
			}
			
		}	
		else
		{
			println("Conta inexistente !");
		}
	}
	
	// SAQUE
	public void saques(ArrayList <ContaCorrente> contas)
	{
		int num = Keyboard.readInt("Digite o número da conta: ");
		

		if (existe(contas, num) == true)
		{
			//println("Saldo disponível na conta: R$" + contas.get(indice).getSaldo());
			contas.get(indice).extrato();
			

			
			Double valor = Keyboard.readDouble("Digite o valor do Saque: R$ ");
			if (valor > 0)
			{
				if (contas.get(indice).saque(valor) == true)
				{	
					//contas.get(indice).saque(valor);
					println("Novo Saldo: R$" + contas.get(indice).getSaldo());
					System.out.printf("Saque de: R$%.2f Efetuado com sucesso !\n", valor);
					
				}	
			}
			else
			{
				println("Valor Negativo !");
			}
			
		}
		else
		{
			println("Conta não encontrada !");
		}
		
	}
	
	// TRANSFERÊNCIA ENTRE CONTAS
	public void transferir(ArrayList <ContaCorrente> contas)
	{
		//GAMBIARRA PARA PEDI NOVAMENTE O NUMERO DA CONTA CASO NÃO EXISTA, POIS LI ESSA EXIGENCIA NA ATIVIDADE QUANDO O PROGRAMA JÁ ESTAVA PRONTO
		boolean repetir = true;
		int indice1;
		int indice2;
		
		while (repetir)
		{
			numConta1 = Keyboard.readInt("Número da conta do remetente: ");
			numConta2 = Keyboard.readInt("Digite o número da conta do destinatario: ");	
			
			
			if (existe(contas, numConta1) == true && existe(contas, numConta2) == true && numConta1 != numConta2)
			{
				repetir = false;
			}
			else{println("OPS: Umas das contas não foi encontrada, tente novamente!");}
			
		}
		existe(contas, numConta1);
		indice1 = indice;
		existe(contas, numConta2);
		indice2 = indice;
		
		Double valor = Keyboard.readDouble("Digite o valor da Transferência: R$ ");
		if (valor > 0)
		{
			if (contas.get(indice1).saque(valor) && contas.get(indice2).deposito(valor))
			{
				System.out.printf("Transferencia de: R$%.2f Efetuado com sucesso !\n", valor);
			}
			else
			{
				println("Ops: Algo deu errado, transferencia não realizada! ");
			}
			
			
		}
		else {println("Valor Negativo !");}	
		
	}
	
	// consulta e imprime o extrato de uma conta
	public void consultar(ArrayList <ContaCorrente> contas)
	{
		int num = Keyboard.readInt("Digite o número da conta: ");
		
		if (existe(contas, num) == true)
		{
			contas.get(indice).extrato();
		}
		else
		{
			println("Conta inexistente !");
		}
	}
	
	// verifica se a conta existe e retorna true ou false e armazena o indice numa variavel global
	
	// ESTUDAR FOREACH E O METODO CONTAIN
	public static boolean existe(ArrayList <ContaCorrente> contas, int num)
	{
		boolean consulta = false;
		for (int i = 0; i < contas.size(); i++)
		{
			if (contas.get(i).getNumConta() == num)
			{	
				consulta = true;
				indice = i;
			}
		}
		return consulta;
	}
	
	
	static void println(Object text)
	{
		System.out.println(text);
	}
	static void print(Object text)
	{
		System.out.print(text);
	}
	

}
