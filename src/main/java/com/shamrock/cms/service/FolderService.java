package com.shamrock.cms.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shamrock.cms.constant.FolderConstant;
import com.shamrock.cms.dao.FolderDao;
import com.shamrock.cms.entity.Folder;
import com.shamrock.cms.exception.FolderNotFoundException;
import com.shamrock.cms.vo.AdminFolderVo;
import com.shamrock.cms.vo.FolderVo;

@Service("folderService")
public class FolderService {
	protected final Logger logger = Logger.getLogger(this.getClass());
	@Autowired
	private FolderDao folderDao;
	@Autowired
	private AdminService adminService;
	@Autowired
	private AdminFolderService adminFolderService;
	/**
	 * 增加目录
	 * @param fatherId
	 * @param name
	 * @param ename
	 * @param status
	 * @param check
	 * @return
	 * @throws FolderNotFoundException
	 */
	@CacheEvict(value="folder")
	@Transactional
	public Folder addFolder(long fatherId,String name,String ename,FolderConstant.Status status,FolderConstant.Check check) throws FolderNotFoundException{
		Folder folder = new Folder();
		folder.setFatherId(fatherId);
		if(fatherId==0){
			folder.setLevel(1);
		}else{
			Folder fatherFolder = this.getFolderById(fatherId);
			folder.setLevel(fatherFolder.getLevel()+1);
		}
		folder.setName(name);
		folder.setEname(ename);
		folder.setContent("");
		folder.setPath("");
		folder.setCount(0);
		folder.setSort(1);
		folder.setStatus(status);
		folder.setCheck(check);
		folder.setCreateTime(new Date());
		folder.setTitle(name);
		folderDao.addFolder(folder);
		long folderId = this.getFolderByEname(ename).getFolderId();
		String path="";
		if(fatherId == 0){
			
			path=folder.getFolderId()+"#";
			
		}else{
			Folder fatherFolder = this.getFolderById(fatherId);
			path = fatherFolder.getPath()+folderId+"#";
			
		}
		folderDao.updatePathLevel(folderId, path, folder.getLevel());
		adminFolderService.addAdminFolder(adminService.getSuperAdminId(), folder.getFolderId());
		
		return folder;
	}
	/**
	 * 删除目录
	 * @param folderId
	 * @return
	 */
	@CacheEvict(value="folder",allEntries=true)
	public boolean deteleFolderById(long folderId){
		return folderDao.deleteFolder(folderId);
	}
	/***
	 * 更新目录
	 * @param folder
	 */
	@CacheEvict(value="folder",allEntries=true)
	public void updateFolder(Folder folder){
		folderDao.updateAll(folder);
	}
	/**
	 * 更新目录
	 * @param folderId
	 * @param name
	 * @param ename
	 * @param status
	 * @param content
	 * @param height
	 * @param width
	 */
	@CacheEvict(value="folder",allEntries=true)
	public void updateFolderById(long folderId,String name,String ename,FolderConstant.Status status, String content,int height,int width){
		folderDao.updateFolderById(folderId, name, ename, status, content, height, width);
	}
	/**
	 * 通过指定Id修改其他目录的序列
	 * @param folderId
	 * @param sort
	 * @return
	 */
	@CacheEvict(value="folder",allEntries=true)
	public int updateSort(long folderId,int sort){
		return folderDao.updateSort(folderId, sort);
	}
    /**
     * 通过指定Id修改目录路径
     * @param folderId
     * @param path
     * @return
     */
	@CacheEvict(value="folder")
	public int updatePathLevel(long folderId,String path,int level){
		return folderDao.updatePathLevel(folderId, path,level);
	}
	/**
	 * 更新指定Id的父id和path及level
	 * @param folderId
	 * @param fatherId
	 * @param path
	 * @param level
	 * @return
	 */
	@CacheEvict(value="folder")
	public int updateFatherIdPathLevel(long folderId,long fatherId,String path,int level){
		return folderDao.updateFatherIdPathLevel(folderId, fatherId, path,level);
	}
	/**
	 * 
	 * @param folderId
	 * @param count
	 * @return
	 */
	public int updateCount(long folderId,int count){
		return folderDao.updateCount(folderId, count);
	}
	/**
	 * 获取指定目录
	 * @param folderId
	 * @return
	 * @throws FolderNotFoundException
	 */
	@Cacheable(value="folder")
	public FolderVo getFolderById(long folderId) throws FolderNotFoundException{
		FolderVo folder = folderDao.getFolderById(folderId);
		if(folder == null){
			throw new FolderNotFoundException("");
		}else{
			logger.debug("目录("+folderId+")中的图片尺寸："+folder.getWidth()+" x "+folder.getHeight());
			return folder;
		}
	}
	
