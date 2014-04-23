package com.quanlythuvien.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quanlythuvien.persit.domain.LoaiDocGia;
import com.quanlythuvien.persit.repository.LoaiDocGiaRepository;

/**
 *
 * @author lvhuy08t2@gmail.com
 *
 */
@Service
public class LoaiDocGiaService {
	@Autowired
	private LoaiDocGiaRepository docGiaRepo;
	public LoaiDocGia create(LoaiDocGia dg)
	{
		return docGiaRepo.save(dg);
	}
	public LoaiDocGia edit(LoaiDocGia dg)
	{
		LoaiDocGia existingDG =docGiaRepo.findOne(dg.getMaDG());
		if(existingDG != null)
		{
			existingDG.setTenDG(dg.getTenDG());
		return	docGiaRepo.save(existingDG);
		}
		else
		return null;
	
	}
	public LoaiDocGia delete(LoaiDocGia dg)
	{
		LoaiDocGia existingDG =docGiaRepo.findOne(dg.getMaDG());
		if(existingDG != null)
		{
			docGiaRepo.delete(existingDG);
		}
		return null;
	}
	
	public List<LoaiDocGia> findAll()
	{
		return docGiaRepo.findAll();
	}
	
	public LoaiDocGia finByMaDG(String maDG)
	{
		return docGiaRepo.findOne(maDG);
	}
}
