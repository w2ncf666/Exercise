package wcf.List.S1;

public interface listMethod {
    void clear();
     void insert(int i,Object x) throws Exception;
     void display() throws Exception;
     void remove(int i) throws Exception;
     boolean isEmpty();
     int currentLength();
     int indexof(Object x);
     Object get(int i) throws Exception;
}
