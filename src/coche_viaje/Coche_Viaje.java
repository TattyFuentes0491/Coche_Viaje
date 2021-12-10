/*
14. Se desea modelar las características del carro de una familia que se fue de paseo y 
se encuentra transitando por una larga carretera lineal. 
a. El carro debe tener el valor de su punto de partida 
b. y la velocidad media a la que se mueve 
c. así como la distancia transitada.  
d. De igual manera sabemos que el carro realiza una parada (para que los niños vayan al baño y para comer) cada 50 kilómetros. 
Dentro del modelamiento nos interesa tener la posibilidad de modelar 
e. el inicio del paseo 
f. y posteriormente tener la posibilidad de actualizar la distancia recorrida. (mismo punto c)
g. El carro tiene también un dueño, un modelo (que  es  el  año  de  fabricación)  y  una  marca.  
h. En cualquier momento se va a necesitar conocer (calcular) cuál es el punto en el que se encuentra 
(seguramente eso implicará una operación entre el punto de partida y la distancia recorrida), 
i. también se va a necesitar calcular (en cualquier momento) cuantas paradas se han realizado desde que el paseo comenzó, 
j. así como también se necesitará conocer cuál es el tiempo que se ha tardado el paseo desde que empezó, 
teniendo en cuenta que cada parada se demora exactamente media hora. 
k. Suponga que la velocidad del automóvil cuando no está parado es siempre la misma.
 */
package coche_viaje;
import java.util.Scanner;

public class Coche_Viaje {
    //atributos globales
    int kmPtoPartida;//punto a / valor del punto de partida
    int velocidadMedia;// punto b y k, se mide en km/h  / velocidad media del automóvil
    double kmDistRecorrida;//punto c y f / distancia transitada o  recorrida.  
    double kmParada; //punto d  /  el carro realiza una parada cada 50 kilómetros. 
    String InicioPaseo;//punto e  /  inicio del paseo 
    String nomDueno;//punto g / El carro tiene también un dueño. 
    String modelo;//punto g / El carro tiene también un modelo (que  es  el  año  de  fabricación). 
    String marca;//punto g / El carro tiene también una  marca. 
    int kmPtoActual;//punto h, restar kmPtoPartida y kmDistRecorrida
    int numParadas;//punto i - ponerlo como contador
    int tiempoParada; //30 minutos //punto j
    
    //constructor con variables inicializadas
    public Coche_Viaje() {
        this.kmPtoPartida=0;
        this.velocidadMedia=0;
        this.kmDistRecorrida=0;
        this.kmParada=50;
        this.InicioPaseo=null;
        this.nomDueno=null;
        this.modelo=null;
        this.marca=null;
        this.kmPtoActual=0;
        this.numParadas=0;
        this.tiempoParada=30;
    }
    
    //metodos get y set de los atributos
    public int getKmPtoPartida() {
        return kmPtoPartida;
    }

    public void setKmPtoPartida(int kmPtoPartida) {
        this.kmPtoPartida = kmPtoPartida;
    }

    public int getVelocidadMedia() {
        return velocidadMedia;
    }

    public void setVelocidadMedia(int velocidadMedia) {
        this.velocidadMedia = velocidadMedia;
    }

    public double getKmDistRecorrida() {
        return kmDistRecorrida;
    }

    public void setKmDistRecorrida(double kmDistRecorrida) {
        this.kmDistRecorrida = kmDistRecorrida;
    }

    public double getKmParada() {
        return kmParada;
    }

    public void setKmParada(double kmParada) {
        this.kmParada = kmParada;
    }

    public String getInicioPaseo() {
        return InicioPaseo;
    }

    public void setInicioPaseo(String InicioPaseo) {
        this.InicioPaseo = InicioPaseo;
    }

    public String getNomDueno() {
        return nomDueno;
    }

