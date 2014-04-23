package com.quanlythuvien.web.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.quanlythuvien.persit.domain.DocGia;
import com.quanlythuvien.persit.domain.LoaiDocGia;
import com.quanlythuvien.util.DateUtil;

/**
 *
 * @author lvhuy08t2@gmail.com
 *
 */
public class DocGiaMapper {
	public static DocGiaUI convertToUI(DocGia dG)
	{
		DocGiaUI ui =new DocGiaUI();
		if(dG != null)
		{
			ui.setDiaChi(dG.getDiaChi());
			ui.setDienThoai(dG.getDienThoai());
			ui.setEmail(dG.getEmail());
			ui.setGioiTinh(dG.getGioiTinh());
			ui.setLoaiDG(dG.getLoaiDG().getTenDG());
			ui.setMaDG(dG.getMaDG());
			if(dG.getNgaySinh() != null)
			{
				ui.setNgaySinh(dG.getNgaySinh().toString());
			}
			else
			{
				ui.setNgaySinh(new Date().toString());
			}
			ui.setTenDG(dG.getTenDG());
		}
		return ui;
	}
	public static DocGia convetToEntity(DocGiaUI ui,LoaiDocGia lDG)
	{
		DocGia dG=new DocGia();
		if(ui != null)
		{
			dG.setDiaChi(ui.getDiaChi());
			dG.setDienThoai(ui.getDienThoai());
			dG.setEmail(ui.getEmail());
			dG.setGioiTinh(ui.getGioiTinh());
			dG.setLoaiDG(lDG);
			dG.setMaDG(ui.getMaDG());
			if(dG.getNgaySinh() != null)
			{
				dG.setNgaySinh(DateUtil.convertStringToDate(ui.getNgaySinh(),"mm/dd/yy"));
			}
			else
			{
				dG.setNgaySinh(new Date());
			}
			dG.setTenDG(ui.getTenDG());
		}
		return dG;
	}
	
	public static List<DocGiaUI> convertToListUI(List<DocGia> dGs)
	{
		List<DocGiaUI> uis =new ArrayList<DocGiaUI>();
		for(DocGia dg : dGs)
		{
			uis.add(convertToUI(dg));
		}
		return uis;
	}
	
	public static List<DocGia> convertToListEntity(List<DocGiaUI> uis,LoaiDocGia lDG)
	{
		List<DocGia> dGs =new ArrayList<DocGia>();
		for(DocGiaUI ui : uis)
		{
			dGs.add(convetToEntity(ui, lDG));
		}
		return dGs;
	}
	

}
