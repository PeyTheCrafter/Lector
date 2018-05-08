package vista;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class UI extends JFrame {

	protected JPanel contentPane;
	protected JPanel panelPantalla;
	protected JPanel panelBotones;
	protected JButton btnRetroceso;
	protected JButton btnMarcar;
	protected JButton btnIrAMarca;
	protected JButton btnAvance;
	protected JTextField txtDebug;
	protected JTextArea txtLector;

	/**
	 * Create the frame.
	 */
	public UI() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 300, 450, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 30 };
		gbl_contentPane.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 1.0, 0.0 };
		contentPane.setLayout(gbl_contentPane);

		panelPantalla = new JPanel();
		GridBagConstraints gbc_panelPantalla = new GridBagConstraints();
		gbc_panelPantalla.insets = new Insets(0, 0, 5, 0);
		gbc_panelPantalla.fill = GridBagConstraints.BOTH;
		gbc_panelPantalla.gridx = 0;
		gbc_panelPantalla.gridy = 0;
		contentPane.add(panelPantalla, gbc_panelPantalla);
		panelPantalla.setLayout(new BorderLayout(0, 0));

		txtLector = new JTextArea();
		txtLector.setLineWrap(true);
		txtLector.setWrapStyleWord(true);
		panelPantalla.add(txtLector, BorderLayout.CENTER);

		panelBotones = new JPanel();
		GridBagConstraints gbc_panelBotones = new GridBagConstraints();
		gbc_panelBotones.fill = GridBagConstraints.BOTH;
		gbc_panelBotones.gridx = 0;
		gbc_panelBotones.gridy = 1;
		contentPane.add(panelBotones, gbc_panelBotones);

		btnRetroceso = new JButton("<<");
		panelBotones.add(btnRetroceso);

		btnMarcar = new JButton("Marcar");
		panelBotones.add(btnMarcar);

		btnIrAMarca = new JButton("Ir a marca");
		panelBotones.add(btnIrAMarca);

		btnAvance = new JButton(">>");
		panelBotones.add(btnAvance);

		txtDebug = new JTextField();
		panelBotones.add(txtDebug);
		txtDebug.setColumns(10);
	}
}
