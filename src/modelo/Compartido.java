/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Mónica
 */
public class Compartido {
   private Tablero tablero;

   //private int valorCompartido=-1;
   private boolean turnoJugador [];
   private boolean hayComida[]; //

   public Compartido(Tablero tablero, int jugadores){
   this.tablero=tablero;
   turnoJugador = new boolean [jugadores];

   }

   public synchronized boolean movidaValida(){
      boolean resultado = true;
      for(int i=0; i < turnoJugador.length ; i++)
         if(turnoJugador[i])
            resultado = false;
      return (resultado);
   }

   public synchronized void set( Tablero tablero )
   {
      while ( !movidaValida() ) {  // MIENTRAS QUE NO PUEDA ESCRIBIR
         try {
            wait();
         }
         catch ( InterruptedException e ) {
            e.printStackTrace();
         }
      }

      System.err.println( Thread.currentThread().getName() +"Va a jugar "  );


      // Decirle a consumidores que pueden comer
      //for(int i=0; i < hayComida.length ; i++)
      //   hayComida[i]=true;
      //this.tablero=tablero;
      // Despertar a los consumidores dormidos
      notifyAll();
   }

   public synchronized Tablero get()
   {
     /* String quienEs = new String(Thread.currentThread().getName()); // Nombre del Hilo
      int posicion = Integer.parseInt(quienEs.substring(2,quienEs.length()));

      while ( !turnoJugador[posicion] ) {   // not the consumer's turn
         try {
            wait();
         }
         catch ( InterruptedException e ) {
            e.printStackTrace();
         }
      }
      turnoJugador[posicion]= false;

      notifyAll();*/

      //System.err.println( quienEs +" se comio un " + valorCompartido );

      return tablero;
   }

}

