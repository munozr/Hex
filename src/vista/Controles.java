/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Manejador;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import modelo.Tablero;

/**
 *
 * @author Mónica
 */
public class Controles extends JPanel {
  private JButton boton;
  private JLabel etiquetaEjeX,etiquetaEjeY;
  private JTextField nombreEjeX,nombreEjeY;
  //public JButton boton;
  private Pizarra pizarra;
  private Manejador manejador;
  private Controles c;
  private Tablero tablero;

  public Controles(Pizarra p,Tablero tablero){
    pizarra = p;
    this.tablero =tablero;


    // Crear un manejador de eventos

    // Crear el vector de botones
    boton = new JButton("Poner Ficha");
    // Crear el botón para Poner Ficha
    //boton[0]=new JButton("Poner Ficha");
    etiquetaEjeX = new JLabel("Eje X:");
    nombreEjeX = new JTextField(5);
    etiquetaEjeY = new JLabel("Eje Y:");
    nombreEjeY = new JTextField(5);
    manejador = new Manejador(pizarra,this,tablero);
    manejador.start();
    //for(int i=0; i<boton.length; i++){
      add(boton);
      boton.addActionListener(manejador);
   // }

    add(etiquetaEjeX);
    add(nombreEjeX);
    add(etiquetaEjeY);
    add(nombreEjeY);
    nombreEjeX.addActionListener(manejador);
    nombreEjeY.addActionListener(manejador);
  }

  public String getEjeX()
  {
   return nombreEjeX.getText();
   }

  public String getEjeY()
  {
   return nombreEjeY.getText();
   }


}