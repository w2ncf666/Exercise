package wcf.StackandQueue.S1;

import wcf.List.S1.singleNode;

public class linkStack implements IStack {
    private singleNode top;

    @Override
    public void clear() {
        top = null;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public int currentLength() {
        singleNode p=top;
        int length=0;
        while (p!=null){
            length++;
            p=p.next;
        }
        return length;
    }

    @Override
    public Object peek() {
        if (isEmpty())
            return null;
        else
            return top.data;
    }

    @Override
    public void push(Object x) throws Exception {
        singleNode s=new singleNode(x);
        s.next=top;
        top=s;
    }

    @Override
    public Object pop() {
        if(isEmpty())
            return null;
        singleNode s=top;
        top=top.next;
        return s.data;
    }
}
