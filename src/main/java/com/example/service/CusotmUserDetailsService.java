//package com.example.service;
//
//import com.example.dao.SysUserRepository;
//import com.example.model.SysUser;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//import java.util.Optional;
//
///**
// * Created by gaojx on 2020/7/17.
// */
//public class CusotmUserDetailsService implements UserDetailsService {
//
//    SysUserRepository sysUserRepository;
//
//    public CusotmUserDetailsService(SysUserRepository sysUserRepository) {
//        this.sysUserRepository = sysUserRepository; //1
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Optional<SysUser> sysUserOptional = sysUserRepository.findByUsername(username); //2
//        return  sysUserOptional
//                .orElseThrow(() -> new UsernameNotFoundException("Username not found")); //3
//    }
//}
