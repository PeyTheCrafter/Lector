package modelo.acceso;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Gestor {
	private String ruta;

	public Gestor(String ruta) {
		super();
		this.ruta = ruta;
	}

	public String getString() {
		String str = "";
		File archivo = new File(this.ruta);
		FileInputStream flujoR = null;
		BufferedInputStream bufferR = null;
		if (archivo.exists()) {
			try {
				flujoR = new FileInputStream(archivo);
				bufferR = new BufferedInputStream(flujoR);
				int ch = bufferR.read();
				while (ch != -1) {
					str.concat(String.valueOf(Character.toChars(ch)));
					ch = bufferR.read();
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				bufferR.close();
				flujoR.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return str;
	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

};