package atividade03;

public class TesteTarefa {

    public static void main(String[] args){

        Tarefa tarefa1 = new Tarefa("Estudar para a prova de Carla", NivelPrioridade.MEDIA);
        Tarefa tarefa2 = new Tarefa("Fazer Laboratorio de POO", NivelPrioridade.BAIXA);
        Tarefa tarefa3 = new Tarefa("Estudar para a segunda prova de MTM Discreta", NivelPrioridade.ALTA);
        Tarefa tarefa4 = new Tarefa("Iniciar estudo de caso para segunda nota", NivelPrioridade.URGENTE);

        System.out.println(tarefa1);
        System.out.println(tarefa2);
        System.out.println(tarefa3);
        System.out.println(tarefa4);

    }

}
