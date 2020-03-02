package com.zx.dao.impl;

import com.zx.dao.BaseDao;
import com.zx.dao.IRoomDao;

public class RoomDaoImpl extends BaseDao implements IRoomDao{


	@Override
	public void insert(String type, String price, String info, int hotelId) {
		System.out.println(type);
		System.out.println(price);
		System.out.println(info);
		System.out.println(hotelId);
		System.out.println("Here is RoomDaoImpl function");
		String sql = "INSERT INTO `room` (`id`, `type`, `price`, `info`, `hotelId`) VALUES (0, ?,?,?,?)";
		
		super.update(sql, type,price,info,hotelId);
	}
}
