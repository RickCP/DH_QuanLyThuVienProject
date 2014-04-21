package com.quanlythuvien.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quanlythuvien.persit.domain.Sach;
import com.quanlythuvien.persit.repository.SachRepository;

/**
 *
 * @author lvhuy08t2@gmail.com
 *
 */
@Service
public class SachService {
	@Autowired
	private SachRepository sachRepository;
	public List<Sach> timTatCaCuonSach()
	{
		return sachRepository.findAll();
	}
	public Sach saveOrUpdate(Sach sachNew)
	{
		return sachRepository.save(sachNew);
	}
	
	public Sach timSachByMaSach(String maSach)
	{
		return sachRepository.timSachByMaSach(maSach);
	}
	
	public void delete(Sach sach)
	{
		 sachRepository.delete(sach);
	}
	

}
