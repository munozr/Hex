/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import modelo.Tablero;
import vista.Controles;
import vista.Pizarra;

/**
 *
 * @author Mónica
 */
public class Manejador extends Thread implements ActionListener {
    Pizarra pizarra;
    Controles c;
  Graphics g;
  ObjectInputStream input;
  ObjectOutputStream output;
  Socket socket;
    Tablero tablero;
  public Manejador(Pizarra p,Controles c,Tablero tablero){
    pizarra = p;
    this.tablero=tablero;
    this.c = c;
     try {

         // make connection
         socket = new Socket(InetAddress.getByName( "localhost" ), 5000 );

         // get streams

         output = new ObjectOutputStream(socket.getOutputStream() );
         output.flush();
         input = new ObjectInputStream(socket.getInputStream() );
      }

      // catch problems setting up connection and streams
      catch ( Exception ioException ) {
         ioException.printStackTrace();
      }
  }

  public void run() {


    while (true)
    {
          try {
                      Thread.sleep( (int) ( Math.random() * 3000 ) );
                   }
                   catch( InterruptedException exception ) {
                      System.err.println( exception.toString() );
         }

          try {
                  System.out.println("Inicia la conexión");
                      this.tablero = (Tablero) input.readObject();
                      System.out.println("Ya recibio el tablero ");
                      //output.writeInt( location );
                   }

                   // process problems sending message
                   catch ( Exception ioException ) {
                      ioException.printStackTrace();
          }

  }

          }
  // METODO QUE MANEJA LOS EVENTOS
  public void actionPerformed(ActionEvent e){
           if ((e.getActionCommand().equals("Poner Ficha")))
                        {

                        int numX=Integer.parseInt(c.getEjeX());
                        int numY=Integer.parseInt(c.getEjeY());

                        pizarra.ponerFicha(numX,numY);
                        try{
                output.writeObject(tablero);
                System.out.println("Ya se conecto");
                            }

                            catch ( Exception ioException ) {
                                                      ioException.printStackTrace();
          }
                        }

}

}