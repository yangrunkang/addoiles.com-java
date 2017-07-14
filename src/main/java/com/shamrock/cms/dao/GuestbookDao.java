package com.shamrock.cms.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.shamrock.cms.constant.GuestbookConstant;
import com.shamrock.cms.entity.Guestbook;
import com.shamrock.cms.vo.GuestbookVo;

@Repository("guestbookDao")
public interface GuestbookDao {

	public int addGuestbook(Guestbook guestbook);

	public int updateReplyById(@Param("reply") String reply,
			@Param("guestbookId") long guestbookId,
			@Param("status") GuestbookConstant.Status status,
			@Param("replyTime") Date replyTime);

	public GuestbookVo getGuestbookById(@Param("guestbookId") long guestbookId);

	public List<GuestbookVo> getGuestbookList(
			@Param("status") GuestbookConstant.Status status,
			@Param("offset") long offset, @Param("rows") long rows);

	public int getGuestbookCountList(
			@Param("status") GuestbookConstant.Status status);

	public int updateStatusById(
			@Param("status") GuestbookConstant.Status status,
			@Param("guestbookId") long guestbookId);
}
