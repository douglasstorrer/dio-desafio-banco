package banco.contas;

import banco.Cliente;

public class ContaPoupanca extends Conta{
  
  public ContaPoupanca(Cliente cliente) {
    super(cliente);
  }
  
  @Override
  public void imprimirExtrato() {
    super.imprimirExtrato("Poupança");
  }
  
}
