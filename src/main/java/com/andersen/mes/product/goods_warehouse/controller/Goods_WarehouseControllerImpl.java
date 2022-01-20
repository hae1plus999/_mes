package com.andersen.mes.product.goods_warehouse.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.andersen.mes.product.goods_warehouse.controller.Goods_WarehouseControllerImpl;
import com.andersen.mes.product.goods_warehouse.service.Goods_WarehouseService;
import com.andersen.mes.product.goods_warehouse.vo.Goods_WarehouseVO;

@Controller("goods_warehouseController")
public class Goods_WarehouseControllerImpl implements Goods_WarehouseController{
	private static final Logger logger = LoggerFactory.getLogger(Goods_WarehouseControllerImpl.class);
	@Autowired
	private Goods_WarehouseService goods_warehouseService;
	@Autowired
	private Goods_WarehouseVO goods_warehouseVO;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	@Override
	@RequestMapping(value="/product/main_goods_warehouse.do" ,method = RequestMethod.GET)
	public ModelAndView main_goods_warehouse(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("/product/main_goods_warehouse.do");
		String pr_NO = request.getParameter("checked_pr_no");
		System.out.println("checked_pr_no :" +pr_NO);
		String viewName = getViewName(request);
		logger.info("viewName: "+ viewName);
		logger.debug("viewName: "+ viewName);
		ModelAndView mav = new ModelAndView(viewName);
		
//		if (pr_NO != null) {
//			List downList = goods_warehouseService.find_goods_warehouse(pr_NO);
//			List mainList = goods_warehouseService.main_goods_warehouse();
//			mav.addObject("downList", downList);
//			mav.addObject("mainList", mainList);
//		} else if (pr_NO == null) {
//			List mainList = goods_warehouseService.main_goods_warehouse();
//			mav.addObject("mainList", mainList);
//		}
		
		return mav;
	}
	
	@Override //실적기간 날짜검색
	@RequestMapping(value="/product/find_material_use.do" ,method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView findDate_goods_warehouse(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("/product/find_material_use.do");
		String viewName = getViewName(request);
		logger.info("viewName: "+ viewName);
		logger.debug("viewName: "+ viewName);
		ModelAndView mav = new ModelAndView(viewName);
		
		//실적번호체크로 조회
		String pr_NO = request.getParameter("checked_pr_no"); //지시번호체크
		System.out.println("실적번호출력 :" +pr_NO);
		
		//실적기간 Date로 변환하고 sql.Date 로 변환 
		String biginDate = request.getParameter("beginDate");
		String endDate = request.getParameter("endDate");
		System.out.println("실적기간조회 :" +biginDate+"-"+endDate);
		
//		if(pr_NO != null) {
//			
//			material_useVO.setPr_NO(pr_NO);//다음페이지 생산자재사용등록 저장하기 위한 vo 세터저장
//			
//			List downList = material_useService.DownList_material_use(pr_NO);
//			List mainList = material_useService.main_material_use();
//			mav.addObject("downList", downList);
//			mav.addObject("mainList", mainList);
//			
//		} else if(biginDate != null) {
//			
//			Date bigin_Date = sdf.parse(biginDate);
//			Date end_Date = sdf.parse(endDate);
//			String a = sdf.format(bigin_Date);
//			String b = sdf.format(end_Date);
//			java.sql.Date date1 = java.sql.Date.valueOf(a);
//			java.sql.Date date2 = java.sql.Date.valueOf(b);
//			material_useVO.setBeginDate(date1);
//			material_useVO.setEndDate(date2);
//
//			//지시기간 리스트 출력
//			List mainList = material_useService.findDate_material_use(material_useVO);
//			mav.addObject("mainList", mainList);
//			System.out.println("mainList :" +mainList);
//		}

		return mav;
	}
	
	private String getViewName(HttpServletRequest request) throws Exception {
		String contextPath = request.getContextPath();
		String uri = (String) request.getAttribute("javax.servlet.include.request_uri");
		if (uri == null || uri.trim().equals("")) {
			uri = request.getRequestURI();
		}

		int begin = 0;
		if (!((contextPath == null) || ("".equals(contextPath)))) {
			begin = contextPath.length();
		}

		int end;
		if (uri.indexOf(";") != -1) {
			end = uri.indexOf(";");
		} else if (uri.indexOf("?") != -1) {
			end = uri.indexOf("?");
		} else {
			end = uri.length();
		}

		String viewName = uri.substring(begin, end);
		if (viewName.indexOf(".") != -1) {
			viewName = viewName.substring(0, viewName.lastIndexOf("."));
		}
		if (viewName.lastIndexOf("/") != -1) {
			viewName = viewName.substring(viewName.lastIndexOf("/", 1), viewName.length());
		}
		return viewName;
	}
}
