package wcf.List.S2;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class text3 {
    public static void main(String[] args) throws Exception {
        ObjectInputStream input=new ObjectInputStream(new FileInputStream("student.dat"));
        studentManageSystem sm=(studentManageSystem) input.readObject();
        sm.display();
    }
}
