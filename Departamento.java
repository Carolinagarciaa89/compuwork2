package compuwork;

import java.util.ArrayList;
import java.util.List;

class Departamento {
    private String idDepartamento;
    private String nombreDepartamento;
    private String ubicacion;
    private List<Empleado> empleados;
    private List<ReporteDepartamento> reportesDepartamento;

    public Departamento(String idDepartamento, String nombreDepartamento, String ubicacion) {
        this.idDepartamento = idDepartamento;
        this.nombreDepartamento = nombreDepartamento;
        this.ubicacion = ubicacion;
        this.empleados = new ArrayList<>();
        this.reportesDepartamento = new ArrayList<>();
    }

    public String getIdDepartamento() { return idDepartamento; }
    public String getNombreDepartamento() { return nombreDepartamento; }
    public String getUbicacion() { return ubicacion; }

    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    public void eliminarEmpleado(Empleado empleado) {
        empleados.remove(empleado);
    }

    public List<Empleado> getEmpleados() { return empleados; }

    public void generarReporteDepartamento(String codigoReporte, int volumenProyectos, String periodo, float tasaResolucion) {
        ReporteDepartamento reporte = new ReporteDepartamento(codigoReporte, volumenProyectos, periodo, tasaResolucion);
        reportesDepartamento.add(reporte);
    }

    public ReporteDepartamento consultarReporteDepartamento(String codigo) {
        for (ReporteDepartamento r : reportesDepartamento) {
            if (r.getCodigoReporte().equalsIgnoreCase(codigo)) return r;
        }
        return null;
    }

    public String toString() {
        return "Departamento: " + idDepartamento + " - Nombre=" + nombreDepartamento + " - Ubicacion=" + ubicacion;
    }
}
