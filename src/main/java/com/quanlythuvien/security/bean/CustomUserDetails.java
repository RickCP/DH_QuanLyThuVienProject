package com.quanlythuvien.security.bean;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.quanlythuvien.persit.domain.TaiKhoan;

/**
 * 
 * @author lvhuy08t2@gmail.com
 * 
 */
public class CustomUserDetails extends User {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TaiKhoan taiKhoan;
	public CustomUserDetails(String username, String password, boolean enabled,
			boolean accountNonExpired, boolean credentialsNonExpired,
			boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities,
			TaiKhoan taiKhoan) {
		super(username, password, enabled, accountNonExpired,
				credentialsNonExpired, accountNonLocked, authorities);
		this.taiKhoan = taiKhoan;
	}

	public TaiKhoan getTaiKhoan() {
		return taiKhoan;
	}

	public void setTaiKhoan(TaiKhoan taiKhoan) {
		this.taiKhoan = taiKhoan;
	}


}
