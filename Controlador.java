import java.util.HashMap;
import java.util.Map;

class Controlador {
    private Map<String, Empleado> empleados = new HashMap<>();
    private Map<String, Departamento> departamentos = new HashMap<>();

    public void crearEmpleado(Empleado empleado) { empleados.put(empleado.getIdEmpleado(), empleado); }
    public Empleado buscarEmpleado(String idEmpleado) { return empleados.get(idEmpleado); }
    public void eliminarEmpleado(String idEmpleado) { empleados.remove(idEmpleado); }

    public void crearDepartamento(Departamento departamento) { departamentos.put(departamento.toString(), departamento); }
    public Departamento buscarDepartamentoPorNombre(String nombreDepartamento) {
        for (Departamento departamento : departamentos.values()) {
            if (departamento.toString().contains(nombreDepartamento)) return departamento;
        }
        return null;
    }

    public void eliminarDepartamentoPorNombre(String nombreDepartamento) {
        String clave = null;
        for (Map.Entry<String, Departamento> it : departamentos.entrySet()) {
            if (it.getValue().toString().contains(nombreDepartamento)) { clave = it.getKey(); break; }
        }
        if (clave != null) departamentos.remove(clave);
    }

    public void asignarEmpleadoADepartamento(String idEmpleado, Departamento departamento) {
        Empleado empleado = empleados.get(idEmpleado);
        if (empleado != null && departamento != null) {
            empleado.modificarDepartamento(departamento);
        }
    }
}