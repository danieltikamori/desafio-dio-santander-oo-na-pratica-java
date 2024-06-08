package cofre;

import java.util.Scanner;

abstract class Cofre {
  protected String tipo;
  protected String metodoAbertura;

  protected Cofre(String tipo, String metodoAbertura) {
    this.tipo = tipo;
    this.metodoAbertura = metodoAbertura;
  }

  public void imprimirInformacoes() {
    System.out.println("Tipo: " + this.tipo);
    System.out.println("Metodo de abertura: " + this.metodoAbertura);
  }
}

class CofreDigital extends Cofre {

  private int senha;

  public CofreDigital(int senha) {
    super("Cofre Digital", "Senha");
    this.senha = senha;
  }

  public boolean validarSenha(int confirmacaoSenha) {
    return confirmacaoSenha == this.senha;
  }
}

class CofreFisico extends Cofre {

  public CofreFisico() {
    super("Cofre Fisico", "Chave");
  }

}

public class DesafioCofre {
  public static void main(String[] args) {
    // Lê o tipo de cofre (primeira linha da entrada)
    Scanner scanner = new Scanner(System.in);
    String tipoCofre = scanner.nextLine();
    
    // Implementação das condições necessárias para a verificação dos cofres seguros:
    if (tipoCofre.equalsIgnoreCase("digital")) {
//      System.out.println("Digite a senha do cofre digital:");
      int senha = scanner.nextInt();
      scanner.nextLine(); // Consumir o \n do buffer
//      System.out.println("Confirme a senha do cofre digital:");
      int confirmacaoSenha = scanner.nextInt();
      scanner.nextLine(); // Consumir o \n do buffer

      CofreDigital cofreDigital = new CofreDigital(senha);
      if (cofreDigital.validarSenha(confirmacaoSenha)) {
        cofreDigital.imprimirInformacoes();
        System.out.println("Cofre aberto!");
      } else {
        cofreDigital.imprimirInformacoes();
        System.out.println("Senha incorreta!");
      }
    } else if (tipoCofre.equalsIgnoreCase("fisico")) {
      CofreFisico cofreFisico = new CofreFisico();
      cofreFisico.imprimirInformacoes();
    }
  }
}