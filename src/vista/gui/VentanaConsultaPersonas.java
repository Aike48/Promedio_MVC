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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modelo.vo.EstudianteVO;

public class VentanaConsultaPersonas extends JFrame {

	private JPanel panelPrincipal;
	private JTable tablaPersonas;
	private DefaultTableModel modelo;

	private Coordinador miCoordinador;

	public void setCoordinador(Coordinador coordinador) {
		this.miCoordinador = coordinador;
	}

	public VentanaConsultaPersonas() {
		setSize(507, 343);
		setTitle("Consulta de Estudiantes");
		setLocationRelativeTo(null);
		setResizable(false);
		iniciarComponentes();
	}

	private void iniciarComponentes() {
		panelPrincipal = new JPanel();
		panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelPrincipal);
		panelPrincipal.setLayout(null);

		JLabel lblTitulo = new JLabel("MOSTRAR ESTUDIANTES");
		lblTitulo.setBackground(Color.black);
		lblTitulo.setForeground(Color.white);
		lblTitulo.setOpaque(true);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTitulo.setBounds(0, 0, 499, 50);
		panelPrincipal.add(lblTitulo);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 60, 473, 236);
		panelPrincipal.add(scrollPane);

		tablaPersonas = new JTable();
		scrollPane.setViewportView(tablaPersonas);

		// Crear el modelo de la tabla al iniciar la ventana
		crearModelo();
	}

	private void crearModelo() {
		modelo = new DefaultTableModel() {
			// Evitamos que las celdas sean editables
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		modelo.addColumn("Documento");
		modelo.addColumn("Nombre");
		modelo.addColumn("Nota 1");
		modelo.addColumn("Nota 2");
		modelo.addColumn("Nota 3");
		modelo.addColumn("Promedio");
		tablaPersonas.setModel(modelo);
	}

	public void llenarTabla() {
		// Limpiar la tabla antes de llenarla (en caso de que ya tenga datos)
		modelo.setRowCount(0);

		List<EstudianteVO> listaEstudiantes = miCoordinador.getListaPersonas(); // Obtener la lista de estudiantes

		if (listaEstudiantes != null && !listaEstudiantes.isEmpty()) {
			for (EstudianteVO estudiante : listaEstudiantes) {
				modelo.addRow(new Object[]{
						estudiante.getDocumento(),
						estudiante.getNombre(),
						estudiante.getNota1(),
						estudiante.getNota2(),
						estudiante.getNota3(),
						estudiante.getPromedio()
				});
			}
		} else {
			// Si no hay estudiantes, mostramos un mensaje en consola o podemos manejarlo visualmente
			System.out.println("No hay estudiantes registrados.");
		}
	}
}







