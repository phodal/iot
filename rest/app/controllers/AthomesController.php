<?php

class AthomesController extends \BaseController {

	/**
	 * Display a listing of the resource.
	 *
	 * @return Response
	 */
    public $restful=true;

    protected $athome;

	public function __construct(Athomes $athome)
	{
	    $this->athome = $athome ;
	 }    

	public function index()
	{
		$maxid=Athomes::all();
	    return Response::json($maxid);
	}

	/**
	 * Show the form for creating a new resource.
	 *
	 * @return Response
	 */
	public function create()
	{
		$maxid=Athomes::max('id');
		return View::make('athome.create')->with('maxid',$maxid);
	}

	/**
	 * Store a newly created resource in storage.
	 *
	 * @return Response
	 */
	public function store()
	{
		// validate
		// read more on validation at http://laravel.com/docs/validation
		$rules = array(
			'led1'=>'required',
			'sensors1' => 'required|numeric|Min:-50|Max:80',
			'sensors2' => 'required|numeric|Min:-50|Max:80',
			'temperature' => 'required|numeric|Min:-50|Max:80'
		);
		$validator = Validator::make(Input::all(), $rules);

		// process the login
		if ($validator->fails()) {
			return Redirect::to('athome/create')
				->withErrors($validator)
				->withInput(Input::except('password'));
		} else {
			// store
			$nerd = new Athomes;
			$nerd->sensors1       = Input::get('sensors1');
			$nerd->sensors2       = Input::get('sensors2');
			$nerd->temperature    = Input::get('temperature');
			$nerd->led1			  = Input::get('led1');
			$nerd->save();

			// redirect
			Session::flash('message', 'Successfully created athome!');
			return Redirect::to('athome');
		}
	}

	/**
	 * Display the specified resource.
	 *
	 * @param  int  $id
	 * @return Response
	 */
	public function show($id)
	{
		$myid=Athomes::find($id);
        $maxid=Athomes::where('id','=',$id)
						->select('id','temperature','sensors1','sensors2','led1')
						->get();
	    return Response::json($maxid);
	}

	/**
	 * Show the form for editing the specified resource.
	 *
	 * @param  int  $id
	 * @return Response
	 */
	public function edit($id)
	{
		// get the nerd
		$athome = Athomes::find($id);

		// show the edit form and pass the nerd
		return View::make('athome.edit')
			->with('athome', $athome);
	}

	/**
	 * Update the specified resource in storage.
	 *
	 * @param  int  $id
	 * @return Response
	 */
	public function update($id)
	{
		// validate
		// read more on validation at http://laravel.com/docs/validation
		$rules = array(
			'led1'=>'required|',
			'sensors1' => 'required|numeric|Min:-50|Max:80',
			'sensors2' => 'required|numeric|Min:-50|Max:80',
			'temperature' => 'required|numeric|Min:-50|Max:80'
		);
		$validator = Validator::make(Input::all(), $rules);

		// process the login
		if ($validator->fails()) {
			return Redirect::to('athome/' . $id . '/edit')
				->withErrors($validator);
		} else {
			// store
			$nerd = Athomes::find($id);
			$nerd->sensors1       = Input::get('sensors1');
			$nerd->sensors2       = Input::get('sensors2');
			$nerd->temperature    = Input::get('temperature');
			$nerd->led1			  = Input::get('led1');
			$nerd->save();

			// redirect
			Session::flash('message', 'Successfully created athome!');
			return Redirect::to('athome');
		}
	}

	/**
	 * Remove the specified resource from storage.
	 *
	 * @param  int  $id
	 * @return Response
	 */
	public function destroy($id)
	{
		// delete
		$athome = Athomes::find($id);
		$athome->delete();
        if(is_null($athome))
        {
             return Response::json('Todo not found', 404);
        }
		// redirect
		Session::flash('message', 'Successfully deleted the nerd!');
		return Redirect::to('athome');
	}

}