package compuwork;

import org.junit.Test;
import static org.junit.Assert.*;

public class ControladorTest {

    @Test
    public void crearYBuscarEmpleado() {
        Controlador c = new Controlador();
        Empleado e = new EmpleadoTemporal("E1", "Jose", "Vendedor", (byte)2, 1800000);
        c.crearEmpleado(e);

        Empleado encontrado = c.buscarEmpleado("E1");
        assertNotNull(encontrado);
        assertEquals("E1", encontrado.getIdEmpleado());
    }

    @Test
    public void crearDepartamentoYAsignarEmpleado() {
        Controlador c = new Controlador();
        Empleado e = new EmpleadoTemporal("E2", "Luis", "Soporte", (byte)1, 1500000);
        Departamento d = new Departamento("D1", "TI", "Medellín");
        c.crearEmpleado(e);
        c.crearDepartamento(d);

        c.asignarEmpleadoADepartamento("E2", d);

        assertNotNull(c.buscarEmpleado("E2"));
        assertTrue(d.getEmpleados().contains(e));
    }

    @Test
    public void buscarDepartamentoPorNombre() {
        Controlador c = new Controlador();
        Departamento d = new Departamento("D2", "Recursos Humanos", "Bogotá");
        c.crearDepartamento(d);

        assertNotNull(c.buscarDepartamentoPorNombre("Recursos Humanos"));
        assertNotNull(c.buscarDepartamentoPorNombre("Recursos"));
    }
}
