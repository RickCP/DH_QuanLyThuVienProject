package com.quanlythuvien.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.quanlythuvien.service.QuyenService;
import com.quanlythuvien.service.TaiKhoanService;
import com.quanlythuvien.util.WebConstant;

/**
 * 
 * @author lvhuy08t2@gmail.com
 * 
 */
@Controller
public class TaiKhoanController {
	@Autowired
	private TaiKhoanService tkService;
	@Autowired
	private QuyenService quyenService;

	@RequestMapping(value = "/createTK", method = RequestMethod.GET)
	public String createTaiKhoan() {

		return WebConstant.views.TAO_TAIKHOAN;

	}

	@RequestMapping(value = "/tk/dangnhap", method = RequestMethod.GET)
	public String hienThiDangNhap() {
		return WebConstant.views.DANG_NHAP;
	}

	@RequestMapping(value = "/tk/dangnhap", method = RequestMethod.POST)
	public String xuLyDangNhap(Model model) {
		String error = "error";
		model.addAttribute("error", error);
		return WebConstant.views.DANG_NHAP;

	}

}
