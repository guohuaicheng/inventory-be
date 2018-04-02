package com.yourshop.platform.filter;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.FilterConfig;
import javax.servlet.ServletException;

/**
 * @author G
 */
public abstract class BaseFilter  {
    protected String excludedUrls;
    protected String[] excludedUrlArray;

    public void init(FilterConfig filterConfig) throws ServletException {
        excludedUrls = filterConfig.getInitParameter("excludedUrls");
        if (StringUtils.isNotEmpty(excludedUrls)) {
            excludedUrlArray = excludedUrls.split(",");
        }
    }
}
