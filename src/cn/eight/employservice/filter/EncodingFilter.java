package cn.eight.employservice.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 瞿琮
 * @create 2020-03-16 18:10
 */
public class EncodingFilter implements Filter {
    private String encoding;
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request= (HttpServletRequest) req;
        HttpServletResponse response= (HttpServletResponse) resp;
        //设置了请求正文的编码方式，post的请求信息是通过请求正文发送的
        request.setCharacterEncoding(encoding);

        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        encoding=config.getInitParameter("encoding");
    }

}
