package com.quanlythuvien.security.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.quanlythuvien.persit.domain.TaiKhoan;
import com.quanlythuvien.persit.repository.TaiKhoanRepository;
import com.quanlythuvien.security.bean.CustomUserDetails;

/**
 * 
 * @author lvhuy08t2@gmail.com
 * 
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	private TaiKhoanRepository taiKhoanRepo;

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		TaiKhoan tk = taiKhoanRepo.timTKByTenTK(username);
		UserDetails userDetails = null;
		if (tk == null) {
			throw new UsernameNotFoundException(String.format(
					"Cannot find user by userNam [%s]", username));
		}
		String password = tk.getMatKhau();
		boolean enabled = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;
		List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("USER"));
		userDetails = new CustomUserDetails(username, password, enabled,
				accountNonExpired, credentialsNonExpired, accountNonLocked,
				authorities, tk);
		return userDetails;
	}

}
