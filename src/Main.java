import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String nomeCliente = "Irmão do Jorel";
        double saldoDaConta = 2500.00;
        String tipoDeConta = "Corrente";

        System.out.println("""
                ***************************
                BEM-VINDO AO BANCO
                ***************************
                """);

        System.out.println(String.format("""
                        ***********************
                        Dados iniciais do cliente:
                        Nome: %s
                        Tipo de conta: %s
                        Saldo inicial: R$ %.2f
                        ***********************
                """, nomeCliente, tipoDeConta, saldoDaConta));

        int opcaoDeServico = 0;

        double valorTransferido = 0;
        double valorRecebido = 0;

        Scanner escolhaServico = new Scanner(System.in);
        Scanner transferido = new Scanner(System.in);
        Scanner recebido = new Scanner(System.in);

        while (opcaoDeServico != 4) {
            System.out.println("""
                    OPERAÇÕES DISPONÍVEIS
                        
                    1 - CONSULTAR SALDO
                    2 - DEPOSITAR VALOR
                    3 - TRANSFERIR VALOR
                    4 - SAIR
                        
                    ESCOLHA UMA OPÇÃO:
                """);

            opcaoDeServico = escolhaServico.nextInt();

            if (opcaoDeServico == 1) {
                System.out.println(String.format("SEU SALDO ATUAL: R$ %.2f", saldoDaConta));

            } else if (opcaoDeServico == 2) {
                System.out.println("INFORME O VALOR A SER DEPOSITADO:");
                valorRecebido = recebido.nextDouble();

                if (valorRecebido > 0) {
                    saldoDaConta += valorRecebido;
                    System.out.println("DEPÓSITO REALIZADO COM SUCESSO");
                    System.out.println(String.format("SALDO ATUAL: R$ %.2f", saldoDaConta));
                } else {
                    System.out.println("ERRO: O VALOR DO DEPÓSITO DEVE SER MAIOR QUE ZERO.");
                }
            } else if (opcaoDeServico == 3) {
                System.out.println("INFORME O VALOR A SER TRANSFERIDO:");
                valorTransferido = transferido.nextDouble();

                if (valorTransferido > 0 && valorTransferido <= saldoDaConta) {
                    saldoDaConta -= valorTransferido;
                    System.out.println("TRANSFERÊNCIA REALIZADA COM SUCESSO");
                    System.out.println(String.format("SALDO ATUAL: R$ %.2f", saldoDaConta));
                } else if (valorTransferido > saldoDaConta) {
                    System.out.println("ERRO: SALDO INSUFICIENTE.");
                } else {
                    System.out.println("ERRO: O VALOR DA TRANSFERÊNCIA DEVE SER MAIOR QUE ZERO.");
                }

            } else if (opcaoDeServico == 4) {
                System.out.println("SESSÃO ENCERRADA. ATÉ LOGO!");
                break;

            } else {
                System.out.println("OPÇÃO INVÁLIDA. POR FAVOR, ESCOLHA UMA OPÇÃO ENTRE 1, 2, 3 E 4.");
            }

        }
    }
}
