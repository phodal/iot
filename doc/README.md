#如何使用#

##目录说明##
这是一个简短的功能目录说明，而且还会不断地更新，当有足够的硬件，以及其他语言支持的时候。

 * android 目录下是android的程序
    * 构建工具 gradle
	* IDE     android studio
	* 第三方库 RESTClient,Google GSON
 * hardware 硬件相关程序
    * Arduino Arduino开发板程序
 * python 脚本文件运行于Raspberry PI或者是你的PC
 * rest   用于构建RESTful
    * 语言PHP
	* 框架Laravel
 * doc 基础的一些文档说明
    * dot 构建框架图
	* images 图片放置目录
	* ppt jmpress.js做的ppt
	* nginx nginx配置示例以及说明
	
##使用说明##
需要在开机前用RPI连上硬件，RPI需要联网，在开机前做好准备。

###Raspberry PI###
RPI主要运行获取数据以及与Arduino通讯，通过开头运行python脚本的方法。

修改rc.local
    
     sudo vim /etc/rc.local
	 
添加信命令到exit 0之前

     sudo python /home/iot.py
	 
需要将python目录下的iot.py复制到home目录下,访问/dev/ttyACM0需要root权限。

###Hardware###

####Arduino####
烧写程序到Ardiuino
程序目录Hardware/Arduino/BareMinimum。。

###REST###
如果你有一个可以用于运行的服务器，当然你也可以用RPI去做一个服务器。
那么，请在开始之前配置好LNMP环境或者LAMP等等，即Linux+Nginx/Apache+MySQL/MaraiDB+PHP
需要创建一个名为iot的数据库，以及修改数据库密码，如果你了解此可以跳过这些步骤。
创建数据库步骤如下：

    mysql -uroot -p
	create database iot;	

修改数据库密码的路径

    app/config/database.php

相关位置代码如下：

	'mysql' => array(
		'driver'    => 'mysql',
		'host'      => 'localhost',
		'database'  => 'iot',
		'username'  => 'root',
		'password'  => '',
		'charset'   => 'utf8',
		'collation' => 'utf8_unicode_ci',
		'prefix'    => '',
		),
		

###Android###
构建了一个简单的获取JSON数据及解析的程序，在Android 4.0上运行正常，其他设备或平台暂未测试。
依赖于Google GSON



