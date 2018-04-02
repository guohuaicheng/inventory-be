package com.yourshop.platform.filter;

import com.yourshop.common.constants.IConstants;
import com.yourshop.platform.tenant.model.Tenant;
import com.yourshop.core.runtime.user.TenantContextUtil;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author G
 */
public class TenantLoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletRequest request = (HttpServletRequest) servletRequest;
//        HttpSession session = request.getSession();
//        Tenant tenant = (Tenant) session.getAttribute(IConstants.SESSION_TENANT);
//        if (tenant != null) {
//            TenantContextUtil.setTenant(tenant);
//        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
