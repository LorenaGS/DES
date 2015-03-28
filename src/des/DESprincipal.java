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
    
        public static int [][]S1 = {{14,4,13,1,2,15,11,8,3,10,6,12,5,9,0,7},{0,15,7,4,14,2,13,1,10,6,12,11,9,5,3,8},
            {4,1,14,8,13,6,2,11,15,12,9,7,3,10,5,0},{15,12,8,2,4,9,1,7,5,11,3,14,10,0,6,13}};
        public static int [][]S2 = {{15,1,8,14,6,11,3,4,9,7,2,13,12,0,5,10},{3,13,4,7,15,2,8,14,12,0,1,10,6,9,11,5},
            {0,14,7,11,10,4,13,1,5,8,12,6,9,3,2,15},{13,8,10,1,3,15,4,2,11,6,7,12,0,5,14,9}};
        public static int [][]S3 = {{10,0,9,14,6,3,15,5,1,13,12,7,11,4,2,8},{13,7,0,9,3,4,6,10,2,8,5,14,12,11,15,1},
            {13,6,4,9,8,15,3,0,11,1,2,12,5,10,14,7},{1,10,13,0,6,9,8,7,4,15,14,3,11,5,2,12}};
        public static int [][]S4 = {{7,13,14,3,0,6,9,10,1,2,8,5,11,12,4,15},{13,8,11,5,6,15,0,3,4,7,2,12,1,10,14,9},
            {10,6,9,0,12,11,7,13,15,1,3,14,5,2,8,4},{3,15,0,6,10,1,13,8,9,4,5,11,12,7,2,14}};
        public static int [][]S5 = {{2,12,4,1,7,10,11,6,8,5,3,15,13,0,14,9},{14,11,2,12,4,7,13,1,5,0,15,10,3,9,8,6},
            {4,2,1,11,10,13,7,8,15,9,12,5,6,3,0,14},{11,8,12,7,1,14,2,13,6,15,0,9,10,4,5,3}};
        public static int [][]S6 = {{12,1,10,15,9,2,6,8,0,13,3,4,14,7,5,11},{10,15,4,2,7,12,9,5,6,1,13,14,0,11,3,8},
            {9,14,15,5,2,8,12,3,7,0,4,10,1,13,11,6},{4,3,2,12,9,5,15,10,11,14,1,7,6,0,8,13}};
        public static int [][]S7 = {{4,11,2,14,15,0,8,13,3,12,9,7,5,10,6,1},{13,0,11,7,4,9,1,10,14,3,5,12,2,15,8,6},
            {1,4,11,13,12,3,7,14,10,15,6,8,0,5,9,2},{6,11,13,8,1,4,10,7,9,5,0,15,14,2,3,12}};
        public static int [][]S8 = {{13,2,8,4,6,15,11,1,10,9,3,14,5,0,12,7},{1,15,13,8,10,3,7,4,12,5,6,11,0,14,9,2},
            {7,11,4,1,9,12,14,2,0,6,10,13,15,3,5,8},{2,1,14,7,4,10,8,13,15,12,9,0,3,5,6,11}};

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner opcion1 = new Scanner(System.in);
        int opcion_menu;
        int [][]C = new int[17][28];
        int [][]D = new int[17][28];
        int [][]L = new int[17][32]; 
        int [][]R = new int[17][32];
        
                
        int [][]subKey = new int[17][48];
        
        do{
        menu();
        opcion_menu=opcion1.nextInt();
        
        if(opcion_menu==1){
            System.out.println("1. Encriptar un mensaje");
            System.out.println("Hola niña linda!");
            int[] k={0,0,0,1,0,0,1,1, 0,0,1,1,0,1,0,0, 0,1,0,1,0,1,1,1, 0,1,1,1,1,0,0,1, 1,0,0,1,1,0,1,1, 1,0,1,1,1,1,0,0,1,1,0,1,1,1,1,1, 1,1,1,1,0,0,0,1};
            int[] m={0,0,0,0,0,0,0,1,0,0,1,0,0,0,1,1,0,1,0,0,0,1,0,1,0,1,1,0,0,1,1,1,1,0,0,0,1,0,0,1,1,0,1,0,1,0,1,1,1,1,0,0,1,1,0,1,1,1,1,0,1,1,1,1};
            int[] k0=pc1(k);
        
            int ejemplo=75;
            String bin = String.format("%8s", Integer.toBinaryString(ejemplo)).replace(' ','0');
            //System.out.println(bin);
        
        
            //System.out.println("Llave ingresada - k: ");
            //imprimirArray(k);
        
            //System.out.println("\nAplicando PC-1(k)-k': ");
            //imprimirArray(k0);
            
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
                //System.out.println("\nArray C" + i + ": ");
                //imprimirArray(C[i]);
                //System.out.println("\nArray D" + i + ": ");
                //imprimirArray(D[i]);
                //System.out.println("\nSub-Key: " +i );
                subKey[i] = pc2(C[i], D[i]);
                //imprimirArray(subKey[i]);
            }
            int[] m0= ip(m); 
            //System.out.println("\nAplicando IP (m)-m': ");
            //imprimirArray(m0);
            
            for (int i=0;i< (m0.length)/2;i++){
                L[0][i] = m0 [i];
            }
            //System.out.println("\nLLLLLLL 0 ");
            //imprimirArray(L[0]);
            for (int i=(m0.length)/2;i< m0.length ;i++){
                R[0][i-32] = m0 [i];
            }
            //System.out.println("\nRRRRRRR 0");
            //imprimirArray(R[0]);
            
            for (int i = 1; i<= 16;i++){
                L[i]=R[i-1];
                R[i]= xor(L[i-1],f(R[i-1],subKey[i]));
                //System.out.println("\nLLLLLLL " + i);
                //imprimirArray(L[i]);
                //System.out.println("\nRRRRRRR " + i);
                //imprimirArray(R[i]);
            }
            int[] cipher = ipmenos1(R[16],L[16]);
            
            System.out.println("\nTEXTO CIFRADO!!! ");
            imprimirArray(cipher);
            }
        else{
            if(opcion_menu==2){
                System.out.println("2. Desencriptar un texto cifrado");
            System.out.println("Hola niña linda!");
            int[] k={0,0,0,1,0,0,1,1,0,0,1,1,0,1,0,0,0,1,0,1,0,1,1,1,0,1,1,1,1,0,0,1,1,0,0,1,1,0,1,1,1,0,1,1,1,1,0,0,1,1,0,1,1,1,1,1,1,1,1,1,0,0,0,1};
            int[] c={1,0,0,0,0,1,0,1,1,1,1,0,1,0,0,0,0,0,0,1,0,0,1,1,0,1,0,1,0,1,0,0,0,0,0,0,1,1,1,1,0,0,0,0,1,0,1,0,1,0,1,1,0,1,0,0,0,0,0,0,0,1,0,1};
            int[] k0=pc1(k);

            //System.out.println("Llave ingresada - k: ");
            //imprimirArray(k);
        
            //System.out.println("\nAplicando PC-1(k)-k': ");
            //imprimirArray(k0);
            
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
                //System.out.println("\nArray C" + i + ": ");
                //imprimirArray(C[i]);
                //System.out.println("\nArray D" + i + ": ");
                //imprimirArray(D[i]);
                //System.out.println("\nSub-Key: " +i );
                //subKey[i] = pc2(C[i], D[i]);
                //imprimirArray(subKey[i]);
            }
            int[] c0= ip(c); 
            //System.out.println("\nAplicando IP (m)-m': ");
            //imprimirArray(c0);
            
            for (int i=0;i< (c0.length)/2;i++){ 
                R[16][i] = c0 [i];
            }
            System.out.println("\nR 16 ");
            imprimirArray(R[16]);
            for (int i=(c0.length)/2;i< c0.length ;i++){
                L[16][i-32] = c0 [i];
            }
            System.out.println("\nL 16");
            imprimirArray(L[16]);
            
            for (int i = 16; i>= 1;i--){
                R[i-1]=L[i];
                L[i-1]= xor(R[i],f(L[i],subKey[i]));
                System.out.println("\nLLLLLLL " + (i-1));
                imprimirArray(L[i-1]);
                System.out.println("\nRRRRRRR " + (i-1));
                imprimirArray(R[i-1]);
            }
            int[] decipher = ipmenos1(L[0],R[0]);
            
            System.out.println("\nTEXTO DESCIFRADO!!! ");
            imprimirArray(decipher);
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
        total[33],total[52],total[45],total[41],total[49],total[35],total[28],total[31]};
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
        mensaje[62],mensaje[54],mensaje[46],mensaje[38],mensaje[30],mensaje[22],mensaje[14],mensaje[6]};
        return temporal;
    }
    
    private static int[] ipmenos1(int [] R , int [] L){
        int[] mensajef = new int [64];
        for (int i = 0; i< R.length;i++){
            mensajef[i]=R[i];
        }
        for (int i = 32; i< mensajef.length;i++){
            mensajef[i]=L[i-32];
        }
        int[] temporal=new int[]{
        mensajef[39],mensajef[7],mensajef[47],mensajef[15],mensajef[55],mensajef[23],mensajef[63],mensajef[31],
        mensajef[38],mensajef[6],mensajef[46],mensajef[14],mensajef[54],mensajef[22],mensajef[62],mensajef[30],
        mensajef[37],mensajef[5],mensajef[45],mensajef[13],mensajef[53],mensajef[21],mensajef[61],mensajef[29],
        mensajef[36],mensajef[4],mensajef[44],mensajef[12],mensajef[52],mensajef[20],mensajef[60],mensajef[28],
        mensajef[35],mensajef[3],mensajef[43],mensajef[11],mensajef[51],mensajef[19],mensajef[59],mensajef[27],
        mensajef[34],mensajef[2],mensajef[42],mensajef[10],mensajef[50],mensajef[18],mensajef[58],mensajef[26],
        mensajef[33],mensajef[1],mensajef[41],mensajef[9],mensajef[49],mensajef[17],mensajef[57],mensajef[25],
        mensajef[32],mensajef[0],mensajef[40],mensajef[8],mensajef[48],mensajef[16],mensajef[56],mensajef[24]};
        return temporal;
    }
    
    private static int[] expantion(int [] E){
        int[] temporal=new int[]{
        E[31],E[0],E[1],E[2],E[3],E[4],
        E[3],E[4],E[5],E[6],E[7],E[8],E[7],
        E[8],E[9],E[10],E[11],E[12],E[11],
        E[12],E[13],E[14],E[15],E[16],E[15],
        E[16],E[17],E[18],E[19],E[20],E[19],
        E[20],E[21],E[22],E[23],E[24],E[23],
        E[24],E[25],E[26],E[27],E[28],E[27],
        E[28],E[29],E[30],E[31],E[0]};
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
    
    private static int[] xor(int[] a,int[] b){
        int[] temporal = new int[a.length];
        for (int i=0; i< a.length; i++){
            if(a[i]==b[i]){
                temporal[i] = 0;
            }
            else{
                temporal[i] = 1;
            }
        }
        return temporal;
    }
    
    private static int[] f(int [] R, int [] K){
        int[] permutationT = new int[32];
        int[] temporal=new int[32];
        int[] exp = expantion(R);
        //System.out.println("\nAQUI ESTA EXP DENTRO DE F");
        //imprimirArray(exp);
        int[] result = xor(exp,K);
        //System.out.println("\nAQUI ESTA K");
        //imprimirArray(K);
        //System.out.println("\nAQUI ESTA RESUL XOR");
        //imprimirArray(result);
        int[][] B = new int[8][6];
        for (int i=0;i<8;i++){
            for(int j=0;j<6;j++){
                B[i][j]=result[(i*6)+j];
            }
        }
        int[][] C = new int[8][4];
        
        for (int i=0; i<8;i++){
            C[i]=seleccionbox(B[i],i);
        }
        for (int i=0;i<C.length;i++){
            for (int j=0;j<C[i].length;j++){
                temporal[(i*4)+j] = C[i][j];
            }
        }
        permutationT = permutation(temporal);
        //System.out.println("\nSALIDA DE F");
        //imprimirArray(permutationT);    
        return permutationT;
        
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
    
    private static int[] seleccionbox(int[] vectorB, int indice){
        int[] temporal=new int[4];
        
        String rtemp =Integer.toString(vectorB[0])+Integer.toString(vectorB[5]); 
        String ctemp=Integer.toString(vectorB[1])+Integer.toString(vectorB[2])+Integer.toString(vectorB[3])+Integer.toString(vectorB[4]);
        int r=Integer.parseInt(rtemp,2);
        int c=Integer.parseInt(ctemp,2);
        int resultado=0;
        
        switch(indice){
            case 0:
                resultado=S1[r][c];
                break;
            case 1:
                resultado=S2[r][c];
                break;
            case 2:
                resultado=S3[r][c];
                break;    
            case 3:
                resultado=S4[r][c];
                break;
            case 4:
                resultado=S5[r][c];
                break;
            case 5:
                resultado=S6[r][c];
                break;
            case 6:
                resultado=S7[r][c];
                break;
            case 7:
                resultado=S8[r][c];
                break; 
        }
        
        
        String binario = String.format("%4s", Integer.toBinaryString(resultado)).replace(' ','0');
        char[] charArray = binario.toCharArray();
                     
        for(int i=0;i<charArray.length;i++){
            if(charArray[i]=='0'){
                temporal[i]=0;
            }else{
                temporal[i]=1;
            }
        }
         
        return temporal;
    }
}
