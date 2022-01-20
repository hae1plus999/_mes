package com.andersen.mes.product.material_release.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("material_releaseVO")
/**
 * �����������
 */
public class Material_ReleaseVO {

	String mr_NO; //����ȣ
	Date mr_Date; // default sysdate �������
	String mr_Warehouse; // not null���â��
	String mr_Place; // not null������
	String rd_Process; // ����
	String rd_Workspace; // �۾���
	String emp_Name; // not null�����
	
//	String mr_NO VARCHAR2(20),//����ȣ�� �������� ������ ����
	int mrs_Sequence; //NUMBER(*,4)����
	String itemNO; //ǰ��
	String item_Name; //ǰ��
	String stockUnit; //DEFAULT 'EA'����
	int rr_Quantity; //number(*,4)��û����
	int mrs_Quantity; //number(*,4)������
	int warehouse_Stock; //number(*,4)â����Һ� �� ���
}
