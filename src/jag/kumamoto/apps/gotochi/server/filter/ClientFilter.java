package jag.kumamoto.apps.gotochi.server.filter;

import jag.kumamoto.apps.gotochi.server.meta.ClientAuthMeta;
import jag.kumamoto.apps.gotochi.server.model.ClientAuth;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slim3.datastore.Datastore;

public class ClientFilter implements Filter {

    public void init(FilterConfig arg0) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain filterChain) throws IOException, ServletException {

        String appKey = request.getParameter("appKey");

        System.out.println(appKey);

        // System.out.println(request.getAttribute("appKey"));

        ClientAuth ca =
            Datastore.query(ClientAuth.class).filter(
                ClientAuthMeta.get().authToken.equal(appKey)).asSingle();

        System.out.println(((HttpServletRequest) request).getRequestURL()
            + "："
            + new java.util.Date());

        if (ca != null) {
            filterChain.doFilter(request, response);
        } else {
            response.getWriter().write("invalid!");
            response.getWriter().flush();

        }

    }

    public void destroy() {
    }

}
