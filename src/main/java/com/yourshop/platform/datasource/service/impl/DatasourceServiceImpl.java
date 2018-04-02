package com.yourshop.platform.datasource.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yourshop.common.util.ContextUtil;
import com.yourshop.common.util.IDGenerator;
import com.yourshop.core.model.PageResult;
import com.yourshop.platform.datasource.dao.DatasourceDao;
import com.yourshop.platform.datasource.model.Datasource;
import com.yourshop.platform.datasource.model.DatasourceVO;
import com.yourshop.platform.datasource.service.DatasourceService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author G
 */
@Service
public class DatasourceServiceImpl implements DatasourceService {

    @Autowired
    private DatasourceDao datasourceDao;

    @Override
    public Datasource create(Datasource datasource) {
        if (datasource == null) {
            throw new IllegalArgumentException("create: datasource is null");
        }
        datasource.setId(IDGenerator.generateUUID());
        datasource.setCreatedTime(new Date(System.currentTimeMillis()));
        datasource.setCreatedUser(ContextUtil.getCurrentUser().getId());
        this.datasourceDao.insert(datasource);
        return datasource;
    }

    @Override
    public PageResult<DatasourceVO> query(int pageIndex, int pageSize) {
        PageHelper.startPage(pageIndex, pageSize, true);
        List<DatasourceVO> datasources = this.datasourceDao.query();
        PageInfo<DatasourceVO> pageInfo = new PageInfo<DatasourceVO>(datasources);

        return new PageResult<DatasourceVO>(pageInfo.getTotal(), datasources);
    }

    @Override
    public Datasource update(Datasource datasource) {
        if(datasource == null || StringUtils.isEmpty(datasource.getId())) {
            throw new IllegalArgumentException("update: datasource is null or id is empty");
        }
        datasource.setUpdatedTime(new Date(System.currentTimeMillis()));
        datasource.setUpdatedUser(ContextUtil.getCurrentUser().getId());
        this.datasourceDao.insert(datasource);
        return datasource;
    }


    @Override
    public Datasource findById(String id) {
        return datasourceDao.getById(id);
    }
}
