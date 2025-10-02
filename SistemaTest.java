package compuwork;

import org.junit.Test;
import static org.junit.Assert.*;

public class SistemaTest {

    @Test
    public void flujoCompletoBasico() {
        Controlador c = new Controlador();

        Departamento dept = new Departamento("L9", "Logística", "Cali");
        Empleado emp = new EmpleadoTemporal("D99", "Carolina", "Diseñadora", (byte)1, 1300000);
        c.crearDepartamento(dept);
        c.crearEmpleado(emp);

        c.asignarEmpleadoADepartamento("E99", dept);
        assertTrue(dept.getEmpleados().contains(emp));

        emp.generarReporte("RE-1", 90f, 0, 93f, "Súper desempeño");
        assertNotNull(emp.consultarReporte("RE-1"));

        dept.generarReporteDepartamento("RD-9", 7, "2025-09", 88.3f);
        assertNotNull(dept.consultarReporteDepartamento("RD-9"));
    }
}
