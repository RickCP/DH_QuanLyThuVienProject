package com.quanlythuvien.service;

import java.util.UUID;

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
public class TaiKhoanService {
	@Autowired
	private QuyenRepository quyenRepo;
	public Quyen create()
	{
		Quyen quyen =new Quyen();
		quyen.setMaQuyen(UUID.randomUUID().toString());
		quyen.setTenQuyen("Admin");
		quyenRepo.save(quyen);
		return quyen;
	}

}
