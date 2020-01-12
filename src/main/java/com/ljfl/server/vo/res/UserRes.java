package com.ljfl.server.vo.res;

import com.ljfl.server.vo.base.BaseVO;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Description: java类作用描述
 * @Author: zwx
 * @CreateDate: 2019/12/29 12:01
 */
public class UserRes extends BaseVO {

    private static final long serialVersionUID = 2313116992289233425L;
    @ApiModelProperty("用户ID")
    private String id;
    @ApiModelProperty("用户姓名")
    private String name;
    @ApiModelProperty("用户昵称")
    private String nickName;
    @ApiModelProperty("用户头像")
    private String headImg;
    @ApiModelProperty("微信openid")
    private String openid;
    @ApiModelProperty("用户性别 1男 0女")
    private Boolean sex;
    @ApiModelProperty("用户年龄")
    private Byte age;
    @ApiModelProperty("登录时间")
    private Long loginTime;
    @ApiModelProperty("城市编码")
    private String cityCode;
    @ApiModelProperty("用户电话")
    private String mobile;
    @ApiModelProperty("操作次数")
    private Integer count;
    @ApiModelProperty("用户状态")
    private String isDelete;
    @ApiModelProperty("创建时间")
    private Long createTime;
    @ApiModelProperty("更新时间")
    private Long updateTime;
    @ApiModelProperty("用户积分")
    private Long points;
    @ApiModelProperty("用户备注")
    private String note;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public Byte getAge() {
        return age;
    }

    public void setAge(Byte age) {
        this.age = age;
    }

    public Long getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Long loginTime) {
        this.loginTime = loginTime;
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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String status) {
        this.isDelete = status;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public Long getPoints() {
        return points;
    }

    public void setPoints(Long points) {
        this.points = points;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
