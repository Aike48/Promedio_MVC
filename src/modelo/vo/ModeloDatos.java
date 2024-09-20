package modelo.vo;

import java.util.HashMap;

public class ModeloDatos {
    private HashMap<String, EstudianteVO> listaEstudiantes;

    public ModeloDatos() {
        this.listaEstudiantes = new HashMap<>();
    }

    public void registrarEstudiante(EstudianteVO estudiante) {
        listaEstudiantes.put(estudiante.getDocumento(), estudiante);
    }

    public EstudianteVO consultarEstudiante(String documento) {
        // Simplemente retorna null si no lo encuentra
        return listaEstudiantes.get(documento);
    }

    public void eliminarEstudiante(String documento) {
        listaEstudiantes.remove(documento);
    }

    public void actualizarEstudiante(EstudianteVO estudianteActualizado) {
        listaEstudiantes.replace(estudianteActualizado.getDocumento(), estudianteActualizado);
    }

    public HashMap<String, EstudianteVO> getListaEstudiantes() {
        return listaEstudiantes;
    }
}
