package com.shamrock.cms.service;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.shamrock.cms.constant.ArticleConstant;
import com.shamrock.cms.constant.FolderConstant;
import com.shamrock.cms.dao.ArticleDao;
import com.shamrock.cms.entity.Article;
import com.shamrock.cms.entity.Folder;
import com.shamrock.cms.vo.ArticleVo;
import com.shamrock.cms.vo.FolderVo;
import com.shamrock.cms.vo.PageVo;
import com.shamrock.cms.exception.ArticleNotFoundException;
import com.shamrock.cms.exception.FolderNotFoundException;
import com.shamrock.cms.exception.UploadException;
import com.shamrock.cms.util.MediaUtils;

/**
 * 
 * 文章服务
 * 
 * @author GunnyZeng
 * 
 */
@Service("articleService")
public class ArticleService {

	@Autowired
	private ArticleDao articleDao;

	@Autowired
	private AdminService adminService;

	@Autowired
	private FolderService folderService;

	@Autowired
	private MediaService attachmentService;

	// ///////////////////////////////
	// ///// 增加 ////////
	// ///////////////////////////////

	/**
	 * @param folderId
	 * @param adminId
	 * @param title
	 * @param summary
	 * @param status
	 * @param content
	 * @param file
	 * @param createTime
	 * @return
	 * @throws FolderNotFoundException
	 * @throws UploadException
	 * @throws IOException
	 */
	@CacheEvict(value = "article", allEntries = true)
	public Article addArticle(long folderId, long adminId, String title,
			String summary, ArticleConstant.Status status,String content,
			MultipartFile file, String createTime)
			throws FolderNotFoundException, UploadException,
			IOException {
		FolderVo folder = folderService.getFolderById(folderId);
		Article article = new Article();
		Date now = new Date();
		String picture = "";
		if (file != null && !file.isEmpty()) {
			picture = MediaUtils.saveImage(file, folder.getWidth(),
					folder.getHeight());
		}
		if (folder.getCheck().equals(FolderConstant.Check.yes)) {
			article.setCheck(ArticleConstant.Check.init);
		} else {
			article.setCheck(ArticleConstant.Check.yes);
		}
		article.setFolderId(folder.getFolderId());
		article.setPath(folder.getPath());
		article.setAdminId(adminId);
		article.setTitle(title);
		article.setSummary(summary);
		article.setContent(content);
		article.setViewCount(0);
		article.setCommentCount(0);
		article.setPicture(picture);
		article.setStatus(status);
		if (StringUtils.isBlank(createTime)) {
			article.setCreateTime(now);
		} else {
			SimpleDateFormat sdf = new SimpleDateFormat(
					"yyyy-MM-dd");
			Date date;
			try {
				date = sdf.parse(createTime);
			} catch (ParseException e) {
				date = now;
			}
			article.setCreateTime(date);
		}
		article.setUpdateTime(now);
		articleDao.addArticle(article);
		return articleDao.getArticleById(article.getArticleId());
	}

	// ///////////////////////////////
	// ///// 刪除 ////////
	// ///////////////////////////////

	/**
	 * 删除文件
	 * 
	 * @param fileId
	 * @return boolean
	 */
	@CacheEvict(value = "article", allEntries = true)
	public boolean deleteArticleById(long articleId) {
		return articleDao.deleteArticleById(articleId);
	}

	// ///////////////////////////////
	// ///// 修改 ////////
	// ///////////////////////////////

