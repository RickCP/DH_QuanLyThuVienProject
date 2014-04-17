package com.quanlythuvien.persit.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.quanlythuvien.persit.domain.Quyen;

/**
 *
 * @author lvhuy08t2@gmail.com
 *
 */
public interface QuyenRepository  extends MongoRepository<Quyen,String>{
	@Query("{tenQuyen:?0}")
  public Quyen timBytenQuyen(String tenQuyen);
}
