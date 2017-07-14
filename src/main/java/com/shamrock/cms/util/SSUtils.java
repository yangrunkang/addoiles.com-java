package com.shamrock.cms.util;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;
import org.springframework.web.util.HtmlUtils;

import freemarker.template.utility.HtmlEscape;

/**
 * @author GunnyZeng
 * 
 */
public class SSUtils {

	/**
	 * 把骆驼命名法的变量，变为大写字母变小写且之前加下划线
	 * 
	 * @param str
	 * @return
	 */
	public static String toUnderline(String str) {
		str = StringUtils.uncapitalize(str);
		char[] letters = str.toCharArray();
		StringBuilder sb = new StringBuilder();
		for (char letter : letters) {
			if (Character.isUpperCase(letter)) {
				sb.append("_" + letter + "");
			} else {
				sb.append(letter + "");
			}
		}
		return StringUtils.lowerCase(sb.toString());
	}

	public static String toText(String str) {
		return HtmlUtils.htmlEscape(str);
	}
	
	public static String toHTML(String str) {
		return Jsoup.clean(str, Whitelist.relaxed());
	}
	/**
	 * 截取字符串指定字节长度，其他用...表示
	 * @param str
	 * @param len
	 * @return
	 */
	public static String getFixedLengthStr(String str,int len){
		if(str==null||str.length()<=len){
			return str;
		}
		int t=0;
		String res="";
		for(int i=0;i<str.length()&&t<len;i++){
			if(str.charAt(i)>=0x4E00&&str.charAt(i)<=0x9FA5){
				res+=str.charAt(i);
				t+=2;
			}else{
				String temp="";
				int j=i;
				for(;j<str.length()&&j<=len;j++){
					temp+=str.charAt(j);
					if(str.charAt(j)==' '){
						break;
					}
				}
				if(j<=len){
					res+=temp;
					i=j;
					t=t+j-i;
				}else{
					return res+"...";
				}
			}
		}
		return res+"...";
	}
	public static void main(String[] args) {
		String text = "您好，I am a good boy<script>;alert(123);</script>";
		System.out.println(getFixedLengthStr(text, 5));
		System.out.println(SSUtils.toText(text));
	}
}
