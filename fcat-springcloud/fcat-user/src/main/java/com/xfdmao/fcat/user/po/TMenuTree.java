package com.xfdmao.fcat.user.po;

import com.xfdmao.fcat.common.vo.TreeNode;
import lombok.Data;

import java.util.Date;

/**
 * Created by xiangfei on 2017/10/17.
 */
@Data
public class TMenuTree extends TreeNode{
    private String code;

    private String title;

    private String href;

    private String icon;

    private Integer orderNum;

    private String path;

    private String enabled;

    private Date createTime;

    private Date updateTime;
}
