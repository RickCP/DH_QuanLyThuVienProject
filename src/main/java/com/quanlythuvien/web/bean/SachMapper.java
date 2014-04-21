package com.quanlythuvien.web.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.quanlythuvien.persit.domain.Sach;
import com.quanlythuvien.persit.domain.TheLoaiSach;
import com.quanlythuvien.util.DateUtil;

/**
 * 
 * @author lvhuy08t2@gmail.com
 * 
 */
public class SachMapper {
	public static Sach convertToSach(SachUI sachUI, TheLoaiSach theLoaiSach) {
		Sach sach = new Sach();
		if (sachUI != null) {
			sach.setMaSach(sachUI.getMaSach());
			sach.setNamXuatBan(sachUI.getNamXuatBan());
			sach.setNgonNgu(sachUI.getNgonNgu());
			sach.setNhaXuatBan(sachUI.getNhaXuatBan());
			sach.setSoBanChuaMuon(sachUI.getSoBanChuaMuon());
			sach.setSoTrang(sachUI.getSoTrang());
			sach.setTacGia(sachUI.getTacGia());
			sach.setTenSach(sachUI.getTenSach());
			sach.setTinhTrang(sachUI.getTinhTrang());
			sach.setTongSoBan(sachUI.getTongSoBan());
			sach.setTheLoai(theLoaiSach);
			if (sachUI.getNgayNhap() == null || sachUI.getNgayNhap().equals("")) {
				sach.setNgayNhap(new Date());
			} else
				sach.setNgayNhap(DateUtil.convertStringToDate(
						sachUI.getNgayNhap(), "mm/dd/yy"));
		}
		return sach;
	}

	public static SachUI convertToSachUI(Sach sach) {
		SachUI sachUI = new SachUI();
		if (sach != null) {
			sachUI.setMaSach(sach.getMaSach());
			sachUI.setNamXuatBan(sach.getNamXuatBan());
			sachUI.setNgonNgu(sach.getNgonNgu());
			sachUI.setNhaXuatBan(sach.getNhaXuatBan());
			sachUI.setSoBanChuaMuon(sach.getSoBanChuaMuon());
			sachUI.setSoTrang(sach.getSoTrang());
			sachUI.setTacGia(sach.getTacGia());
			sachUI.setTenSach(sach.getTenSach());
			sachUI.setTinhTrang(sach.getTinhTrang());
			sachUI.setTongSoBan(sach.getTongSoBan());
			sachUI.setTheLoaiUI(sach.getTheLoai().getTenTheLoai());
			if (sach.getNgayNhap() != null)
				sachUI.setNgayNhap(sach.getNgayNhap().toString());
			else
				sachUI.setNgayNhap(new Date().toString());
		}
		return sachUI;
	}

	public static List<SachUI> convertToListSachUI(List<Sach> sachs) {
		List<SachUI> sachUIs = new ArrayList<SachUI>();
		for (Sach s : sachs) {
			sachUIs.add(convertToSachUI(s));
		}
		return sachUIs;
	}

	public static List<Sach> convertToListSach(List<SachUI> sachUIs,
			TheLoaiSach theLoaiSach) {
		List<Sach> sachs = new ArrayList<Sach>();
		for (SachUI sUI : sachUIs) {
			sachs.add(convertToSach(sUI, theLoaiSach));
		}
		return sachs;
	}

}
