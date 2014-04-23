package com.quanlythuvien.web.bean;

import java.util.ArrayList;
import java.util.List;

import com.quanlythuvien.persit.domain.LoaiDocGia;



/**
 *
 * @author lvhuy08t2@gmail.com
 *
 */
public class LoaiDocGiaMapper {
	
	public static LoaiDocGiaUI convertToUI(LoaiDocGia loaiDG)
	{
		LoaiDocGiaUI ui =new LoaiDocGiaUI();
		if(loaiDG != null)
		{
			ui.setMaDG(loaiDG.getMaDG());
			ui.setTenDG(loaiDG.getTenDG());
		}
		return ui;
	}
	public static LoaiDocGia convertToEntity(LoaiDocGiaUI loaiDGUI)
	{
		LoaiDocGia entity =new LoaiDocGia();
		if(loaiDGUI != null)
		{
			entity.setMaDG(loaiDGUI.getMaDG());
			entity.setTenDG(loaiDGUI.getTenDG());
		}
		return entity;
	}
	
	public static List<LoaiDocGiaUI> convertToListUI(List<LoaiDocGia> loaiDGs)
	{
		List<LoaiDocGiaUI> uis =new ArrayList<LoaiDocGiaUI>();
		for(LoaiDocGia dg : loaiDGs)
		{
			uis.add(convertToUI(dg));
		}
		return uis;
	}
	public static List<LoaiDocGia> convertToListEntity(List<LoaiDocGiaUI> loaiDGUIs)
	{
		List<LoaiDocGia> entities =new ArrayList<LoaiDocGia>();
		for(LoaiDocGiaUI dg : loaiDGUIs)
		{
			entities.add(convertToEntity(dg));
		}
		return entities;
	}

}
