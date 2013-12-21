<?php

class DatabaseSeeder extends Seeder {

	/**
	 * Run the database seeds.
	 *
	 * @return void
	 */
	public function run()
	{
		Eloquent::unguard();

		$this->call('AthomesTableSeeder');
	}

}

class AthomesTableSeeder extends Seeder
{
	public function run()
	{
		Athomes::create(array(
			'temperature'=>'19.8',
			'sensors1'=>'22.2',
			'sensors2'=>'7.5',
			'led1'=>False
		));
		Athomes::create(array(
			'temperature'=>'18.8',
			'sensors1'=>'22.0',
			'sensors2'=>'7.6',
			'led1'=>False
		));
	}
}