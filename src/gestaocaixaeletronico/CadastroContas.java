package gestaocaixaeletronico;
import gestaocontas.Conta;
import java.util.ArrayList;

public class CadastroContas {

    private ArrayList<Conta> contas;

    private int numeroDeContas;

    public CadastroContas() {
        this.contas = new ArrayList<>();
    }

    public int numeroDeContasArmazenadas() {
        return this.contas.size();
    }

    public boolean adicionaConta(Conta c) {
        if(this.buscaConta(c.getNumero())!= null) {
            this.contas.add(c);
            return true;
        }
        return false;
    }

    public boolean removeConta(int numero) {
        Conta c = this.buscaConta(numero);
        if(c != null) {
            this.contas.remove(c);
            return true;
        }
        return false;
    }

    public Conta buscaConta(int numero) {
        for (Conta c : this.contas) {
            if (numero == c.getNumero()) {
                return c;
            }
        }
        return null;
    }





}