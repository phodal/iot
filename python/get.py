#!/usr/bin/env python
import json
import urllib2
import serial
import time

url="http://b.phodal.com/athome/1"

while 1:
    try:
        date=urllib2.urlopen(url)
        result=json.load(date)
        status=result[0]['led1']
        print status
    except urllib2.URLError:
        print "Bad URL or timeout"

