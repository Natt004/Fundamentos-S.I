public class Cliente {
private String caracteristicasPredio=" ";
private int identificacion=0;
private String estadoMoroso="Libre";

public Cliente() {
}

public Cliente(String caracteristicasPredio, int identificacion) {
	this.caracteristicasPredio = caracteristicasPredio;
	this.identificacion = identificacion;
}

public Cliente(String caracteristicasPredio, int identificacion, String estadoMoroso) {
	super();
	this.caracteristicasPredio = caracteristicasPredio;
	this.identificacion = identificacion;
	this.estadoMoroso = estadoMoroso;
}

public String getCaracteristicasPredio() {
	return caracteristicasPredio;
}

public void setCaracteristicasPredio(String caracteristicasPredio) {
	this.caracteristicasPredio = caracteristicasPredio;
}

public int getIdentificacion() {
	return identificacion;
}

public void setIdentificacion(int identificacion) {
	this.identificacion = identificacion;
}

public String getEstadoMoroso() {
	return estadoMoroso;
}


public void setEstadoMoroso(String estadoMoroso) {
	this.estadoMoroso = estadoMoroso;
}

@Override
public String toString() {
	return "Cliente [caracteristicasPredio=" + caracteristicasPredio + ", identificacion=" + identificacion
			+ ", estadoMoroso=" + estadoMoroso + "]";
}
}
