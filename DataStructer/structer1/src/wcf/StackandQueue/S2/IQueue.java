package wcf.StackandQueue.S2;

public interface IQueue {
    public void clear();
    public void offer(Object x) throws Exception;//入队
    public boolean isEmpty();
    public int currentLength();
    public Object peek();//取队首元素
    public Object poll() throws Exception;//出队
}
