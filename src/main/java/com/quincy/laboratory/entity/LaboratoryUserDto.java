package com.quincy.laboratory.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class LaboratoryUserDto {
    @ExcelProperty(value = "用户ID")
    private long userId;
    @ExcelProperty(value = "部门ID")
    private long deptId;
    @ExcelProperty(value = "姓名")
    private String username;
    @ExcelProperty(value = "昵称")
    private String nickName;
    @ExcelProperty(value = "用户类型")
    private String userType;
    @ExcelProperty(value = "用户邮箱")
    private String email;
    @ExcelProperty(value = "手机号码")
    private String phoneNumber;
    @ExcelProperty(value = "性别：1, 2, 3")
    private String sex;
    @ExcelProperty(value = "头像地址")
    private String avatar;
    @ExcelProperty(value = "密码")
    private String password;
    @ExcelProperty(value = "账户状态，0-正常，1-停用")
    private String status;
    @ExcelProperty(value = "删除标志")
    private String delFlag;
    @ExcelProperty(value = "最后登录IP")
    private String loginIP;
    @ExcelProperty(value = "最后登录时间")
    private String loginDate;
    @ExcelProperty(value = "创建者")
    private String createBy;
    @ExcelProperty(value = "创建时间")
    private String createTime;
    @ExcelProperty(value = "更新者")
    private String updateBy;
    @ExcelProperty(value = "更新时间")
    private String updateTime;
    @ExcelProperty(value = "备注")
    private String remark;
}
