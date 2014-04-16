package com.quanlythuvien.persit.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.quanlythuvien.persit.domain.Quyen;

/**
 *
 * @author lvhuy08t2@gmail.com
 *
 */
public interface QuyenRepository  extends MongoRepository<Quyen,String>{

}
