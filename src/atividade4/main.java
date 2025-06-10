package atividade4;

public class main {
    public static void main(String[] args){

        Produto produto1 = new Produto("Carro F1", 65.5);
        Produto produto2 = new Produto("Bicicleta azul ", 100.5);
        Produto produto3= new Produto("Mochila azuk", 233);

        CarrinhoDeCompras.adicionarProduto(produto1);
        CarrinhoDeCompras.adicionarProduto(produto2);
        CarrinhoDeCompras.adicionarProduto(produto3);

        CarrinhoDeCompras.listarProdutos();

        double valorTotal = CarrinhoDeCompras.calcularTotal();
        System.out.printf("Valor Total da Compra: R$ %.2f\n", valorTotal);

        System.out.println("\nTeste do carrinho concluído.");









    }
}
