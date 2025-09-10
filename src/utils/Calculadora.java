package utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Calculadora {
    
    public static int subtrair(int a, int b){
        return a - b;
    }

    public static int somar(int a, int b){
        return a + b;
    }

    public static int resto(int numerador, int denominador){
        return numerador % denominador;
    }

    public static int quociente(int numerador, int denominador){
        return numerador / denominador;
    }

    public static int maximoDivisorComum(int numero1, int numero2){
        while ((numero1 % numero2) > 0){
            int resto = numero1 % numero2;
            numero1 = numero2;
            numero2 = resto;
        }
        return numero2;
    }

    public static List<Integer> fatorar(int numero){
        List<Integer> listaFatorados = new ArrayList<Integer>();
        for (int i = 2; i <= Math.sqrt(numero); i++){
            while(numero % i == 0){
                listaFatorados.add(i);
                numero = numero / i;
                System.out.println("divisao: "+numero);
            }
        }
        
        if (numero > 1) {
            listaFatorados.add(numero);
        }

        System.out.println("lista Fatorados:"+listaFatorados);
        
        return listaFatorados;
    }

    public static Map<Integer, Integer> contarExpoentes(List<Integer> listaIntegers){
        Map<Integer, Integer> listaExpoentes = new HashMap<>();
        Set<Integer> setExponentes = new LinkedHashSet<>(listaIntegers);
        setExponentes.stream().forEach((elemento) -> {
            int count = (int) listaIntegers.stream().filter((elemento2) -> {
                return elemento.equals(elemento2);
            }).count();
            listaExpoentes.put(elemento, count);
        });
        System.out.println("lista numeros e expoentes: " + listaExpoentes);
        return listaExpoentes;
    }

    public static int phi(int entrada, Map<Integer, Integer> expoenteMap){
        int produto = expoenteMap.
        entrySet().
        stream().
        mapToInt(e -> (int) (Math.pow(e.getKey(), e.getValue()) - Math.pow(e.getKey(), e.getValue() - 1)))
        .reduce(1, (a, b) -> a * b);
        return produto;
    }

    public static int phi(int entrada){
        Map<Integer, Integer> expoenteMap = contarExpoentes(fatorar(entrada));
        int produto = expoenteMap.
        entrySet().
        stream().
        mapToInt(e -> (int) (Math.pow(e.getKey(), e.getValue()) - Math.pow(e.getKey(), e.getValue() - 1)))
        .reduce(1, (a, b) -> a * b);
        return produto;
    }

    /**
     * 
     * @param a
     * @param m
     * @param n
     * <p>a^m mod n</p>
     * @return
     */
    public static long modExp(long a, long m, long n) {
        long resultado = 1;
        a = a % n;

        while (m > 0) {
            if (m % 2 == 1) {
                resultado = (resultado * a) % n;
            }
            m = m / 2;
            a = (a * a) % n;
        }

        return resultado;
    }

    public static int multiplicar(int a, int b){
        return a * b;
    }
}
