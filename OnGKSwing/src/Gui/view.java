package Gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Scrollbar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import DuLieu.LuuTru;
import Entity.MayTinh;
import Entity.QuanLyMayTinh;


public class view extends JFrame implements ActionListener,KeyListener,MouseListener{
	private JButton button_them, button_xoa, button_xoaTrang, button_luu, bt_tim;
	private JTextField jTextField_maMay, jTextField_tenMay, jTextField_soLuong, jTextField_find;
	private JTable jTable_maytinh;
	private DefaultTableModel defaultTableModel_mayTinh;
	private JComboBox jComboBox_Ncc;
	private MayTinh mayTinh = new MayTinh();
	private QuanLyMayTinh quanLyMayTinh = new QuanLyMayTinh();
	private LuuTru luuTru = new LuuTru();
	
	public view() throws Exception {
		//docFile(); 
		createGUI();
	}
	public static void main(String[] args) throws Exception {
		new view();
	}
	public void createGUI() {
		this.setTitle("Chương trình quản lý máy laptop");
		this.setSize(650,700);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel container = new JPanel(new BorderLayout());
		JPanel jPanel_North = new JPanel();
		JPanel jPanel_Center = new JPanel();
		JPanel jPanel_South = new JPanel();
		
		JLabel jLabel_maMay = new JLabel("Mã máy:");
		JLabel jLabel_tenMay =  new JLabel("Tên máy:");
		JLabel jLabel_nhaCungCap = new JLabel("Nhà cung cấp:");
		JLabel jLabel_soLuong = new JLabel("Số Lượng");
		JLabel jLabel_timKiem = new JLabel("Nhập mã máy cần tìm:");
		
		jTextField_maMay = new JTextField(30);
		jTextField_tenMay = new JTextField(30);
		jTextField_soLuong = new JTextField(30);
		jTextField_find = new JTextField(10);
		
		button_them = new JButton("Thêm");
		button_luu = new JButton("Lưu");
		button_xoa = new JButton("Xóa");
		button_xoaTrang = new JButton("Xóa trắng");
		bt_tim = new JButton("Tìm");
		String[] header = {"Mã máy","Tên máy","Nhà cung cấp","Số lượng"}; 
		defaultTableModel_mayTinh = new DefaultTableModel(header, 0) {
		    @Override
		    public boolean isCellEditable(int row, int column) {
		        if (column == 4)
		            return true; // Cho phép chỉnh sửa cột 5 (index 4)
		        // Đặt tất cả các ô thành không thể chỉnh sửa
		        return false;
		    }
		};
		jTable_maytinh = new JTable(defaultTableModel_mayTinh);
		// Tiếp theo, bạn có thể gọi setRowCount(int) mà không gặp lỗi NullPointerException
		
		String s [] = {"Nguyễn Kim","Điện Máy","Thanh Tùng","FPT Shop"};
		jComboBox_Ncc = new JComboBox(s);
		
		final int width = 100;
		Box box, box1,box2,box3,box4,box5;
		box = Box.createVerticalBox();
		box1 = Box.createHorizontalBox();
		box2 = Box.createHorizontalBox();
		box3 = Box.createHorizontalBox();
		box4 = Box.createHorizontalBox();
		box5 = Box.createHorizontalBox();
		
		box1.add(jLabel_maMay);
		box1.add(Box.createHorizontalStrut(width));
		box1.add(jTextField_maMay);
		box2.add(jLabel_tenMay);
		box2.add(Box.createHorizontalStrut(width));
		box2.add(jTextField_tenMay);
		box3.add(jLabel_nhaCungCap);
		box3.add(Box.createHorizontalStrut(70));
		box3.add(jComboBox_Ncc);
		box4.add(jLabel_soLuong);
		box4.add(Box.createHorizontalStrut(width));
		box4.add(jTextField_soLuong);
		
		box.add(box1);
		box.add(box.createVerticalStrut(15));
		box.add(box2);
		box.add(box.createVerticalStrut(15));
		box.add(box3);
		box.add(box.createVerticalStrut(15));
		box.add(box4);
		
		jPanel_South.add(jLabel_timKiem);
		jPanel_South.add(jTextField_find);
		jPanel_South.add(bt_tim);
		jPanel_South.add(button_them);
		jPanel_South.add(button_xoa);
		jPanel_South.add(button_xoaTrang);
		jPanel_South.add(button_luu);
		
		jPanel_North.add(box);
		jPanel_Center.add(new JScrollPane(jTable_maytinh));
		jPanel_South.setBorder(BorderFactory.createTitledBorder("Chọn tác vụ"));
		container.add(jPanel_North,BorderLayout.NORTH);
		container.add(jPanel_Center,BorderLayout.CENTER);
		container.add(jPanel_South,BorderLayout.SOUTH);
		
		//Them su kien
		button_luu.addActionListener(this);
		button_them.addActionListener(this);
		button_xoa.addActionListener(this);
		button_xoaTrang.addActionListener(this);
		bt_tim.addActionListener(this);
		
		jTable_maytinh.addMouseListener(this);
		this.add(container);
		this.setVisible(true);
		this.setResizable(false);
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		// TODO Auto-generated method stub
		if(ob.equals(button_them)) {
			themMayTinh(mayTinh);
		}
		else if(ob.equals(button_xoaTrang)) {
			xoaTrang();
		}
		else if(ob.equals(button_xoa)) {
			int index = jTable_maytinh.getSelectedRow();
			if(index == -1) {
				JOptionPane.showMessageDialog(this,"Phải chọn dòng cần xóa!");
			}
			else {
				if(JOptionPane.showConfirmDialog(this,"Bạn có muốm xóa dòng này không?","Cảnh báo",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					defaultTableModel_mayTinh.removeRow(index);
					quanLyMayTinh.xoaMayTinh(index);
				}
			}
		}
		else if (ob.equals(bt_tim)) {
			int temp = quanLyMayTinh.timMayTinh(jTextField_find.getText());
			if(temp!=-1) {
				JOptionPane.showMessageDialog(this,"Tìm thấy máy tính");
				jTable_maytinh.setRowSelectionInterval(temp, temp);
			}
			else
				JOptionPane.showMessageDialog(this,"Không tìm thấy máy tính");
		}
		else if(ob.equals(button_luu)) {
			luuTru.LuuFile(quanLyMayTinh.getDsMayTinh(),"Data/dsmaytinh.txt");
			JOptionPane.showMessageDialog(this,"Lưu file thành công");
		}
	}
	//Bieu thuc chinh quy
	public boolean checkRangBuoc() {
		if(jTextField_maMay.getText().trim().equals("") || jTextField_soLuong.getText().equals("")) {
			JOptionPane.showMessageDialog(this,"Các trường không được bỏ trống");
			return false;
		}
		if(!jTextField_soLuong.getText().trim().matches("[0-9]+")) {
			JOptionPane.showMessageDialog(this,"Số lượng phải là kí số");
			return false;
		}
		return true;
	}
	//Them 1 may tinh vao table
	public void themMayTinh(MayTinh mayTinh) {
		if(checkRangBuoc()) {
			int soLuong = Integer.parseInt(jTextField_soLuong.getText().trim());
			mayTinh =  new MayTinh(jTextField_maMay.getText().trim(),jTextField_tenMay.getText().trim(),(String)jComboBox_Ncc.getSelectedItem(),soLuong);
			if(quanLyMayTinh.themMayTinh(mayTinh)) {
				Object ob[] = {
						mayTinh.getMaMay(),
						mayTinh.getTenMay(),
						mayTinh.getNhaCungCap(),
						Integer.toString(mayTinh.getSoLuong()) //Chuyen tu so sang chuoi
				};
				defaultTableModel_mayTinh.addRow(ob);
			}
			else {	
				JOptionPane.showMessageDialog(this,"Mã thêm vào bị trùng");
			}
		}
	}
	//Doc du lieu vao lai table
	private void docFile() throws Exception {
    		//Chuyển từ kiểu đối tượng về kiểu arraylist
    		ArrayList<MayTinh> dsMayTinh = (ArrayList<MayTinh>) luuTru.DocFile("Data/dsmaytinh.txt");
    		//Xóa dữ liệu cũ trước khi thêm dữ liệu mới 
    		defaultTableModel_mayTinh.setRowCount(0);
			for (MayTinh mt : dsMayTinh) {
				Object obj[] = {
					mt.getMaMay(),
					mt.getTenMay(),
					mt.getNhaCungCap(),
					Integer.toString(mt.getSoLuong())
				};
				quanLyMayTinh.themMayTinh(mt);//Phải thêm nhân viên vào trước khi lưu file dữ liệu tiếp theo
				defaultTableModel_mayTinh.addRow(obj);
			}
		
    }
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		hienThiDuLieu();
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	//Xoa trang 
		public void xoaTrang() {
			jTextField_maMay.setText("");
			jTextField_tenMay.setText("");
			jTextField_find.setText("");
			jTextField_soLuong.setText("");
			jComboBox_Ncc.setSelectedIndex(0);
		}
		//Hien thi du lieu tu bang vao lai    
		public void hienThiDuLieu() {
			int index =  jTable_maytinh.getSelectedRow();
			jTextField_maMay.setText((String)jTable_maytinh.getValueAt(index,0));
			jTextField_tenMay.setText((String)jTable_maytinh.getValueAt(index,1));
			jComboBox_Ncc.setSelectedItem((String)jTable_maytinh.getValueAt(index,2));
			jTextField_soLuong.setText((String)jTable_maytinh.getValueAt(index,3));
		}
}
