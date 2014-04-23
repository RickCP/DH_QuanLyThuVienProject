package com.quanlythuvien.web.bean;

import java.util.ArrayList;
import java.util.List;

import com.quanlythuvien.persit.domain.DocGia;
import com.quanlythuvien.persit.domain.TheMuon;
import com.quanlythuvien.util.DateUtil;

/**
 *
 * @author lvhuy08t2@gmail.com
 *
 */
public class TheMapper {
	public static TheUI convertToUI(TheMuon the,DocGia dg)
	{
		TheUI ui =new TheUI();
		if(the != null)
		{   
			ui.setLoaiThe(the.getLoaiThe());
			ui.setMaThe(the.getMaThe());
			if(the.getNgayHetHan() != null)
			ui.setNgayHetHan(the.getNgayHetHan().toString());
			else
			ui.setNgayHetHan(null);
			if(the.getNgayLapThe() != null)
			ui.setNgayLapThe(the.getNgayLapThe().toString());
			else
			ui.setNgayLapThe(null);
			ui.setDiaChi(dg.getDiaChi());
			ui.setDienThoai(dg.getDienThoai());
			ui.setEmail(dg.getEmail());
			ui.setGioiTinh(dg.getGioiTinh());
			ui.setLoaiDG(dg.getLoaiDG().getTenDG());
			ui.setMaDG(dg.getMaDG());
			if(dg.getNgaySinh() != null)
			ui.setNgaySinh(dg.getNgaySinh().toString());
			else
			ui.setNgaySinh(null);
			ui.setTenDG(dg.getTenDG());		
		}
		return ui;
	}
	public static TheMuon convertToEntity(TheUI ui, DocGia dG)
	{
		TheMuon the =new TheMuon();
		if(ui != null)
		{
			 the.setDocGia(dG);
			 the.setLoaiThe(ui.getLoaiThe());
			 the.setMaThe(ui.getMaThe());
			 the.setNgayHetHan(DateUtil.convertStringToDate(ui.getNgayHetHan(),"mm/dd/yy"));
			 the.setNgayLapThe(DateUtil.convertStringToDate(ui.getNgayLapThe(),"mm/dd/yy"));
		}
		return the;
	}
	
	public static List<TheUI> convertToLisUI(List<TheMuon> thes,DocGia dG)
	{
		List<TheUI> uis =new ArrayList<TheUI>();
		for(TheMuon the:thes)
		{
			uis.add(convertToUI(the,dG));
		}
		return uis;
	}
	public static List<TheMuon> convertToListEntity(List<TheUI> uis,DocGia dG)
	{
		List<TheMuon> thes =new ArrayList<TheMuon>();
		if(uis != null)
		{
			for(TheUI ui :uis)
			{
				thes.add(convertToEntity(ui, dG));
			}
		}
		return thes;
	}
}
