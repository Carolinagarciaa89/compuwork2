package compuwork;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Controlador controlador = new Controlador();
        Scanner scanner = new Scanner(System.in);
        boolean ejecutar = true;

        while (ejecutar) {
            System.out.println("=== Sistema CompuWork ===");
            System.out.println("1. Crear empleado");
            System.out.println("2. Crear departamento");
            System.out.println("3. Asignar empleado a departamento");
            System.out.println("4. Generar reporte desempeño");
            System.out.println("5. Generar reporte departamento");
            System.out.println("6. Salir");
            String opcion = scanner.nextLine();

            if (opcion.equals("1")) {
                System.out.print("id: "); String idEmpleado = scanner.nextLine();
                System.out.print("nombre: "); String nombre = scanner.nextLine();
                System.out.print("cargo: "); String cargo = scanner.nextLine();
                System.out.print("años de experiencia: "); byte añosExp = Byte.parseByte(scanner.nextLine());
                System.out.print("salario: "); double salario = Double.parseDouble(scanner.nextLine());

                Empleado empleado = new EmpleadoTemporal(idEmpleado, nombre, cargo, añosExp, salario);
                controlador.crearEmpleado(empleado);
                System.out.println("Empleado creado: " + empleado);

            } else if (opcion.equals("2")) {
                System.out.print("id: "); String idDepartamento = scanner.nextLine();
                System.out.print("nombre: "); String nombreDepartamento = scanner.nextLine();
                System.out.print("ubicacion: "); String ubicacion = scanner.nextLine();

                Departamento departamento = new Departamento(idDepartamento, nombreDepartamento, ubicacion);
                controlador.crearDepartamento(departamento);
                System.out.println("Departamento creado: " + departamento);

            } else if (opcion.equals("3")) {
                System.out.print("id empleado: "); String idEmpleado = scanner.nextLine();
                System.out.print("nombre departamento: "); String nombreDepartamento = scanner.nextLine();

                Departamento departamento = controlador.buscarDepartamentoPorNombre(nombreDepartamento);
                controlador.asignarEmpleadoADepartamento(idEmpleado, departamento);
                System.out.println("Empleado asignado");

            } else if (opcion.equals("4")) {
                System.out.print("id empleado: "); String idEmpleado = scanner.nextLine();
                Empleado empleado = controlador.buscarEmpleado(idEmpleado);

                if (empleado != null) {
                    System.out.print("codigo reporte: "); String codigo = scanner.nextLine();
                    System.out.print("cumplimiento (%): "); float cumplimiento = Float.parseFloat(scanner.nextLine());
                    System.out.print("errores: "); int errores = Integer.parseInt(scanner.nextLine());
                    System.out.print("calidad (%): "); float calidad = Float.parseFloat(scanner.nextLine());
                    System.out.print("comentario: "); String comentario = scanner.nextLine();

                    empleado.generarReporte(codigo, cumplimiento, errores, calidad, comentario);
                    System.out.println("Reporte generado: " + empleado.consultarReporte(codigo));
                }

            } else if (opcion.equals("5")) {
                System.out.print("id departamento: "); String idDepartamento = scanner.nextLine();
                Departamento departamento = controlador.buscarDepartamentoPorId(idDepartamento);

                if (departamento == null) {
                    System.out.println("Departamento no existe.");
                } else {
                    System.out.print("codigo reporte: "); String codigo = scanner.nextLine();
                    System.out.print("volumen proyectos: "); int volumen = Integer.parseInt(scanner.nextLine());
                    System.out.print("periodo: "); String periodo = scanner.nextLine();
                    System.out.print("tasa resolucion: "); float tasa = Float.parseFloat(scanner.nextLine());

                    departamento.generarReporteDepartamento(codigo, volumen, periodo, tasa);
                    System.out.println("Reporte departamento generado: " + departamento.consultarReporteDepartamento(codigo));
                }

            } else if (opcion.equals("6")) {
                ejecutar = false;
                System.out.println("Saliendo del sistema...");
            }
        }
        scanner.close();
    }
}
