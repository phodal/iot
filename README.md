#Minimum Internet of Things#
A Minimum IOT with arduino and raspberry pi.

一个最小的物联网系统设计方案及源码

    android/ 一个最小的Android程序实例
    rest/ PHP Laravel Framework to create RESTful API
    python/ 简单的pyhon示例
    hardware/  硬件串口通信收集
	 -/ arduino Arduino板
    doc/  文档 简介ppt nginx配置 系统框架图


##系统框架图##

![](https://raw.github.com/gmszone/iot/master/doc/dot/struct.jpg)

##Documention##

[Wiki][3]

[一个最小的物联网系统设计方案及源码][2]

[最小物联网系统（一）——系统组成][4]

[最小物联网系统（二）——RESTful][5]

[最小物联网系统（三）——创建RESTful][6]

[最小物联网系统（四）——详解Laravel的RESTful][7]

[最小物联网系统（五）——Laravel RESTful模板化][8]

[最小物联网系统（六）——Ajax打造可视化][9]

[最小物联网系统（七）——与服务器通讯][10]

[最小物联网系统（八）——与单片机通讯][11]

[最小物联网系统（九）——Android客户端][12]

##How to test On you computer##
 1. If you have a Arduino.

 2. Upload the arduino/BareMinimum.ino to you Arduino 


 3. if Windows need to Change the /dev/ttyACM0 to the COM port for example COM3.If Use of ttyACM0 need to change it to suitable

        cd python
 
        sudo python get.py

 4. open localhost/athome/create to create a seed.and open /athome/1/edit for a status change

 5. For a basic test you can visit [b.phodal.com][1]
 
##How to test On you Android Phone

![](https://raw.github.com/gmszone/iot/master/doc/images/android.png)

  1. Download the Android app [Stay at Home][13]

##Basic##

- RESTful Services
- Serial Commucation

##Language##
- PHP(Laravel Framework)
- Python(for Raspberry pi)
- Processing/C/C++ (Arduino)

##Seed##

    php  artisan db:seed

##交流##

QQ群：348100589

BBS： http://bbs.phodal.com


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


[1]:http://b.phodal.com
[2]:http://www.phodal.com/blog/bare-minimum-iot
[3]:https://github.com/gmszone/iot/wiki
[4]:http://www.phodal.com/blog/bare-minimum-iot-system-structure/
[5]:http://www.phodal.com/blog/bare-minimum-iot-system-restful/
[6]:http://www.phodal.com/blog/bare-minimum-iot-system-create-restful/
[7]:http://www.phodal.com/blog/bare-minimum-iot-system-about-restful/
[8]:http://www.phodal.com/blog/bare-minimum-iot-system-restful-template/
[9]:http://www.phodal.com/blog/bare-minimum-iot-system-ajax/
[10]:http://www.phodal.com/blog/bare-minimum-iot-system-date-commucation/
[11]:http://www.phodal.com/blog/bare-minimum-iot-system-mcu-commucation/
[12]:http://www.phodal.com/blog/bare-minimum-iot-system-android-example/
[13]:https://github.com/gmszone/Home-Anywhere/raw/master/app/build/apk/app-debug-unaligned.apk
[14]:http://bbs.phodal.com