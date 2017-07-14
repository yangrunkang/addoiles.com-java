package com.shamrock.cms.service;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shamrock.cms.constant.GuestbookConstant;
import com.shamrock.cms.dao.GuestbookDao;
import com.shamrock.cms.entity.Guestbook;
import com.shamrock.cms.vo.GuestbookVo;
import com.shamrock.cms.vo.PageVo;

@Service
public class GuestbookService {

	@Autowired
	private GuestbookDao guestbookDao;

	public Guestbook addGuestbook(String name, String email, String title,
			String content) {
		Guestbook guestbook = new Guestbook();
		guestbook.setName(name);
		guestbook.setEmail(email);
		guestbook.setTitle(title);
		guestbook.setContent(content);
		guestbook.setReply("");
		guestbook.setStatus(GuestbookConstant.Status.init);
		guestbook.setCreateTime(new Date());
		guestbook.setReplyTime(guestbook.getCreateTime());
		guestbookDao.addGuestbook(guestbook);
		return guestbook;
	}

	public int updateReplyByMessageId(String reply, long messageId,
			GuestbookConstant.Status status) {
		return guestbookDao.updateReplyById(reply, messageId, status,
				new Date());
	}

	public int updateStatusByMessageId(GuestbookConstant.Status status,
			long messageId) {
		return guestbookDao.updateStatusById(status, messageId);
	}

	public GuestbookVo getGuestbookById(long messageId) {
		return guestbookDao.getGuestbookById(messageId);
	}

	public List<GuestbookVo> getGuestbookList(GuestbookConstant.Status status,
			long offset, long rows) {
		List<GuestbookVo> list = guestbookDao.getGuestbookList(status, offset,
				rows);
		return list;
	}

	public int getGuestbookCountList(GuestbookConstant.Status status) {
		return guestbookDao.getGuestbookCountList(status);
	}

	public PageVo<GuestbookVo> getMessageBoardPage(int pageNum,
			GuestbookConstant.Status status, String number) {
		PageVo<GuestbookVo> pageVo = new PageVo<GuestbookVo>(pageNum);
		pageVo.setRows(10);
		List<GuestbookVo> list = this.getGuestbookList(status,
				pageVo.getOffset(), pageVo.getRows());
		if (StringUtils.isBlank(number)) {
			for (GuestbookVo message : list) {
				if (message.getContent().length() > 25) {
					message.setContent(message.getContent().substring(0, 23)
							+ "...");
				}
			}
		}
		pageVo.setList(list);
		pageVo.setCount(this.getGuestbookCountList(status));
		return pageVo;
	}

}
