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
        int opcion_menu;
        int [][]C = new int[17][28];
        int [][]D = new int[17][28];
        int [][]subKey = new int[17][48];
        
        do{
        menu();
        opcion_menu=opcion1.nextInt();
        
        if(opcion_menu==1){
            System.out.println("1. Encriptar un mensaje");
            System.out.println("Hola niña linda!");
            int[] k={0,0,0,1,0,0,1,1, 0,0,1,1,0,1,0,0, 0,1,0,1,0,1,1,1, 0,1,1,1,1,0,0,1, 1,0,0,1,1,0,1,1, 1,0,1,1,1,1,0,0,1,1,0,1,1,1,1,1, 1,1,1,1,0,0,0,1};
        
            int[] k0=pc1(k);
        
            int ejemplo=75;
            String bin = String.format("%8s", Integer.toBinaryString(ejemplo)).replace(' ','0');
            System.out.println(bin);
        
        
            System.out.println("Llave ingresada - k: ");
            imprimirArray(k);
        
            System.out.println("\nAplicando PC-1(k)-k': ");
            imprimirArray(k0);
            
            for (int i=0;i< (k0.length)/2;i++){
                C[0][i] = k0 [i];
            }
            for (int i=(k0.length)/2;i< k0.length ;i++){
                D[0][i-28] = k0 [i];
            }
            
            //TO-DO: Terminar la generación de las 16 sub llaves
            for(int i=1;i<=16;i++){
                C[i]= ls(C[i-1],i);
                D[i]= ls(D[i-1],i);
                System.out.println("\nArray C" + i + ": ");
                imprimirArray(C[i]);
                System.out.println("\nArray D" + i + ": ");
                imprimirArray(D[i]);
                System.out.println("\nSub-Key: " +i );
                subKey[i] = pc2(C[i], D[i]);
                imprimirArray(subKey[i]);
            }
            }
            //TO-DO: Hacer los stages
        }while(opcion_menu!=3);        
    }
    
    private static int[] pc1(int [] entrada_llave){
        int[] temporal=new int[]{
        entrada_llave[56],entrada_llave[48],entrada_llave[40], entrada_llave[32],entrada_llave[24],
        entrada_llave[16],entrada_llave[8], entrada_llave[0],  entrada_llave[57],entrada_llave[49],
        entrada_llave[41],entrada_llave[33],entrada_llave[25], entrada_llave[17],entrada_llave[9],
        entrada_llave[1], entrada_llave[58],entrada_llave[50], entrada_llave[42],entrada_llave[34],
        entrada_llave[26],entrada_llave[18],entrada_llave[10], entrada_llave[2], entrada_llave[59],
        entrada_llave[51],entrada_llave[43],entrada_llave[35], entrada_llave[62],entrada_llave[54],
        entrada_llave[46],entrada_llave[38],entrada_llave[30], entrada_llave[22],entrada_llave[14],
        entrada_llave[6], entrada_llave[61],entrada_llave[53], entrada_llave[45],entrada_llave[37],
        entrada_llave[29],entrada_llave[21],entrada_llave[13], entrada_llave[5], entrada_llave[60],
        entrada_llave[52],entrada_llave[44],entrada_llave[36], entrada_llave[28],entrada_llave[20],
        entrada_llave[12],entrada_llave[4], entrada_llave[27], entrada_llave[19],entrada_llave[11],
        entrada_llave[3]};
        return temporal;
    }
    
    private static int[] ls(int[] array, int indice){
        int[] temporal = new int[28];
        if (indice == 1 || indice == 2 || indice ==  9 || indice == 16){
            for (int i = 0 ; i< (array.length)-1; i++ ){
                temporal[i] = array[i+1];               
            }
            temporal[27] = array[0];
        }
        else{
            for (int i = 0 ; i< (array.length)-2; i++ ){
                temporal[i] = array[i+2];               
            }
            temporal[26] = array[0];
            temporal[27] = array[1];
        }
        return temporal;
    }
    
    private static int[] pc2(int [] C,int [] D){
        int[] total = new int [56];
        for (int i = 0; i< C.length;i++){
            total[i]=C[i];
        }
        for (int i = 28; i< total.length;i++){
            total[i]=D[i-28];
        }
        int[] temporal=new int[]{
        total[13],total[16],total[10],total[23],total[0],total[4],total[2],total[27],total[14],total[5],
        total[20],total[9],total[22],total[18],total[11],total[3],total[25],total[7],total[15],total[6],
        total[26],total[19],total[12],total[1],total[40],total[51],total[30],total[36],total[46],total[54],
        total[29],total[39],total[50],total[44],total[32],total[47],total[43],total[48],total[38],total[55],
        total[33],total[52],total[45],total[42],total[49],total[35],total[28],total[31]};
        return temporal;
    }
    
    private static int[] ip(int [] mensaje){
        int[] temporal=new int[]{
        mensaje[57],mensaje[49],mensaje[41],mensaje[33],mensaje[25],mensaje[17],mensaje[9],mensaje[1],
        mensaje[59],mensaje[51],mensaje[43],mensaje[35],mensaje[27],mensaje[19],mensaje[11],mensaje[3],
        mensaje[61],mensaje[53],mensaje[45],mensaje[37],mensaje[29],mensaje[21],mensaje[13],mensaje[5],
        mensaje[63],mensaje[55],mensaje[47],mensaje[39],mensaje[31],mensaje[23],mensaje[15],mensaje[7],
        mensaje[56],mensaje[48],mensaje[40],mensaje[32],mensaje[24],mensaje[16],mensaje[8],mensaje[0],
        mensaje[58],mensaje[50],mensaje[42],mensaje[34],mensaje[26],mensaje[18],mensaje[10],mensaje[2],
        mensaje[60],mensaje[52],mensaje[44],mensaje[36],mensaje[28],mensaje[20],mensaje[12],mensaje[4],
        mensaje[62],mensaje[54],mensaje[46],mensaje[38],mensaje[30],mensaje[22],mensaje[14],mensaje[7]};
        return temporal;
    }
    
    private static int[] ipmenos1(int [] mensajef){
        int[] temporal=new int[]{
        mensajef[57],mensajef[49],mensajef[41],mensajef[33],mensajef[25],mensajef[17],mensajef[9],mensajef[1],
        mensajef[59],mensajef[51],mensajef[43],mensajef[35],mensajef[27],mensajef[19],mensajef[11],mensajef[3],
        mensajef[61],mensajef[53],mensajef[45],mensajef[37],mensajef[29],mensajef[21],mensajef[13],mensajef[5],
        mensajef[63],mensajef[55],mensajef[47],mensajef[39],mensajef[31],mensajef[23],mensajef[15],mensajef[7],
        mensajef[56],mensajef[48],mensajef[40],mensajef[32],mensajef[24],mensajef[16],mensajef[8],mensajef[0],
        mensajef[58],mensajef[50],mensajef[42],mensajef[34],mensajef[26],mensajef[18],mensajef[10],mensajef[2],
        mensajef[60],mensajef[52],mensajef[44],mensajef[36],mensajef[28],mensajef[20],mensajef[12],mensajef[4],
        mensajef[62],mensajef[54],mensajef[46],mensajef[38],mensajef[30],mensajef[22],mensajef[14],mensajef[7]};
        return temporal;
    }
    
    private static int[] expansion(int [] E){
        int[] temporal=new int[]{
        E[31],E[0],E[1],E[2],E[3],E[4],
        E[3],E[5],E[6],E[7],E[8],E[7],
        E[8],E[9],E[10],E[11],E[12],E[11],
        E[12],E[13],E[14],E[15],E[16],E[15],
        E[16],E[17],E[18],E[19],E[20],E[19],
        E[20],E[21],E[22],E[23],E[24],E[23],
        E[24],E[25],E[26],E[27],E[28],E[27],
        E[28],E[27],E[28],E[29],E[30],E[31],E[0]};
        return temporal;
    }
    
    private static int[] permutation(int [] mensaje){
        int[] temporal=new int[]{
        mensaje[15],mensaje[6],mensaje[19],mensaje[20],
        mensaje[28],mensaje[11],mensaje[27],mensaje[16],
        mensaje[0],mensaje[14],mensaje[22],mensaje[25],
        mensaje[4],mensaje[17],mensaje[30],mensaje[9],
        mensaje[1],mensaje[7],mensaje[23],mensaje[13],
        mensaje[31],mensaje[26],mensaje[2],mensaje[8],
        mensaje[18],mensaje[12],mensaje[29],mensaje[5],
        mensaje[21],mensaje[10],mensaje[3],mensaje[24]};
        return temporal;
    }
    
    private static void imprimirArray(int [] array){
        for (int i = 0; i< array.length;i++){
            System.out.print(array[i]);
        }
    }
    
    private static void menu(){
        System.out.println("\n     Bienvenido a la implementación de DES");
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
