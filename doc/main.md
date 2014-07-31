##一个最小的物联网系统设计方案及源码##

    或许这个可以当成是你的毕业设计又或者你可以用它来控制你想控制的东西，总之你可以用它来做一个最小的物联网系统。

    不过，在这里可能没有那么复杂的功能，因为强调的是最小。BareMinimum，这也是为什么我没有改Arduino上面的工程名的原因，因为它是最小的，(PS：大家都懂的，如果玩硬件）。物联网，这个东西一直很复杂，也不是很复杂，只是从硬件到软件涉及到的东西过多了，不止一点点。当然写在本文的方案也有很多，不止这一个，只是这个算是基本的最小的，仅此而已。

###框架:###

*   PHP Laravel*   jQuery (Javascript 主要用于Ajax)
*   jQuery Mobile（可选）(我觉得我有点懒，于是从原来做的项目直接拿了出来）
*   Bootstrap (可选） (其实没有多大实际用处，只是因为好看和jQuery Mobile一样)

###语言:###

    Processing/C/C++ Arduino用 

    Python 如果你有Raspberry Pi或者与之相近的都可以，只要可以与Arduino串口通信

    PHP 我学得不是很好，因为Laravel没有让我学好，但是让我能做想做的事。

###相关文章###
    
[一个最小的物联网系统设计方案及源码][2]

[最小物联网系统（一）——系统组成][4]

[最小物联网系统（二）——RESTful][5]

[最小物联网系统（三）——创建RESTful][6]

[最小物联网系统（四）——详解Laravel的RESTful][7]

[最小物联网系统（五）——Laravel RESTful模板化][8]

[最小物联网系统（六）——Ajax打造可视化][9]

### 
    相关知识

#### 
    搞硬件的同学需要重点了解的知识

*   RESTful
*   Ajax
*   JSON

#### 
    搞软件的同学需要重要了解的知识

*   串口通信
*   高低电平

### 
    关于服务器

*   Nginx 需要配置，具体配置可以参照github上面的代码
*   LNMP 直接用上面的会比较简单，但是可能也会遇到一些问题。
*   Phpmyadmin 最好需要有这个，如果不是很精通MYSQL

## 
    设计方案

### 
    系统框架图

    ![](http://img.blog.csdn.net/20131222115240562?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcGhvZGFs/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)


[1]:http://b.phodal.com
[2]:http://www.phodal.com/blog/bare-minimum-iot
[3]:https://github.com/gmszone/iot/wiki
[4]:http://www.phodal.com/blog/bare-minimum-iot-system-structure/
[5]:http://www.phodal.com/blog/bare-minimum-iot-system-restful/
[6]:http://www.phodal.com/blog/bare-minimum-iot-system-create-restful/
[7]:http://www.phodal.com/blog/bare-minimum-iot-system-about-restful/
[8]:http://www.phodal.com/blog/bare-minimum-iot-system-restful-template/
[9]:http://www.phodal.com/blog/bare-minimum-iot-system-ajax/