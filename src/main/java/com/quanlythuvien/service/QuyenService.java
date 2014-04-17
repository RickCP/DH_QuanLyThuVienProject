package com.quanlythuvien.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quanlythuvien.persit.domain.Quyen;
import com.quanlythuvien.persit.repository.QuyenRepository;

/**
 * 
 * @author lvhuy08t2@gmail.com
 * 
 */
@Service
public class QuyenService {
	@Autowired
	private QuyenRepository quyenRepo;
	public Quyen create(Quyen quyen) {
		Quyen quyenSaved = quyenRepo.save(quyen);
		return quyenSaved;
	}
	

}
