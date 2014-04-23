package com.quanlythuvien.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quanlythuvien.persit.domain.DocGia;
import com.quanlythuvien.persit.repository.DocGiaRepository;

/**
 *
 * @author lvhuy08t2@gmail.com
 *
 */
@Service
public class DocGiaService {
	@Autowired
	private DocGiaRepository docGiaRepo;
	public DocGia create(DocGia dg)
	{
		return docGiaRepo.save(dg);
	}
	public DocGia edit(DocGia dg)
	{
		DocGia existingDG =docGiaRepo.findOne(dg.getMaDG());
		if(existingDG != null)
		{
			existingDG.setTenDG(dg.getTenDG());
		return	docGiaRepo.save(existingDG);
		}
		else
		return null;
	
	}
	public DocGia delete(DocGia dg)
	{
		DocGia existingDG =docGiaRepo.findOne(dg.getMaDG());
		if(existingDG != null)
		{
			docGiaRepo.delete(existingDG);
		}
		return null;
	}
	
	public List<DocGia> findAll()
	{
		return docGiaRepo.findAll();
	}
	
	public DocGia finByMaDG(String maDG)
	{
		return docGiaRepo.findOne(maDG);
	}
}
