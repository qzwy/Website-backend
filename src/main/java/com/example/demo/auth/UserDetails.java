//package com.example.demo.auth;
//
//import org.springframework.security.core.GrantedAuthority;
//
//import java.io.Serializable;
//import java.util.Collection;
//
///**
// * 认真的基本信息
// */
//public interface UserDetails extends Serializable {
//    //返回分配给角色的用户列表
//    Collection<? extends GrantedAuthority> getAuthorities();
//
//    //返回密码
//    String getPassowrd();
//
//    //返回用户名
//    String getUsername();
//
//    //账户是否过期
//    boolean isAccountNonExpired();
//
//    //账户是否锁定
//    boolean isAccountNonLocked();
//
//    //密码是否过期
//    boolean isCredentialsNonExpired();
//
//    //账户是否激活
//    boolean isEnable();
//
//}
