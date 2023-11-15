package controller;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/calcu")
public class CalculatorController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CalculatorController() {

		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String view = "/WEB-INF/views/calculatorView.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);

	}

	List<String> inputNumList = new ArrayList<String>();
	List<String> numList = new ArrayList<String>();
	Boolean symFlg = false;
	DecimalFormat format = new DecimalFormat("0.#");

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String calcuNum = request.getParameter("calcuNum");
		String calcuSymbol = request.getParameter("calcuSymbol");

		if (calcuNum != null) {
			inputNumList.add(calcuNum);
			request.setAttribute("result", String.join("", inputNumList));
			symFlg = false;
		}

		if (calcuSymbol != null) {
			symFlg = true;
		}

		if (symFlg) {

			if (calcuSymbol.equals("AC")) {
				numList.clear();
				inputNumList.clear();
			}

			if (calcuSymbol.equals("C")) {
				numList.clear();
			}

			String calcuNumStr = String.join("", inputNumList);

			if (calcuSymbol.equals("=") && inputNumList.size() > 0) {
				numList.add(calcuNumStr);
			} else if (!calcuSymbol.equals("") && !calcuSymbol.equals("=") && inputNumList.size() > 0) {
				numList.add(calcuNumStr);
				numList.add(calcuSymbol);
			}
			if (!calcuSymbol.equals("=")) {
				request.setAttribute("result", calcuNumStr);
			}

			inputNumList.clear();

			if (calcuSymbol.equals("=")) {
				String joinNumList = String.join("", numList);

				if (joinNumList.contains("×") || joinNumList.contains("÷")) {
					String replace1 = joinNumList.replace("÷", "/");
					String replaceNumList = replace1.replace("×", "*");
					double anser = Eval.eval(replaceNumList);
					request.setAttribute("result", format.format(anser));
					//					request.setAttribute("result", replaceNumList);
				} else {
					double anser = Eval.eval(joinNumList);
					request.setAttribute("result", format.format(anser));
					//					request.setAttribute("result", joinNumList);
				}
				numList.clear();
			}

			symFlg = false;

		}

		doGet(request, response);

	}

}
