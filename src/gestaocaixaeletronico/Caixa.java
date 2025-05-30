package gestaocaixaeletronico;

import gestaocontas.Conta;

public class Caixa {

    private final Terminal  meuTerminal;
    private final CadastroContas bdContas;
    private double saldo;

    public Caixa(Terminal terminal, CadastroContas bdContas) {
        this.meuTerminal = terminal;
        this.bdContas = bdContas;
    }

    public double verificaSaldo(int numero, int senha) {

        Conta conta = this.bdContas.buscaConta(numero);
        if(conta != null) {
            return conta.verificaSaldo(senha);
        }

        return -1;
    }

    public boolean efetuaSaque(int numero, double valor, int senha) {

        if(valor < 0 || (valor%50) != 0 || valor > 500 || valor > this.saldo) {
            return false;
        }

        Conta conta = this.bdContas.buscaConta(numero);
        if(conta == null || !conta.debitaValor(valor, senha, "Saque")) {
            return false;
        }
        this.saldo -= valor;
        this.liberaCedulas((int)(valor/50));
        if(this.saldo < 500) {
            this.meuTerminal.setModo(0);
        }
        return true;

    }

    public void recarrega() {
        this.saldo = 2000;
        this.meuTerminal.setModo(1);
    }

    public boolean depositoDinheiro(int numero, double valor, int senha){
        Conta conta = this.bdContas.buscaConta(numero);
        if(conta != null && conta.verificaSaldo(senha) != -1){
            return conta.creditaValor(valor, "Deposito em dinheiro");
        }
        return false;
    }

    public boolean depositoCheque(int numero, double valor, int senha){
        Conta conta = this.bdContas.buscaConta(numero);
        if(conta != null && conta.verificaSaldo(senha) != -1){
            return conta.creditaValor(valor, "Deposito em cheque");
        }
        return false;
    }


    public boolean transferencia(int numeroOrigem, int numeroDestino, double valor, int senha) {
        Conta origem = this.bdContas.buscaConta(numeroOrigem);
        Conta destino = this.bdContas.buscaConta(numeroDestino);
        if (origem != null && destino != null) {
            if (origem.debitaValor(valor, senha, "Transferência para Conta " + numeroDestino)) {
                destino.creditaValor(valor, "Transferência Recebida de Conta " + numeroOrigem);
                return true;
            }
        }
        return false;
    }

    public String consultarExtrato(int numero, int senha) {
        Conta conta = this.bdContas.buscaConta(numero);
        if (conta != null) {
            return conta.verificaHistoricoDeLancamentos(senha);
        }
        return null;
    }

    private void liberaCedulas(int quantidade) {
        while(quantidade-- > 0) {
            System.out.println("===/ R$ 50,00 /===");
        }
    }

}
