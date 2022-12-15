package wcf.List.S2;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class text2 {
    public static void main(String[] args) throws Exception {
        ObjectOutputStream output=new ObjectOutputStream(new FileOutputStream("student.dat"));
        studentManageSystem sm=new studentManageSystem(50);
        sm.addStudent(new studentNode(10010,"温超凡","男",90,88));
        //sm.display();
        output.writeObject(sm);
    }
}
