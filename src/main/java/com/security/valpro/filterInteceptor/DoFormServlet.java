package com.security.valpro.filterInteceptor;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "doFormServlet",urlPatterns = "/doFormServlet")
public class DoFormServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        boolean b=isRepeatSubmit(request);
        if(b==true){
            System.out.println("请不要重复提交");
            return;
        }
        request.getSession().removeAttribute("token'");;
        System.out.println("处理用户的请求");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        doGet(request,response);
    }

    private boolean isRepeatSubmit(HttpServletRequest request){
        String client_token=request.getParameter("token");
        //如果没有token，则用户是重复提交了表单
        if(client_token==null){
            return true;
        }
        //取出存储再session的token
        String server_token=(String)request.getSession().getAttribute("token");
        if(server_token==null){
            return true;
        }
        if(!client_token.equals(server_token)){
            return true;
        }
        return false;
    }
}
