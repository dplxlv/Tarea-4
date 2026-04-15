public class Paciente {
    public String nombre;
    public String id;
    public String tipoSeguro;

    private int edad;
    private double costoConsulta;
    private int numeroConsultas;
    private int prioridad;

    // Constructor
    public Paciente(String nombre, String id, String tipoSeguro, int edad, double costoConsulta, int numeroConsultas, int prioridad) {
        this.nombre = nombre;
        this.id = id;
        this.tipoSeguro = tipoSeguro;
        setEdad(edad);
        setCostoConsulta(costoConsulta);
        setNumeroConsultas(numeroConsultas);
        setPrioridad(prioridad);
    }

    // Validaciones
    public void setEdad(int edad) {
        if (edad > 0) this.edad = edad;
    }

    public void setCostoConsulta(double costoConsulta) {
        if (costoConsulta > 0) this.costoConsulta = costoConsulta;
    }

    public void setNumeroConsultas(int numeroConsultas) {
        if (numeroConsultas >= 0) this.numeroConsultas = numeroConsultas;
    }

    public void setPrioridad(int prioridad) {
        if (prioridad >= 1 && prioridad <= 5) this.prioridad = prioridad;
    }

    // Cálculos
    public double calcularTotal() {
        return costoConsulta * numeroConsultas;
    }

    public double calcularDescuento() {
        double total = calcularTotal();

        switch (tipoSeguro) {
            case "Basico": return total * 0.10;
            case "Premium": return total * 0.20;
            default: return 0;
        }
    }

    public double costoFinal() {
        return calcularTotal() - calcularDescuento();
    }

    public String clasificacion() {
        if (prioridad >= 4) return "Alta prioridad";
        else if (prioridad >= 2) return "Prioridad media";
        else return "Prioridad baja";
    }

    public String mensaje() {
        switch (clasificacion()) {
            case "Alta prioridad":
                return "Atención inmediata requerida";
            case "Prioridad media":
                return "Seguimiento necesario";
            default:
                return "Control regular";
        }
    }

    public void mostrarReporte() {
        System.out.println("Nombre: " + nombre);
        System.out.println("ID: " + id);
        System.out.println("Seguro: " + tipoSeguro);
        System.out.println("Costo total: " + calcularTotal());
        System.out.println("Descuento: " + calcularDescuento());
        System.out.println("Costo final: " + costoFinal());
        System.out.println("Clasificación: " + clasificacion());
        System.out.println("Mensaje: " + mensaje());
    }
}