#该网站说明文档

该网站基于springmvc+mybatis+freemarker+bootstrap框架，是一个内容管理系统，或者说快速建站系统。因为国内cms开源框架较少，国外虽然有很多优秀的框架，却并未真正开源，故旨在建立真正cms开源框架。

#第一：网站设置
1)域名端口的修改
本网站的域名时本地域名及端口为：master:8888,域名和端口需要使用者改成自己的域名。其中涉及修改的地方有，
pom.xml中webapp.port;
ueditor.config.json中多处需要替换，其中网站目录我用的/cms，请自行修改;
shamrockcms.sql数据库文件，可能有多处替换;
2）数据库配置修改
configure.properties中自行修改jdbc参数

#第二：网站安装运行
1)将根目录下的shamrockcms.sql文件按上面修改后导入数据库中
2)用eclipse打开项目进行配置之后运行即可；如果用其他命令或者放入tomcat下运行，请自行解决。

#第三：鸣谢
该cms受到师说cms的启发，甚至框架有基于它的前提，但是我进行了更多优秀的开发和改进，如有侵权，不负责任。

#第四：交流
如果大家遇到什么问题，可以进群交流，群号：386233861
博客地址：[shamrockcms基于springmvc+mybatis+freemarker+bootstrap框架的开源建站系统](http://blog.csdn.net/gesanghuazgy/article/details/52846268)

