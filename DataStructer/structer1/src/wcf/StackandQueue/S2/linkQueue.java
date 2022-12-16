package wcf.StackandQueue.S2;

import wcf.List.S1.singleNode;

public class linkQueue implements IQueue{
    private singleNode front;
    private singleNode rear;
    public linkQueue(){
        front=rear=null;
    }
    @Override
    public void clear() {
        front=rear=null;
    }

    @Override
    public void offer(Object x) throws Exception {
        singleNode s=new singleNode(x);
        if(isEmpty())
            front=rear=s;
        else{
            rear.next=s;
            rear=s;
        }
    }

    @Override
    public boolean isEmpty() {
        return front==null;
    }

    @Override
    public int currentLength() {
        singleNode p=front;
        int count=0;
        while (p!=null){
            count++;
            p=p.next;
        }
        return count;
    }

    @Override
    public Object peek() {
        return front.data;
    }

    @Override
    public Object poll() throws Exception {
        if(isEmpty())
            throw new Exception("当前链队列为空!");
        Object x=front.data;
        front=front.next;
        if(front==null)//此处注意!!!!不知道会不会错,教材写法是建立一个singleNode p=front,判断(p==rear)
            rear=null;
        return x;
    }
}
