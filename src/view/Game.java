package view;

import model.Calcular;

import java.util.Scanner;

public class Game {

    static Scanner teclado = new Scanner(System.in);
    static int pontos = 0;
    static Calcular calc;

    public static void main(String[] args) {
        Game.jogar();
    }

    public static void jogar() {
        System.out.print("Informe o nível de dificuldade desejado [1, 2, 3, 4]: ");
        int dificuldade = Game.teclado.nextInt();

        Game.calc = new Calcular(dificuldade);

        System.out.println("Informe o resultado para a seguinte operação: ");

        // Soma
        if (calc.getOperacao() == 0) {
            System.out.print(calc.getValor1() + " + " + calc.getValor2() + " = ");
            int resposta = Game.teclado.nextInt();

            if (calc.somar(resposta)) {
                // Ganha 1 ponto
                Game.pontos += 1;
                System.out.println("Você tem " + Game.pontos + " ponto(s)");
            }
        }

        // Subtrair
        else if (calc.getOperacao() == 1) {
            System.out.print(calc.getValor1() + " - " + calc.getValor2() + " = ");
            int resposta = Game.teclado.nextInt();

            if (calc.subtrair(resposta)) {
                // Ganha 1 ponto
                Game.pontos += 1;
                System.out.println("Você tem " + Game.pontos + " ponto(s)");
            }
        }

        // Multiplicar
        else if (calc.getOperacao() == 2) {
            System.out.print(calc.getValor1() + " X " + calc.getValor2() + " = ");
            int resposta = Game.teclado.nextInt();

            if (calc.multiplicar(resposta)) {
                // Ganha 1 ponto
                Game.pontos += 1;
                System.out.println("Você tem " + Game.pontos + " ponto(s)");
            }
        }

        else {
            System.out.println("A operação " + calc.getOperacao() + " Não é reconhecida.");
        }

        System.out.print("Deseja continuar? [1 - Sim, 0 - Não]: ");
        int continuar = Game.teclado.nextInt();
        if (continuar == 1) {
            System.out.println();
            Game.jogar();
        } else {
            if (Game.pontos < 10) {
                System.out.println("\n|----------------------|");
                System.out.println("| Você fez " + Game.pontos + " pontos.   |");
                System.out.println("| Até a proxima!       |");
                System.out.println("|----------------------|");
                System.exit(0);
            } else {
                System.out.println("\n|-----------------------|");
                System.out.println("| Você fez " + Game.pontos + " pontos.   |");
                System.out.println("| Até a proxima!        |");
                System.out.println("|-----------------------|");
                System.exit(0);
            }
        }
    }
}
