package com.quanlythuvien.persit.domain;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 
 * @author lvhuy08t2@gmail.com
 * 
 */
@Document
public class Sach {
	@Id
	private String maSach;
	private String tenSach;
	@DBRef
	private TheLoaiSach theLoai;
	private String tacGia;
	private String nhaXuatBan;
	private String namXuatBan;
	private Integer tongSoBan;
	private Integer soBanChuaMuon;
	private Date ngayNhap;
	private String tinhTrang;
	private Integer soTrang;
	private String ngonNgu;

	public String getMaSach() {
		return maSach;
	}

	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}

	public String getTenSach() {
		return tenSach;
	}

	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}

	public TheLoaiSach getTheLoai() {
		return theLoai;
	}

	public void setTheLoai(TheLoaiSach theLoai) {
		this.theLoai = theLoai;
	}

	public String getTacGia() {
		return tacGia;
	}

	public void setTacGia(String tacGia) {
		this.tacGia = tacGia;
	}

	public String getNhaXuatBan() {
		return nhaXuatBan;
	}

	public void setNhaXuatBan(String nhaXuatBan) {
		this.nhaXuatBan = nhaXuatBan;
	}

	public String getNamXuatBan() {
		return namXuatBan;
	}

	public void setNamXuatBan(String namXuatBan) {
		this.namXuatBan = namXuatBan;
	}

	public Integer getTongSoBan() {
		return tongSoBan;
	}

	public void setTongSoBan(Integer tongSoBan) {
		this.tongSoBan = tongSoBan;
	}

	public Integer getSoBanChuaMuon() {
		return soBanChuaMuon;
	}

	public void setSoBanChuaMuon(Integer soBanChuaMuon) {
		this.soBanChuaMuon = soBanChuaMuon;
	}

	public Date getNgayNhap() {
		return ngayNhap;
	}

	public void setNgayNhap(Date ngayNhap) {
		this.ngayNhap = ngayNhap;
	}

	public String getTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(String tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	public Integer getSoTrang() {
		return soTrang;
	}

	public void setSoTrang(Integer soTrang) {
		this.soTrang = soTrang;
	}

	public String getNgonNgu() {
		return ngonNgu;
	}

	public void setNgonNgu(String ngonNgu) {
		this.ngonNgu = ngonNgu;
	}

}
