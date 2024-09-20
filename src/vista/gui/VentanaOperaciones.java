package vista.gui;

import controlador.Coordinador;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import modelo.vo.EstudianteVO;

public class VentanaOperaciones extends JFrame implements ActionListener {

	private JPanel panelPrincipal;
	private JTextField txtNombre;
	private JTextField txtNota1;
	private JTextField txtNota2;
	private JTextField txtNota3;
	private JTextField txtDocumento;
	private JLabel lblResPromedio, lblResultado;
	private JButton btnCalcular, btnImprimirTotal, btnConsultarestudiante, btnConsultarLista;

	private Coordinador miCoordinador;

	public void setCoordinador(Coordinador coordinador) {
		this.miCoordinador = coordinador;
	}

	public VentanaOperaciones() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(486, 531);
		setTitle("CALCULO DE PROMEDIO");
		setLocationRelativeTo(null);
		setResizable(false);
		iniciarComponentes();
	}

	private void iniciarComponentes() {
		panelPrincipal = new JPanel();
		panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelPrincipal);
		panelPrincipal.setLayout(null);

		JLabel lblTitulo = new JLabel("CALCULAR PROMEDIO");
		lblTitulo.setBackground(Color.black);
		lblTitulo.setForeground(Color.white);
		lblTitulo.setOpaque(true);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTitulo.setBounds(0, 0, 477, 50);
		panelPrincipal.add(lblTitulo);

		// Etiquetas y campos de texto
		agregarCamposTexto();

		// Botones
		agregarBotones();

		// Resultados
		agregarResultados();
	}

	private void agregarCamposTexto() {
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre.setBounds(31, 86, 100, 23);
		panelPrincipal.add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setBounds(95, 80, 200, 39);
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtNombre.setColumns(10);
		panelPrincipal.add(txtNombre);

		JLabel lblNota1 = new JLabel("Nota1:");
		lblNota1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNota1.setBounds(31, 135, 100, 23);
		panelPrincipal.add(lblNota1);

		txtNota1 = new JTextField();
		txtNota1.setColumns(10);
		txtNota1.setBounds(95, 129, 63, 39);
		txtNota1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelPrincipal.add(txtNota1);

		JLabel lblNota2 = new JLabel("Nota2:");
		lblNota2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNota2.setBounds(168, 135, 100, 23);
		panelPrincipal.add(lblNota2);

		txtNota2 = new JTextField();
		txtNota2.setColumns(10);
		txtNota2.setBounds(232, 129, 63, 39);
		txtNota2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelPrincipal.add(txtNota2);

		JLabel lblNota3 = new JLabel("Nota3:");
		lblNota3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNota3.setBounds(300, 135, 100, 23);
		panelPrincipal.add(lblNota3);

		txtNota3 = new JTextField();
		txtNota3.setColumns(10);
		txtNota3.setBounds(364, 129, 63, 39);
		txtNota3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelPrincipal.add(txtNota3);

		JLabel lblDoc = new JLabel("CC: ");
		lblDoc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDoc.setBounds(312, 86, 42, 23);
		panelPrincipal.add(lblDoc);

		txtDocumento = new JTextField();
		txtDocumento.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtDocumento.setColumns(10);
		txtDocumento.setBounds(364, 78, 63, 39);
		panelPrincipal.add(txtDocumento);
	}

	private void agregarBotones() {
		btnCalcular = new JButton("Calcular");
		btnCalcular.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCalcular.setBounds(310, 190, 117, 31);
		btnCalcular.addActionListener(this);
		panelPrincipal.add(btnCalcular);

		btnImprimirTotal = new JButton("Imprimir total");
		btnImprimirTotal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnImprimirTotal.setBounds(28, 365, 136, 31);
		btnImprimirTotal.addActionListener(this);
		panelPrincipal.add(btnImprimirTotal);

		btnConsultarestudiante = new JButton("Consultar");
		btnConsultarestudiante.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnConsultarestudiante.setBounds(327, 365, 100, 31);
		btnConsultarestudiante.addActionListener(this);
		panelPrincipal.add(btnConsultarestudiante);

		btnConsultarLista = new JButton("Consulta Total");
		btnConsultarLista.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnConsultarLista.setBounds(181, 365, 136, 31);
		btnConsultarLista.addActionListener(this);
		panelPrincipal.add(btnConsultarLista);
	}

	private void agregarResultados() {
		JLabel lblPromedio = new JLabel("Promedio:");
		lblPromedio.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblPromedio.setBounds(31, 245, 127, 31);
		panelPrincipal.add(lblPromedio);

		lblResPromedio = new JLabel("");
		lblResPromedio.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblResPromedio.setBounds(156, 245, 271, 31);
		panelPrincipal.add(lblResPromedio);

		lblResultado = new JLabel("Resultado:");
		lblResultado.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblResultado.setBounds(31, 286, 396, 31);
		panelPrincipal.add(lblResultado);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCalcular) {
			calcularPromedio();
		} else if (e.getSource() == btnImprimirTotal) {
			imprimirTotal();
		} else if (e.getSource() == btnConsultarestudiante) {
			consultarEstudiante();
		} else if (e.getSource() == btnConsultarLista) {
			consultarLista();
		}
	}

	private void limpiarCampos() {
		txtNombre.setText("");
		txtNota1.setText("");
		txtNota2.setText("");
		txtNota3.setText("");
	}
	private void consultarLista() {
		miCoordinador.mostrarVentanaConsultaPersonas();
		limpiarCampos();
	}

	private void imprimirTotal() {
		miCoordinador.mostrarVentanaConsultaGeneral();
		limpiarCampos();
	}

	private void consultarEstudiante() {
		miCoordinador.mostrarVentanaConsulta();
		limpiarCampos();
	}

	private void calcularPromedio() {
		try {
			// Validación de campos vacíos
			if (txtNombre.getText().isEmpty() || txtDocumento.getText().isEmpty() || txtNota1.getText().isEmpty() || txtNota2.getText().isEmpty() || txtNota3.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}

			String nombre = txtNombre.getText();
			String documento = txtDocumento.getText();
			double nota1 = Double.parseDouble(txtNota1.getText());
			double nota2 = Double.parseDouble(txtNota2.getText());
			double nota3 = Double.parseDouble(txtNota3.getText());

			// Validación de rango de notas
			if (nota1 < 0 || nota1 > 5 || nota2 < 0 || nota2 > 5 || nota3 < 0 || nota3 > 5) {
				JOptionPane.showMessageDialog(null, "Las notas deben estar entre 0 y 5.", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}

			// Calcula el promedio
			double promedio = miCoordinador.calcularPromedio(nota1, nota2, nota3);
			lblResPromedio.setText(String.format("%.2f", promedio));

			// Determina el resultado
			if (promedio >= 3.0) {
				lblResultado.setText("Ha ganado la materia.");
				lblResultado.setForeground(Color.GREEN);
			} else {
				lblResultado.setText("Ha perdido la materia.");
				lblResultado.setForeground(Color.RED);
			}

			// Llamada al Coordinador para registrar en la base de datos
			EstudianteVO estudiante = new EstudianteVO(documento, nombre, nota1, nota2, nota3, promedio);
			miCoordinador.registrarEnBD(estudiante);

		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(null, "Por favor, ingrese valores numéricos válidos para las notas.", "Error", JOptionPane.ERROR_MESSAGE);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Ocurrió un error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}

		limpiarCampos();
	}


}
