package DuLieu;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class LuuTru {
	public boolean LuuFile(Object object, String filePath) {
	    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
	        oos.writeObject(object);
	        oos.close();
	        return true;
	    } catch (Exception e) {
	        e.printStackTrace(); // Thay vì chỉ ném exception, in thông tin lỗi để kiểm tra.
	        return false;
	    }
	}
	public Object DocFile(String filePath) throws Exception{
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath));
		Object ob = ois.readObject();
		ois.close();
		return ob;
	}
}
