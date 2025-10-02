package compuwork;

class EmpleadoPermanente extends Empleado {
    public static final String EMPL_PERMANENTE = "Permanente";

    public EmpleadoPermanente(String idEmpleado, String nombre, String cargo, byte añosExp, double salario) {
        super(idEmpleado, nombre, cargo, añosExp, salario);
    }
}
