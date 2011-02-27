package jag.kumamoto.apps.gotochi.server.filter;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

public class AdminFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain filterChain) throws IOException, ServletException {

        final HttpServletRequest httpServletRequest =
            (HttpServletRequest) request;
        final UserService userService = UserServiceFactory.getUserService();

        // リクエストのあったURL
        final String requestUri = httpServletRequest.getRequestURI();

        // googleアカウントにログインしているかを判定するUtilクラス(後述)
        if (isGoogleLogin(httpServletRequest) == false) {
            ((HttpServletResponse) response).sendRedirect(userService
                .createLoginURL(requestUri));
            return;
        }

        // ログイン成功
        filterChain.doFilter(request, response);

    }

    /**
     * googleアカウントにログインしているかを判定する。
     * 
     * @param request
     * @return ログインしていればtrue, していなければfalse
     */
    public boolean isGoogleLogin(final HttpServletRequest request) {

        final UserService userService = UserServiceFactory.getUserService();
        final Principal principal = request.getUserPrincipal();

        if (principal == null
            || !userService.isUserLoggedIn()
            || !userService.isUserAdmin()) {
            return false;
        }

        return true;
    }

    public void destroy() {
    }

    public void init(FilterConfig arg0) throws ServletException {
    }

}
