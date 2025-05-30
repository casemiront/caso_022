package gestaocaixaeletronico;

import java.util.Scanner;

public class Terminal {

    private final Caixa meuCaixa;
    private int modoAtual;

    public Terminal(CadastroContas bdContas) {
        this.meuCaixa = new Caixa(this, bdContas);
    }

    public void iniciaOperacao() {

        int opcao;
        opcao = this.getOpcao();

        while (opcao != 7) {
            switch (opcao) {
                case 1:
                    double saldo = this.meuCaixa.verificaSaldo(this.getInt("Número da Conta"), this.getInt("senha"));
                    if (saldo != -1) {
                        System.out.println("Saldo Atual: " + saldo);
                    } else {
                        System.out.println("Conta/ senha inválida");
                    }
                    break;
                case 2:
                    boolean b = this.meuCaixa.efetuaSaque(this.getInt("Número da Conta"), this.getInt("valor"),
                            this.getInt("senha"));
                    if (b) {
                        System.out.println("Saque Realizado");
                    } else {
                        System.out.println("Pedido de Saque Recusado");
                    }
                    break;

                case 3:
                    boolean aprovacaodinheiro = this.meuCaixa.depositoDinheiro(this.getInt("Numero da conta"), this.getInt("valor"), this.getInt("senha"));
                    if(aprovacaodinheiro){
                        System.out.println("Deposito em dinheiro aprovado");
                    }
                    else {
                        System.out.println("Deposito recusado");

                    }
                    break;
                case 4:
                    boolean aprovacaocheque = this.meuCaixa.depositoCheque(this.getInt("NUmero da conta"), this.getInt("valor"), this.getInt("senha"));
                    if(aprovacaocheque){
                        System.out.println("Deposito em cheque aprovado");
                    }
                    else{
                        System.out.print("Deposito recusado");
                    }
                    break;

                case 5:
                    boolean sucessoTransferencia = this.meuCaixa.transferencia(this.getInt("Número da Conta Origem"), this.getInt("Número da Conta Destino"), this.getInt("valor"), this.getInt("senha"));
                    if (sucessoTransferencia) {
                        System.out.println("Transferencia aprovada");
                    } else {
                        System.out.println("Transferencia Recusada");
                    }
                    break;

                case 6:
                    String extrato = this.meuCaixa.consultarExtrato(
                            this.getInt("Número da Conta"),
                            this.getInt("senha"));
                    if (extrato != null) {
                        System.out.println(" Extrato Bancario ");
                        System.out.println(extrato);
                    } else {
                        System.out.println("Conta/senha invalida ou sem movimentacao");
                    }
                    break;

                case 7:
                    this.meuCaixa.recarrega();
                    break;

            }
            opcao = this.getOpcao();
        }

    }

    public void setModo(int modo) {
        if (modo == 0 || modo == 1) {
            this.modoAtual = modo;
        }
    }

    private int getOpcao() {
        int opcao;
        do {
            if (this.modoAtual == 1) {
                opcao = this.getInt("1 - Consulta Saldo, 2 - Saque, 3 - Depósito Dinheiro, 4 - Depósito Cheque, 5 - Transferência, 6 - Extrato, 7 - Sair");
                if (opcao < 1 || opcao > 7) {
                    opcao = 0;
                }

            } else {
                opcao = this.getInt("7 - Recarrega Caixa, 6 - Sair");
                if (opcao != 7 && opcao != 6) {
                    opcao = 0;
                }
            }
        } while (opcao == 0);

        return opcao;
    }

    private int getInt(String string) {

        
        Scanner sc = new Scanner(System.in);

        System.out.println("Entre com " + string);

        if (sc.hasNextInt()) {
            return sc.nextInt();
        }

        @SuppressWarnings("unused")
        String st = sc.next();
        System.out.println("Erro na leitura de dados");
        return 0;

    }

}
