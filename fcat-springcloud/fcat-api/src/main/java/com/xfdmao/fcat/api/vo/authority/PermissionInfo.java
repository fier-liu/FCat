package com.xfdmao.fcat.api.vo.authority;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by xiangfei on 2017/10/16.
 */
@Data
public class PermissionInfo implements Serializable{
    private String code;
    private String type;
    private String uri;
    private String method;
}
