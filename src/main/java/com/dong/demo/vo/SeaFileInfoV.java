package com.dong.demo.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class SeaFileInfoV implements Serializable {

    private static final long serialVersionUID = 7788948231499274065L;
    /**
     * id
     */
    private Integer id;
    /**
     * 系统号
     */
    private Integer comm_tree_id;
    /**
     * 文件id
     */
    private String domain_id;
    /**
     * 文件批号
     */
    private String atta_domain;
    /**
     * 下载链接
     */
    private String downloadUrl;
    /**
     * 内部短链接
     */
    private String atta_url;

}
