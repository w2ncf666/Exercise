package wcf.S1;

import java.util.Scanner;

public class linkList implements listMethod {
    public singleNode head;

    public linkList() {
        head = new singleNode();
    }

    public linkList(int n, boolean order) throws Exception {
        this();
        if (order)
            buildFromEnd(n);
        else buildFromHead(n);
    }

    public void buildFromHead(int n) throws Exception {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            insert(1, sc.next());
        }
    }

    public void buildFromEnd(int n) throws Exception {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            insert(currentLength() + 1, sc.next());
        }
    }


    @Override
    public void clear() {
        head.next = null;
    }

    @Override
    public void insert(int i, Object x) throws Exception {
        singleNode p = head;
        int j = 1;
        while (j < i && p != null) {//这部分是找插入点的前驱
            p = p.next;
            j++;
        }
        if (j > i || p == null)
            throw new Exception("插入位置非法");
        singleNode s = new singleNode(x);
        s.next = p.next;
        p.next = s;
    }

    @Override
    public void display() {
        singleNode p = head.next;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    @Override
    public void remove(int i) throws Exception {
        int j = 1;
        singleNode p = head;
        while (j < i && p.next != null) {
            p = p.next;
            j++;
        }
        if (j > i || p.next == null)
            throw new Exception("第"+i+"个元素不存在");
        p.next = p.next.next;
    }

    @Override
    public boolean isEmpty() {
        return head.next == null;
    }

    @Override
    public int currentLength() {
        int count = 0;
        singleNode p = head;
        while ((p = p.next) != null)
            count++;
        return count;
    }

    @Override
    public int indexof(Object x) {//查不了重复的呃
        int i = 0;
        singleNode p = head;
        while ((p = p.next) != null) {
            i++;
            if (p.data.equals(x))
                return i;
        }
        return -1;
    }

    @Override
    public Object get(int i) throws Exception {
        int j = 0;
        singleNode p = head;
        while ((p = p.next) != null && ++j < i) ;
        if (p == null || j > i)
            throw new Exception("第"+i+"个元素不存在");
        else return p.data;
    }

}
