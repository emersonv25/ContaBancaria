/*
 *  Autor: Emerson de Jesus Santos
 *  Mat: 16017157
 *  Formando em Analise e desenvolvimento de sistemas
 *  Centro Universitário Maurício de Nassau
 *  
 */

package contacorrente.model;

public class ContaCorrente 
{

	int numConta;
	String nomeCliente;
	double saldo;
	double cEspecial;
	//double cDevedor;

	//Construtor default
	public ContaCorrente(int numConta, String nomeCliente)
	{
		this.numConta = numConta;
		this.nomeCliente = nomeCliente;
		this.saldo = 0;
		this.cEspecial = 100; 
		//this.cDevedor = 0;
		
	}
	
	// SOBRECARGAS
	
	// já que o enuciado pede um construtor somente com o número da conta... 
	public ContaCorrente(int numConta)
	{
		this.numConta = numConta;
		this.nomeCliente = "";
		this.saldo = 0;
		this.cEspecial = 100; 
	}
	
	public ContaCorrente(int numConta, String nomeCliente, double saldo)
	{
		this.numConta = numConta;
		this.nomeCliente = nomeCliente;
		this.saldo = saldo;
		this.cEspecial = 100;
		
	}
	public boolean saque(double valor)		
	{

		if (valor > 0 && valor <= saldo + cEspecial)
		{
			
			if (this.saldo >= -cEspecial)
			{
				this.saldo -= valor;
			}
			
			if (this.saldo < 0)
			{	
				System.out.println("Será cobrado o valor de R$" + saldo + " no proximo deposito");
				return true;
			}
			return true;
			
		}
		else
		{
			System.out.println("OPS: Não foi possível efetuar o saque, saldo insuficiente ou valor negativo !");
			return false;
		}
		
		
	}
	
	public boolean deposito (double valor)
	{
		if (valor > 0)
		{
			this.saldo += valor;
			return true;
		}
		else
		{
			return false;
		}
	}
		
	
	// GETTERS
	public double getSaldo()
	{
		return this.saldo;
	}
	
	public int getNumConta()
	{
		return this.numConta;
	}
	
	public String getNome()
	{
		return this.nomeCliente;
	}
	public Double getCreditoEspecial()
	{
		return this.cEspecial;
	}

	
	
	public void extrato()
	{
		System.out.println("Num Conta  Nome do Cliente                               Saldo              Crédito Especial");
		System.out.println("---------  ------------------------------            ----------------     --------------------");
		//System.out.println("xxxx     xxxxxxxxxxxxxxxxxxxxx              xxxx,xx ");
		System.out.printf("%5d  \t    %-40s \t %.2f  \t            %.2f  \n\n", getNumConta(), getNome(), getSaldo(), getCreditoEspecial());
	}
	
	
}