	/**
	 * 修改文件
	 * 
	 * @param fileId
	 * @param folderId
	 * @param adminId
	 * @param picture
	 * @param name
	 * @param content
	 * @param type
	 * @param status
	 * @return
	 * @throws UploadException
	 * @throws ParseException
	 * @throws IOException
	 * @throws FolderNotFoundException 
	 */
	@CacheEvict(value = "article", allEntries = true)
	public Article updateArticle(long articleId, long folderId,
			long adminId, String title, String summary,
			String content, ArticleConstant.Status status,MultipartFile file,
			String updateTime) throws UploadException, IOException, FolderNotFoundException {
		Date now = new Date();
		Article article = articleDao.getArticleById(articleId);
		FolderVo folder = folderService.getFolderById(folderId);
		String picture = article.getPicture();
		//Date createTime = article.getCreateTime();
		if (file != null && !file.isEmpty()) {
			picture = MediaUtils.saveImage(file, folder.getWidth(),
					folder.getHeight());
		}
		article.setFolderId(folder.getFolderId());
		article.setPath(folder.getPath());
		article.setAdminId(adminId);
		article.setTitle(title);
		article.setSummary(summary);
		article.setContent(content);
		article.setViewCount(0);
		article.setCommentCount(0);
		article.setPicture(picture);
		article.setStatus(status);
		if (article.getCheck().equals(ArticleConstant.Check.no)) {
			article.setCheck(ArticleConstant.Check.init);
		}
		if (StringUtils.isBlank(updateTime)) {
			article.setUpdateTime(now);
		} else {
			SimpleDateFormat sdf = new SimpleDateFormat(
					"yyyy-MM-dd");
			Date date;
			try {
				date = sdf.parse(updateTime);
			} catch (ParseException e) {
				date = now;
			}
			article.setUpdateTime(date);
		}
		articleDao.updateArticle(article);
		return article;
	}

	/**
	 * 更新浏览人数
	 * 
	 * @param fileId
	 * @param viewCount
	 * 
	 */
	public void updateViewCount(long articleId, int nowViewCount) {
		articleDao.updateViewCount(articleId, nowViewCount + 1);
	}
	/**
	 * 更新指定目录id的path
	 * @param folderId
	 * @param path
	 * @return
	 */
	@CacheEvict(value = "article", allEntries = true)
	public int updatePath(long folderId,String path){
		return articleDao.updatePath(folderId, path);
	}

	// ///////////////////////////////
	// ///// 查詢 ////////
	// ///////////////////////////////

	/**
	 * 得到文件
	 * 
	 * @param fileId
	 * @return File
	 * @throws ArticleNotFoundException
	 */
	@Cacheable(value = "article", key = "'getArticleById_'+#articleId")
	public ArticleVo getArticleById(long articleId)
			throws ArticleNotFoundException {
		ArticleVo articleVo = articleDao.getArticleById(articleId);
		articleVo.setAdmin(adminService.getAdminById(articleVo.getAdminId()));
		if (articleVo == null) {
			throw new ArticleNotFoundException(articleId
					+ " 文件，不存在");
		} else {
			return articleVo;
		}
	}

	/**
	 * 得到目录的显示的文件分页
	 * 
	 * @param folderId
	 * @return pageVo
	 * @throws FolderNotFoundException
	 */
	@Cacheable(value = "article")
	public PageVo<ArticleVo> getArticlePageByFolderId(long folderId,
			int pageNum, int rows) throws FolderNotFoundException {
		PageVo<ArticleVo> pageVo = new PageVo<ArticleVo>(pageNum);
		FolderVo folder = folderService.getFolderById(folderId);
		pageVo.setRows(rows);
		pageVo.setCount(articleDao
				.getArticleCountOfDisplayByPath(folder
						.getPath()));
		List<ArticleVo> articlelist = articleDao
				.getArticleListOfDisplayByPath(
						folder.getPath(),
						pageVo.getOffset(),
						pageVo.getRows());
		for (ArticleVo article : articlelist) {
			FolderVo articleFolder = folderService
					.getFolderById(article.getFolderId());
			article.setAdmin(adminService.getAdminById(article.getAdminId()));
			article.setFolder(articleFolder);
		}
		pageVo.setList(articlelist);
		return pageVo;
	}
	/**
	 * 获取所有目录指定页码和行数的文章列表
	 * @param pageNum
	 * @param rows
	 * @return
	 * @throws FolderNotFoundException
	 */
	@Cacheable(value = "article")
	public PageVo<ArticleVo> getArticlePage(String path,int pageNum, int rows) throws FolderNotFoundException {
		PageVo<ArticleVo> pageVo = new PageVo<ArticleVo>(pageNum);
		pageVo.setRows(rows);
		pageVo.setCount(articleDao.getArticleCountOfDisplayByPath(path));
		List<ArticleVo> articlelist = articleDao.getArticleListOfDisplayByPath(path,pageVo.getOffset(),pageVo.getRows());
		for (ArticleVo article : articlelist) {
			FolderVo articleFolder = folderService
					.getFolderById(article.getFolderId());
			article.setAdmin(adminService.getAdminById(article.getAdminId()));
			article.setFolder(articleFolder);
		}
		pageVo.setList(articlelist);
		return pageVo;
	}

