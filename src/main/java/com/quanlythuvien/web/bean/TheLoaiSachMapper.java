package com.quanlythuvien.web.bean;

import java.util.ArrayList;
import java.util.List;

import com.quanlythuvien.persit.domain.TheLoaiSach;

/**
 *
 * @author lvhuy08t2@gmail.com
 *
 */
public class TheLoaiSachMapper {
  public static TheLoaiSachUI convertToUI(TheLoaiSach theLoaiSach)
  {   TheLoaiSachUI tLUI = new TheLoaiSachUI();
	  if(theLoaiSach != null)
	  {
		  tLUI.setMaTheLoai(theLoaiSach.getTenTheLoai());
		  tLUI.setTenTheLoai(theLoaiSach.getTenTheLoai());
	  }
	  return tLUI;
  }
  public static TheLoaiSach convertToTheLoaiSach(TheLoaiSachUI theLoaiSachUI)
  {
	  TheLoaiSach tlS =new TheLoaiSach();
	  if(tlS != null)
	  {
		  tlS.setMaTheLoai(theLoaiSachUI.getMaTheLoai());
		  tlS.setTenTheLoai(theLoaiSachUI.getTenTheLoai());
	  }
	  return tlS;
  }
  public static List<TheLoaiSach> convertToListTheLoaiSach(List<TheLoaiSachUI> tLSUIs)
  {
	  List<TheLoaiSach> tlSs =new ArrayList<TheLoaiSach>();
	  for(TheLoaiSachUI ui: tLSUIs)
	  {
		  tlSs.add(convertToTheLoaiSach(ui));
	  }
	  return tlSs;
  }
  public static List<TheLoaiSachUI> convertToListTheLoaiSachUI(List<TheLoaiSach> tlSs)
  {
	  List<TheLoaiSachUI>  tLSUIs = new ArrayList<TheLoaiSachUI>();
	  for(TheLoaiSach tlS : tlSs)
	  {
		  tLSUIs.add(convertToUI(tlS)); 
	  }
	  return tLSUIs;
  }
}
