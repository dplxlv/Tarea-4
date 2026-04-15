public class Vendedor {
    public String nombre;
    public String area;

    private double montoVendido;
    private double porcentajeComision;
    private double cumplimiento;

    public Vendedor(String nombre, String area, double montoVendido, double porcentajeComision, double cumplimiento) {
        this.nombre = nombre;
        this.area = area;
        setMontoVendido(montoVendido);
        setPorcentajeComision(porcentajeComision);
        setCumplimiento(cumplimiento);
    }

    public double getMontoVendido() {
        return montoVendido;
    }

    public void setMontoVendido(double montoVendido) {
        if (montoVendido > 0) {
            this.montoVendido = montoVendido;
        }
    }

    public double getPorcentajeComision() {
        return porcentajeComision;
    }

    public void setPorcentajeComision(double porcentajeComision) {
        if (porcentajeComision >= 0) {
            this.porcentajeComision = porcentajeComision;
        }
    }

    public double getCumplimiento() {
        return cumplimiento;
    }

    public void setCumplimiento(double cumplimiento) {
        if (cumplimiento >= 0 && cumplimiento <= 100) {
            this.cumplimiento = cumplimiento;
        }
    }

    public double calcularComision() {
        return montoVendido * (porcentajeComision / 100);
    }

    public double calcularIngresoTotal() {
        return montoVendido + calcularComision();
    }

    public String estadoCumplimiento() {
        if (cumplimiento >= 90) return "Excelente";
        else if (cumplimiento >= 70) return "Aceptable";
        else return "Bajo";
    }

    public String mensajeFinal() {
        switch (estadoCumplimiento()) {
            case "Excelente":
                return "Vendedor con desempeño sobresaliente";
            case "Aceptable":
                return "Vendedor con desempeño aceptable";
            default:
                return "Se requiere seguimiento comercial";
        }
    }

    public void mostrarReporte() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Área: " + area);
        System.out.println("Monto vendido: " + montoVendido);
        System.out.println("Comisión: " + calcularComision());
        System.out.println("Ingreso total: " + calcularIngresoTotal());
        System.out.println("Estado: " + estadoCumplimiento());
        System.out.println("Mensaje: " + mensajeFinal());
    }
}