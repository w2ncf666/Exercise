import java.util.Random;
import java.util.Scanner;

public class doubleball {
    public static void main(String[] args) {
        int[] arr1 = creatnumber();

        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + " ");
        }
        System.out.println("-------------------------------");
        int[] arr2 = userinput();
        money(arr1, arr2);
    }

    public static int[] creatnumber() {
        int[] arr = new int[7];
        Random r = new Random();
        for (int i = 0; i < 6; ) {
            int rednumber = r.nextInt(33) + 1;
            if (!iscontain(arr, rednumber)) {
                arr[i] = rednumber;
                i++;
            }
        }
        int bluenumber = r.nextInt(16) + 1;
        arr[6] = bluenumber;
        return arr;
    }

    public static boolean iscontain(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x)
                return true;
        }
        return false;
    }

    public static int[] userinput() {
        int[] arr = new int[7];
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < 6; ) {
            System.out.println("请输入第" + (i + 1) + "个红球号码");
            int rednumber = input.nextInt();
            if (rednumber >= 1 && rednumber <= 33) {
                if (iscontain(arr, rednumber))
                    System.out.println("已存在该红球号码。");
                else {
                    arr[i] = rednumber;
                    i++;
                }
            } else System.out.println("当前红球号码超出范围。");
        }
        while (true) {
            System.out.println("请输入篮球号码");
            int blueNumber = input.nextInt();
            if (blueNumber >= 1 && blueNumber <= 16) {
                arr[6] = blueNumber;
                break;
            } else System.out.println("当前蓝球号码超出范围");
        }
        return arr;
    }

    public static void money(int[] arr1, int[] arr2) {
        int redcount = 0;
        int bluecount = 0;
        for (int i = 0; i < arr1.length - 1; i++)
            for (int i1 = 0; i1 < arr2.length - 1; i1++)
                if (arr1[i] == arr2[i1]) {
                    redcount++;
                    break;
                }

        if (arr1[arr1.length - 1] == arr2[arr2.length - 1])
            bluecount++;
        System.out.println(bluecount);
        System.out.println(redcount);
        if (redcount == 6 && bluecount == 1) {
            System.out.println("恭喜你中奖1000万！");
        } else if (redcount == 6 && bluecount == 0) {
            System.out.println("恭喜你中奖500万！");
        } else if (redcount == 5 && bluecount == 1) {
            System.out.println("恭喜你中奖3000元！");
        } else if ((redcount == 5 && bluecount == 0) || (redcount == 4 && bluecount == 1)) {
            System.out.println("恭喜你中奖200元！");
        } else if ((redcount == 4 && bluecount == 0) || (redcount == 3 && bluecount == 1)) {
            System.out.println("恭喜你中奖10元！");
        } else if ((redcount == 2 && bluecount == 1) || (redcount == 1 && bluecount == 1) || (redcount == 0 && bluecount == 1)) {
            System.out.println("恭喜你中奖5元！");
        } else {
            System.out.println("老霉币0元！");
        }
    }
}

