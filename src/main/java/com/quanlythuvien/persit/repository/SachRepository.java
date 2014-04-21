package com.quanlythuvien.persit.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.quanlythuvien.persit.domain.Sach;

/**
 *
 * @author lvhuy08t2@gmail.com
 *
 */
public interface SachRepository extends MongoRepository<Sach,String> {
	@Query("{maSach : ?0}")
	public Sach timSachByMaSach(String maSach);

}
