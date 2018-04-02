package com.yourshop.platform.datasource.controller;

import com.yourshop.core.model.PageResult;
import com.yourshop.platform.datasource.model.Datasource;
import com.yourshop.platform.datasource.model.DatasourceVO;
import com.yourshop.platform.datasource.service.DatasourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author G
 */
@RestController
@RequestMapping("/platform/datasource")
public class DatasourceController {
    @Autowired
    private DatasourceService datasourceService;

    @RequestMapping(method = RequestMethod.POST)
    public Datasource create(@RequestBody Datasource datasource) {
        return this.datasourceService.create(datasource);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Datasource update(@RequestBody Datasource datasource) {
        return this.datasourceService.update(datasource);
    }

    @RequestMapping(method = RequestMethod.GET)
    public PageResult<DatasourceVO> query(@RequestParam(defaultValue = "1") int pageIndex, @RequestParam(defaultValue = "10") int pageSize) {
        return this.datasourceService.query(pageIndex, pageSize);
    }
}
