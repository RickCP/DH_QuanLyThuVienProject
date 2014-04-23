package com.quanlythuvien.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quanlythuvien.persit.domain.TheMuon;
import com.quanlythuvien.persit.repository.TheMuonRepository;

/**
 *
 * @author lvhuy08t2@gmail.com
 *
 */
@Service
public class TheMuonService {
	@Autowired
	private TheMuonRepository repo;
	public TheMuon create(TheMuon the)
	{
		return repo.save(the);
	}
}
