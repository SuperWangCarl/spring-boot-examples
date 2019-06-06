package com.carlme.mybatisplus.persistence.po;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableLogic;
import java.io.Serializable;

/**
 * <p>
 * 通知公告
 * </p>
 *
 * @author carlme
 * @since 2019-06-06
 */
@TableName("t_common_notice")
public class CommonNotice extends Model<CommonNotice> {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "id", type = IdType.UUID)
    private String id;
    /**
     * 通告名
     */
    private String noticeName;
    /**
     * 创建者的用户ID
     */
    private String createId;
    /**
     * 修改者的用户ID
     */
    private String modifiedId;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date modifiedTime;
    /**
     * 备注
     */
    private String comment;
    /**
     * 是否可以删除标记：0不能删除,1可以删除,默认1
     */
    private Integer delFlag;
    /**
     * 是否在使用（删除）标记：0不使用(已逻辑删除),1使用,默认1
     */
    @TableLogic
    private Integer useFlag;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNoticeName() {
        return noticeName;
    }

    public void setNoticeName(String noticeName) {
        this.noticeName = noticeName;
    }

    public String getCreateId() {
        return createId;
    }

    public void setCreateId(String createId) {
        this.createId = createId;
    }

    public String getModifiedId() {
        return modifiedId;
    }

    public void setModifiedId(String modifiedId) {
        this.modifiedId = modifiedId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public Integer getUseFlag() {
        return useFlag;
    }

    public void setUseFlag(Integer useFlag) {
        this.useFlag = useFlag;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "CommonNotice{" +
        ", id=" + id +
        ", noticeName=" + noticeName +
        ", createId=" + createId +
        ", modifiedId=" + modifiedId +
        ", createTime=" + createTime +
        ", modifiedTime=" + modifiedTime +
        ", comment=" + comment +
        ", delFlag=" + delFlag +
        ", useFlag=" + useFlag +
        "}";
    }
}