	/**
	 * 获取当前用户的所有目录
	 * @param adminId
	 * @return
	 */
	public List<FolderVo> getAllFolderList(long adminId){
		List<FolderVo> folderList = folderDao.getAllFolderList();
		HashMap<String, FolderVo> folderMap = new HashMap<String, FolderVo>();

		for(FolderVo folder:folderList){
			folderMap.put(folder.getFolderId()+"",folder);
			AdminFolderVo adminFolder = adminFolderService.getAdminFolderById(adminId, folder.getFolderId());
			if(adminFolder == null){
				folder.setOwner("no");
			}else{
				folder.setOwner("yes");
			}
		}
		
		for(FolderVo folder:folderList){
			folder.setPathName(getPathName(folderMap,folder.getPath()));
		}
		
		return folderList;
	}
	/**
	 * 获取所有目录
	 * @return
	 */
	public List<FolderVo> getAllFolderList(){
		return folderDao.getAllFolderList();
	}
	/**
	 * 获取当前用户，除指定目录其子目录的其他全部目录
	 * @param adminId
	 * @param folderId
	 * @return
	 */
	public List<FolderVo> getFolderOtherList(long adminId,long folderId){
		//获取当前用户的所有目录
		List<FolderVo> folderList=getAllFolderList(adminId);
		for(FolderVo folder:folderList){
			String match = "#"+folderId+"#";
			if(folder.getPath().indexOf(match)!=-1){
				folder.setOwner("no");
			}
		}
		return folderList;
	}
	
	@Cacheable(value="folder")
	private String getPathName(HashMap<String, FolderVo> folderMap,String path){
		List<String> names = new ArrayList<String>();
		try {
			String[] folderIds = path.split("#");
			for(String folderId:folderIds){
				names.add(folderMap.get(folderId).getName());
			}
		} catch (Exception e) {
			logger.fatal(path+"-"+StringUtils.join(path.split("#"),","));
		}
		return StringUtils.join(names," - ");
 	}
	/**
	 * 获得所有子目录
	 * @param fatherId
	 * @param status
	 * @return
	 */
	@Cacheable(value="folder")
	public List<FolderVo> getFolderListByFatherId(long fatherId,FolderConstant.Status status){
		return folderDao.getFolderListByFatherId(fatherId, status);
	}
	/**
	 * 通过ename和fathreId获得目录
	 * @param ename
	 * @return
	 * @throws FolderNotFoundException
	 */
	@Cacheable(value="folder")
	public Folder getFolderByEname(String ename) throws FolderNotFoundException{
		Folder folder = folderDao.getFolderByEname(ename);
		if(folder == null){
			throw new FolderNotFoundException(ename+" 目录,不存在");
		}else{
			return folder;
		}
	}
	@Cacheable(value="folder")
	public boolean isFolderByEname(String ename){
		Folder folder = folderDao.getFolderByEname(ename);
		if(folder == null){
			return false;
		}else{
			return true;
		}
	}
	/**
	 * 得到目录的path
	 * @param folderId
	 * @return
	 * @throws Exception
	 */
//	@Cacheable(value="folder")
	public List<FolderVo> getFolderPathListByFolderId(long folderId) throws Exception{
		List<FolderVo> list = new ArrayList<FolderVo>();
		if(folderId ==0){
			return list;
		}else{
			Folder folder = this.getFolderById(folderId);
			String[] str = folder.getPath().split("#");
			for(int i=0;i<folder.getLevel();i++){
				FolderVo fold = this.getFolderById(Long.parseLong(str[i]));
				list.add(fold);
			}
			return list;
		}
	}
	
	@CacheEvict(value="folder")
	public void updateStatus(long folderId,FolderConstant.Status status){
		folderDao.updateStatus(folderId, status);
	}
	/**
	 * 判断英文目录名是否已存在
	 * @param ename
	 * @return
	 */
	@Cacheable(value="folder")
	public boolean isFolderEname(String ename){
		try {
			this.getFolderByEname(ename);
			return false;
		} catch (FolderNotFoundException e) {
			return true;
		}
	}
	public long firstFolderId(long folderId){
		FolderVo folder = folderDao.getFolderById(folderId);
		String[] folderList = folder.getPath().split("#");
		return Long.parseLong(folderList[0]);
 	}
	public long secondFolderId(long folderId){
		FolderVo folder = folderDao.getFolderById(folderId);
		String[] folderList = folder.getPath().split("#");
		return Long.parseLong(folderList[1]);
 	}
}
