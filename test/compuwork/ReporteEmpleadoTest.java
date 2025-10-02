package compuwork;

import org.junit.Test;
import static org.junit.Assert.*;

public class ReporteEmpleadoTest {

    @Test
    public void generarYConsultarReporteEmpleado() {
        Empleado e = new EmpleadoTemporal("E15", "Jose", "Analista", (byte)3, 2000000);

        e.generarReporte("R-001", 92.5f, 1, 95.0f, "Tuvo un buen mes");
        assertNotNull(e.consultarReporte("R-001"));
        assertEquals("R-001", e.consultarReporte("R-001").getCodigoReporte());

        assertNull(e.consultarReporte("R-999"));
    }
}
