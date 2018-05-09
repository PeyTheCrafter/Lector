package control.acciones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MALMarcar implements ActionListener{
	
	ParaUI paraUI;
	
	public MALMarcar(ParaUI paraUI) {
		this.paraUI = paraUI;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.paraUI.getLibro().marcarPagina();
		this.paraUI.actualizarVentana();
	}

}
