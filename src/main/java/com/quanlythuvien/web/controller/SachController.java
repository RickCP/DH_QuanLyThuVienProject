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

import com.quanlythuvien.persit.domain.Sach;
import com.quanlythuvien.persit.domain.TheLoaiSach;
import com.quanlythuvien.service.SachService;
import com.quanlythuvien.service.TheLoaiSachService;
import com.quanlythuvien.util.WebConstant;
import com.quanlythuvien.web.bean.SachMapper;
import com.quanlythuvien.web.bean.SachUI;
import com.quanlythuvien.web.bean.TheLoaiSachMapper;
import com.quanlythuvien.web.bean.TheLoaiSachUI;

/**
 * 
 * @author lvhuy08t2@gmail.com
 * 
 */
@Controller
public class SachController {
	@Autowired
	private TheLoaiSachService theLoaiSachService;
	@Autowired
	private SachService sachService;

	@RequestMapping(value = "/sach/list", method = RequestMethod.GET)
	public String hienThiDanhMucSach(Model model) {
		List<Sach> sachs = sachService.timTatCaCuonSach();
		List<SachUI> sachUIs = SachMapper.convertToListSachUI(sachs);
		model.addAttribute("sachUIs", sachUIs);
		return WebConstant.views.DANH_MUC_SACH;
	}

	@RequestMapping(value = "/sach/tracuusach", method = RequestMethod.GET)
	public String hienThiTraCuuSach(Model model) {
		return WebConstant.views.TRA_CUU_SACH;
	}

	@RequestMapping(value = "/sach/thongkesach", method = RequestMethod.GET)
	public String hienThiThongKeSach(Model model) {
		return WebConstant.views.THONG_KE_SACH;
	}

	@RequestMapping(value = "/sach/muontrasach", method = RequestMethod.GET)
	public String hienThiMuonTraSach(Model model) {
		return WebConstant.views.MUON_TRA_SACH;
	}

	@RequestMapping(value = "/sach/add", method = RequestMethod.GET)
	public String hienThiThemSach(Model model) {
		List<TheLoaiSach> theLoaiSachs = theLoaiSachService
				.timDanhMucTheLoaiSach();
		List<TheLoaiSachUI> theLoaiSachUIs = new ArrayList<TheLoaiSachUI>();
		if (theLoaiSachs.size() > 0) {
			for (TheLoaiSach theLoaiSach : theLoaiSachs) {
				TheLoaiSachUI tLSachUIL = new TheLoaiSachUI();
				tLSachUIL.setMaTheLoai(theLoaiSach.getMaTheLoai());
				tLSachUIL.setTenTheLoai(theLoaiSach.getTenTheLoai());
				theLoaiSachUIs.add(tLSachUIL);
			}
		}
		SachUI sachUI = new SachUI();
		sachUI.setMaSach(UUID.randomUUID().toString());
		model.addAttribute("theLoaiUIs", theLoaiSachUIs);
		model.addAttribute("sachUI", sachUI);
		model.addAttribute("btnName","Thêm Sách Mới");
		return WebConstant.views.THEM_SACH;
	}

	@RequestMapping(value = "/sach/add", method = RequestMethod.POST)
	public String create(SachUI sachUI, Model model) {
		TheLoaiSach theLoaiSach = theLoaiSachService.timTheLoaiSachByTen(sachUI
				.getTheLoaiUI());
		if (theLoaiSach != null) {
			Sach sach = SachMapper.convertToSach(sachUI, theLoaiSach);
			sachService.saveOrUpdate(sach);
		}

		return "redirect:/sach/list";
	}

	@RequestMapping(value = "/sach/edit", method = RequestMethod.GET)
	public String hienThiSuaSach( @RequestParam(value="maSach", required=true) String maSach, Model model) {
		Sach sachExisting = sachService.timSachByMaSach(maSach);
		if(sachExisting != null)
		{
			SachUI sachUI = SachMapper.convertToSachUI(sachExisting);
			model.addAttribute("sachUI",sachUI);
			List<TheLoaiSach> tLSs = theLoaiSachService.timDanhMucTheLoaiSach();
			List<TheLoaiSachUI> tLSUIs = TheLoaiSachMapper.convertToListTheLoaiSachUI(tLSs);
			model.addAttribute("theLoaiUIs", tLSUIs);
		}
		model.addAttribute("btnName","Sửa Thông Tin Sách");
		return WebConstant.views.THEM_SACH;

	}
	
	@RequestMapping(value = "/sach/delete",method =RequestMethod.GET)
	public String delete(@RequestParam(value ="maSach") String maSach)
	{
		Sach sachExisting = sachService.timSachByMaSach(maSach);
		if(sachExisting != null)
		{
			sachService.delete(sachExisting);
		}
		return "redirect:/sach/list";
	}

	
}
