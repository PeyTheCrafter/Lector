package modelo.acceso;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class GestorMarca {
	private String ruta;

	public GestorMarca() {
		super();
		this.ruta = "src/modelo/marca.mrk";
	}

	/**
	 * Almacena el número de la página guardada en un archivo.
	 * 
	 * @param v
	 *            el índice a guardar.
	 */
	public void guardar(int v) {
		File archivo = new File(this.ruta);
		FileOutputStream flujoW = null;
		DataOutputStream conversorW = null;
		try {
			flujoW = new FileOutputStream(archivo);
			conversorW = new DataOutputStream(flujoW);
			conversorW.writeInt(v);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			conversorW.close();
			flujoW.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Carga el número de la página marcada anteriormente guardada. En caso de estar
	 * vacío, arroja una excepción que no afecta al funcionamiento normal del
	 * programa.
	 * 
	 * @return el valor almacenado. 0 si no había nada guardado (correspondiente a
	 *         la primera página).
	 */
	public int cargar() {
		int v = 0;
		File archivo = new File(this.ruta);
		FileInputStream flujoR = null;
		DataInputStream conversorR = null;
		if (!archivo.exists()) {
			try {
				archivo.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			flujoR = new FileInputStream(archivo);
			conversorR = new DataInputStream(flujoR);
			v = conversorR.readInt();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			conversorR.close();
			flujoR.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return v;
	}
}
