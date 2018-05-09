package control.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import control.acciones.ParaUI;

public class MALRetroceder implements ActionListener {
	ParaUI paraUI;

	public MALRetroceder(ParaUI paraUI) {
		super();
		this.paraUI = paraUI;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.paraUI.getLibro().retrocederPagina();
		this.paraUI.actualizarVentana();
	}
}
