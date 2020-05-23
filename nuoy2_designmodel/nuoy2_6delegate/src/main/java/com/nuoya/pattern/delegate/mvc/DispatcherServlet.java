package com.nuoya.pattern.delegate.mvc;


import com.nuoya.pattern.delegate.mvc.controller.MemberController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class DispatcherServlet extends HttpServlet {

    private List<Handler> handlerMapping = new ArrayList<Handler>();

    @Override
    public void init() throws ServletException {
        try {
            Class<?> memberControllerClass = MemberController.class;
            handlerMapping.add(new Handler()
                    .setController(memberControllerClass.newInstance())
                    .setMethod(memberControllerClass.getMethod("getMemberById", new Class[]{String.class}))
                    .setUrl("/web/getMemberById.json"));
        } catch (Exception e) {

        }

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 完整调度
        doDispatch(req, resp);
    }

    private void doDispatch(HttpServletRequest req, HttpServletResponse resp) {
        //1、获取用户请求的 url
        // 如果按照 J2EE 的标准、每个 url 对对应一个 Serlvet，url 由浏览器输入
        String uri = req.getRequestURI();

        //2、Servlet 拿到 url 以后，要做权衡(要做判断，要做选择)
        //       根据用户请求的 URL，去找到这个 url 对应的某一个 java 类的方法
        //3、通过拿到的 URL 去 handlerMapping(我们把它认为是策略常量)
        Handler handler = null;
        for (Handler h : handlerMapping) {
            if (uri.equals(h.getUrl())) {
                handler = h;
                break;
            }
        }

        //4、将具体的任务分发给 Method(通过反射去调用其对应的方法)
        Object object = null;
        try {
            object = handler.getMethod().invoke(handler.getController(), "模拟参数");
            try {
                //5、获取到 Method 执行的结果，通过 Response 返回出去
                resp.getWriter().write(object.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /*private void doDispatch(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String uri = req.getRequestURI();
        String mid = req.getParameter("mid");
        if ("getMemberById".equals(uri)) {
            new MemberController().getMemberById(mid);
        } else if ("getyOrderById".equals(uri)) {
            new OrderController().getOrderById(mid);
        } else if ("logout".equals(uri)) {
            new SystemController().logout();
        } else {
            resp.getWriter().write("404 Noy Found!!!");
        }
    }*/

    class Handler {
        private Object Controller;
        private Method method;
        private String url;

        public Object getController() {
            return Controller;
        }

        public Handler setController(Object controller) {
            Controller = controller;
            return this;
        }

        public Method getMethod() {
            return method;
        }

        public Handler setMethod(Method method) {
            this.method = method;
            return this;
        }

        public String getUrl() {
            return url;
        }

        public Handler setUrl(String url) {
            this.url = url;
            return this;
        }
    }
}
