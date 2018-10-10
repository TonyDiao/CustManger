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
    //1.��װ����У������
    //2.����service�е���ӿͻ�����
    //3.�ض�����ҳ

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��������
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		CustService service = BasicFactory.getFactory().getInstance(CustService.class);
		//1.��װУ������
		try {
			Cust cust = new Cust();
			//��ȡҳ�����
			BeanUtils.populate(cust, request.getParameterMap());
			//��������ͻ�����
			String[] prefs = request.getParameterValues("preference");
			StringBuffer buffer = new StringBuffer();
			for (String pref : prefs) {
				buffer.append(pref+",");
			}
			String pref = buffer.substring(0, buffer.length()-1);
			cust.setPreference(pref);
			//2.����service�еķ�����ӿͻ�
			service.addCust(cust);
			//3.�ض�����ҳ
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
