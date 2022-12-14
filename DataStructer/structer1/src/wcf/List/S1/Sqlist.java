package wcf.List.S1;

public class Sqlist implements listMethod {
    private Object[] listElem;//数组
    private int current;//当前容量
    public Sqlist(int maxLength) {//初始化构造,根据maxLength创建
        listElem = new Object[maxLength];
        this.current = 0;
    }

    @Override
    public void clear() {
        current = 0;
    }

    @Override
    public void insert(int i, Object x) throws Exception {
        if (i < 0 || i > currentLength())
            throw new Exception("插入位置非法");
        if (current == listElem.length)
            throw new Exception("顺序表已满");
        for (int j = current - 1; j >= i; j--) {
            listElem[j + 1] = listElem[j];
        }
        listElem[i] = x;
        current++;
    }

    @Override
    public void display() throws Exception {//展示,遍历线性表
        for (int i = 0; i < current; i++)
            System.out.print(listElem[i] + " ");
        System.out.println();
    }

    @Override
    public void remove(int i) throws Exception {
        if (i < 0 || i > current - 1)
            throw new Exception("索引非法");
        for (int j = i; j < current - 1; j++) {
            listElem[j] = listElem[j + 1];
        }
        current--;
    }

    @Override
    public boolean isEmpty() {
        return current == 0;
    }

    @Override
    public int currentLength() {
        return current;
    }

    @Override
    public int indexof(Object x) {
        for (int i = 0; i < current; i++) {
            if (x.equals(listElem[i]))
                return i;
        }
        return -1;
    }

    @Override
    public Object get(int i) throws Exception {
        if (i < 0 || i > current - 1)
            throw new Exception("线性表索引非法!");
        return listElem[i];
    }
    public void reverse() throws Exception {
        int from=0,to=currentLength()-1;
        while (from<to){
            Object temp=get(from);
            listElem[from]=listElem[to];
            listElem[to]=temp;
            from++;
            to--;
        }
    }
    public void moveSome(int n) throws Exception {
        if(n<0)
            throw new Exception("移动的位数错误");
        Object []temp=new Object[currentLength()];
        for (int i = 0; i < currentLength(); i++) {
            temp[(i+n)%currentLength()]=listElem[i];
        }
        listElem=temp;
    }
}
