#!/usr/bin/env python

import json
import urllib2
import serial
import time
import RPi.GPIO as GPIO

GPIO.setmode(GPIO.BOARD)
GPIO.setup(18, GPIO.OUT)
GPIO.setup(22, GPIO.OUT)


url="http://b.phodal.com/athome/1"

while 1:
    try:
        date=urllib2.urlopen(url)
        result=json.load(date)
        status=result[0]['led1']
        print status
        ser=serial.Serial("/dev/ttyACM0",9600)
        if status==1 :
            ser.write('1')
            GPIO.output(18, GPIO.LOW)
            GPIO.output(22, GPIO.LOW)
        elif status==0:
            ser.write('0')
            GPIO.output(18, GPIO.HIGH)
            GPIO.output(22, GPIO.HIGH)
        time.sleep(1)
    except urllib2.URLError:
        print "Bad URL or timeout"