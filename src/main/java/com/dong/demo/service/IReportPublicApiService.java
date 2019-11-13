package com.dong.demo.service;

import com.dong.demo.vo.DictionaryRV;

/**
 * @Desc : 公文管理公共服务接口
 * @Author: xm.yi
 * @Date: 11:21 2019/7/22
 */
public interface IReportPublicApiService {

    void afterPropertiesSet();

    String getPublicVersion();

    DictionaryRV getPublicResource();

}
