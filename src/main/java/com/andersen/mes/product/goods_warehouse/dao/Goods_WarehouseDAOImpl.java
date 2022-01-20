package com.andersen.mes.product.goods_warehouse.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.andersen.mes.product.goods_warehouse.vo.Goods_WarehouseVO;

@Repository("goods_warehouseDAO")
public class Goods_WarehouseDAOImpl implements Goods_WarehouseDAO {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List selectAllGoods_WarehouseUpList() throws DataAccessException {
		List<Goods_WarehouseVO> mainList = null;
		mainList = sqlSession.selectList("mapper.product.performance.selectAllGoods_WarehouseUpList");
		return mainList;
	}
	
	@Override
	public List selectAllGoods_WarehouseDownList() throws DataAccessException {
		List<Goods_WarehouseVO> downList = null;
		downList = sqlSession.selectList("mapper.product.goods.selectAllGoods_WarehouseList");
		return downList;
	}
	
	@Override
	public List searchGoods_Warehouse(String pr_NO) throws DataAccessException {
		List<Goods_WarehouseVO> findList = null;
		findList = sqlSession.selectList("mapper.product.goods.searchGoods_Warehouse", pr_NO);
		return findList;
	}
	
	@Override
	public int insertGoods_Warehouse(Goods_WarehouseVO goods_warehouseVO) throws DataAccessException {
		int result = sqlSession.insert("mapper.product.goods.insertGoods_Warehouse", goods_warehouseVO);
		return result;
	}
	
	@Override
	public int updateGoods_Warehouse(Goods_WarehouseVO goods_warehouseVO) throws DataAccessException {
		int result = sqlSession.insert("mapper.product.goods.updateGoods_Warehouse", goods_warehouseVO);
		return result;
	}
	
	@Override
	public int deleteGoods_Warehouse(String id) throws DataAccessException {
		int result = sqlSession.delete("mapper.product.goods.deleteGoods_Warehouse", id);
		return result;
	}
}
