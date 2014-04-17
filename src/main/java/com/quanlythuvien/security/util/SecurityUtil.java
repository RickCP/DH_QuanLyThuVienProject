package com.quanlythuvien.security.util;

import org.springframework.security.core.context.SecurityContextHolder;
import com.quanlythuvien.persit.domain.TaiKhoan;
import com.quanlythuvien.security.bean.CustomUserDetails;

/**
 * 
 * @author lvhuy08t2@gmail.com
 * 
 */
public class SecurityUtil {
	public static CustomUserDetails getUserDetail() {
		return (CustomUserDetails) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
	}

	public static TaiKhoan getCurrentUser() {
		CustomUserDetails userDetail = (CustomUserDetails) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();
		TaiKhoan tk = userDetail.getTaiKhoan();
		return tk;
	}

}