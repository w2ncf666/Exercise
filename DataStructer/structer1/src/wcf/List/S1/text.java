package wcf.List.S1;

import java.util.Scanner;

public class text {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        Sqlist sq=new Sqlist(5);
        sq.insert(0,"我");
        sq.insert(1,1);
        sq.insert(2,3);
        sq.insert(3,"asd");
        sq.insert(4,"你");
        //sq.insert(5,"它");
        sq.display();
        //sq.clear();
        System.out.println("----------------------");
        sq.display();
        System.out.println(sq.get(3).equals("asd"));
        //sq.get(9);索引越界异常
        System.out.println(sq.indexof(5));
        //sq.get(5);
        System.out.println("---------------以上是顺序表------------------------");
        linkList L=new linkList();
        //L.buildFromHead(5);
        //L.buildFromEnd(4);
        //L.insert(0,5);  0位置非法
        L.insert(1,5);
        L.insert(2,"我");
        //L.insert(4,2);//4位置非法,因为3还没有元素
//        L.display();
//        System.out.println(L.currentLength());
//        L.remove(1);
//        System.out.println(L.currentLength());
//        L.clear();
//        System.out.println(L.currentLength());
//        System.out.println(L.isEmpty());
//        L.display();
        System.out.println(L.indexof("我"));
        System.out.println(L.indexof("你"));
        System.out.println(L.get(2));
        System.out.println("---------------以上是链表基本功能------------------------");
        //linkList L2=new linkList(4,true);
//        System.out.println("去重前");
//        L2.display();
//        System.out.println("去重后");
//        removeRepeatElem(L2);
//        L2.display();
        System.out.println("-------------------以上是链表去重测试----------------------");
//        linkList a=new linkList(5,true);
//        linkList b=new linkList(2,true);
//        linkList c=mergeLinkList(a, b);
//        System.out.println(c.get(6));
//        c.display();
        //System.out.println(new PolynNode(1, 5).data);
    }

    private static linkList mergeLinkList(linkList a, linkList b) {
        singleNode p1=a.head.next;
        singleNode p2=b.head.next;
        singleNode q=b.head;
        while(p1!=null&&p2!=null){
            if(Integer.parseInt((String)p1.data)<Integer.parseInt((String)p2.data)){
                q.next=p1;//q.next改变的是q结点的next域,而不是它下一个结点的值
                q=p1;
                p1=p1.next;
            }
            else{
                q.next=p2;
                q=p2;
                p2=p2.next;
            }
        }
        /*if(p1==null)
            q.next=p2;
        else q.next=p1;
        return b;*/
        q.next=(p1==null?p2:p1);
        return b;
    }

    private static void removeRepeatElem(linkList l) throws Exception {
        singleNode p=l.head.next,q;
        while(p!=null){
            q=p.next;
            int index=l.indexof(p.data);
            while(q!=null) {
                if (p.data.equals(q.data)){
                    l.remove(index+1);
                    index--;
                }
                index++;
                q=q.next;
            }
            p=p.next;
        }
    }

}
