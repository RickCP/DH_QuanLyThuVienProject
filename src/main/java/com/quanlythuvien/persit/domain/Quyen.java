package com.quanlythuvien.persit.domain;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 
 * @author lvhuy08t2@gmail.com
 * 
 */
@Document(collection = "quyen")
public class Quyen implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String maQuyen;
	
	@Indexed(unique = true)
	private String tenQuyen;

	public String getMaQuyen() {
		return maQuyen;
	}

	public void setMaQuyen(String maQuyen) {
		this.maQuyen = maQuyen;
	}

	public String getTenQuyen() {
		return tenQuyen;
	}

	public void setTenQuyen(String tenQuyen) {
		this.tenQuyen = tenQuyen;
	}

}
