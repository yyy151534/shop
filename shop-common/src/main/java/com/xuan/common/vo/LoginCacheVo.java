package com.xuan.common.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class LoginCacheVo implements Serializable {

    private static final long serialVersionUID = -6089539131454932253L;
    private Long id;
    private byte[] a = new byte[1024];
}
