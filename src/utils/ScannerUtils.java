package utils;

import java.util.Scanner;

public class ScannerUtils {

    public static final Scanner INPUT = new Scanner(System.in);

    public static boolean  SoloTexto (String texto){
        return texto !=null && !texto.isEmpty() && texto.matches("[a-zA-Z ]+");
    }

    public static boolean  validarCedula (String cedula){
        return cedula !=null && !cedula.isEmpty() && cedula.matches("^[0-9]{10}$");
    }



    public static String capturarTexto(String mensaje) {
        while (true) {
            System.out.print(mensaje + ": ");
            String textoCapturado = INPUT.nextLine();
            if (!SoloTexto(textoCapturado)) {
                System.out.println("Error: solo se permiten letras y no puede estar vacío");
            } else {
                return textoCapturado;
            }
        }
    }

    public static String capturarCedula(String mensaje) {
        while (true) {
            System.out.print(mensaje + ": ");
            String textoCapturado = INPUT.nextLine();
            if (!validarCedula(textoCapturado)) {
                System.out.println("Error: cedula inválida (debe tener 10 dígitos)");
            } else {
                return textoCapturado;
            }
        }
    }


    public static int capturarNumeroEntero(String texto) {
        while(true) {
            try {
                System.out.print(texto + ": ");
                return Integer.parseInt(INPUT.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: solo puede ingresar enteros");
            }
        }
    }

    public static double capturarNumeroDecimal(String texto) {
        while(true) {
            try {
                System.out.print(texto + ": ");
                return Double.parseDouble(INPUT.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: solo puede ingresar decimales");
            }
        }
    }



}