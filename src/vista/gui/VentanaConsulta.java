package vista.gui;

import controlador.Coordinador;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import modelo.operaciones.DatosInvalidosException;
import modelo.vo.EstudianteVO;

public class VentanaConsulta extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtNota1;
	private JTextField txtNota2;
	private JTextField txtNota3;
	private JTextField txtDoc;
	private JButton btnConsultar;
	private JButton btnActualizar;
	private JButton btnEliminar;
	private JLabel lblResultado;
	private JLabel lblResPromedio;

	private Coordinador miCoordinador;

	public void setCoordinador(Coordinador coordinador) {
		this.miCoordinador = coordinador;
	}

	public VentanaConsulta() {
		setSize(491, 426);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		iniciarComponentes();
	}

	public void iniciarComponentes() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setLayout(null);
		panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelPrincipal.setBounds(0, 0, 477, 379);
		getContentPane().add(panelPrincipal);

		JLabel lblConsultar = new JLabel("CONSULTAR");
		lblConsultar.setOpaque(true);
		lblConsultar.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsultar.setForeground(Color.WHITE);
		lblConsultar.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblConsultar.setBackground(Color.BLACK);
		lblConsultar.setBounds(0, 0, 477, 50);
		panelPrincipal.add(lblConsultar);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre.setBounds(31, 104, 100, 23);
		panelPrincipal.add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtNombre.setColumns(10);
		txtNombre.setBounds(95, 98, 332, 39);
		panelPrincipal.add(txtNombre);

		JLabel lblNota1 = new JLabel("Nota1:");
		lblNota1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNota1.setBounds(31, 153, 100, 23);
		panelPrincipal.add(lblNota1);

		txtNota1 = new JTextField();
		txtNota1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtNota1.setColumns(10);
		txtNota1.setBounds(95, 147, 63, 39);
		panelPrincipal.add(txtNota1);

		JLabel lblNota2 = new JLabel("Nota2:");
		lblNota2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNota2.setBounds(168, 153, 100, 23);
		panelPrincipal.add(lblNota2);

		txtNota2 = new JTextField();
		txtNota2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtNota2.setColumns(10);
		txtNota2.setBounds(232, 147, 63, 39);
		panelPrincipal.add(txtNota2);

		JLabel lblNota3 = new JLabel("Nota3:");
		lblNota3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNota3.setBounds(300, 153, 100, 23);
		panelPrincipal.add(lblNota3);

		txtNota3 = new JTextField();
		txtNota3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtNota3.setColumns(10);
		txtNota3.setBounds(364, 147, 63, 39);
		panelPrincipal.add(txtNota3);

		JLabel lblPromedio = new JLabel("Promedio:");
		lblPromedio.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblPromedio.setBounds(31, 196, 127, 31);
		panelPrincipal.add(lblPromedio);

		lblResPromedio = new JLabel("");
		lblResPromedio.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblResPromedio.setBounds(156, 196, 271, 31);
		panelPrincipal.add(lblResPromedio);

		lblResultado = new JLabel("Resultado:");
		lblResultado.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblResultado.setBounds(31, 237, 396, 31);
		panelPrincipal.add(lblResultado);

		btnConsultar = new JButton("Consultar");
		btnConsultar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnConsultar.setBounds(264, 60, 110, 31);
		btnConsultar.addActionListener(this);
		panelPrincipal.add(btnConsultar);

		JLabel lblDoc = new JLabel("Documento");
		lblDoc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDoc.setBounds(85, 65, 100, 23);
		panelPrincipal.add(lblDoc);

		txtDoc = new JTextField();
		txtDoc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtDoc.setColumns(10);
		txtDoc.setBounds(170, 60, 85, 31);
		panelPrincipal.add(txtDoc);

		btnActualizar = new JButton("Actualizar");
		btnActualizar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnActualizar.setBounds(31, 278, 184, 31);
		btnActualizar.addActionListener(this);
		panelPrincipal.add(btnActualizar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnEliminar.setBounds(243, 278, 184, 31);
		btnEliminar.addActionListener(this);
		panelPrincipal.add(btnEliminar);
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnConsultar) {
			consultarEstudiante();
		} else if (e.getSource() == btnActualizar) {
			actualizarEstudiante();
		} else if (e.getSource() == btnEliminar) {
			eliminarEstudiante();
		}
	}

	private void consultarEstudiante() {
		String documento = txtDoc.getText();
		EstudianteVO estudiante = miCoordinador.obtenerEstudiante(documento);

		if (estudiante != null) {
			txtNombre.setText(estudiante.getNombre());
			txtNota1.setText(Double.toString(estudiante.getNota1()));
			txtNota2.setText(Double.toString(estudiante.getNota2()));
			txtNota3.setText(Double.toString(estudiante.getNota3()));
			lblResPromedio.setText(Double.toString(estudiante.getPromedio()));
			actualizarResultado(estudiante.getPromedio());
		} else {
			JOptionPane.showMessageDialog(this, "Estudiante no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void actualizarEstudiante() {
		try {
			String documento = txtDoc.getText();
			double nota1 = Double.parseDouble(txtNota1.getText());
			double nota2 = Double.parseDouble(txtNota2.getText());
			double nota3 = Double.parseDouble(txtNota3.getText());

			if (validarNotas(nota1, nota2, nota3)) {
				miCoordinador.actualizarEstudiante(txtNombre.getText(), documento, nota1, nota2, nota3);
				EstudianteVO estudianteActualizado = miCoordinador.obtenerEstudiante(documento);
				lblResPromedio.setText(Double.toString(estudianteActualizado.getPromedio()));
				actualizarResultado(estudianteActualizado.getPromedio());
				JOptionPane.showMessageDialog(this, "Estudiante actualizado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(this, "Las notas deben estar entre 0 y 5", "Error", JOptionPane.ERROR_MESSAGE);
			}
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(this, "Por favor ingrese valores válidos para las notas", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void eliminarEstudiante() {
		String documento = txtDoc.getText();
		miCoordinador.eliminarEstudiante(documento);
		JOptionPane.showMessageDialog(this, "Estudiante eliminado", "Éxito", JOptionPane.INFORMATION_MESSAGE);
		limpiarCampos();
	}

	private void actualizarResultado(double promedio) {
		if (promedio >= 3.0) {
			lblResultado.setText("Aprobado");
			lblResultado.setForeground(Color.GREEN);
		} else {
			lblResultado.setText("Reprobado");
			lblResultado.setForeground(Color.RED);
		}
	}

	private boolean validarNotas(double nota1, double nota2, double nota3) {
		return (nota1 >= 0 && nota1 <= 5) && (nota2 >= 0 && nota2 <= 5) && (nota3 >= 0 && nota3 <= 5);
	}

	private void limpiarCampos() {
		txtNombre.setText("");
		txtNota1.setText("");
		txtNota2.setText("");
		txtNota3.setText("");
		lblResPromedio.setText("");
		lblResultado.setText("");
	}
}
