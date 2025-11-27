import utils.ScannerUtils;

public class Main {

    public static void main(String[] args) {

       String nombre = ScannerUtils.capturarTexto("Ingrese su nombre");
       int edad = ScannerUtils.capturarNumeroEntero("Ingrese su edad");
       double estatura = ScannerUtils.capturarNumeroDecimal("Ingrese su altura en (m)");

        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Estatura: " + estatura);



    }
}