package wcf.StackandQueue.S1;

public interface IStack {
    public void clear();
    public boolean isEmpty();
    public int currentLength();
    public Object peek();
    public void push(Object x) throws Exception;
    public Object pop();
}
