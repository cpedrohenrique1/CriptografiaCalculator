import utils.Calculadora;

public class App {
    public static void main(String[] args) {
        int numerador, denominador;
        numerador = 888888888;
        denominador = 26;
        // System.out.println("Quociente: " + Calculadora.quociente(numerador,denominador));
        // System.out.println("Resto: " + Calculadora.resto(numerador,denominador));
        System.out.println("Fatoração: " + Calculadora.fatorar(numerador));
        System.out.println("Expoentes: " + Calculadora.contarExpoentes(Calculadora.fatorar(numerador)));
    }
}
