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

@WebServlet("/calc")
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

		String calcNum = request.getParameter("calcNum");
		String calcSymbol = request.getParameter("calcSymbol");

		if (calcNum != null) {
			inputNumList.add(calcNum);
			request.setAttribute("calcResult", String.join("", inputNumList));
			symFlg = false;
		}

		if (calcSymbol != null) {
			symFlg = true;
		}

		if (symFlg) {

			if (calcSymbol.equals("AC")) {
				numList.clear();
				inputNumList.clear();
			}

			String calcNumStr = String.join("", inputNumList);

			if (calcSymbol.equals("=") && inputNumList.size() > 0) {
				numList.add(calcNumStr);
			} else if (!calcSymbol.equals("") && !calcSymbol.equals("=") && inputNumList.size() > 0) {
				numList.add(calcNumStr);
				numList.add(calcSymbol);
			}
			if (!calcSymbol.equals("=")) {
				request.setAttribute("calcResult", calcNumStr);
			}

			inputNumList.clear();

			if (calcSymbol.equals("=")) {
				String joinNumList = String.join("", numList);

				if (joinNumList.contains("×") || joinNumList.contains("÷")) {
					String replace1 = joinNumList.replace("÷", "/");
					String replaceNumList = replace1.replace("×", "*");
					//					double anser = Eval.eval(replaceNumList);
					//					request.setAttribute("result", format.format(anser));
					request.setAttribute("calcResult", replaceNumList);
				} else {
					//					double anser = Eval.eval(joinNumList);
					//					request.setAttribute("result", format.format(anser));
					request.setAttribute("calcResult", joinNumList);
				}
				numList.clear();
			}

			symFlg = false;

		}
		doGet(request, response);
	}

}
