package classes;
import java.util.ArrayList;
import java.util.Scanner;

public class ControleDeCompras {
    public void menu() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o limite do cartão: \n");
        double limite = scanner.nextDouble();

        ArrayList<Compra> compras = new ArrayList<>();

        while (limite > 0) {
            System.out.print("\n***************************** \n\nDigite a descrição da compra: \n(ou 'fim' para encerrar): \n");
            String descricao = scanner.next();

            if (descricao.equalsIgnoreCase("fim")) {
                break;
            }

            System.out.print("***************************** \n\nDigite o valor da compra: \n");
            double valor = scanner.nextDouble();

            if (valor > limite) {
                System.out.println("***************************** \n\nCompra não permitida. Limite excedido.");
            } else {
                compras.add(new Compra(descricao, valor));
                limite -= valor;
            }
        }

        scanner.close();

        System.out.println("***************************** \n\nCompras realizadas (ordenadas do maior valor para o menor):\n");
        compras.sort((c1, c2) -> Double.compare(c2.getValor(), c1.getValor()));

        for (Compra compra : compras) {
            System.out.println(compra.getDescricao() + " - R$ " + compra.getValor());
        }
    }
}