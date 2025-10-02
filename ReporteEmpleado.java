package compuwork;

import java.time.LocalDate;

class ReporteEmpleado {
    private String codigoReporte;
    private LocalDate fecha;
    private float porcentajeCumplimiento;
    private int erroresPorProyecto;
    private float porcentajeCalidadTrabajo;
    private String comentario;

    public ReporteEmpleado(String codigoReporte, LocalDate fecha, float porcentajeCumplimiento, int erroresPorProyecto, float porcentajeCalidadTrabajo, String comentario) {
        this.codigoReporte = codigoReporte;
        this.fecha = fecha;
        this.porcentajeCumplimiento = porcentajeCumplimiento;
        this.erroresPorProyecto = erroresPorProyecto;
        this.porcentajeCalidadTrabajo = porcentajeCalidadTrabajo;
        this.comentario = comentario;
    }

    public String getCodigoReporte() { return codigoReporte; }

    public String comentario() { return comentario; }
    public void comentario(String nuevoComentario) { this.comentario = nuevoComentario; }

    public String toString() {
        return "ReporteEmpleado: " + codigoReporte + " - Fecha=" + fecha +
               " - Cumplimiento=" + porcentajeCumplimiento +
               " - Errores=" + erroresPorProyecto +
               " - Calidad=" + porcentajeCalidadTrabajo +
               " - Comentario=" + comentario;
    }
}
