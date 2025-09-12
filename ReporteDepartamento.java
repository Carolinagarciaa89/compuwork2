class ReporteDepartamento {
    private String codigoReporte;
    private int volumenProyectos;
    private String periodo;
    private float tasaResolucion;

    public ReporteDepartamento(String codigoReporte, int volumenProyectos, String periodo, float tasaResolucion) {
        this.codigoReporte = codigoReporte;
        this.volumenProyectos = volumenProyectos;
        this.periodo = periodo;
        this.tasaResolucion = tasaResolucion;
    }

    public String toString() {
        return "ReporteDepartamento: " + codigoReporte +
               " - Proyectos=" + volumenProyectos +
               " - Periodo=" + periodo +
               " - TasaResolucion=" + tasaResolucion;
    }
}