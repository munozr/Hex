/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Graphics;
import javax.swing.JPanel;
import modelo.Compartido;
import modelo.Tablero;

/**
 *
 * @author Mónica
 */
public class Pizarra extends JPanel {
  private int x;
  private int y;
  private int numX;
  private int numY;
  private int turno=1;
  private Tablero tablero;
    Compartido compartido;
  int filaText=200;
  int columnaText=200;
  int [] posicionX= new int [36];
  int [] posicionY= new int [36];
  int [] numeroHex= new int [36];
  private String nombre;
  static final int COLUMNAINICIAL=100;
  static final int FILAINICIAL=300;
  private Pizarra p;
  //private Controles jugada;

  public Pizarra(Tablero tablero){
    this.tablero=tablero;
    x = 200;
    y = 200;
    //setEjeX(" ");
    //setEjeY(" ");
  }


  public void ponerFicha(int numX, int numY){


    turno=tablero.guardarJugada (turno, numX,numY);

        repaint();
  }

  public void abajo(){
    y+=10;
    repaint();
  }
  public void izquierda(){
    x-=10;
    repaint();
  }
  public void derecha(){
    x+=10;
    repaint();
  }


  public void paintComponent(Graphics g){
    super.paintComponent(g);
   //g.drawString(nombre,x,y);
    int fila=FILAINICIAL;
    int columna=COLUMNAINICIAL;

    int numero=0;
    int [] valorColumna = new int [6];
    int [] valorFila= new int [6];
    int colum=COLUMNAINICIAL;
    for (int j=0;j<=5;j++)
    {
      for (int i=0;i<=5;i++)
      {
        numero++;
        valorColumna[0]=columna;
        valorColumna[1]=columna+=20;
        valorColumna[2]=columna+=20;
        valorColumna[3]=columna;
        valorColumna[4]=columna-=20;
        valorColumna[5]=columna-=20;
        valorFila[0]=fila;
        valorFila[1]=fila-=20;
        valorFila[2]=fila+=20;
        valorFila[3]=fila+=20;
        valorFila[4]=fila+=20;
        valorFila[5]=fila-=20;
        g.drawPolygon(valorColumna,valorFila,6);
        columnaText=valorColumna[5]+5;
        filaText=valorFila[5]-5;
        posicionX[numero-1]=columnaText;
        posicionY[numero-1]=filaText;
        numeroHex[numero-1]=numero;
        //g.drawString(""+i,columnaText-50,filaText);
        g.drawString(" "+tablero.getCelda(i,j),columnaText,filaText);

        //g.fillPolygon(x,y,6);
        fila-=60;
        columna+=20;
      }
      g.drawString(""+j,columnaText+10,filaText-40);

      fila=FILAINICIAL;
      colum+=40;
      columna=colum;
    }
    columna=60;
    fila=350;
    for (int i =0 ; i<6; i++)
    {
                g.drawString (""+i,columna+=20,fila-=40);
        }
  }
  public void dibujaOval(Graphics g)
  {

    g.drawOval(200,200,50,50);
  }
}
