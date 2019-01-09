package com.imooc.course.filter;


import javax.servlet.*;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class CharsetEncodingFilter implements Filter {
    private String encoding;
    @Override
    public void init(FilterConfig filterConfig) {
        this.encoding=filterConfig.getInitParameter("encoding");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding(encoding);//设置编码集
        filterChain.doFilter(servletRequest,servletResponse);//将请求转发给过滤器链下一个filter
    }

    @Override
    public void destroy() {

    }
}
