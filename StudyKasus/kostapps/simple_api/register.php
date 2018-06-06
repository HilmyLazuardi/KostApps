<?php
  include 'connect.php';

  class usr{}

  $nama = $_POST["nama"];
  $alamat = $_POST["alamat"];
  $status = $_POST["status"];

  $username = $_POST["username"];
  $password = $_POST["password"];
  $confirm_password = $_POST["confirm_password"];

  if ((empty($nama))) {
      $response = new usr();
      $response->success = 0;
      $response->message = "Kolom nama tidak boleh kosong";
      die(json_encode($response));
  } else if ((empty($alamat))) {
      $response = new usr();
      $response->success = 0;
      $response->message = "Kolom alamat tidak boleh kosong";
      die(json_encode($response));
  } else if ((empty($status))) {
      $response = new usr();
      $response->success = 0;
      $response->message = "Kolom status tidak boleh kosong";
      die(json_encode($response));
  } else if ((empty($username))) {
      $response = new usr();
      $response->success = 0;
      $response->message = "Kolom username tidak boleh kosong";
      die(json_encode($response));
  } else if ((empty($password))) {
      $response = new usr();
      $response->success = 0;
      $response->message = "Kolom password tidak boleh kosong";
      die(json_encode($response));
  } else if ((empty($confirm_password)) || $password != $confirm_password) {
      $response = new usr();
      $response->success = 0;
      $response->message = "Kolom password tidak sesuai";
      die(json_encode($response));
  } else {
      if (!empty($username) && $password == $confirm_password){
          $num_rows = mysqli_num_rows(mysqli_query($con, "SELECT * FROM users WHERE username='".$username."'"));

          if ($num_rows == 0){
                  $query = mysqli_query($con, "INSERT INTO users (id_users, nama, alamat, status, username, password) VALUES (0,'".$nama."','".$alamat."','".$status."','".$username."','".$password."')");
                  /*$query2 = mysqli_query($con, "INSERT INTO biodata (id, nama, alamat, status) VALUES (0,'".$nama."','".$alamat."','".$status."')");*/

                  if ($query){
                          $response = new usr();
                          $response->success = 1;
                          $response->message = "Register berhasil, silahkan login.";
                          die(json_encode($response));

                  } else {
                          $response = new usr();
                          $response->success = 0;
                          $response->message = "Username sudah ada";
                          die(json_encode($response));
                  }
          } else {
                 $response = new usr();
                 $response->success = 0;
                 $response->message = "Username sudah ada";
                 die(json_encode($response));
          }
     } 
 }

  mysqli_close($con);
?>