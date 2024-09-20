package controlador;

import modelo.operaciones.*;
import modelo.vo.*;
import java.util.ArrayList;

import vista.gui.*;

public class Coordinador {
    private Procesos procesos;
    private VentanaConsulta miVentanaConsulta;
    private VentanaConsultaGeneral miVentanaConsultaGeneral;
    private VentanaConsultaPersonas miVentanaConsultaPersonas;
    private VentanaOperaciones miVentanaPrincipal;

    public Coordinador(ModeloDatos modeloDatos) {
        this.procesos = new Procesos(modeloDatos);
    }

    public void mostrarVentanaConsulta () {
        miVentanaConsulta.setVisible(true);
    }

    public void mostrarVentanaConsultaGeneral () {
        miVentanaConsultaGeneral.llenarAreaTexto();
        miVentanaConsultaGeneral.setVisible(true);
    }

    public void mostrarVentanaConsultaPersonas () {
        miVentanaConsultaPersonas.llenarTabla();
        miVentanaConsultaPersonas.setVisible(true);
    }

    public void mostarVentanaPrincipal () {
        miVentanaPrincipal.setVisible(true);
    }

    public VentanaConsulta getVentanaConsulta() {
        return miVentanaConsulta;
    }

    public void setVentanaConsulta(VentanaConsulta miVentanaConsulta) {
        this.miVentanaConsulta = miVentanaConsulta;
    }

    public VentanaConsultaGeneral getVentanaConsultaGeneral() {
        return miVentanaConsultaGeneral;
    }

    public void setVentanaConsultaGeneral(VentanaConsultaGeneral miVentanaConsultaGeneral) {
        this.miVentanaConsultaGeneral = miVentanaConsultaGeneral;
    }

    public VentanaConsultaPersonas getVentanaConsultaPersonas() {
        return miVentanaConsultaPersonas;
    }

    public void setVentanaConsultaPersonas(VentanaConsultaPersonas miVentanaConsultaPersonas) {
        this.miVentanaConsultaPersonas = miVentanaConsultaPersonas;
    }

    public VentanaOperaciones getVentanaPrincipal() {
        return miVentanaPrincipal;
    }

    public void setVentanaPrincipal(VentanaOperaciones miVentanaPrincipal) {
        this.miVentanaPrincipal = miVentanaPrincipal;
    }


    // Metodo para registrar un estudiante
    public void registrarEstudiante(String nombre, String documento, double nota1, double nota2, double nota3) {
        try {
            if (procesos.verificarDatosValidos(nombre, documento, nota1, nota2, nota3)) {
                if (!procesos.validarDatosRepetidos(documento)) {
                    double promedio = procesos.calcularPromedio(nota1, nota2, nota3);
                    EstudianteVO estudiante = new EstudianteVO(documento, nombre, nota1, nota2, nota3, promedio);
                    procesos.registrarEnBD(estudiante);
                    System.out.println("Estudiante registrado con éxito.");
                } else {
                    System.out.println("El estudiante ya está registrado.");
                }
            }
        } catch (DatosInvalidosException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Metodo para eliminar un estudiante
    public void eliminarEstudiante(String documento) {
        try {
            procesos.eliminarEstudiante(documento);
            System.out.println("Estudiante eliminado.");
        } catch (DatosInvalidosException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Metodo para actualizar un estudiante
    public void actualizarEstudiante(String nombre, String documento, double nota1, double nota2, double nota3 ) {
        try {
            if (procesos.verificarDatosValidos(nombre, documento, nota1, nota2, nota3)) {
                double promedio = procesos.calcularPromedio(nota1, nota2, nota3);
                EstudianteVO estudianteActualizado = new EstudianteVO(documento, nombre, nota1, nota2, nota3, promedio);
                procesos.registrarEnBD(estudianteActualizado);
                System.out.println("Estudiante actualizado con éxito.");
            }
        } catch (DatosInvalidosException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Metodo para obtener una lista de estudiantes
    public ArrayList<EstudianteVO> obtenerListaEstudiantes() {
        return procesos.getListaPersonas();
    }

    // Metodo para obtener un estudiante por su documento
    public EstudianteVO obtenerEstudiante(String documento) {
        return procesos.obtenerEstudiante(documento);
    }

    // Metodo para calcular el promedio total de notas
    public double calcularPromedioTotalNotas() {
        return procesos.calcularPromedioTotalNotas();
    }

    // Metodo para imprimir la lista de estudiantes
    public void imprimirListaEstudiantes() {
        procesos.imprimirListaEstudiantes();
    }

    public void registrarEnBD(EstudianteVO estudiante) {
        procesos.registrarEnBD (estudiante);
    }

    public double calcularPromedio(EstudianteVO estudiante) {
        return procesos.calcularPromedioTotalNotas();
    }

    public ArrayList<EstudianteVO> getListaPersonas() {
        return procesos.getListaPersonas();

    }

    public double calcularPromedio(double nota1, double nota2, double nota3) {
        return procesos.calcularPromedio(nota1, nota2, nota3);
    }

    public void verificarDatosValidos(String nombre, String documento, double nota1, double nota2, double nota3) throws DatosInvalidosException {
        procesos.verificarDatosValidos(nombre, documento, nota1, nota2, nota3);
    }
}
