package dominio;

public class Seguro {
	
	private int idSeguro;
	private String descripcion;
	private TipoSeguro tipo;
	private float costoContratacion;
	private float costoAsegurado;
	
	
	
	public Seguro() {
		
	}
	
	public int getIdSeguro() {
		return idSeguro;
	}
	public void setIdSeguro(int idSeguro) {	
		this.idSeguro = idSeguro;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public TipoSeguro getTipoSeguro() {
		return this.tipo;
	}
	public void setTipoSeguro(TipoSeguro Tipo) {
		this.tipo = Tipo;
	}

	public float getCostoContratacion() {
		return costoContratacion;
	}
	public void setCostoContratacion(float costoContratacion) {
		this.costoContratacion = costoContratacion;
	}
	public float getCostoAsegurado() {
		return costoAsegurado;
	}
	public void setCostoAsegurado(float costoAsegurado) {
		this.costoAsegurado = costoAsegurado;
	}
	@Override
	public String toString() {
		return "Seguro [idSeguro=" + idSeguro + ", descripcion=" + descripcion + ", idTipo=" + tipo
				+ ", costoContratacion=" + costoContratacion + ", costoAsegurado=" + costoAsegurado + "]";
	}
}
