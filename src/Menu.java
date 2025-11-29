import utils.ScannerUtils;
import java.io.*;
import java.util.ArrayList;

public class Menu {

    private final ArrayList<Persona> registroPersonas;
    private final String archivo = "personas.txt";

    public Menu() {
        registroPersonas = new ArrayList<>();
        cargarDesdeArchivo(); // ← carga la lista al iniciar
    }

    public void ejecutarMenu() {

        int opcion;

        do {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1. Registrar persona");
            System.out.println("2. Ver lista de personas");
            System.out.println("3. Buscar persona por cédula");
            System.out.println("4. Editar persona por cédula");
            System.out.println("5. Eliminar persona por cédula");
            System.out.println("6. Guardar registros en archivo");
            System.out.println("7. Salir");

            opcion = ScannerUtils.capturarNumeroEntero("Ingrese opcion");

            switch (opcion) {
                case 1 -> registrarPersona();
                case 2 -> verListaPersonas();
                case 3 -> buscarPersona();
                case 4 -> editarPersona();
                case 5 -> eliminarPersona();
                case 6 -> guardarEnArchivo();
                case 7 -> System.out.println("Gracias por usar el sistema.");
                default -> System.out.println("Opción inválida.");
            }

        } while (opcion != 7);
    }

    // =============================================================
    //                    REGISTRAR PERSONA
    // =============================================================
    private void registrarPersona() {
        System.out.println("\n=== REGISTRO DE PERSONA ===");

        Persona p = new Persona();

        p.setNombre(ScannerUtils.capturarTexto("Ingrese nombre"));
        p.setApellido(ScannerUtils.capturarTexto("Ingrese apellido"));
        p.setEdad(ScannerUtils.capturarNumeroEntero("Ingrese edad"));
        p.setCedula(ScannerUtils.capturarCedula("Ingrese cedula"));

        registroPersonas.add(p);

        System.out.println("Persona registrada.");
    }

    // =============================================================
    //                    VER LISTA
    // =============================================================
    private void verListaPersonas() {
        if (registroPersonas.isEmpty()) {
            System.out.println("\nNo existen personas registradas.");
            return;
        }

        System.out.println("\n=== PERSONAS REGISTRADAS ===");
        for (Persona p : registroPersonas) {
            System.out.println(p.informacionPersona());
        }
    }

    // =============================================================
    //                    BUSCAR PERSONA
    // =============================================================
    private Persona buscarPorCedula(String cedula) {
        for (Persona p : registroPersonas) {
            if (p.getCedula().equals(cedula)) {
                return p;
            }
        }
        return null;
    }

    private void buscarPersona() {
        String ced = ScannerUtils.capturarCedula("Ingrese cédula a buscar");
        Persona encontrada = buscarPorCedula(ced);

        if (encontrada == null) {
            System.out.println("No existe persona con esa cédula.");
        } else {
            System.out.println("Persona encontrada:");
            System.out.println(encontrada.informacionPersona());
        }
    }

    // =============================================================
    //                    EDITAR PERSONA
    // =============================================================
    private void editarPersona() {
        String ced = ScannerUtils.capturarCedula("Ingrese cédula a editar");
        Persona p = buscarPorCedula(ced);

        if (p == null) {
            System.out.println("No existe persona con esa cédula.");
            return;
        }

        System.out.println("Editando persona:");
        System.out.println(p.informacionPersona());

        p.setNombre(ScannerUtils.capturarTexto("Nuevo nombre"));
        p.setApellido(ScannerUtils.capturarTexto("Nuevo apellido"));
        p.setEdad(ScannerUtils.capturarNumeroEntero("Nueva edad"));

        System.out.println("Datos actualizados.");
    }

    // =============================================================
    //                    ELIMINAR PERSONA
    // =============================================================
    private void eliminarPersona() {
        String ced = ScannerUtils.capturarCedula("Ingrese cédula a eliminar");
        Persona p = buscarPorCedula(ced);

        if (p == null) {
            System.out.println("No existe persona con esa cédula.");
            return;
        }

        registroPersonas.remove(p);
        System.out.println("Persona eliminada con éxito.");
    }

    // =============================================================
    //                    ARCHIVOS
    // =============================================================
    private void guardarEnArchivo() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {

            for (Persona p : registroPersonas) {
                bw.write(p.toFileFormat());
                bw.newLine();
            }

            System.out.println("Datos guardados en archivo.");
        } catch (IOException e) {
            System.out.println("Error al guardar archivo.");
        }
    }

    private void cargarDesdeArchivo() {
        File file = new File(archivo);
        if (!file.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                registroPersonas.add(Persona.fromFileFormat(linea));
            }

            System.out.println("Archivo cargado (" + registroPersonas.size() + " personas).");

        } catch (IOException e) {
            System.out.println("Error al cargar archivo.");
        }
    }
}
