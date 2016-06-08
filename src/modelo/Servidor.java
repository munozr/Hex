/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.IOException;
import java.net.ServerSocket;

/**
 *
 * @author Mónica
 */
public class Servidor{
   private ServerSocket server;
   private Player players[];
   private Compartido compartido;
   private Tablero tablero;


   // set up tic-tac-toe server and GUI that displays messages
   public Servidor(Tablero tablero)
   {
      //super( "Servidor de Hex" );
      this.tablero = tablero;

      players = new Player[ 2 ];


      // set up ServerSocket
      try {
         server = new ServerSocket( 5000, 2 );
         System.out.println("Servidor creado");
      }

      // process problems creating ServerSocket
      catch( IOException ioException ) {
         ioException.printStackTrace();
         System.exit( 1 );
      }
      crearCliente();

  }


public void dialogo(){

        players[0].enviar(tablero);
        players[1].enviar(tablero);
        }

public void crearCliente(){

  for ( int i = 0; i < players.length; i++ ) {

         // wait for connection, create Player, start thread
         try {
            players[ i ] = new Player( server.accept(), i ,this,compartido);
            players[ i ].start();
         }

         // process problems receiving connection from client
         catch( IOException ioException ) {
            ioException.printStackTrace();
            System.exit( 1 );
         }
      }
    }

public static void main (String arg[])
{
    Tablero tablero = new Tablero();
        Servidor servidor = new Servidor(tablero);
        }


}

