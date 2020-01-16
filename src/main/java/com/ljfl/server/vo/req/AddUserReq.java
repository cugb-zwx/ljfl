package com.ljfl.server.vo.req;

import com.ljfl.server.vo.base.BaseVO;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Description: java类作用描述
 * @Author: zwx
 * @CreateDate: 2019/12/13 20:50
 */
public class AddUserReq extends BaseVO {
    private static final long serialVersionUID = 3939302248038510574L;
    @ApiModelProperty("用户姓名")
    private String name;
    @ApiModelProperty("用户昵称")
    private String nickName;
    @ApiModelProperty("用户头像")
    private String headImg;
    @ApiModelProperty("用户密码")
    private String passward;
    @ApiModelProperty("用户密码2")
    private String passward2;
    @ApiModelProperty("微信code")
    private String code;
    @ApiModelProperty("用户性别")
    private Byte sex;
    @ApiModelProperty("用户年龄")
    private Byte age;
    @ApiModelProperty("用户城市编码")
    private String cityCode;
    @ApiModelProperty("用户手机号")
    private String mobile;
    @ApiModelProperty("用户状态")
    private String isDelete;
    @ApiModelProperty("用户备注")
    private String note;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public String getPassward() {
        return passward;
    }

    public void setPassward(String passward) {
        this.passward = passward;
    }

    public String getPassward2() {
        return passward2;
    }

    public void setPassward2(String passward2) {
        this.passward2 = passward2;
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public Byte getAge() {
        return age;
    }

    public void setAge(Byte age) {
        this.age = age;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String status) {
        this.isDelete = status;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
