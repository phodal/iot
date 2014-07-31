<?php

use Illuminate\Database\Schema\Blueprint;
use Illuminate\Database\Migrations\Migration;

class CreateAthomesTable extends Migration {

	public function up()
	{
		Schema::create('athomes', function(Blueprint $table)
		{
			$table->increments('id');
			$table->float('temperature');
			$table->float('sensors1');
			$table->float('sensors2');
			$table->boolean('led1');
			$table->timestamps();
		});
	}

	public function down()
	{
		Schema::drop('athomes');
	}

}
