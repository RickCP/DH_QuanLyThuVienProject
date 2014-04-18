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
public class TheDGController {
	@RequestMapping(value = "/the/lapthedg", method = RequestMethod.GET)
	public String hienThiLapTheDG() {
		return WebConstant.views.LAP_THE_DG;
	}
	@RequestMapping(value = "/the/list", method = RequestMethod.GET)
	public String hienThiThe() {
		return WebConstant.views.DANH_MUC_THE;
	}
}
