package com.quanlythuvien.persit.domain;
import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 
 * @author lvhuy08t2@gmail.com
 * 
 */
@Document
public class TaiKhoan implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	public String maTK;
	@Indexed(unique=true)
	public String tenTK;
	public String matKhau;
	@DBRef()
	public Quyen quyen;

	public String getMaTK() {
		return maTK;
	}

	public void setMaTK(String maTK) {
		this.maTK = maTK;
	}

	public String getTenTK() {
		return tenTK;
	}

	public void setTenTK(String tenTK) {
		this.tenTK = tenTK;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public Quyen getQuyen() {
		return quyen;
	}

	public void setQuyen(Quyen quyen) {
		this.quyen = quyen;
	}
}
