package clase;

import java.text.Normalizer;

import database.HSQL;

public class Pedido {
	private String mensaje;
	private String nameUsuario;
	private String nameAsistente;
	private HSQL db;
	
	public Pedido(String mensaje_original, String nameUsuario, String nameAsistente, HSQL db) {
		super();
		this.mensaje = normalizado(mensaje_original);
		this.nameUsuario = nameUsuario;
		this.nameAsistente = nameAsistente;
		this.db = db;
	}

	public String getMensaje() {
		return mensaje;
	}

	public String getNameUsuario() {
		return nameUsuario;
	}

	public String getNameAsistente() {
		return nameAsistente;
	}
	
	public HSQL getDB() {
		return db;
	}

	public String normalizado(String texto_original) {	
//		limpiar de tildes
        String texto_normalizado = Normalizer.normalize(texto_original.trim().toLowerCase(), Normalizer.Form.NFD);
//      eliminar char que no son ascii salvo �?!��
        texto_normalizado = texto_normalizado.replaceAll("[^\\p{ASCII}(N\u0303)(n\u0303)(\u00A1)(\u00BF)(\u00B0)(U\u0308)(u\u0308)]", "");
        texto_normalizado = Normalizer.normalize(texto_normalizado, Normalizer.Form.NFC);        
        return texto_normalizado;
	}
	
	
}
