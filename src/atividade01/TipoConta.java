package atividade01;

public enum TipoConta {
    CORRENTE,
    POUPANCA,
    SALARIO;
    public String toString() {
        switch(this) {
            case CORRENTE: return "Conta Corrente";
            case POUPANCA: return "Conta Poupança";
            case SALARIO: return "Conta Salário";
            default: return "undefined";
        }
    }
}
