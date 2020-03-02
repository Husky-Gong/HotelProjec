package com.zx.service.impl;

import java.util.Map;

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
	/*
	@Override
	public Result add(String userName, String realName, String type) {
		//业务数据校验
		//校验用户名 不能重复
		CUser user = cuserDao.selectUser(userName);
		if(user != null) {
			return new Result(CodeMsg.USER_USERNAME_EXIST_ERROR);
		}
		String password = SecureUtil.md5(Constant.DEFAULT_PASSWORD);
		Integer isDel = Constant.USER_STATE_VALID;
		String createTime = DateUtil.format(new Date(), Constant.YYYY_MM_DD_HH_MM_SS);
		String modifyTime = createTime;
		cuserDao.insert(userName,password,realName,type,isDel,createTime,modifyTime);
		return new Result();
	}

	@Override
	public Result delete(String... ids) {
		//判断业务员是否关联客户,若关联客户则不让其修改
		//根据业务员查询客户
		List<CCustomer> customers = customerDao.selectCustomers(ids);
		if(customers != null && !customers.isEmpty()) {
			return new Result(CodeMsg.USER_DELETE_ERROR);
		}
		
		cuserDao.updateState(Constant.USER_STATE_INVALID,ids);
		return new Result();
	}

	@Override
	public Result resetPwd(String id) {
		String password = SecureUtil.md5(Constant.DEFAULT_PASSWORD);
		cuserDao.updatePwd(id,password);
		return new Result();
	}

	@Override
	public Result enable(String id) {
		cuserDao.updateState(Constant.USER_STATE_VALID, id);
		return new Result();
	}

	@Override
	public Result updatePwd(CUser user, String password, String newPassword) {
		Integer userId = user.getId();
		user = cuserDao.selectUser(userId);
		//比较原始密码
		if(!StrUtil.equals(user.getPassword(),SecureUtil.md5(password))) {
			return new Result(CodeMsg.SYS_USER_PASSWORD_ERROR);
		}
		//修改新密码
		newPassword = SecureUtil.md5(newPassword); 
		cuserDao.updatePwd(userId.toString(), newPassword);
		return new Result();
	}

	@Override
	public Result updateImg(Integer userId, String imgUrl) {
		cuserDao.updateImg(userId, imgUrl);
		return new Result();
	}

	@Override
	public Result salesman() {
		List<CUser> users = cuserDao.selectUsers(Constant.USER_TYPE_SALES);
		return new Result(users);
	}
*/
}

