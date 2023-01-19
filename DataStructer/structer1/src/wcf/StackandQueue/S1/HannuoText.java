package wcf.StackandQueue.S1;

public class HannuoText {
    static int count = 0;

    public static void main(String[] args) {
        hanNuo(3, "a", "b", "c");
    }

    public static void hanNuo(int n, String a, String b, String c) {
        if (n == 1)
            move(a, c,n);
        else {
            hanNuo(n-1,a,c,b);
            move(a,c,n);
            hanNuo(n-1,b,a,c);
        }
    }

    public static void move(String a, String b,int n) {
        System.out.println("第" + (++count) + "次将"+n+"号盘子从" + a + "移动到" + b);
    }
}
