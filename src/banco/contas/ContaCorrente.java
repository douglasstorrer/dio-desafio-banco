package banco.contas;

import banco.Cliente;

public class ContaCorrente extends Conta{
  
  public ContaCorrente(Cliente cliente) {
    super(cliente);
  }
  
  @Override
  public void imprimirExtrato() {
    super.imprimirExtrato("Corrente");
  }
  
}

