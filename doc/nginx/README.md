##Example of Laravel Configure##
Laravel与nginx使用的时候需要添加下面的重定向规则，供参考 。

    127.0.0.2.conf  本地配置用的时候，nginx版本1.5.6
    nginx.conf      网上示例


##Need to add to you configure##
		 # Enforce No WWW - I put this in an include:
		    # include /etc/nginx/includes/enforce_non_www;
		    if ($host ~* ^www\.(.*))
		    {
			set $host_without_www $1;
			rewrite ^/(.*)$ $scheme://$host_without_www/$1 permanent;
		    }
		 
		    # Check if file exists
		    if (!-e $request_filename)
		    {
			rewrite ^/(.*)$ /index.php?/$1 last;
			break;
		    }
