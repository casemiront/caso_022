package atividade03;

public class Tarefa {

    private String descricao;
    private NivelPrioridade prioridade;
    public Tarefa(String descricao, NivelPrioridade prioridade) {
        this.descricao = descricao;
        this.prioridade = prioridade;
    }
    @Override
    public String toString() {
        return "Tarefa: " + descricao + " [Prioridade: " + prioridade + "]";
    }
}
