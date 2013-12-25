##Example of Laravel Configure##

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
