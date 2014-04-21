package com.quanlythuvien.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quanlythuvien.persit.domain.TheLoaiSach;
import com.quanlythuvien.persit.repository.TheLoaiSachRepository;

/**
 * 
 * @author lvhuy08t2@gmail.com
 * 
 */
@Service
public class TheLoaiSachService {
	@Autowired
	private TheLoaiSachRepository theLoaiSachRepo;

	public TheLoaiSach create(TheLoaiSach theLoaiSach) {
		TheLoaiSach existingTheLoaiSach = theLoaiSachRepo.findOne(theLoaiSach
				.getMaTheLoai());
		if (existingTheLoaiSach == null)
			return theLoaiSachRepo.save(theLoaiSach);
		else
			return null;
	}

	public TheLoaiSach timTheLoaiSachByTen(String tenTheLoai) {
		return theLoaiSachRepo.timTheLoaiSachByTenLoaiSach(tenTheLoai);
	}

	public List<TheLoaiSach> timDanhMucTheLoaiSach() {
		return theLoaiSachRepo.findAll();
	}

	public void delete(String maTheLoai) {
		TheLoaiSach theLoaiSach = theLoaiSachRepo.findOne(maTheLoai);
		if (theLoaiSach != null) {
			theLoaiSachRepo.delete(theLoaiSach);
		}

	}

	public TheLoaiSach edit(TheLoaiSach TheLoaiSachUpdate) {
		TheLoaiSach existingTheLoaiSach = theLoaiSachRepo
				.findOne(TheLoaiSachUpdate.getMaTheLoai());
		if (existingTheLoaiSach != null)
			return theLoaiSachRepo.save(TheLoaiSachUpdate);
		else

			return null;
	}
}
