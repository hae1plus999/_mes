package com.andersen.mes.product.material_release.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("material_releaseVO")
/**
 * 생산자재출고
 */
public class Material_ReleaseVO {

	String mr_NO; //출고번호
	Date mr_Date; // default sysdate 출고일자
	String mr_Warehouse; // not null출고창고
	String mr_Place; // not null출고장소
	String rd_Process; // 공정
	String rd_Workspace; // 작업장
	String emp_Name; // not null담당자
	
//	String mr_NO VARCHAR2(20),//출고번호는 브라우저에 보이지 않음
	int mrs_Sequence; //NUMBER(*,4)순서
	String itemNO; //품번
	String item_Name; //품명
	String stockUnit; //DEFAULT 'EA'단위
	int rr_Quantity; //number(*,4)요청수량
	int mrs_Quantity; //number(*,4)출고수량
	int warehouse_Stock; //number(*,4)창고장소별 현 재고
}
