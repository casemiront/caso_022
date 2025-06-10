package atividade4;
import java.util.ArrayList;

public class CarrinhoDeCompras {
    private static ArrayList<Produto> produtos = new ArrayList<>();

    public static void adicionarProduto(Produto p) {
        produtos.add(p);
    }
    public static void listarProdutos() {
        for (Produto p : produtos) {
            System.out.println(p);
        }
    }
    public static double calcularTotal() {
        double total = 0;
        for (Produto p : produtos) {
            total += p.getPreco();
        }
        return total;
    }
}

