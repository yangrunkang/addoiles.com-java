package com.shamrock.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.junit.runners.Parameterized.Parameters;
import org.springframework.stereotype.Repository;

import com.shamrock.cms.constant.FolderConstant;
import com.shamrock.cms.constant.FolderConstant.Status;
import com.shamrock.cms.entity.Folder;
import com.shamrock.cms.vo.FolderVo;

/**
 * 目录服务
 * 
 * @author Harbored
 * 
 */

@Repository("folderDao")
public interface FolderDao {

	// ///////////////////////////////
	// ///// 增加 ////////
	// ///////////////////////////////
	/**
	 * 增加目录
	 * 
	 * @return Integer
	 */
	public int addFolder(Folder folder);
	/**
	 * 更新
	 * @param folder
	 * @return
	 */
	public int updateAll(Folder folder);
	// ///////////////////////////////
	// ///// 刪除 ////////
	// ///////////////////////////////
	/**
	 * 删除目录
	 * 
	 * @param folder
	 * @return boolean
	 */
	public boolean deleteFolder(@Param("folderId") long folderId);

	// ///////////////////////////////
	// ///// 修改 ////////
	// ///////////////////////////////

	/**
	 * @param folderId
	 * @param name
	 * @param ename
	 * @param content
	 * @param status
	 */
	public void updateFolderById(@Param("folderId") long folderId,
			@Param("name") String name, @Param("ename") String ename,
			@Param("status") FolderConstant.Status status,
			@Param("content") String content, @Param("height") int height,
			@Param("width") int width);

	public int updateSort(@Param("folderId") long folderId,
			@Param("sort") int sort);

	public int updateCount(@Param("folderId") long folderId,
			@Param("count") int count);

	// ///////////////////////////////
	// ///// 查询 ////////
	// ///////////////////////////////
	/**
	 * 得到目录
	 * 
	 * @param folderId
	 * @return Folder
	 */
	public FolderVo getFolderById(@Param("folderId") long folderId);

	/**
	 * 得到所有子目录
	 * 
	 * @param fatherId
	 * @return List<FolderVo>
	 */
	public List<FolderVo> getFolderListByFatherId(
			@Param("fatherId") long fatherId,
			@Param("status") FolderConstant.Status status);

	/**
	 * 通过ename和fatherId获得指定目录
	 * 
	 * @param ename
	 * @param fatherId
	 * @return
	 */
	public Folder getFolderByEname(@Param("ename") String ename);

	/**
	 * @param folderId
	 * @param status
	 */
	public void updateStatus(@Param("folderId") long folderId,
			@Param("status") Status status);

	public int updatePathLevel(@Param("folderId") long folderId,
			@Param("path") String path,
			@Param("level")int level);
	public int updateFatherIdPathLevel(@Param("folderId") long folderId,
			@Param("fatherId")long fatherId,
			@Param("path") String path,
			@Param("level")int level);
	public List<FolderVo> getAllFolderList();

}
