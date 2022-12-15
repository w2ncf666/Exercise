package wcf.List.S1;

public class text2 {
    public static void main(String[] args) throws Exception {
    /*    PolynList a2=new PolynList(1);
        PolynList a1=new PolynList(3);
        a1.addPolyn(a2);
        System.out.println("请再添加一项");
        Scanner sc=new Scanner(System.in);
        a1.insert(new PolynNode(sc.nextDouble(),sc.nextInt()));
        a1.display();*/
        Sqlist sq=new Sqlist(5);
        sq.insert(0,1);
        sq.insert(1,2);
        sq.insert(2,3);
        sq.insert(3,4);
        sq.insert(4,5);
        sq.display();
        //sq.reverse();
        sq.moveSome(1);
        sq.display();
        String s="123";
    }
}
