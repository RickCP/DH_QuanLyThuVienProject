package com.quanlythuvien.web.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.quanlythuvien.persit.domain.DocGia;
import com.quanlythuvien.persit.domain.LoaiDocGia;
import com.quanlythuvien.service.DocGiaService;
import com.quanlythuvien.service.LoaiDocGiaService;
import com.quanlythuvien.util.WebConstant;
import com.quanlythuvien.web.bean.DocGiaMapper;
import com.quanlythuvien.web.bean.DocGiaUI;
import com.quanlythuvien.web.bean.LoaiDocGiaMapper;
import com.quanlythuvien.web.bean.LoaiDocGiaUI;

/**
 * 
 * @author lvhuy08t2@gmail.com
 * 
 */
@Controller
public class DocGiaController {
	@Autowired
	private DocGiaService dGService;
	@Autowired
	private LoaiDocGiaService lDGService;

	@RequestMapping(value = "/docgia/list", method = RequestMethod.GET)
	public String hienThiDanhMucDG(Model model) {
		List<DocGia> dGs = dGService.findAll();
		List<DocGiaUI> dGUIs = DocGiaMapper.convertToListUI(dGs);
		model.addAttribute("dGUIs", dGUIs);
		return WebConstant.views.DANH_MUC_DG;
	}

	@RequestMapping(value = "/docgia/add", method = RequestMethod.GET)
	public String hienThiThemDG(Model model) {
		DocGiaUI dGUI = new DocGiaUI();
		List<LoaiDocGia> lDGs = lDGService.findAll();
		List<LoaiDocGiaUI> lDGUIs = LoaiDocGiaMapper.convertToListUI(lDGs);
		model.addAttribute("lDGUIs", lDGUIs);
		model.addAttribute("dGUI", dGUI);
		model.addAttribute("btnName", "Thêm Mới Độc Giả");
		return WebConstant.views.THEM_DG;

	}
	@RequestMapping(value = "/docgia/add", method = RequestMethod.POST)
	public String addPost(DocGiaUI dGUI)
	{
		
		DocGia existingDG = dGService.finByMaDG(dGUI.getMaDG());
		LoaiDocGia existingLDG = lDGService.finByMaDG(dGUI.getLoaiDG());
		if(existingDG != null)
		{
			dGUI.setMaDG(existingDG.getMaDG());
			existingDG = DocGiaMapper.convetToEntity(dGUI,existingLDG);
			dGService.create(existingDG);
		}
		else
		{
			dGUI.setMaDG(UUID.randomUUID().toString());
			DocGia saved = DocGiaMapper.convetToEntity(dGUI,existingLDG);
			saved.setMaDG(dGUI.getMaDG());
			dGService.create(saved);
		}
		return "redirect:/docgia/list";
	}

	@RequestMapping(value = "/docgia/edit", method = RequestMethod.GET)
	public String hienThiUpdateDG(@RequestParam(value="maDG")String maDG,Model model) {
		DocGia existingDG = dGService.finByMaDG(maDG);
		DocGiaUI dGUI =new DocGiaUI();
		if(existingDG != null)
		{
			dGUI =DocGiaMapper.convertToUI(existingDG);
			
		}
		List<LoaiDocGia> lDGs = lDGService.findAll();
		List<LoaiDocGiaUI> lDGUIs = LoaiDocGiaMapper.convertToListUI(lDGs);
		model.addAttribute("lDGUIs", lDGUIs);
		model.addAttribute("dGUI", dGUI);
		model.addAttribute("btnName", "Sửa Thông Tin Độc Giả");
		return WebConstant.views.UPDATE_DG;
	}

	@RequestMapping(value = "/docgia/delete", method = RequestMethod.GET)
	public String deleteDG(@RequestParam(value="maDG")String maDG) {
		DocGia existingDG = dGService.finByMaDG(maDG);
		if(existingDG != null)
		{
			dGService.delete(existingDG);
		}
		return "redirect:/docgia/list";
	}

	@RequestMapping(value = "/docgia/tracuudg", method = RequestMethod.GET)
	public String traCuuDG() {
		return WebConstant.views.TRA_CUU_DG;
	}

}
