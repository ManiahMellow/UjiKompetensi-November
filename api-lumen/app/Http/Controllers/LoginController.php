<?php

namespace App\Http\Controllers;
use App\Models\User;
use Illuminate\Http\Request;
use Illuminate\Support\Str;
use Illuminate\Support\Facades\Hash;

class LoginController extends Controller
{
  public function index()
  {
   $data = User::where('level','<>','pelanggan')->get();
   
   return response()->json($data);
  }
    public function register(Request $request)
    {

      $this -> validate($request, [
        'nama' => 'required | unique:users',
        'alamat' => 'required',
        'email' => 'required | email',
        'password' => 'required | min:8',
        'telp' => 'required'
      ]);

      $data = [
        'nama' => $request->input('nama'),
        'alamat' => $request->input('alamat'),
        'telp' => $request->input('telp'),
        'email' => $request->input('email'),
        'password' => $request->input('password') ,
        'level' => "pelanggan",
        'api_token' => '123456',
        'status' => '1',
        'relasi' => '1',
      ];

      User::create($data);
      $data = User::all();
       $datauser = [
          'message' => 'succes',
          'status' => 202,
          'data' => $data
      ];

      return response()->json($datauser);
    }

    public function login(Request $request)
    {
      $email = $request->input('email');
      $password = $request->input('password');

      $user = User::where('email',$email)->first();

      if (isset($user)) {
        if ($user->status === 1) {
          if ($password && $email) {
      
   
            // $user->update([
            //     'api_token' => $token
            // ]);
   
            return response()->json([
              'message' => 'succes',
          'status' => 202,
          'data' => $user
            ]);
         }else{
           return response()->json([
               'pesan' => 'login gagal',
               'data' => ''
            ]);
         }
        }else{
          return response()->json([
              'pesan' => 'login gagal',
              'data' => ''
           ]);
        }
      }else{
        return response()->json([
          'pesan' => 'login gagal',
          'data' => ''
       ]);
      }

     

     
    }

    public function update(Request $request, $id)
    {
        //

      $user =  User::where('id',$id)->update($request->all());
        if ($user) {
            return response()->json([
                'pesan' => "Data sudah di ubah !"
            ]);
           }
    }
}
