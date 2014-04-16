package com.quanlythuvien.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quanlythuvien.util.WebConstant;

/**
 * 
 * @author lvhuy08t2@gmail.com
 * 
 */
@Controller

public class MediatorController {
	@RequestMapping("/")
	public String getHomePage() {
		return WebConstant.views.TRANG_CHU;
	}
	@RequestMapping("/gioithieu")
	public String hienThiGioiThieu()
	{
		return WebConstant.views.GIOI_THIEU;
	}
}
