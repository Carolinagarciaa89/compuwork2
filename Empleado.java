import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class Empleado {
    private String idEmpleado;
    private String nombre;
    private String cargo;
    private byte añosExp;
    private double salario;
    private Departamento departamento;
    private List<ReporteEmpleado> reportesEmpleado;

    public Empleado(String idEmpleado, String nombre, String cargo, byte añosExp, double salario) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.cargo = cargo;
        this.añosExp = añosExp;
        this.salario = salario;
        this.reportesEmpleado = new ArrayList<>();
    }

    public String getIdEmpleado() { return idEmpleado; }
    public String getNombre() { return nombre; }

    public void setCargo(String cargo) { this.cargo = cargo; }
    public void setAñosExp(byte añosExp) { this.añosExp = añosExp; }
    public void setSalario(double salario) { this.salario = salario; }

    public void crearDepartamento(Departamento departamento) {
        this.departamento = departamento;
        departamento.agregarEmpleado(this);
    }

    public void modificarDepartamento(Departamento nuevoDepartamento) {
        if (this.departamento != null) {
            this.departamento.getEmpleados().remove(this);
        }
        this.departamento = nuevoDepartamento;
        nuevoDepartamento.agregarEmpleado(this);
    }

    public void eliminarEmpleado() {
        if (departamento != null) {
            departamento.getEmpleados().remove(this);
            departamento = null;
        }
    }

    public void asignarEmpleado(Departamento departamento) {
        this.crearDepartamento(departamento);
    }

    public void generarReporte(String codigoReporte, float cumplimiento, int errores, float calidad, String comentario) {
        ReporteEmpleado reporte = new ReporteEmpleado(codigoReporte, LocalDate.now(), cumplimiento, errores, calidad, comentario);
        reportesEmpleado.add(reporte);
    }

    public ReporteEmpleado consultarReporte(String codigo) {
        for (ReporteEmpleado r : reportesEmpleado) {
            if (r.getCodigoReporte().equals(codigo)) return r;
        }
        return null;
    }

    public String toString() {
        return "Empleado: " + idEmpleado + " - Nombre=" + nombre +
               " - Cargo=" + cargo + " - AñosExp=" + añosExp + " - Salario=" + salario;
    }
}