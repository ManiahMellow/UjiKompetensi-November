<?php

namespace Database\Seeders;

use App\Models\Order;
use Illuminate\Database\Seeder;
use Faker\Factory as Faker;

class OrderSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        $faker = Faker::create();

        for ($i=0; $i < 1; $i++) {
            $data = [
                'idpelanggan' =>'1',
                    'tglorder' => $faker->date(),
                    'tglkembali' => $faker->date(),
                    'total' => '1212',
                    'bayar' => '1212',
                    'kembali' => '1212'
            ];
                Order::create($data);
        }
    }
}