package com.yourshop.platform.datasource.dao;

import com.yourshop.platform.annotation.MybatisRepository;
import com.yourshop.platform.datasource.model.Datasource;
import com.yourshop.platform.datasource.model.DatasourceVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
import java.util.List;

/**
 * @author G
 */
@MybatisRepository
@Repository
public interface DatasourceDao {
    /**
     * 创建数据源信息
     * @param datasource
     */
    void insert(Datasource datasource);

    /**
     * 修改数据源信息
     * @param datasource
     */
    void update(Datasource datasource);

    /**
     * 根据ID查询数据源信息
     * @param id
     * @return
     */
    Datasource getById(@Param("id") String id);

    /**
     * 获取数据源信息
     * @return
     */
    List<DatasourceVO> query();

    /**
     * 获取数据源个数
     * @return
     */
    int count();

    /**
     * 删除数据源信息, 根据状态位软删除
     * @param id
     */
    void remove(@Param("id") String id);

    /**
     * 删除数据源信息
     * @param id
     */
    void delete(@Param("id") String id);
}
