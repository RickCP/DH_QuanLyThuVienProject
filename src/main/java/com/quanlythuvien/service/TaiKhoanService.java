package com.quanlythuvien.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quanlythuvien.persit.domain.TaiKhoan;
import com.quanlythuvien.persit.repository.QuyenRepository;
import com.quanlythuvien.persit.repository.TaiKhoanRepository;

/**
 *
 * @author lvhuy08t2@gmail.com
 *
 */
@Service
public class TaiKhoanService {
	@Autowired
	private QuyenRepository quyenRepo;
	@Autowired
	private TaiKhoanRepository taiKhoanRepo;
	public TaiKhoan create(TaiKhoan tk)
	{  
		TaiKhoan tkSaved = taiKhoanRepo.save(tk);
		return tkSaved;
	}
	
	public TaiKhoan timTKByTenTK(String tenTK)
	{   
		return taiKhoanRepo.timTKByTenTK(tenTK);
	}

}
