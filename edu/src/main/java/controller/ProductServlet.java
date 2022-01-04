package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.ProductVO;

@WebServlet("/fruit")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		int num = Integer.parseInt(request.getParameter("pid").substring(1));
		System.out.println(num);
		
		if(session.getAttribute("fruitInfo") == null) {
			session.setAttribute("fruitInfo", new ProductVO(0,0,0));
			ProductVO pv = (ProductVO)session.getAttribute("fruitInfo");
			IncreaseCnt(num, pv);
		} else {
			ProductVO pv = (ProductVO)session.getAttribute("fruitInfo");
			IncreaseCnt(num, pv);
		}
		
		request.getRequestDispatcher("/jspsrc/productView.jsp").forward(request, response);
	}
	
	public void IncreaseCnt(int num, ProductVO pv) {
		if (num == 1) {
			pv.setApple_cnt(1);
		} else if (num ==2) {
			pv.setBanana_cnt(1);
		} else {
			pv.setHanla_cnt(1);
		}
	}

}
