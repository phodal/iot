import json
import requests

url = "http://b.phodal.com/athome/1"

data = {"temperature": 19, "sensors1": 22, "sensors2": 7.5, "led1": 1, "method": "PUT"}

r = requests.put(url, data)
print r.text
