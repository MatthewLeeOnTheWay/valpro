package com.security.valpro.filterInteceptor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;
//收到转发请求--》生成令牌和跳转页面
//隐藏域存储生成的token》》》value="<%=session.getAttribute("token") || value="${token}"%>"
@WebServlet(name = "formServlet",urlPatterns = "/ServletFormSubmit")
public class FormServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String token= UUID.randomUUID().toString();
        request.getSession();;
        request.getRequestDispatcher("/form.jsp").forward(request,response);
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response)  throws ServletException, IOException{
        doGet(request,response);
    }
}
