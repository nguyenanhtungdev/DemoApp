package Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class QuanLyMayTinh implements Serializable {
	private static ArrayList<MayTinh> dsMayTinh;

	public QuanLyMayTinh() {
		this.dsMayTinh = new ArrayList<MayTinh>();
	}
	//Them may tinh
	public boolean themMayTinh(MayTinh mayTinh) {
		if(dsMayTinh.contains(mayTinh)) {
			return false;
		}
		dsMayTinh.add(mayTinh);
		return true;
	}
	//Xoa may tinh
	public boolean xoaMayTinh(int index) {
		dsMayTinh.remove(index);
		return true;
	}
	//Tim may tinh
	public int timMayTinh(String maMay) {
        OptionalInt find_Staff = IntStream.range(0, dsMayTinh.size())
                .filter(i -> dsMayTinh.get(i).getMaMay().equals(maMay))
                .findFirst();
        return find_Staff.orElse(-1); // Trả về -1 nếu không tìm thấy, hoặc trả về vị trí nếu tìm thấy.
	}
	public static ArrayList<MayTinh> getDsMayTinh() {
		return dsMayTinh;
	}
	public static void setDsMayTinh(ArrayList<MayTinh> dsMayTinh) {
		QuanLyMayTinh.dsMayTinh = dsMayTinh;
	}
	public int getSize() {
		return dsMayTinh.size();
	}
	public boolean checkNullI() {
		return dsMayTinh.isEmpty();
	}
}
