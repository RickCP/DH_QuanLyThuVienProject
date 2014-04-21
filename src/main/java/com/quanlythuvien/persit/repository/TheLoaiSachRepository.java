package com.quanlythuvien.persit.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.quanlythuvien.persit.domain.TheLoaiSach;

/**
 *
 * @author lvhuy08t2@gmail.com
 *
 */
public interface TheLoaiSachRepository extends MongoRepository<TheLoaiSach,String> {
	@Query("{tenTheLoai : ?0 }")
	public TheLoaiSach timTheLoaiSachByTenLoaiSach(String tenTheLoai);

}
