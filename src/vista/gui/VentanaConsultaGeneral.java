package vista.gui;

import controlador.Coordinador;
import java.awt.Color;
import java.awt.Font;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import modelo.vo.EstudianteVO;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class VentanaConsultaGeneral extends JFrame {

	private JPanel panelPrincipal;
	private JTextArea areaInformacion;

	private Coordinador miCoordinador;

	public void setCoordinador(Coordinador coordinador) {
		this.miCoordinador = coordinador;
	}

	public VentanaConsultaGeneral() {
		setSize(527, 337);
		setTitle("Consulta General de Estudiantes");
		setLocationRelativeTo(null);
		setResizable(false);
		iniciarComponentes();
	}

	private void iniciarComponentes() {
		panelPrincipal = new JPanel();
		panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelPrincipal);
		panelPrincipal.setLayout(null);

		JLabel lblTitulo = new JLabel("IMPRIMIR INFORMACIÓN");
		lblTitulo.setBackground(Color.black);
		lblTitulo.setForeground(Color.white);
		lblTitulo.setOpaque(true);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTitulo.setBounds(0, 0, 499, 50);
		panelPrincipal.add(lblTitulo);

		JScrollPane scroll = new JScrollPane();
		scroll.setBounds(10, 60, 489, 230);
		panelPrincipal.add(scroll);

		areaInformacion = new JTextArea();
		areaInformacion.setWrapStyleWord(true);
		areaInformacion.setLineWrap(true);
		areaInformacion.setFont(new Font("Nirmala UI Semilight", Font.PLAIN, 16));
		areaInformacion.setEditable(false); // No editable
		scroll.setViewportView(areaInformacion);
	}

	public void llenarAreaTexto() {
		List<EstudianteVO> listaEstudiantes = miCoordinador.getListaPersonas(); // Obtener la lista de estudiantes

		if (listaEstudiantes != null && !listaEstudiantes.isEmpty()) {
			StringBuilder resultado = new StringBuilder();
			double sumaPromedios = 0;
			int contadorEstudiantes = 0;

			for (EstudianteVO estudiante : listaEstudiantes) {
				resultado.append("Nombre: ").append(estudiante.getNombre()).append("\n")
						.append("Documento: ").append(estudiante.getDocumento()).append("\n")
						.append("Nota 1: ").append(estudiante.getNota1()).append("\n")
						.append("Nota 2: ").append(estudiante.getNota2()).append("\n")
						.append("Nota 3: ").append(estudiante.getNota3()).append("\n")
						.append("Promedio: ").append(estudiante.getPromedio()).append("\n")
						.append("-------------------------------\n");

				sumaPromedios += estudiante.getPromedio();
				contadorEstudiantes++;
			}

			// Calcular el promedio total de todos los estudiantes
			double promedioGeneral = sumaPromedios / contadorEstudiantes;
			resultado.append("\nPromedio General de Todos los Estudiantes: ").append(String.format("%.2f", promedioGeneral));

			// Mostrar la información en el área de texto
			areaInformacion.setText(resultado.toString());

		} else {
			areaInformacion.setText("No hay estudiantes registrados.");
		}
	}
}
