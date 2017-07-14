package com.addoiles.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.addoiles.entity.Admin;
import com.addoiles.vo.AdminVo;
@Repository("adminDao")
public interface AdminDao {
	/**
	 * 添加管理员
	 * @param admin
	 * @return int
	 */
	public int addAdmin(Admin admin);
	
	/**
	 * 删除管理员
	 * @param adminId
	 * @return
	 */
	public int deleteAdmin(long adminId);
	/**
	 * 修改管理员的信息
	 * @param adminId
	 * @param password
	 */
	public void updateAdminByadminId(@Param("adminId")long adminId,@Param("password")String password);
	/**
	 * 获取所有对象
	 * @param offset
	 * @param rows
	 * @return
	 */
	public List<Admin> getAllList(@Param("offset")long offset,@Param("rows")long rows);
	/**
	 * 获取所有管理员的数量
	 * @return
	 */
	public int getAllListCount();
	/**
	 * 通过Id获取指定管理员资料
	 * @param adminId
	 * @return
	 */
	public Admin getAdminById(long adminId);
	/**
	 * 通过name获得制定管理员
	 * @param name
	 * @return
	 */
	public AdminVo getAdminByName(String name);
}
