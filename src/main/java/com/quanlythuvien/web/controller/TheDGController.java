package com.quanlythuvien.web.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.quanlythuvien.persit.domain.DocGia;
import com.quanlythuvien.persit.domain.TheMuon;
import com.quanlythuvien.service.DocGiaService;
import com.quanlythuvien.service.LoaiDocGiaService;
import com.quanlythuvien.service.TheMuonService;
import com.quanlythuvien.util.WebConstant;
import com.quanlythuvien.web.bean.DocGiaMapper;
import com.quanlythuvien.web.bean.DocGiaUI;
import com.quanlythuvien.web.bean.TheMapper;
import com.quanlythuvien.web.bean.TheUI;

/**
 * 
 * @author lvhuy08t2@gmail.com
 * 
 */
@Controller
public class TheDGController {
	@Autowired
	private TheMuonService theService;
	@Autowired
	private DocGiaService dGService;
	@Autowired
	private LoaiDocGiaService lDGService;

	@RequestMapping(value = "/the/lapthedg", method = RequestMethod.GET)
	public String hienThiLapTheDG(Model model) {
		List<DocGia> dGs = dGService.findAll();
		TheUI theUI = new TheUI();
		List<DocGiaUI> dGUIs = DocGiaMapper.convertToListUI(dGs);
		model.addAttribute("dGUIs", dGUIs);
		model.addAttribute("theUI", theUI);
		model.addAttribute("theUI", theUI);
		model.addAttribute("displayBtn",null);
		return WebConstant.views.LAP_THE_DG;

	}

	@RequestMapping(value = "/the/list", method = RequestMethod.GET)
	public String hienThiThe() {
		return WebConstant.views.DANH_MUC_THE;
	}

	@RequestMapping(value = "/the/getdg/{maDG}", method = RequestMethod.GET)
	public String loadInformationDG(@PathVariable(value = "maDG") String maDG,
			Model model) {
		TheMuon the = new TheMuon();
		TheUI theUI = new TheUI();

		DocGia dG = dGService.finByMaDG(maDG);
		if (dG != null) {
			theUI = TheMapper.convertToUI(the, dG);
			theUI.setMaThe(UUID.randomUUID().toString());
		}
		List<DocGia> dGs = dGService.findAll();
		List<DocGiaUI> dGUIs = DocGiaMapper.convertToListUI(dGs);
		model.addAttribute("dGUIs", dGUIs);
		model.addAttribute("theUI", theUI);
		model.addAttribute("displayBtn", "displayBtn");
		return WebConstant.views.LAP_THE_DG;
	}
	@RequestMapping(value ="/the/lapthe",method =RequestMethod.POST)
	public String add(TheUI theUI,Model model)
	{	DocGia existingDG = dGService.finByMaDG(theUI.getMaDG());
		if(theUI != null)
		{
			if(existingDG != null)
			{
				TheMuon the = TheMapper.convertToEntity(theUI, existingDG);
				theService.create(the);
			}
			
		}
		model.addAttribute("info","error");
		return "redirect:/the/lapthedg";
	}
}
