package control.acciones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MALIrAMarca implements ActionListener {
	ParaUI paraUI;

	public MALIrAMarca(ParaUI paraUI) {
		this.paraUI = paraUI;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.paraUI.getLibro().irAMarca();
		this.paraUI.actualizarVentana();
	}

}
