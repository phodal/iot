<?php

class AthomeTest extends TestCase {

	/**
	 * A basic functional test example.
	 *
	 * @return void
	 */
	public function testGetHomepage()
	{
		$crawler = $this->client->request('GET', '/');

		$this->assertTrue($this->client->getResponse()->isOk());
	}
	public function testGetAthomeIndex()
	{
		$crawler=$this->client->request('GET','/athome');
		$this->assertTrue($this->client->getResponse()->isOk());
	}

}