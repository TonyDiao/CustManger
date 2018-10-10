package xin.diaoyc.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import xin.diaoyc.domain.Cust;
import xin.diaoyc.factory.BasicFactory;
import xin.diaoyc.service.CustService;

/**
 * Servlet implementation class AddCustServlet
 */
@WebServlet("/AddCustServlet")
public class AddCustServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddCustServlet() {
        super();
    }
    //1.封装数据校验数据
    //2.调用service中的添加客户方法
    //3.重定向到主页

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//处理乱码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		CustService service = BasicFactory.getFactory().getInstance(CustService.class);
		//1.封装校验数据
		try {
			Cust cust = new Cust();
			//获取页面参数
			BeanUtils.populate(cust, request.getParameterMap());
			//单独处理客户爱好
			String[] prefs = request.getParameterValues("preference");
			StringBuffer buffer = new StringBuffer();
			for (String pref : prefs) {
				buffer.append(pref+",");
			}
			String pref = buffer.substring(0, buffer.length()-1);
			cust.setPreference(pref);
			//2.调用service中的方法添加客户
			service.addCust(cust);
			//3.重定向到主页
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
