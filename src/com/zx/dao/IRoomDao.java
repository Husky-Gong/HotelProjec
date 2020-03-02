package com.zx.dao;


public interface IRoomDao {
	
	void insert(String type, String price, String info, int hotelId);

	void updateState(String id);

}