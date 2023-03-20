import java.time.LocalDate;
import java.time.Period;
import java.util.Random;

public class Servicio {
private int numeroSolicitud;
private LocalDate fechaInstalacion;

public int getNumeroSolicitud() {
	return numeroSolicitud;
}

public LocalDate getFechaInstalacion() {
	return fechaInstalacion;
}

public void setFechaInstalacion(LocalDate fechaInstalacion) {
	this.fechaInstalacion = fechaInstalacion;
}

public void generarNumeroSolicitud()
{numeroSolicitud=((int) (Math.random()*100000));
}

LocalDate fechaHoy=LocalDate.now();

public void programarFechaInstalacion()
{int diaHoy= fechaHoy.getDayOfMonth();
int mesHoy=fechaHoy.getMonthValue();
int anioHoy=fechaHoy.getYear();

int diaPedido=diaHoy+((int) (Math.random()*3));

fechaInstalacion=LocalDate.of(anioHoy, mesHoy, diaPedido);
	
}

public void comprobarFechaInstalacion()
{Period periodo= Period.between(fechaHoy, fechaInstalacion);
if(periodo.getDays()>3)
{programarFechaInstalacion();
}
}

public void ordenDeInstalacion(Cliente c)
{System.out.println("-------------------------");
System.out.println("Orden de instalacion\n");
System.out.println("Creada el: " +fechaHoy);
System.out.println("Programada el: " +fechaInstalacion);
System.out.println("Cliente: " +c.getIdentificacion());
System.out.println("Direccion: " +c.getCaracteristicasPredio());
}

public void ordenDeEjecucion()
{System.out.println("-------------------------");
System.out.println("\nOrden de ejecucion");
System.out.println("\nSe debe llevar a cabo la ejecucion de la instalacion del servicio considerando\nlas condiciones de calidad establecidas por la empresa.");
}

public void verificacionDelTrabajo()
{System.out.println("-------------------------");
System.out.println("\nSe verifica el cumplimiento de las condiciones");
System.out.println("\nEl trabajo de instalacion cumplio con las condiciones de calidad establecidas.");
}

}
