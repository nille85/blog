package be.nille.boot;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by nholvoet on 27/01/2017.
 */

public class AuthenticationInterceptor extends HandlerInterceptorAdapter {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        String uri = request.getRequestURI();
        boolean isProtectedURI = uri.matches(".*/protected/.*");
        if(isProtectedURI)
        {
            /*TODO
            Check something on the session
             */
             response.sendRedirect("/admin/login");
             return false;

        }
        return true;
    }


}