	/**
	 * 获取某种文件的分页
	 * 
	 * @param type
	 * @param status
	 * @param pageNum
	 * @return PageVo<File>
	 * @throws Exception 
	 * 
	 */
	public PageVo<ArticleVo> getArticlePageByFolderId(long adminId,
			long folderId, ArticleConstant.Check check, int pageNum)
			throws Exception {
		PageVo<ArticleVo> pageVo = new PageVo<ArticleVo>(pageNum);
		pageVo.setRows(20);
		List<ArticleVo> list = new ArrayList<ArticleVo>();
		int count = 0;
		if (folderId == 0) {
			count = this.getArticleCountByAdminIdAndFolderId(
					adminId, 0, check);
			list = this.getArticleListByAdminIdAndFolderId(adminId,
					0, check, pageVo.getOffset(),
					pageVo.getRows());
		} else {
			list = this.getArticleListByAdminIdAndFolderId(adminId,
					folderId, check, pageVo.getOffset(),
					pageVo.getRows());
			count = this.getArticleCountByAdminIdAndFolderId(
					adminId, folderId, check);
		}
		for (ArticleVo article : list) {
			try {
				article.setFolder(folderService
						.getFolderById(article
								.getFolderId()));
				article.setFolderPathList(folderService
						.getFolderPathListByFolderId(article
								.getFolderId()));
				article.setAdmin(adminService.getAdminById(article.getAdminId()));
			} catch (FolderNotFoundException e) {
				article.setFolder(new Folder());
			}
		}
		pageVo.setList(list);
		pageVo.setCount(count);
		return pageVo;
	}

	/**
	 * @param adminId
	 * @param folderId
	 * @param offset
	 * @param rows
	 * @return
	 * @throws FolderNotFoundException
	 */
	public List<ArticleVo> getArticleListByAdminIdAndFolderId(long adminId,
			long folderId, ArticleConstant.Check check,
			long offset, long rows) throws FolderNotFoundException {
		String path = "";
		if (folderId != 0) {
			Folder folder = folderService.getFolderById(folderId);
			path = folder.getPath();
		}
		List<ArticleVo> articleList = articleDao
				.getArticleListByAdminIdAndPath(adminId, path,
						check, offset, rows);
		return articleList;
	}

	/**
	 * @param adminId
	 * @param folderId
	 * @return
	 * @throws FolderNotFoundException
	 */
	public int getArticleCountByAdminIdAndFolderId(long adminId,
			long folderId, ArticleConstant.Check check)
			throws FolderNotFoundException {
		String path = "";
		if (folderId != 0) {
			Folder folder = folderService.getFolderById(folderId);
			path = folder.getPath();
		}
		return articleDao.getArticleCountByAdminIdAndPath(adminId,
				path, check);
	}

	/**
	 * @param folderId
	 * @return
	 * @throws FolderNotFoundException
	 */
	public int getArticleCountByFolderId(long folderId)
			throws FolderNotFoundException {
		return articleDao.getArticleCountByFolderId(folderId);
	}

	@CacheEvict(value = "article", allEntries = true)
	public void updateCheck(long articleId,ArticleConstant.Check check) {
		articleDao.updateCheck(articleId, check);
	}

	/**
	 * @param path
	 * @param offset
	 * @param rows
	 * @return
	 */
	public List<ArticleVo> getArticleListOfDisplayByPath(String path,
			int offset, int rows) {
		List<ArticleVo> articlelist = articleDao
				.getArticleListOfDisplayByPath(path, offset,
						rows);
		return articlelist;
	}

}
