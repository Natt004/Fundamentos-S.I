import java.util.Scanner;

public class Principal {
public static void main(String[] args) {

System.out.println("Bienvenido al proceso de solicitud del nuevo serivicio de TV digital\n");
Scanner sc=new Scanner(System.in);

//Se declaran las variables, y el arreglo de clientes.
int posicion;
String predio;
int identificacion;
int decision=0;
String registroActivo=" ";
Cliente[] clientes= new Cliente[100];
for (int i=0;i<clientes.length;i++)
{clientes[i]=new Cliente();
}

//Se inicializa un cliente, con estado moroso activo.
clientes[0]=new Cliente("Cra 1A8 #20-50 3er piso",112030,"Activo");

//Se verifica que posicion en el arreglo esta libre.
int posicionLibre=-1;
do
{posicionLibre++;
}while(clientes[posicionLibre].getIdentificacion()!=0);

posicion=posicionLibre;

//Se muestran los requisitos necesarios para proceder con el servicio
System.out.println("Los requisitos solicitados para proceder con el servicio son los siguientes:\n ");
System.out.println("-Disponibilidad en los proximos tres dias\n-No ser una persona morosa\n");
System.out.println("El costo del servicio es de $500.0000 pesos\n");

//Se le pregunta al cliente si acepta o no las condiciones.
while(decision!=1&&decision!=2)
{System.out.println("Acepta las condiciones del servicio? \n1.Si\n2.No");
decision=sc.nextInt();

switch(decision)
{case 1:
	
//Se preguntan los datos comerciales del cliente	
System.out.println("Para comenzar con el proceso es necesario conocer sus datos comerciales: ");
System.out.println("Identificacion: ");
identificacion=sc.nextInt();

System.out.println("Direccion, Caracteristicas del predio: ");
predio=sc.nextLine();
predio=sc.nextLine();

//Se revisa en el sistema si existe registro previo del cliente.
int posicionOcupada=-1;
for(Cliente c:clientes)
{posicionOcupada++;
if(c.getIdentificacion()==identificacion)
{System.out.println("Ya cuenta con registro previo en el sistema");
registroActivo="Si";
posicion=posicionOcupada;
break;}
else{
registroActivo="No";
}}

//En caso de no existir se crea el registro en el sistema.
if(registroActivo.equals("No"))
{clientes[posicionLibre]=new Cliente(predio, identificacion);
}

//Se revisa si el cliente registra estado morodo activo.
if (registroActivo.equals("Si"))
{ if(clientes[posicionOcupada].getEstadoMoroso().equals("Activo"))
{System.out.println("Tiene estado moroso activo, por lo tanto, no se puede proceder con el servicio");
break;}}

Servicio servicio=new Servicio();
//Se registra el numero de solicitud.
servicio.generarNumeroSolicitud();
System.out.println("El numero de solicitud es: " +servicio.getNumeroSolicitud());

//Se programa y se comprueba la fecha de instalacion no mayor a tres dias desde hoy.
servicio.programarFechaInstalacion();
servicio.comprobarFechaInstalacion();

System.out.println("La fecha de instalacion programada es: " +servicio.getFechaInstalacion() +"\n");

//Se genera la orden de instalacion
servicio.ordenDeInstalacion(clientes[posicion]);

//Se genera la orden de ejecucion
servicio.ordenDeEjecucion();

int satisfecho=0;

//Se verifica la satisfaccion del cliente con el servicio.
while(satisfecho!=1)
{servicio.verificacionDelTrabajo();

String opinion;

System.out.println("-------------------------");

System.out.println("\nEsta satisfecho con el trabajo entregado?\n1.Si\n2.No");
satisfecho=sc.nextInt();
switch(satisfecho)
{case 1: System.out.println("Nos alegramos que nuestro servicio haya sido de su agrado.");
break;
case 2: System.out.println("Podría decirnos que le disgusto?");
opinion=sc.nextLine();
opinion=sc.nextLine();
System.out.println("Gracias por su opinion, se llevara a cabo nuevamente la instalacion\nteniendo en cuenta sus observaciones.");
break;
default:
System.out.println("Esta opcion no se encuentra dentro de la seleccion, vuelve a intentar.");
break;
}}

break;

case 2:
System.out.println("Si no se aceptan las condiciones del servicio, no se puede continuar con el proceso.");
break;

default: 
System.out.println("Esta opcion no se encuentra dentro de la seleccion, vuelve a intentar.");
break;
}
}
}
}
