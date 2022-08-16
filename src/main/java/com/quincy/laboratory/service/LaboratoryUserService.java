package com.quincy.laboratory.service;

import com.quincy.laboratory.dao.LaboratoryUserMapper;
import com.quincy.laboratory.entity.LaboratoryUserDto;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LaboratoryUserService {

    @Resource
    private LaboratoryUserMapper userMapper;

    public List<LaboratoryUserDto> findAllUsers() {
        return userMapper.findAllUsers();
    }

    public List<LaboratoryUserDto> findAllUsersPage(int offset, int limit) {
        return userMapper.findAllUsersPage(offset, limit);
    }

    public List<LaboratoryUserDto> findAllUsersPageFetchSize(int offset, int limit){
        return userMapper.findAllUsersPageFetchSize(offset, limit);
    }
    public int countAllUsers() {
        return userMapper.countAllUsers();
    }

}
