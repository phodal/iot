#Minimum Internet of Things#
A Minimum IOT with arduino and raspberry pi.

一个最小的物联网系统设计方案及源码

    android/ for a last test project of android in iot
    rest/ PHP Laravel Framework to create RESTful API
    python/ simple python get from internet run in RPI Or PC
    arduino/ A simple version of Hardware
    doc/  The document files


##System Structure##

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