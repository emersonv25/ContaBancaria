/*
 *  Autor: Emerson de Jesus Santos
 *  Mat: 16017157
 *  Formando em Analise e desenvolvimento de sistemas
 *  Centro Universitário Maurício de Nassau
 *  
 */


package contacorrente;

import java.util.ArrayList;

import contacorrente.model.*;
import contacorrente.util.Keyboard;

public class Main {

	String nome;
	int num;
	static ArrayList<ContaCorrente> contas = new ArrayList<>(); // cria um arraylist do objeto contas


	public static void main(String[] args) 
	{

		contas.add(new ContaCorrente(1111, "Emerson", 500));
		contas.add(new ContaCorrente(2222, "Jessica"));

		
		while (true)
		{
			Menu menu = new Menu(); // cria um objeto da classe Menu para usar os metodos não-estaticos
			//Menu.printMenu(); // printa o MENU de opções
		
			int opcao = Keyboard.menu("Cadastrar Contas/Listar Contas/Excluir Contas/Efetuar Depósitos/"
					+ "Efetuar Saques/Consultar Conta/Efetuar transferência entre contas/Sair");
			
			
			
			// switch de opções
			switch(opcao)
			{
				case 1:		
					menu.cadastrar(contas);
					enter();
					break;
				// caso 2, listará o número de contas
				case 2:
					menu.listar(contas);	
					enter();
					break;
				case 3:
					menu.listar(contas);
					menu.excluir(contas);
					enter();
					break;
				case 4:
					menu.depositos(contas);
					enter();
					break;
				case 5:
					menu.saques(contas);
					enter();
					break;
				case 6:
					menu.consultar(contas);
					enter();
					break;
				case 7:
					menu.transferir(contas);
					break;
				case 8:
					sair();
					break;
					
				default:
					print("Opção Inválida!");
					break;
		
				
		
			}
		}		
		
		
	}
	
	// Uma função para organizar o print
	static void print(Object text)
	{
		System.out.println(text);
	}
		
	static void sair () 
	{ 
		System.out.println("Programa Encerrado.");
		System.exit(0);
	}
	
	static void enter()
	{
		Keyboard.waitEnter();
	}

}
