package com.quincy.laboratory.dao;

import com.quincy.laboratory.entity.LaboratoryUserDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LaboratoryUserMapper {
    // 查询出所有启用的用户信息
    List<LaboratoryUserDto> findAllUsers();

    List<LaboratoryUserDto> findAllUsersPage(int offset, int limit);

    List<LaboratoryUserDto> findAllUsersPageFetchSize(int offset, int limit);

    // 查询所有用户数目
    int countAllUsers();

}
