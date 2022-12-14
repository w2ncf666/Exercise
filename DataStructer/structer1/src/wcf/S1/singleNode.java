package wcf.S1;

public class singleNode{
    public Object data;
    public singleNode next;
    public singleNode(){
        this(null,null);
    }
    public singleNode(Object data){
        this(data,null);
    }
    public singleNode(Object data,singleNode node){
        this.data=data;
        this.next=node;
    }
}
