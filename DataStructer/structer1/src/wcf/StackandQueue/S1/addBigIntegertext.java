package wcf.StackandQueue.S1;

import java.util.Scanner;

public class addBigIntegertext {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        System.out.println(add(sc.next(), sc.next()));
    }
    public static String add(String a, String b) throws Exception {
        linkStack L1 = numSplit(a);
        linkStack L2 = numSplit(b);
        linkStack result = new linkStack();
        boolean isup = false;
        int temp = 0;
        while (!L1.isEmpty() && !L2.isEmpty()) {
            temp = (int) L1.pop() + (int) L2.pop();
            if (isup) {
                temp++;
                isup = false;
            }
            if (temp < 10)
                result.push(temp);
            else {
                temp -= 10;
                result.push(temp);
                isup = true;
            }
        }
        linkStack L3 = L1.isEmpty() ? L2 : L1;
        temp = 0;
        while (!L3.isEmpty()) {
            temp = (int) L3.pop();
            if (isup) {
                temp++;
                isup = false;

                if (temp < 10)
                    result.push(temp);
                else {
                    temp -= 10;
                    result.push(temp);
                    isup = true;
                }
            } else result.push(temp);
        }
        if (isup)
            result.push((int) 1);
        StringBuilder sb = new StringBuilder();
        while (!result.isEmpty())
            sb.append(result.pop());
        return sb.toString();
    }

    private static linkStack numSplit(String s) throws Exception {
        linkStack L = new linkStack();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9')
                L.push(Integer.parseInt(c + ""));
            else throw new Exception("输入的不是纯数字");
        }
        return L;
    }
}
