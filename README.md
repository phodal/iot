#文档#
[最小物联网系统文档][https://github.com/gmszone/iot-doc]

#Minimum Internet of Things#
A Minimum IOT with arduino and raspberry pi.

一个最小的物联网系统设计方案及源码

    android/ 一个最小的Android程序实例
    rest/ PHP Laravel Framework to create RESTful API
    python/ 简单的pyhon示例
    hardware/  硬件串口通信收集
	 -/ arduino Arduino板
    doc/  文档 简介ppt nginx配置 系统框架图
    dashboard/ 基于ruby框架dashing的dashboard

##简要的初始化代码说明##
代码中因为有两个子模块，即Android与REST，Android是一个简单的Android程序示例,REST作为子模块的原因是考虑到后期会用更简单的源码来替换。但是laravel作为一个运行环境，还是很理想的。

先clone

    git clone https://github.com/gmszone/iot.git iot

子模块

    git submodule init
    git submodule update

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

[最小物联网系统设计——给Laravel添加测试][15]

[最小物联网系统——Dashboard][16]

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

##如何添加硬件##

对于一个有硬件需求的项目来说，足够多的硬件支持对于这个系统后期的扩展有着相当重要的意义。至于在这个最小物的物联网系统设计的过程中，一开始用的是Arduino只要是对于其他软件开发者来说是相对简单的，我们也需要足够多的硬件支持来支持硬件开发者。

通常在这里我们说的硬件是独立于RPI的硬件，也就是用串口通信来控制的部分，只是在这里我们也可以用其他的通信方式来替代串口通信。只是对应于这其他来说，串口通信是比较常用的，及简洁的。
（ps:PRI指的是Raspberry PI，也就是其的缩写。）

###关于硬件###

硬件的种类比较繁多，可能有FPGA,51,STM32,AVR等等系列的芯片，至于ARM，如果有足够的网络支持我想可以替换掉RPI。

 - 在这里的硬件通常是指可以替换其他硬件，通过使用串口通信的方式进行控制的。
 - 硬件的串口通信为比较简洁的两部分，即由接收到的串口通信的1和0来实现简单的控制。
 - 这里说的简单的控制指的是我们可以用LED的亮和灭来充当一个状态控制显示。

你可以自由的添加硬件种类，不过请让源码simple，当你需要推送到github上面可以联系我。

###添加到github###

####如果你没有用过github####

 - 注册一个github帐号
 - 建一个简单的项目及使用git版本管理工具来进行基本的操作熟悉
 - git clone 项目到你的工作目录。
    - 如果你不熟悉git的用法，那么请先clone
    - 将你修改完的代码放至指定的目录，hardware/硬件设备
    - 确认没有添加其他不必要的东西，如可执行的二进制文件也不是必需的。
 - git push 就这简单
    - 你还需要联系我或者其他项目成员获得push权限。

 ####注意事项####

 - 不要push可执行的二进制文件
 - 仅工程及源码就足够了
 - 如果一个硬件下面有多个不同的源码库
   - 假设有lib1以及lib2，硬件为atmega16
   - 重新命名原来的项目名为atmega16-lib1，新的项目名为atmega16-lib2再进行push

##关于物联网##
<blockquote>物联网（Internet of Things，缩写IOT）是一个基于互联网、传统电信网等信息承载体，让所有能够被独立寻址的普通物理对象实现互联互通的网络。</blockquote>

<blockquote>物联网一般为无线网，由于每个人周围的设备可以达到一千至五千个，所以物联网可能要包含500万亿至一千万亿个物体，在物联网上，每个人都可以应用电子标签将真实的物体上网联结，在物联网上都可以查找出它们的具体位置。通过物联网可以用中心计算机对机器、设备、人员进行集中管理、控制，也可以对家庭设备、汽车进行遥控，以及搜寻位置、防止物品被盗等各种应用。</blockquote>

简单的来说
Internet是一个由计算机组成的网络，那么物联网就是一个由物体(Things)组成的网络，只不过其依赖于Internet，是Internet的一部分。

##最小物联网系统##
这个也就是我们要讨论的主题了，我们要做的最小物联网系统其实也就相当于是一个平台。我们可以上传我们各种物体的信息，同时给予这些物体一些属性，我们也可以通过网络来控制这些物体，而他们之间也可以相互控制。因此，我们需要给他们提供一个网络，这就是RESTful的由来。

所以我们也稍微了解一下RESTful吧。

###RESTful###

<blockquote>REST 从资源的角度来观察整个网络，分布在各处的资源由URI确定，而客户端的应用通过URI来获取资源的表征。获得这些表征致使这些应用程序转变了其状态。随着不断获取资源的表征，客户端应用不断地在转变着其状态，所谓表征状态转移（Representational State Transfer）。</blockquote>

我们的世界是由资源来组成的，一个物体也就相当于是一个资源，以这种方式来构建我们的物联网系统，在目前来说是再好不过的一个方案了。

<blockquote>REST架构就是希望能够统一这一类的Hypermedia Controls, 赋予他们标准的, 高度可扩展的标准语义及表现形式, 使得甚至无人工干预的机器与机器间的通用交互协议边的可能.</blockquote>

这个也就是我们的目的了，物联网最后的核心就是使物体与物体之间的交互成为可能。

那么，这里也就解释了为什么我们要用RESTful来做这个最小系统的原因了。

###最小系统中的RESTful###

例如，一个简单的例子，
列举所有物体状态，

    GET http://localhost/athome

呈现某一特定状态，

    GET http://localhost/athome/1/

剩下的部分这里就不多说了，多说无益，可以自己谷歌去。

接着我们要讨论的就是系统框架

##系统框架##

###为什么是Raspberry PI###

Raspberry Pi在这里只是充当了数据的发送和接收，虽然我们可以直接将Raspberry PI作为控制的对象，但是将这个从中剥离来讲清楚系统的结构会更加简单。从而，可以让我们把核心注意力聚焦在要解决的问题上，也就是数据传送，每个部分都可以简单地从系统剥离出来，用另外的事物来替换。


###为什么是Arduino###
这个问题的答案和上面是一样的，只是因为有些搞物联网是从软件过来的，对于他们来说去理解端口的难道可能有点大。所以，我们在简化系统设计的同时，也把系统的代码简化了。因为Arduino足够的简单，我们可以关心问题的本质，而不是如何去编程。

###为什么是Ajax###
至于什么是Ajax，

<blockquote>AJAX即“Asynchronous JavaScript and XML”（异步的JavaScript与XML技术），指的是一套综合了多项技术的浏览器端网页开发技术。
</blockquote>

这里的目的只是在于演示如何运用这些数据，使它具有他应有的价值，而不在于技术本身。当然ajax不是必需的，如果你需要的只是用来控制这个灯。

###为什么是Laravel###
只是因为个人喜爱，你也可以用Ruby On Rails来搭建这样一个功能，或者是Java。只不过PHP在我的服务器上运行得挺不错的，而且我又不需要重新去写配置那些配置。
同时Laravel可以简单的开发我们所需要的功能，换句话说他是PHP世界的Ruby On Rails。

## Liscense

© 2014 Phodal Huang. This code is distributed under the MIT license.


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
[15]:http://www.phodal.com/blog/bare-minimum-iot-system-add-test-for-laravel/
[16]:http://www.phodal.com/blog/bare-minimum-iot-system-dashboard-framework-dashing/
