/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author Mónica
 */
public class Player extends Thread implements Runnable {
      private Socket connection;
      private ObjectInputStream input;
      private ObjectOutputStream output;
      private int playerNumber;
      private String mark;
      Servidor servidor;
      Tablero tablero;
      //protected boolean suspended = true;

      // set up Player thread
      public Player( Socket socket, int number, Servidor servidor, Compartido compartido )
      {

         playerNumber = number;

         // specify player's mark
         mark = ( playerNumber == 0 ? "ROJO" : "AZUL" );
         this.servidor=servidor;
         connection = socket;

         // obtain streams from Socket
         try {

            output = new ObjectOutputStream(
               connection.getOutputStream() );
            output.flush();
            output.writeObject("Conectado");
            input = new ObjectInputStream(
                                       connection.getInputStream() );

         }

         // process problems getting streams
         catch( Exception ioException ) {
            ioException.printStackTrace();
            System.exit( 1 );
         }
      }

      // send message that other player moved; message contains
      // a String followed by an int
      /*public void otherPlayerMoved( int location )
      {
         // send message indicating move
         try {
            output.writeUTF( "Opponent moved" );
            output.writeInt( location );
         }

         // process problems sending message
         catch ( IOException ioException ) {
            ioException.printStackTrace();
         }
      }*/

      // control thread's execution

      public void run()
      {

        while (true)
        {
                  try {
                              Thread.sleep( (int) ( Math.random() * 3000 ) );
                           }
                           catch( InterruptedException exception ) {
                              System.err.println( exception.toString() );
         }
         try {
            System.out.println("Prueba para ver si el servidor recibe");
            tablero = (Tablero) input.readObject();
           System.out.println(" "+tablero);
           // System.out.println(" "+dato);
            servidor.dialogo();

            //output.writeInt( location );
         }

         // process problems sending message
         catch ( Exception ioException ) {
            ioException.printStackTrace();
          }}
          }

     public void enviar(Tablero tablero){
                 try {
                             output.writeObject(tablero);
                             output.flush();
                             //servidor.dialogo(dato);
                             //output.writeInt( location );
                          }

                          // process problems sending message
                          catch ( IOException ioException ) {
                             ioException.printStackTrace();
          }

                 }
      // set whether or not thread is suspended
    /*  public void setSuspended( boolean status )
      {
         suspended = status;
      }*/

   }  // end class Player

