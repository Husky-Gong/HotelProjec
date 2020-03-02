package com.zx.service.impl;

import java.util.List;
import java.util.Map;

import com.zx.common.CodeMsg;
import com.zx.common.PageInfo;
import com.zx.common.Result;
import com.zx.dao.IRoomDao;
import com.zx.dao.ISearchDao;
import com.zx.dao.impl.RoomDaoImpl;
import com.zx.dao.impl.SearchDaoImpl;
import com.zx.service.ISearch;
import com.zx.pojo.searchRst;

public class ISearchImpl implements ISearch{
	private ISearchDao searchDao = new SearchDaoImpl();
	private IRoomDao roomDao = new RoomDaoImpl();

	@Override
	public Result queryPage(Map<String, Object> param, String page, String limit) {
		PageInfo<searchRst> pageInfo = searchDao.selectPage(param, Integer.parseInt(page), Integer.parseInt(limit));
		
		return new Result(pageInfo);
	}
	
	@Override
	public Result add(String name, String price, String type, String info) {
		System.out.println("name is:"+ name);
		System.out.println("price is:"+ price);
		System.out.println("type is:"+ type);
		System.out.println("info is:"+ info);
		
		int hotelId;
		if(name.equals("aaa")) {
			hotelId=1;
		}else if(name.equals("bbb")) {
			hotelId=2;
		}else {
			hotelId=3;
		}
		System.out.println("type is:"+ type);
		System.out.println("price is:"+ price);
		System.out.println("info is:"+ info);
		System.out.println("hotelId is:"+ hotelId);
		
		roomDao.insert(type,price,info,hotelId);
		return new Result();
	}

	@Override
	public Result delete(String id) {
		//判断业务员是否关联客户,若关联客户则不让其修改
		roomDao.updateState(id);
		return new Result();
	}

}

