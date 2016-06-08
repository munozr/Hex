/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

/**
 *
 * @author Mónica
 */
import javax.swing.*;
import java.awt.*;
import modelo.Compartido;
import modelo.Tablero;

public class Ventana extends JFrame {
   Pizarra pizarra;
   Controles controles;
   Container contenedor;
    Compartido compartido;

   Graphics g;
   public Ventana(){
      super("HEX");
     // tablero=new Tablero();
       Tablero tablero = new Tablero();
          Compartido compartido=new Compartido (tablero,2);
      pizarra = new Pizarra(compartido.get());
      controles = new Controles(pizarra,tablero);
      contenedor = getContentPane();

      contenedor.add(pizarra,BorderLayout.CENTER);
      contenedor.add(controles,BorderLayout.SOUTH);
      setSize(400,400);
      setVisible(true);
   }

}