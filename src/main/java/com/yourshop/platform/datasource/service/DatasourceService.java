package com.yourshop.platform.datasource.service;

import com.yourshop.core.model.PageResult;
import com.yourshop.platform.datasource.model.Datasource;
import com.yourshop.platform.datasource.model.DatasourceVO;

/**
 * @author G
 */
public interface DatasourceService {
    /**
     * 创建数据源信息
     * @param datasource
     * @return
     */
    Datasource create(Datasource datasource);

    /**
     * 查询数据源
     * @param pageIndex
     * @param pageSize
     * @return
     */
    PageResult<DatasourceVO> query(int pageIndex, int pageSize);

    /**
     * 更新数据源信息
     * @param datasource
     * @return
     */
    Datasource update(Datasource datasource);

    /**
     * 根据ID查询数据源信息
     * @param id
     * @return
     */
    Datasource findById(String id);
}
