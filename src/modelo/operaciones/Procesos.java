package modelo.operaciones;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import modelo.vo.EstudianteVO;
import modelo.vo.ModeloDatos;
import modelo.operaciones.DatosInvalidosException;  // Asegúrate de tener esta clase definida

public class Procesos {

	private ModeloDatos modeloDatos;

	// Constructor que recibe el ModeloDatos para interactuar con los datos
	public Procesos(ModeloDatos modeloDatos) {
		this.modeloDatos = modeloDatos;
	}

	public boolean verificarEstudianteHashMap(String doc) {
		HashMap<String, EstudianteVO> listaEstudiantes = modeloDatos.getListaEstudiantes();
		return listaEstudiantes.containsKey(doc);
	}

	public void eliminarEstudiante(String doc) throws DatosInvalidosException {
		if (verificarEstudianteHashMap(doc)) {
			modeloDatos.eliminarEstudiante(doc);
		} else {
			throw new DatosInvalidosException("El estudiante con documento " + doc + " no existe.");
		}
	}


	public double calcularPromedio(double n1, double n2, double n3) {
		return (n1 + n2 + n3) / 3.0;
	}

	public double calcularPromedio(EstudianteVO est) {
		return calcularPromedio(est.getNota1(), est.getNota2(), est.getNota3());
	}

	public void registrarEnBD(EstudianteVO estudiante) {
		modeloDatos.registrarEstudiante(estudiante);
	}

	// Imprimir la lista de estudiantes (esto puede ser adaptado a un formato de impresión específico)
	public void imprimirListaEstudiantes() {
		for (EstudianteVO estudiante : modeloDatos.getListaEstudiantes().values()) {
			System.out.println(estudiante);
		}
	}

	// Obtener una lista de estudiantes como ArrayList
	public ArrayList<EstudianteVO> getListaPersonas() {
		return new ArrayList<>(modeloDatos.getListaEstudiantes().values());
	}

	// Obtener un estudiante por su documento
	public EstudianteVO obtenerEstudiante(String doc) {
		return modeloDatos.consultarEstudiante(doc);
	}

	// Validar que no se permitan datos de usuarios repetidos
	public boolean verificarDatosValidos(String nombre, String documento, double nota1, double nota2, double nota3) throws DatosInvalidosException {
		if (documento.length() < 1) { throw new DatosInvalidosException("El documento no puede estar vacío."); }
		if (nombre.length() < 1) { throw new DatosInvalidosException("El nombre no puede estar vacío."); }
		if (!(nota1 >= 0 && nota1 <= 5)) { throw new DatosInvalidosException("La nota 1 debe estar en el rango de 0 a 5."); }
		if (!(nota2 >= 0 && nota2 <= 5)) { throw new DatosInvalidosException("La nota 2 debe estar en el rango de 0 a 5."); }
		if (!(nota3 >= 0 && nota3 <= 5)) { throw new DatosInvalidosException("La nota 3 debe estar en el rango de 0 a 5."); }
		return true;
	}

	// Validar que no se permitan datos de usuarios repetidos
	public boolean validarDatosRepetidos(String documento) {
		return modeloDatos.getListaEstudiantes().containsKey(documento);
	}

	// Calcular el promedio total de notas de todos los estudiantes
	public double calcularPromedioTotalNotas() {
		double sumaTotal = 0;
		int totalEstudiantes = 0;
		for (EstudianteVO estudiante : modeloDatos.getListaEstudiantes().values()) {
			sumaTotal += calcularPromedio(estudiante);
			totalEstudiantes++;
		}
		return totalEstudiantes > 0 ? sumaTotal / totalEstudiantes : 0;
	}

}



