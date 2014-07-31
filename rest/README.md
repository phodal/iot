##A sample of RESTful API##
###Create with PHP Framework Laravel###


##More##
    localhost/athome ##for visit
    localhost/athome/create ##for create
    localhost/athome/{id}/edit ##for edit


##Quick Start##
Add the Database to your MySQL

And edit the 

    app/config/database.php
    
for 

    database

    password
    
To Laravel

    git clone https://github.com/laravel/laravel
    curl -sS https://getcomposer.org/installer | php

To RESTful 
    php artisan migrate:make create_athomes_table 

For more informations can visit my blog of it

 - [Laravel RESTful快速部署指南（一）][1] 
 - [Laravel RESTful快速部署指南（二）][2] 
 - [Laravel RESTful快速部署指南（三）][3] 

##If need edit##
 - app/modals/Athomes.php
 - app/routes.php
 - app/database/migrations/%date%_create_athomes_table.php
 - app/controllers/AthomesController.php



[1]:http://blog.csdn.net/phodal/article/details/15340355 
[2]:http://blog.csdn.net/phodal/article/details/15364481
[3]:http://blog.csdn.net/phodal/article/details/15378083