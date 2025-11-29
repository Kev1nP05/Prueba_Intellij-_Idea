public class Persona {

    private String nombre;
    private String apellido;
    private int edad;
    private String cedula;

    public Persona() {}

    public Persona(String nombre, String apellido, int edad, String cedula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.cedula = cedula;

    }


    public String informacionPersona() {

        StringBuilder informacion = new StringBuilder();

        informacion.append("\nPersona\n" )
                .append("Nombre: " + this.nombre + "\n")
                .append("Apellido: " + this.apellido + "\n")
                .append("Edad: " + this.edad + "\n")
                .append("Cedula: " + this.cedula);

        return informacion.toString();
    }

    // Para guardar en archivo
    public String toFileFormat() {
        return this.nombre + ";" + this.apellido + ";" + this.edad + ";" + this.cedula;
    }

    // Para cargar desde archivo
    public static Persona fromFileFormat(String line) {
        String[] datos = line.split(";");
        return new Persona(
                datos[0],
                datos[1],
                Integer.parseInt(datos[2]),
                datos[3]
        );
    }

    // Getters y setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }

    public String getCedula() { return cedula; }
    public void setCedula(String cedula) { this.cedula = cedula; }
}
