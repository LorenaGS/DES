/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package des;

import java.util.Scanner;

/**
 *
 * @author ADMINW7
 */
public class DESprincipal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner opcion1 = new Scanner(System.in);
        int [][]c=new int [16][28];
        int [][]d=new int [16][28];
        int [][]subkeys=new int [16][48];
        int opcion_menu;
        
        do{
        menu();
        opcion_menu=opcion1.nextInt();
        
        if(opcion_menu==1){
            System.out.println("1. Encriptar un mensaje");
            System.out.println("Hola niña linda!");
            int[] temp={0,0,0,1,0,0,1,1, 0,0,1,1,0,1,0,0, 0,1,0,1,0,1,1,1, 0,1,1,1,1,0,0,1, 1,0,0,1,1,0,1,1, 1,0,1,1,1,1,0,0,1,1,0,1,1,1,1,1, 1,1,1,1,0,0,0,1};
        
            int[] prueba=pc1(temp);
        
            int ejemplo=75;
            String bin = String.format("%8s", Integer.toBinaryString(ejemplo)).replace(' ','0');
            System.out.println(bin);
        
        
            System.out.println("Llave ingresada - k: ");
            for(int i=0;i<temp.length;i++){
                System.out.print(temp[i]);
            }
        
            System.out.println("\nAplicando PC-1(k)-k': ");
            for(int i=0;i<prueba.length;i++){
                System.out.print(prueba[i]);
            }
        
            //TO-DO: Terminar la generación de las 16 sub llaves
            for(int i=1;i<=16;i++){
                System.out.println("Sub-Key: " +i);
            }
            }
            //TO-DO: Hacer los stages
        }while(opcion_menu!=3);        
    }
    
    private static int[] pc1(int [] entrada_llave){
        int[] temporal=new int[56];
        temporal[0]=entrada_llave[56];
        temporal[1]=entrada_llave[48];
        temporal[2]=entrada_llave[40];
        temporal[3]=entrada_llave[32];
        temporal[4]=entrada_llave[24];
        temporal[5]=entrada_llave[16];
        temporal[6]=entrada_llave[8];
        temporal[7]=entrada_llave[0];
        temporal[8]=entrada_llave[57];
        temporal[9]=entrada_llave[49];
        temporal[10]=entrada_llave[41];
        temporal[11]=entrada_llave[33];
        temporal[12]=entrada_llave[25];
        temporal[13]=entrada_llave[17];
        temporal[14]=entrada_llave[9];
        temporal[15]=entrada_llave[1];
        temporal[16]=entrada_llave[58];
        temporal[17]=entrada_llave[50];
        temporal[18]=entrada_llave[42];
        temporal[19]=entrada_llave[34];
        temporal[20]=entrada_llave[26];
        temporal[21]=entrada_llave[18];
        temporal[22]=entrada_llave[10];
        temporal[23]=entrada_llave[2];
        temporal[24]=entrada_llave[59];
        temporal[25]=entrada_llave[51];
        temporal[26]=entrada_llave[43];
        temporal[27]=entrada_llave[35];
        temporal[28]=entrada_llave[62];
        temporal[29]=entrada_llave[54];
        temporal[30]=entrada_llave[46];
        temporal[31]=entrada_llave[38];
        temporal[32]=entrada_llave[30];
        temporal[33]=entrada_llave[22];
        temporal[34]=entrada_llave[14];
        temporal[35]=entrada_llave[6];
        temporal[36]=entrada_llave[61];
        temporal[37]=entrada_llave[53];
        temporal[38]=entrada_llave[45];
        temporal[39]=entrada_llave[37];
        temporal[40]=entrada_llave[29];
        temporal[41]=entrada_llave[21];
        temporal[42]=entrada_llave[13];
        temporal[43]=entrada_llave[5];
        temporal[44]=entrada_llave[60];
        temporal[45]=entrada_llave[52];
        temporal[46]=entrada_llave[44];
        temporal[47]=entrada_llave[36];
        temporal[48]=entrada_llave[28];
        temporal[49]=entrada_llave[20];
        temporal[50]=entrada_llave[12];
        temporal[51]=entrada_llave[4];
        temporal[52]=entrada_llave[27];
        temporal[53]=entrada_llave[19];
        temporal[54]=entrada_llave[11];
        temporal[55]=entrada_llave[3];
        return temporal;
    }
    
    private static int[] ls(int [] array, int contador){
        int[] temporal=new int[28];
        return temporal;
    }
    
    private static int[] pc2(int [] C,int [] D){
        int[] temporal=new int[48];
        return temporal;
    }
    
    private static int[] ip(){
        int[] temporal=new int[64];
        return temporal;
    }
    
    private static int[] ipm1(){
        int[] temporal=new int[64];
        return temporal;
    }
    
    private static int[] expantion(){
        int[] temporal=new int[48];
        return temporal;
    }
    
    private static int[] permutation(){
        int[] temporal=new int[32];
        return temporal;
    }
    
    private static void menu(){
        System.out.println("       Bienvenido a la implementación de DES");
        System.out.println("          Creado por:");
        System.out.println("            Deici Lorena Gomez Suarez");
        System.out.println("            David Fernando Espinel Sarmiento");
        System.out.println("Opciones disponibles: ");
        System.out.println("1. Encriptar mensaje");
        System.out.println("2. Desencriptar mensaje");
        System.out.println("3. Salir");
        System.out.println("Ingrese su opción: ");
        
    }
}
