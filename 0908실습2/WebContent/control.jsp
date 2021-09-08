<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, model.product.*"%>

<%
	request.setCharacterEncoding("UTF-8");
	String condition=request.getParameter("condition");
	String content=request.getParameter("content");
	System.out.println(condition+" "+content);
%>

<jsp:useBean id="productDAO" class="model.product.ProductDAO"/>
<jsp:useBean id="productVO" class="model.product.ProductVO"/>
<jsp:setProperty property="*" name="productVO"/>


<%
	// 컨트롤러를 호출했을 때의 action 파라미터에 따라 작업을 분할
	String action = request.getParameter("action");
	System.out.println(action); // log출력
	System.out.println(session.getAttribute("name"));
	
	if(action.equals("nowProduct")){
		ArrayList<ProductVO> datas = productDAO.getProductList();
		request.setAttribute("datas", datas);
		pageContext.forward("index.jsp");
	}
	else if(action.equals("insert")){
		if(productDAO.insertProduct(productVO)){
			// 같은 페이지의 다른 곳으로 이동할 때는 주로 redirect 방식을 이용함 -> spring에서 자세히
			response.sendRedirect("control.jsp?action=nowProduct");
		}
		else{
			// 예외를 발생시켜 에러페이지로 이동
			throw new Exception("DB 변경 오류 발생!");
		}
	}
	else if(action.equals("delete")){
		if(productDAO.deleteProduct(productVO)){
			response.sendRedirect("control.jsp?action=nowProduct");
			System.out.println("delete 정상적으로 작동!");
		}
		else{
			throw new Exception("DB 삭제 오류 발생!");
		}
	}
	else if(action.equals("update")){
		if(productDAO.updateProduct(productVO)){
			// 같은 페이지의 다른 곳으로 이동할 때는 주로 redirect 방식을 이용함 -> spring에서 자세히
			response.sendRedirect("control.jsp?action=nowProduct");
		}
		else{
			// 예외를 발생시켜 에러페이지로 이동
			throw new Exception("DB 변경 오류 발생!");
		}
	}
	
	else if(action.equals("edit")){
		
		String name = (String)session.getAttribute("name");
		ProductVO data = productDAO.getProduct(productVO);
		request.setAttribute("data", data);
		pageContext.forward("edit.jsp");
		
		
	}

	// 검색
	else if(action.equals("search")){
		ArrayList<ProductVO> datas=productDAO.searchProduct(condition,content);
		for(ProductVO data: datas){
			System.out.println(data);
		}
		request.setAttribute("datas",datas);
		pageContext.forward("index.jsp");
	}
	
	
	
	
%>