import urllib    
import urllib2    
    
def post(url, data):    
    req = urllib2.Request(url)    
    data = urllib.urlencode(data)    
    #enable cookie    
    opener = urllib2.build_opener(urllib2.HTTPCookieProcessor())    
    response = opener.open(req, data)    
    return response.read()    
    
def main():    
    posturl = "http://b.phodal.com/athome/1/"    
    data = {"temperature":19,"sensors1":22,"sensors2":7.5,"led1":1}  
    print post(posturl, data)    
    
if __name__ == '__main__':    
    main()    
