package com.addoiles.test;


import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.shamrock.cms.dao.AdminDao;
import com.shamrock.cms.dao.AdminFolderDao;
import com.shamrock.cms.dao.AdminMapper;
import com.shamrock.cms.dao.ArticleDao;
import com.shamrock.cms.dao.ConfigDao;
import com.shamrock.cms.dao.FolderDao;
import com.shamrock.cms.dao.GuestbookDao;
import com.shamrock.cms.dao.HeadlineDao;
import com.shamrock.cms.dao.MediaDao;
import com.shamrock.cms.entity.Admin;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class DaoTest {

	@Resource(name="adminMapper")
	private AdminMapper adminMapper;
	@Resource(name="adminDao")
	private AdminDao adminDao;
	@Resource(name="adminFolderDao")
	private AdminFolderDao adminFolderDao;
	@Resource(name="articleDao")
	private ArticleDao articleDao;
	@Resource(name="configDao")
	private ConfigDao configDao;
	@Resource(name="folderDao")
	private FolderDao folderDao;
	@Resource(name="guestbookDao")
	private GuestbookDao guestbookDao;
	@Resource(name="headlineDao")
	private HeadlineDao headlineDao;
	@Resource(name="mediaDao")
	private MediaDao mediaDao;
	public void adminTester(){
		System.out.println("-----insert test-----");
		Admin admin = new Admin();
		admin.setCreateTime(new Date());;
		admin.setName("哈哈");
		admin.setPassword("123456");
		int res=adminDao.addAdmin(admin);
		System.out.println(res);
		
		System.out.println("-----delete test-----");
		adminDao.deleteAdmin(3L);
		
		System.out.println("-----update test-----");
		adminDao.updateAdminByadminId(2L, "456789");
		
		System.out.println("-----offset rows test-----");
		adminDao.getAllList(1L, 1L);
		
		System.out.println("-----get count test-----");
		System.out.println(adminDao.getAllListCount());
		
		System.out.println("-----get by name test-----");
		System.out.println(adminDao.getAdminByName("观音").getAdminId());
	}
	
	
	public void adminMapperTester(){
		Admin admin = new Admin();
		admin=adminMapper.selectByPrimaryKey(1L);
		System.out.println(admin.getName()+","+admin.getPassword());
		
		
		admin = new Admin();
		admin.setCreateTime(new Date());;
		admin.setName("观音");
		admin.setPassword("123456");
		int res=adminMapper.insert(admin);
		System.out.println(res);
	}
	
	@Test
	public void adminFolderDaoTest(){
		assert(adminFolderDao.getAdminFolderListById(1L).size()>0);
	}
	
	@Test
	public void articleDaoTest(){
		assert(articleDao.getArticleCountByFolderId(1L)>0);
	}
	
	@Test
	public void configDaoTest(){
		assert(configDao.getConfigByKey("shamrock_static")!=null);
	}
	
	@Test
	public void folderDaoTest(){
		assert(folderDao.getFolderById(1L)!=null);
	}
	
	@Test
	public void guestbookDaoTest(){
		assert(guestbookDao.getGuestbookById(1L)==null);
	}
	
	@Test
	public void headlineDaoTest(){
		assert(headlineDao.getHeadlineById(1L)==null);
	}
	
	@Test
	public void mediaDaoTest(){
		assert(mediaDao.getMediaById(1L)==null);
	}
}
