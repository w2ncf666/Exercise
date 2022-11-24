package text;

import java.util.Random;

public class text {
    public static void main(String[] args) {
        int[][] arr = new int[4][4];
        int[] temparr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        Random r = new Random();
        for (int i = 0; i < temparr.length; i++) {
            int index = r.nextInt(temparr.length);
            int temp = temparr[i];
            temparr[i] = temparr[index];
            temparr[index] = temp;

        }
        for (int i = 0; i < temparr.length; i++) {
            System.out.print(temparr[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < temparr.length; i++) {
            arr[i / 4][i % 4] = temparr[i];
        }
//        for (int i = 0; i < arr.length; i++) {
//           for (int j = 0; j < arr[i].length; j++) {
//               arr[i][j] = temparr[j];
//           }
      // }
       for (int i = 0; i < arr.length; i++) {
           for (int j = 0; j <arr[i].length; j++) {
               System.out.print(arr[i][j] + " ");
           }
       }

       System.out.println();
    }
}
