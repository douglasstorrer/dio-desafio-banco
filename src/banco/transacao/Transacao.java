package banco.transacao;

import java.util.Date;

public class Transacao {
  private String tipo;
  private double valor;
  private Date data;
  
  public Transacao(String tipo, double valor, Date data) {
    this.tipo = tipo;
    this.valor = valor;
    this.data = data;
  }
  public String getTipo() {
    return tipo;
  }
  public void setTipo(String tipo) {
    this.tipo = tipo;
  }
  public double getValor() {
    return valor;
  }
  public void setValor(double valor) {
    this.valor = valor;
  }
  public Date getData() {
    return data;
  }
  public void setData(Date data) {
    this.data = data;
  }
}
