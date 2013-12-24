#!/usr/bin/env python
import json,urllib2,serial

url="http://b.phodal.com/athome/1"
while True:
    status=json.load(urllib2.urlopen(url))[0]['led1']
    serialport=serial.Serial("/dev/ttyACM0",9600)
    if status==1 :
        serialport.write('1')
    elif status==0:
        serialport.write('0')
