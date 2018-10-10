package xin.diaoyc.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xin.diaoyc.domain.Cust;
import xin.diaoyc.factory.BasicFactory;
import xin.diaoyc.service.CustService;


@WebServlet("/ListCustServlet")
public class ListCustServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ListCustServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		CustService service = BasicFactory.getFactory().getInstance(CustService.class);
		//1.����service�еĲ�ѯ���������ҵ����пͻ�
		List<Cust> list = service.getAllCust();
		//2.�����ҵ�����Ϣ����request���У�����ת����listCust.jspҳ�����չʾ
		request.setAttribute("list", list);
		request.getRequestDispatcher("listCust.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
