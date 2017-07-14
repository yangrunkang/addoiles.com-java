package com.shamrock.cms.entity;

import java.util.Date;

import com.shamrock.cms.constant.FolderConstant;

/**
 * 目录实体
 * 
 * @author zsy
 * 
 */
public class Folder {
	/**
	 * 目录Id
	 */
	private long folderId;

	/**
	 * 父亲Id
	 */
	private long fatherId;

	/**
	 * 英文名称
	 */
	private String ename;

	/**
	 * 目录名称
	 */
	private String name;

	/**
	 * 内容
	 */
	private String content;

	/**
	 * 路径
	 */
	private String path;
	/**
	 * 层级
	 */
	private int level;

	/**
	 * 排序
	 */
	private int sort;
	/**
	 * 宽
	 */
	private int width;
	/**
	 * 高
	 */
	private int height;

	/**
	 * 文件数
	 */
	private int count;

	/**
	 * 状态
	 */
	private FolderConstant.Status status;

	/**
	 * 审核
	 */
	private FolderConstant.Check check;

	/**
	 * 创建时间
	 */
	private Date createTime;
	
	/**
	 * 如果该目录是网站根目录，则此字段代表网站的名字
	 */
	private String title;
	
	/**
	 *  如果该目录是网站根目录，则此字段代表网站的logo
	 */
	private String logo;

	public long getFolderId() {
		return folderId;
	}

	public void setFolderId(long folderId) {
		this.folderId = folderId;
	}

	public long getFatherId() {
		return fatherId;
	}

	public void setFatherId(long fatherId) {
		this.fatherId = fatherId;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public final FolderConstant.Status getStatus() {
		return status;
	}

	public final void setStatus(FolderConstant.Status status) {
		this.status = status;
	}

	public final FolderConstant.Check getCheck() {
		return check;
	}

	public final void setCheck(FolderConstant.Check check) {
		this.check = check;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}
	
	
	
}
