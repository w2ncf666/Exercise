package wcf.StackandQueue.S2;

public class circleSqQueue implements IQueue{
    public Object[]queueElem;
    private int front;
    private int rear;
    public circleSqQueue(int maxsize){//创建一个多大的空队列
        queueElem=new Object[maxsize];
        front=rear=0;
    }
    @Override
    public void clear() {
        front=rear=0;
    }

    @Override
    public void offer(Object x) throws Exception {//入队
        if(isFull())
            throw new Exception("队列已满!");
        queueElem[rear]=x;
        rear=(rear+1)% queueElem.length;//循环队列
    }

    @Override
    public boolean isEmpty() {
        return front==rear;
    }

    @Override
    public int currentLength() {
        return (rear-front+queueElem.length)%queueElem.length;
    }

    public boolean isFull() {
        return front==(rear+1)%queueElem.length;
    }

    @Override
    public Object peek() {//取队首
        if(isEmpty())
            return null;
        return queueElem[front];
    }

    @Override
    public Object poll() throws Exception {//出队
        if(isEmpty())
            throw new Exception("当前队列为空!");
        Object t=queueElem[front];
        front=(front+1)%queueElem.length;
        return t;
    }
}