    public void setNomDueno(String nomDueno) {
        this.nomDueno = nomDueno;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getKmPtoActual() {
        return kmPtoActual;
    }

    public void setKmPtoActual(int kmPtoActual) {
        this.kmPtoActual = kmPtoActual;
    }

    public int getNumParadas() {
        return numParadas;
    }

    public void setNumParadas(int numParadas) {
        this.numParadas = numParadas;
    }

    public int getTiempoParada() {
        return tiempoParada;
    }

    public void setTiempoParada(int tiempoParada) {
        this.tiempoParada = tiempoParada;
    }
        
    //calcular datos del viaje
    public void calcularDatosDelViaje(int finPaseo, int pararCoche){
        double tiempoRecorrido=0,kmRecorridos=0,knParada=0,restKm=0;
        int contParada=0, tiempoParada=0;
        try {
            Scanner teclado = new Scanner(System.in);
            knParada=getKmParada();
            contParada=getNumParadas();
            //validamos los datos al hacer una parada
            if(finPaseo==1 && pararCoche==2){
                //capturamos la distancia recorrida en el viaje
                System.out.print("¿Cuantos km/h Recorrió?:  ");
                setKmDistRecorrida(teclado.nextInt());  
                System.out.print("¿Cual fue la velocidad (km/h) media? ");
                setVelocidadMedia(teclado.nextInt());
                kmRecorridos = getKmDistRecorrida(); 
                //el coche para cada 50 km - validamos eso...
                while (kmRecorridos >= knParada){ 
                    //valiadamos la cantidad de paradas hechas
                    if(kmRecorridos < getKmParada()){
                        restKm = kmRecorridos - getKmParada();
                    }else{
                        restKm = kmRecorridos - getKmParada();
                        kmRecorridos=restKm;
                    }
                    contParada = contParada+1; //cantidad de paradas realizadas desde que el paseo comenzó
                    tiempoParada = (getTiempoParada()/60)*contParada;
                    tiempoRecorrido = (getKmDistRecorrida() / getVelocidadMedia()) + tiempoParada;
                }
                System.out.println("---------------------------------------------------");
                System.out.println("El coche realizó "+contParada+" paradas. ");
                System.out.println("El coche recorrió "+getKmDistRecorrida()+" km/h. ");
                System.out.println("El paseo duro "+tiempoRecorrido+" horas. ");
                              
            }else{
                System.out.println("OPCION NO VALIDA.");
            }
            System.out.println("---------------------------------------------------");
            System.out.println("FIN PROGRAMA");
        } catch (Exception e) {
            System.out.println("ERROR - "+e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        int parar=0, finPaseo=0;
        //instanciamos la clase
        Coche_Viaje cv = new Coche_Viaje();
        // capturamos los datos de entrada necesarios para procesar la informacion
        Scanner teclado = new Scanner(System.in);
        System.out.print("Ingrese nombre del dueño del coche: ");
        cv.setNomDueno(teclado.next());
        System.out.print("Ingrese modelo del coche: ");
        cv.setModelo(teclado.next());
        System.out.print("Ingrese marca del coche: ");
        cv.setMarca(teclado.next());
        System.out.print("Ingrese donde inicia el paseo: ");
        cv.setInicioPaseo(teclado.next());
        do{
            System.out.println("-----------------------------");
            System.out.println("¿Fin del paseo?");
            System.out.print("Ingrese 1(SI) ó 2(NO), según su criterio: ");
            finPaseo = teclado.nextInt();
            if (finPaseo == 1){
                cv.calcularDatosDelViaje(finPaseo,2);
            }else if (finPaseo == 2){
                System.out.println("¿Desea hacer una parada? ");
                System.out.print("Ingrese 1(SI) ó 2(NO), según su criterio: ");
                parar = teclado.nextInt();
                if(parar==1){
                    System.out.println("***El coche hizo una parada***");
                }else{
                    System.out.println("........COCHE ANDANDO.......");
                }
            }else{
                System.out.println("ERROR \nOPCION NO VALIDA");
            }
            
        }while(finPaseo==2);
        
    }
    
}
