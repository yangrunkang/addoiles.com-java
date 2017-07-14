package com.shamrock.cms.action;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.shamrock.cms.constant.SystemConstant;
import com.shamrock.cms.exception.ValidateException;
import com.shamrock.cms.service.AdminService;
import com.shamrock.cms.util.HttpUtils;
import com.shamrock.cms.vo.JsonVo;
/**
 * 用户登陆界面
 * @author GunnyZeng
 *
 */
@Controller
@RequestMapping("/admin")
public class AdminAction {
	@Autowired
	private DefaultKaptcha captchaProducer;
	@Autowired
	private AdminService adminService;
	
	/**
	 * 登陆页面
	 * @param request
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value="/login.htm",method=RequestMethod.GET)
	public String login(HttpServletRequest request,ModelMap modelMap){
		return "template/manage/login";
	}
	/**
	 * 生成验证码
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value="/captcha.htm",method=RequestMethod.GET)
	public void captcha(HttpServletRequest request,HttpServletResponse response) throws IOException{
		response.setDateHeader("Expires", 0);
		response.setHeader("Cache-Control", "no-store,no-cache,must-revalidate");
		response.addHeader("Cache-Control", "post-check=0,pre-check=0");
		response.setHeader("Pragma", "no-cache");
		response.setContentType("image/jpeg");
		String capText = captchaProducer.createText();
		request.getSession().setAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY, capText);
		BufferedImage bImage = captchaProducer.createImage(capText);
		ServletOutputStream outputStream =response.getOutputStream();
		ImageIO.write(bImage, "jpg", outputStream);
		outputStream.flush();
		outputStream.close();
	} 
	@ResponseBody
	@RequestMapping(value="/login.json",method=RequestMethod.POST)
	public JsonVo<String> adminLogin(@RequestParam(value="name") String name,
			@RequestParam("password") String password,
			@RequestParam("captcha")String captcha,
			HttpServletRequest request,ModelMap modelMap){
		JsonVo<String> json = new JsonVo<String>();
		try {
			String kaptcha = (String) request.getSession().getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
			//密码格式验证
			if(StringUtils.isBlank(password)){
				json.getErrors().put("password", "密码不能为空");
			}else if(password.length()<6&&password.length()>30){
				json.getErrors().put("password", "密码长度应为6-30之间");
				
			}
			//验证码验证
			if(StringUtils.isNotBlank(kaptcha)&&kaptcha.equalsIgnoreCase(captcha)){
				
			}else{
				json.getErrors().put("captcha", "验证码错误");
			}
			json.check();
			adminService.adminLogin(name, password, request);
		} catch (Exception e) {
			request.getSession().removeAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
			json.setResult(false);
			json.getErrors().put("password", "用户名或密码错误");
			json.setMsg("change_captcha");
		}
		return json;
	}
	@RequestMapping(value="/logout.htm")
	public String logout(HttpServletRequest request,ModelMap modelMap){
		request.getSession().removeAttribute(SystemConstant.SESSION_ADMIN);
		return "redirect:"+HttpUtils.getBasePath(request);
	}
}
