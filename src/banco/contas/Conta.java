package banco.contas;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import banco.Cliente;
import banco.transacao.Transacao;

public abstract class Conta {
  protected int agencia;
  protected int numero;
  protected double saldo;
  protected Cliente cliente;
  protected List<Transacao> transacoes;
  
  protected static int AGENCIA_PADRAO = 0001;
  protected static int SEQUENCIAL = 0001;

  public Conta(Cliente cliente) {
    this.cliente = cliente;
    this.agencia = AGENCIA_PADRAO;
    this.numero = SEQUENCIAL++;
    this.transacoes = new ArrayList<>();
  }
 
  public void  sacar(double valor, boolean transferencia) {
    saldo -= valor;
    this.transacoes.add(new Transacao(transferencia ? "Saque (Transferência)" : "Saque", valor, new Date()));
  } 
  
  public void  depositar(double valor) {
    saldo += valor;
    this.transacoes.add(new Transacao("Depósito", valor, new Date()));
  }  
  
  public void  transferir(double valor, Conta contaDestino) {
    this.sacar(valor, true);
    contaDestino.depositar(valor);
  }
  
  public void imprimirExtrato() {
    this.imprimirExtrato("");
  }
  
  protected void imprimirExtrato(String tipoConta) {
    System.out.println("====================================");
    System.out.println("*** Extrato Conta " + tipoConta + " ***");
    System.out.println(String.format("Titular: %s", cliente.getNome()));
    System.out.println(String.format("Agência: %d", agencia));
    System.out.println(String.format("Número: %d", numero));
    System.out.println(String.format("Saldo: %.2f", saldo));

    for(Transacao transacao : transacoes) {
      System.out.println("------------------------------------");
      System.out.println("Data: " + transacao.getData());
      System.out.println("Tipo: " + transacao.getTipo());
      System.out.println("Valor: " + transacao.getValor());
    }
    System.out.println("====================================\n");
  }
  
}
