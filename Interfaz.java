package compuwork;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Interfaz extends JFrame {

    private Controlador controlador = new Controlador();

    public Interfaz() {
        setTitle("CompuWork - Gestión Información");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 1));

        JButton btnEmpleado = new JButton("Crear Empleado");
        JButton btnDepto = new JButton("Crear Departamento");
        JButton btnAsignar = new JButton("Asignar Empleado a Departamento");
        JButton btnReporteEmp = new JButton("Generar Reporte Empleado");
        JButton btnReporteDepto = new JButton("Generar Reporte Departamento");

        btnEmpleado.addActionListener(e -> {
            String id = JOptionPane.showInputDialog("ID empleado:");
            String nombre = JOptionPane.showInputDialog("Nombre:");
            String cargo = JOptionPane.showInputDialog("Cargo:");
            byte exp = Byte.parseByte(JOptionPane.showInputDialog("Años de experiencia:"));
            double salario = Double.parseDouble(JOptionPane.showInputDialog("Salario:"));

            Empleado emp = new EmpleadoTemporal(id, nombre, cargo, exp, salario);
            controlador.crearEmpleado(emp);
            JOptionPane.showMessageDialog(this, "Empleado creado:\n" + emp);
        });

        btnDepto.addActionListener(e -> {
            String id = JOptionPane.showInputDialog("ID departamento:");
            String nombre = JOptionPane.showInputDialog("Nombre:");
            String ubicacion = JOptionPane.showInputDialog("Ubicación:");

            Departamento d = new Departamento(id, nombre, ubicacion);
            controlador.crearDepartamento(d);
            JOptionPane.showMessageDialog(this, "Departamento creado:\n" + d);
        });

        btnAsignar.addActionListener(e -> {
            String idEmp = JOptionPane.showInputDialog("ID empleado:");
            String nombreDepto = JOptionPane.showInputDialog("Nombre del departamento:");

            Departamento d = controlador.buscarDepartamentoPorNombre(nombreDepto);
            controlador.asignarEmpleadoADepartamento(idEmp, d);
            JOptionPane.showMessageDialog(this, "Empleado asignado al depto " + nombreDepto);
        });

        btnReporteEmp.addActionListener(e -> {
            String idEmp = JOptionPane.showInputDialog("ID empleado:");
            Empleado emp = controlador.buscarEmpleado(idEmp);

            if (emp != null) {
                String codigo = JOptionPane.showInputDialog("Código reporte:");
                float cumplimiento = Float.parseFloat(JOptionPane.showInputDialog("Cumplimiento (%):"));
                int errores = Integer.parseInt(JOptionPane.showInputDialog("Errores:"));
                float calidad = Float.parseFloat(JOptionPane.showInputDialog("Calidad (%):"));
                String comentario = JOptionPane.showInputDialog("Comentario:");

                emp.generarReporte(codigo, cumplimiento, errores, calidad, comentario);
                JOptionPane.showMessageDialog(this, "Reporte generado:\n" + emp.consultarReporte(codigo));
            } else {
                JOptionPane.showMessageDialog(this, "Empleado no encontrado");
            }
        });

        btnReporteDepto.addActionListener(e -> {
            String idDepto = JOptionPane.showInputDialog("ID departamento:");
            Departamento d = controlador.buscarDepartamentoPorId(idDepto);

            if (d != null) {
                String codigo = JOptionPane.showInputDialog("Código reporte:");
                int volumen = Integer.parseInt(JOptionPane.showInputDialog("Volumen proyectos:"));
                String periodo = JOptionPane.showInputDialog("Periodo:");
                float tasa = Float.parseFloat(JOptionPane.showInputDialog("Tasa resolución:"));

                d.generarReporteDepartamento(codigo, volumen, periodo, tasa);
                JOptionPane.showMessageDialog(this, "Reporte depto generado:\n" + d.consultarReporteDepartamento(codigo));
            } else {
                JOptionPane.showMessageDialog(this, "Departamento no encontrado");
            }
        });

        add(btnEmpleado);
        add(btnDepto);
        add(btnAsignar);
        add(btnReporteEmp);
        add(btnReporteDepto);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Interfaz());
    }
}
