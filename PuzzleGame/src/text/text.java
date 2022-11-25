package text;

import java.util.Random;

import static text.codetext.getcode;

public class text {
    //    public static void main(String[] args) {
//        int[][] arr = new int[4][4];
//        int[] temparr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
//        Random r = new Random();
//        for (int i = 0; i < temparr.length; i++) {
//            int index = r.nextInt(temparr.length);
//            int temp = temparr[i];
//            temparr[i] = temparr[index];
//            temparr[index] = temp;
////
//        }
//        for (int i = 0; i < temparr.length; i++) {
//            System.out.print(temparr[i] + " ");
//        }
//        System.out.println();
//        for (int i = 0; i < temparr.length; i++) {
//            arr[i / 4][i % 4] = temparr[i];
//        }
////        for (int i = 0; i < arr.length; i++) {
////           for (int j = 0; j < arr[i].length; j++) {
////               arr[i][j] = temparr[j];
////           }
//      // }
//       for (int i = 0; i < arr.length; i++) {
//           for (int j = 0; j <arr[i].length; j++) {
//               System.out.print(arr[i][j] + " ");
//           }
//       }
//
//       System.out.println();
//    }
//    public static void main(String[] args) {
//        //System.out.println('9'-0);//a-z  97-122  65-90 48-57
//        char[] arr = new char[52];//a-z  97-122  65-90 48-57
//        for (int i = 0; i < arr.length; i++) {
//            if (i < 26)
//                arr[i] = (char) (97 + i);
//            else arr[i] = (char) (65 + i - 26);
//        }
////    for (int i = 0; i < arr.length; i++) {
////        System.out.print(arr[i]+" ");
////    }
//        Random r = new Random();
//        char[] code = new char[3];
//        for (int i = 0; i < 3; i++) {
//            int index = r.nextInt(52);
//            code[i] = (char) arr[index];
//        }
//        int a = r.nextInt(10);
//        String s = new String(code);
//        s+=a;
//        char[]c=s.toCharArray();
//    int index=r.nextInt(3);
//    char temp=c[index];
//    c[index]=c[c.length-1];
//    c[c.length-1]=temp;
//    c.toString();
//    String t=new String(c);
//    }
    public static void main(String[] args) {
        System.out.println(codetext.getcode());
    }
}
