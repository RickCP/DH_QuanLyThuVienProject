package com.quanlythuvien.persit.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.quanlythuvien.persit.domain.TaiKhoan;

/**
 *
 * @author lvhuy08t2@gmail.com
 *
 */
public interface TaiKhoanRepository extends MongoRepository<TaiKhoan,String> {

	@Query("{quyen.$id : ?0}")
	public TaiKhoan timTaiKhoanByMaQuyen(String maQuyen);
	@Query("{tenTK : ?0 }")
	public TaiKhoan timTKByTenTK(String tenTK);
 
}
