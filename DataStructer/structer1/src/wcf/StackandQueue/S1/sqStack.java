package wcf.StackandQueue.S1;

public class sqStack implements IStack{
    private Object[]stackElem;
    private int top;
    public sqStack(int maxsize){
        top=0;
        stackElem=new Object[maxsize];
    }
    @Override
    public void clear() {
        top=0;
    }

    @Override
    public boolean isEmpty() {
        return top==0;
    }

    @Override
    public int currentLength() {
        return top;
    }

    @Override
    public Object peek() {//取栈顶元素
        if(isEmpty())
            return null;
        else return stackElem[top-1];
    }

    @Override
    public void push(Object x) throws Exception {
        if(currentLength()==stackElem.length)
            throw new Exception("栈已满!");
        stackElem[top++]=x;
    }

    @Override
    public Object pop() {
        if(isEmpty())
            return null;
        else
            return stackElem[--top];
    }
}
