package compuwork;

import org.junit.Test;
import static org.junit.Assert.*;

public class DepartamentoTest {        

    @Test
    public void agregarYEliminarEmpleado() {     
        Departamento d = new Departamento("D4", "Asesor", "Cucuta");
        Empleado e = new EmpleadoTemporal("E20", "Yeison", "Director", (byte)4, 2500000);

        d.agregarEmpleado(e);
        assertTrue(d.getEmpleados().contains(e));

        d.eliminarEmpleado(e);
        assertFalse(d.getEmpleados().contains(e));
    }

    @Test
    public void generarYConsultarReporteDepartamento() {   
        Departamento d = new Departamento("D3", "Recursos Humanos", "Medellín");
        d.generarReporteDepartamento("RD-100", 12, "2025-Q3", 87.5f);

        assertNotNull(d.consultarReporteDepartamento("RD-100"));
        assertNull(d.consultarReporteDepartamento("NO-EXISTE"));
    }
}
