package aplicacion;

import javax.swing.JOptionPane;

public class GaleriaTICExcepcion extends Exception{
	
	public static final String NOMBRE_CORTO_VACIO = "El nombre corto esta vacio";

	public GaleriaTICExcepcion(String message){
		JOptionPane.showMessageDialog(null, message, "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
	}
}