#!/usr/bin/env python
import requests

url = "http://b.phodal.com/athome/1"
r = requests.get(url)
print r.text
