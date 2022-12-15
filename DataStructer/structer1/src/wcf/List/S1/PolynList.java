package wcf.List.S1;

import java.util.Scanner;

public class PolynList extends linkList {
    public PolynList() {
    }

    public PolynList(int n) throws Exception {
        head.data = new PolynNode(0, -1);
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            insert(currentLength() + 1, new PolynNode(sc.nextDouble(), sc.nextInt()));
        }
    }

    public void display() throws Exception {//重写父类的display方法
        for (int i = 1; i <= currentLength(); i++) {
            PolynNode p = (PolynNode) get(i);
            System.out.println("系数为" + p.coef + ",指数为" + p.expn);
        }
    }

    public void addPolyn(PolynList b) {//多项式相加
        singleNode q1=head.next;
        singleNode q2=b.head.next;
        singleNode Q=head;
        while (q1 != null&&q2!=null){
            PolynNode p1 = (PolynNode) (q1.data);
            PolynNode p2 = (PolynNode) (q2.data);
            switch (cmp(p1,p2)){
                case 0:
                    double sum=p1.coef+p2.coef;
                    if(sum==0.0){
                        q1=q1.next;
                        q2=q2.next;
                    }
                    else {
                        p1.coef=sum;
                        Q.next=q1;
                        Q=q1;
                        q1=q1.next;
                        q2=q2.next;
                    }
                    break;
                case -1:
                    Q.next=q1;
                    Q=q1;
                    q1=q1.next;
                    break;
                case 1:
                    Q.next=q2;
                    Q=q2;
                    q2=q2.next;
                    break;
            }
            Q.next=(q1==null?q2:q1);
        }
    }

    public int cmp(PolynNode a,PolynNode b) {//多项式指数的比较
        if(a.expn> b.expn)
            return 1;
        else if (a.expn< b.expn)
            return -1;
        else return 0;
    }
    public void insert(PolynNode b) throws Exception {
        if(b.expn==0)
            throw new Exception("指数为0,非法");
        int i=1;
        for (; i <= currentLength(); i++) {
            PolynNode p=(PolynNode) get(i);
            if(p.expn>b.expn)
                break;
        }
        insert(i,b);
    }
}

