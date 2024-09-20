import controlador.Coordinador;
import vista.gui.*;
import modelo.vo.*;
import modelo.operaciones.*;

public class Principal {
	private VentanaConsulta miVentanaConsulta;
	private VentanaConsultaGeneral miVentanaConsultaGeneral;
	private VentanaConsultaPersonas miVentanaConsultaPersonas;
	private VentanaOperaciones miVentanaPrincipal;
	private ModeloDatos miModeloDatos;
	private Coordinador miCoordinador;

	public static void main(String[] args) {
		Principal miPrincipal = new Principal();
		miPrincipal.iniciar();
	}

	public void iniciar() {
		miVentanaConsulta = new VentanaConsulta();
		miVentanaConsultaGeneral = new VentanaConsultaGeneral();
		miVentanaConsultaPersonas = new VentanaConsultaPersonas();
		miVentanaPrincipal = new VentanaOperaciones();
		miModeloDatos = new ModeloDatos();
		miCoordinador = new Coordinador(miModeloDatos);

		// Asignar el coordinador a las ventanas
		miVentanaConsulta.setCoordinador(miCoordinador);
		miVentanaConsultaGeneral.setCoordinador(miCoordinador);
		miVentanaConsultaPersonas.setCoordinador(miCoordinador);
		miVentanaPrincipal.setCoordinador(miCoordinador);

		// Asignar ventanas al coordinador
		miCoordinador.setVentanaConsulta(miVentanaConsulta);
		miCoordinador.setVentanaConsultaGeneral(miVentanaConsultaGeneral);
		miCoordinador.setVentanaConsultaPersonas(miVentanaConsultaPersonas);
		miCoordinador.setVentanaPrincipal(miVentanaPrincipal);

		// Mostrar ventana principal
		miCoordinador.mostarVentanaPrincipal();
	}
}
