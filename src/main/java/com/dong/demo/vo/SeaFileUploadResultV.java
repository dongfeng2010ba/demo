package com.dong.demo.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class SeaFileUploadResultV implements Serializable {

    private static final long serialVersionUID = 7788948231499274065L;
    /**
     * id
     */
    private Integer id;
    /**
     * 文件id
     */
    private String commTreeId;
    /**
     * 文件批号
     */
    private String attaDomain;
    /**
     * 下载链接
     */
    private String downloadUrl;
    /**
     * 内部短链接
     */
    private String attaUrl;
    /**
     * 文件大小
     */
    private String fileSize;
    /**
     * 文件名
     */
    private String attaName;

}
