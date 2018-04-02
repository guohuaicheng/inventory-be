package com.yourshop.platform.filter;

import com.auth0.jwt.interfaces.Claim;
import com.yourshop.common.constants.IConstants;
import com.yourshop.common.util.JWTHelper;
import com.yourshop.common.util.TenantCache;
import com.yourshop.core.runtime.user.TenantContextUtil;
import com.yourshop.core.runtime.user.UserContextThreadLocalHolder;
import com.yourshop.login.model.UserInfoVO;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @author G
 */
public class UserLoginFilter extends BaseFilter implements Filter {

    private final static String NOT_LOGIN = "login/not";
    private final static String LOGIN = "/login";

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String url = request.getServletPath();
        if (StringUtils.equals(LOGIN, url)) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        String token = request.getHeader(IConstants.SESSION_TOKEN);
        try {
            if (!StringUtils.isEmpty(token)) {
                Map<String, Claim> map = JWTHelper.verifyToken(token);
                UserInfoVO user = new UserInfoVO();
                user.setId(map.get(IConstants.SESSION_USER).asString());
                UserContextThreadLocalHolder.set(user);
                Claim claim = map.get(IConstants.SESSION_TENANT);
                if (claim != null) {
                    TenantContextUtil.setTenant(TenantCache.getTenant(claim.asString()));
                }
            } else {

                if (!url.endsWith(".js")) {
                    if (excludedUrlArray != null) {
                        boolean isExcludedPage = false;
                        for (String excludedUrl : excludedUrlArray) {
                            if (url.equals(excludedUrl)) {
                                isExcludedPage = true;
                                break;
                            }
                        }
                        if (!isExcludedPage) {
                            response.getWriter().print("error");
                            return;
                        }
                    } else {
                        response.getWriter().print("error");
                        return;
                    }
                }
            }
        } catch (Exception e) {
            request.getRequestDispatcher(NOT_LOGIN).forward(request, response);
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
