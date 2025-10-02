package compuwork;

class EmpleadoTemporal extends Empleado {
    public static final String EMPL_TEMPORAL = "Temporal";

    public EmpleadoTemporal(String idEmpleado, String nombre, String cargo, byte añosExp, double salario) {
        super(idEmpleado, nombre, cargo, añosExp, salario);
    }
}
