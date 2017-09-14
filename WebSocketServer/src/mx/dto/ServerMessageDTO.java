package mx.dto;

import java.io.Serializable;
import java.util.List;

public class ServerMessageDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5836577197148163665L;
	private String tipo;
	private Long emisor;
	private List<Long> receptor;
	private Object datos;
	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}
	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	/**
	 * @return the emisor
	 */
	public Long getEmisor() {
		return emisor;
	}
	/**
	 * @param emisor the emisor to set
	 */
	public void setEmisor(Long emisor) {
		this.emisor = emisor;
	}
	/**
	 * @return the receptor
	 */
	public List<Long> getReceptor() {
		return receptor;
	}
	/**
	 * @param receptor the receptor to set
	 */
	public void setReceptor(List<Long> receptor) {
		this.receptor = receptor;
	}
	/**
	 * @return the datos
	 */
	public Object getDatos() {
		return datos;
	}
	/**
	 * @param datos the datos to set
	 */
	public void setDatos(Object datos) {
		this.datos = datos;
	}
	
	

}
