package com.quanlythuvien.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.quanlythuvien.util.WebConstant;

/**
 * 
 * @author lvhuy08t2@gmail.com
 * 
 */
@Controller
public class DocGiaController {
	@RequestMapping(value = "/docgia/list", method = RequestMethod.GET)
	public String hienThiDanhMucDG() {
		return WebConstant.views.DANH_MUC_DG;
	}
	@RequestMapping(value = "/docgia/add", method = RequestMethod.GET)
	public String hienThiThemDG()
	{
		return WebConstant.views.THEM_DG;
	}
	@RequestMapping(value = "/docgia/edit",method = RequestMethod.GET)
	public String hienThiUpdateDG()
	{
		return WebConstant.views.UPDATE_DG;
	}
	
	@RequestMapping(value = "/docgia/delete",method = RequestMethod.GET)
	public String deleteDG()
	{
		return "redirect: /docgia/list";
	}
	
	@RequestMapping(value = "/docgia/tracuudg",method = RequestMethod.GET)
	public String traCuuDG()
	{
		return WebConstant.views.TRA_CUU_DG;
	}

}
