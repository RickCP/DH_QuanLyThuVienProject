package com.quanlythuvien.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.quanlythuvien.persit.domain.TheLoaiSach;
import com.quanlythuvien.persit.repository.TheLoaiSachRepository;
import com.quanlythuvien.service.TheLoaiSachService;
import com.quanlythuvien.util.WebConstant;
import com.quanlythuvien.web.bean.TheLoaiSachUI;

/**
 * 
 * @author lvhuy08t2@gmail.com
 * 
 */
@Controller
public class TheLoaiSachController {
	@Autowired
	private TheLoaiSachService theLoaiSachService;
	@Autowired TheLoaiSachRepository theLoaiSachRepo;

	@RequestMapping(value = "/theloai/add", method = RequestMethod.GET)
	public String hienThiTheLoaiSach(Model model) {
		TheLoaiSachUI theLoaiSachUI = new TheLoaiSachUI();
		theLoaiSachUI.setMaTheLoai(UUID.randomUUID().toString());
		model.addAttribute("theLoaiSachUI", theLoaiSachUI);
		return WebConstant.views.THEM_THE_LOAI;
	}

	@RequestMapping(value = "/theloai/add", method = RequestMethod.POST)
	public String create(TheLoaiSachUI theLoaiSachUI, Model model) {
		
		if (theLoaiSachUI.getMaTheLoai() != null || !theLoaiSachUI.getMaTheLoai().equals("")) {			
			 TheLoaiSach existinsTheLoaiSach = theLoaiSachRepo.findOne(theLoaiSachUI.getMaTheLoai());			 
			if (existinsTheLoaiSach != null) {
				TheLoaiSach theLoaiSach = new TheLoaiSach();
				theLoaiSach.setMaTheLoai(existinsTheLoaiSach.getMaTheLoai());
				theLoaiSach.setTenTheLoai(theLoaiSachUI.getTenTheLoai());
				theLoaiSachService.edit(theLoaiSach);
				return "redirect:/theloai/list";				
			}
			else
			{   theLoaiSachUI.setMaTheLoai(UUID.randomUUID().toString());
				TheLoaiSach theLoaiSach = new TheLoaiSach();
				theLoaiSach.setMaTheLoai(theLoaiSachUI.getMaTheLoai());
				theLoaiSach.setTenTheLoai(theLoaiSachUI.getTenTheLoai());
				theLoaiSachService.create(theLoaiSach);
			}
		}
		return "redirect:/sach/add";
	}
	@RequestMapping(value = "/theloai/list", method = RequestMethod.GET)
	public String hienThiDanhMucTheLoaiSach(Model model) {
		TheLoaiSachUI theLoaiSachUI = new TheLoaiSachUI();
		model.addAttribute("theLoaiSachUI", theLoaiSachUI);
		model.addAttribute("btnName","Thêm Mới Thể Loại Sách");
		List<TheLoaiSach> theLoaiSachs = theLoaiSachService.timDanhMucTheLoaiSach();
		List<TheLoaiSachUI> theLoaiSachUIs = new ArrayList<TheLoaiSachUI>();
		if(theLoaiSachs.size() >0)
		{		
			for(TheLoaiSach theLoaiSach : theLoaiSachs)
			{
				TheLoaiSachUI tLSachUIL = new TheLoaiSachUI();
				tLSachUIL.setMaTheLoai(theLoaiSach.getMaTheLoai());
				tLSachUIL.setTenTheLoai(theLoaiSach.getTenTheLoai());
				theLoaiSachUIs.add(tLSachUIL);
			}
		}
		model.addAttribute("theLoaiSachUIs", theLoaiSachUIs);
		return WebConstant.views.THEM_THE_LOAI;
	}
	@RequestMapping(value="/theloai/delete",method = RequestMethod.GET)
	public String delete( @RequestParam(value="maTheLoai", required=true) String maTheLoai, Model model) {
		model.addAttribute("btnName","Thêm Mới Thể Loại Sách");
		theLoaiSachService.delete(maTheLoai);
		return "redirect:/theloai/list";
	}
	@RequestMapping(value="/theloai/edit",method = RequestMethod.GET)
	public String edit( @RequestParam(value="maTheLoai", required=true) String maTheLoai, Model model) {
		
		TheLoaiSach theLoaiSachupdate = theLoaiSachRepo.findOne(maTheLoai);
		model.addAttribute("btnName","Cập Nhật Thể Loại Sách");
		if(theLoaiSachupdate != null)
		{
			TheLoaiSachUI theLoaiSachUI = new TheLoaiSachUI();
			theLoaiSachUI.setMaTheLoai(theLoaiSachupdate.getMaTheLoai());
			theLoaiSachUI.setTenTheLoai(theLoaiSachupdate.getTenTheLoai());
			model.addAttribute("theLoaiSachUI", theLoaiSachUI);
		}
		List<TheLoaiSach> theLoaiSachs = theLoaiSachService.timDanhMucTheLoaiSach();
		List<TheLoaiSachUI> theLoaiSachUIs = new ArrayList<TheLoaiSachUI>();
		if(theLoaiSachs.size() >0)
		{		
			for(TheLoaiSach theLoaiSach : theLoaiSachs)
			{
				TheLoaiSachUI tLSachUIL = new TheLoaiSachUI();
				tLSachUIL.setMaTheLoai(theLoaiSach.getMaTheLoai());
				tLSachUIL.setTenTheLoai(theLoaiSach.getTenTheLoai());
				theLoaiSachUIs.add(tLSachUIL);
			}
		}
		model.addAttribute("theLoaiSachUIs", theLoaiSachUIs);
		
		return WebConstant.views.THEM_THE_LOAI;
	}

}
