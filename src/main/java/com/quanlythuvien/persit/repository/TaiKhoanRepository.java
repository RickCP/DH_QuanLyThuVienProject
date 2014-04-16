package com.quanlythuvien.persit.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.quanlythuvien.persit.domain.TaiKhoan;

/**
 *
 * @author lvhuy08t2@gmail.com
 *
 */
public interface TaiKhoanRepository extends MongoRepository<TaiKhoan,String> {

}
