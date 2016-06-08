/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;

/**
 *
 * @author Mónica
 */
public class Tablero implements Serializable
{

     private String tablero [][] =new String[6][6];

     public Tablero()
     {
     int i=0;
     int j=0;
     int n=0;
     for (i=0; i<6;i++)
     {
       for (j=0; j<6;j++)
       {
       tablero[i][j]=""+n;
       ++n;
       }

     }
     }//Fin del método constructor por omisión


     public void imprimirTablero()
     {
       int i=0;
       int j=0;
       for (i=0; i<6;i++)
          {
            for (j=0; j<6;j++)
            {
            System.out.print(""+tablero[i][j]+"\t");

            }
            System.out.println("");
          }
      }//Fin del método constructor por omisión

      public int guardarJugada (int turno, int columna, int fila)
      {


                      if (turno==0)
                      {
                       tablero[columna][fila]="ROJO";
                       turno=1;
                      }
                      else
                       {
                         tablero[columna][fila]="AZUL";
                         turno=0;

                       }
                       //System.out.println(" "+getCelda(columna,fila)+" "+columna+" "+fila);
                       return turno;
                    }


        public String getCelda (int columna, int fila)
        {
        return tablero[columna][fila];
        }

}
