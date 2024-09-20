package Entity;

import java.io.Serializable;
import java.util.Objects;

public class MayTinh implements Serializable{
	private String maMay;
	private String tenMay;
	private String nhaCungCap;
	private int soLuong;
	public MayTinh(String maMay, String tenMay, String nhaCungCap, int soLuong) {
		super();
		this.maMay = maMay;
		this.tenMay = tenMay;
		this.nhaCungCap = nhaCungCap;
		this.soLuong = soLuong;
	}
	public MayTinh() {
		super();
	}
	public String getMaMay() {
		return maMay;
	}
	public void setMaMay(String maMay) {
		this.maMay = maMay;
	}
	public String getTenMay() {
		return tenMay;
	}
	public void setTenMay(String tenMay) {
		this.tenMay = tenMay;
	}
	public String getNhaCungCap() {
		return nhaCungCap;
	}
	public void setNhaCungCap(String nhaCungCap) {
		this.nhaCungCap = nhaCungCap;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maMay);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
//		if (getClass() != obj.getClass())
//			return false;
		MayTinh other = (MayTinh) obj;
		return Objects.equals(maMay, other.maMay);
	}
	@Override
	public String toString() {
		return "MayTinh [maMay=" + maMay + ", tenMay=" + tenMay + ", nhaCungCap=" + nhaCungCap + ", soLuong=" + soLuong
				+ "]";
	}
}	
