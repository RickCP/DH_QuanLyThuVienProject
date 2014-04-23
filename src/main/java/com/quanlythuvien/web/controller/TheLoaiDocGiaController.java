package com.quanlythuvien.web.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.quanlythuvien.persit.domain.LoaiDocGia;
import com.quanlythuvien.service.LoaiDocGiaService;
import com.quanlythuvien.util.WebConstant;
import com.quanlythuvien.web.bean.LoaiDocGiaMapper;
import com.quanlythuvien.web.bean.LoaiDocGiaUI;

/**
 * 
 * @author lvhuy08t2@gmail.com
 * 
 */
@Controller
public class TheLoaiDocGiaController {
	@Autowired
	private LoaiDocGiaService dGService;

	@RequestMapping(value = "/loaidg/list", method = RequestMethod.GET)
	public String listGet(Model model) {
		List<LoaiDocGia> lDGs = dGService.findAll();
		List<LoaiDocGiaUI> loaiDGUIs = LoaiDocGiaMapper.convertToListUI(lDGs);
		model.addAttribute("loaiDGUIs", loaiDGUIs);
		model.addAttribute("loaiDGUI", new LoaiDocGiaUI());
		model.addAttribute("btnName", "Thêm Loại Độc Giả");
		return WebConstant.views.THEM_LOAI_DG;
	}

	@RequestMapping(value = "loaidg/add", method = RequestMethod.POST)
	public String addPost(LoaiDocGiaUI lDGUI, Model model) {
		if (lDGUI.getTenDG() != null || !lDGUI.getTenDG().equals("")) {
			LoaiDocGia existingLDG = dGService.finByMaDG(lDGUI.getMaDG());
			if (existingLDG != null) {
				existingLDG.setTenDG(lDGUI.getTenDG());
				dGService.create(existingLDG);
			} else {
				lDGUI.setMaDG(UUID.randomUUID().toString());
				LoaiDocGia lDG = LoaiDocGiaMapper.convertToEntity(lDGUI);
				dGService.create(lDG);
			}
		}
		return "redirect:/docgia/add";
	}

	@RequestMapping(value = "loaidg/edit", method = RequestMethod.GET)
	public String editGet(@RequestParam(value = "maDG") String maDG, Model model) {
		LoaiDocGia existingLDG = dGService.finByMaDG(maDG);
		LoaiDocGiaUI lDGUI = new LoaiDocGiaUI();
		if (existingLDG != null) {
			lDGUI = LoaiDocGiaMapper.convertToUI(existingLDG);

		}
		model.addAttribute("loaiDGUI", lDGUI);
		List<LoaiDocGia> lDGs = dGService.findAll();
		List<LoaiDocGiaUI> loaiDGUIs = LoaiDocGiaMapper.convertToListUI(lDGs);
		model.addAttribute("loaiDGUIs", loaiDGUIs);
		model.addAttribute("btnName", "Sửa Thông Tin Loại Độc Giả");
		return WebConstant.views.THEM_LOAI_DG;

	}

	@RequestMapping(value = "loaidg/delete", method = RequestMethod.GET)
	public String deleteGet(@RequestParam(value = "maDG") String maDG,
			Model model) {
		LoaiDocGia existingLDG = dGService.finByMaDG(maDG);
		if (existingLDG != null) {
			dGService.delete(existingLDG);
		}
		return "redirect:/loaidg/list";

	}

}
