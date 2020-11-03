//package com.example.dao;
//
//import com.example.model.SysUser;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//
//import java.util.Optional;
//
///**
// * Created by gaojx on 2020/7/17.
// */
//public interface SysUserRepository extends JpaRepository<SysUser, Long> {
//    Optional<SysUser> findByUsername(String username);
//
//    @Query("select u from SysUser u where u.id = ?#{principal?.id} and true=?#{hasRole('ROLE_ADMIN')}")
//    Optional<SysUser> findRoleAdminMyself();
//}
