package compuwork;

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
    private List<ReporteEmpleado> reportes = new ArrayList<>();

    public Empleado(String idEmpleado, String nombre, String cargo, byte añosExp, double salario) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.cargo = cargo;
        this.añosExp = añosExp;
        this.salario = salario;
    }

    public String getIdEmpleado() { return idEmpleado; }

    public Departamento getDepartamento() { return departamento; }

    public void modificarDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public void generarReporte(String codigo, float cumplimiento, int errores, float calidad, String comentario) {
        ReporteEmpleado r = new ReporteEmpleado(
                codigo, LocalDate.now(), cumplimiento, errores, calidad, comentario
        );
        reportes.add(r);
    }

    public ReporteEmpleado consultarReporte(String codigo) {
        for (ReporteEmpleado r : reportes) {
            if (r.getCodigoReporte().equalsIgnoreCase(codigo)) return r;
        }
        return null;
    }

    public String toString() {
        return "Empleado{id=" + idEmpleado + ", nombre=" + nombre + ", cargo=" + cargo +
               ", exp=" + añosExp + ", salario=" + salario + "}";
    }
}
