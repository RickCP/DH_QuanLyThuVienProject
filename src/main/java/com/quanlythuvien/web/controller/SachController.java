package com.quanlythuvien.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.quanlythuvien.util.WebConstant;

/**
 * 
 * @author lvhuy08t2@gmail.com
 * 
 */
@Controller
public class SachController {
	@RequestMapping(value = "/sach/list", method = RequestMethod.GET)
	public String hienThiDanhMucSach(Model model) {
		return WebConstant.views.DANH_MUC_SACH;
	}

	@RequestMapping(value = "/sach/tracuusach", method = RequestMethod.GET)
	public String hienThiTraCuuSach(Model model) {
		return WebConstant.views.TRA_CUU_SACH;
	}

	@RequestMapping(value = "sach/thongkesach", method = RequestMethod.GET)
	public String hienThiThongKeSach(Model model) {
		return WebConstant.views.THONG_KE_SACH;
	}

	@RequestMapping(value = "sach/muontrasach", method = RequestMethod.GET)
	public String hienThiMuonTraSach(Model model) {
		return WebConstant.views.MUON_TRA_SACH;
	}
}
