<?php
	include "connect.php";
	
	$nama 	= $_POST['nama'];
	$alamat = $_POST['alamat'];
	$status = $_POST['status'];
	
	class emp{}
	
	if (empty($nama) || empty($alamat) || empty($status)) { 
		$response = new emp();
		$response->success = 0;
		$response->message = "Kolom isian tidak boleh kosong"; 
		die(json_encode($response));
	} else {
		$query = mysqli_query($con, "INSERT INTO biodata (id_users,nama,alamat,status) VALUES(0,'".$nama."','".$alamat."','".$status."')");
		
		if ($query) {
			$response = new emp();
			$response->success = 1;
			$response->message = "Data berhasil di simpan";
			die(json_encode($response));
		} else{ 
			$response = new emp();
			$response->success = 0;
			$response->message = "Error simpan Data";
			die(json_encode($response)); 
		}	
	}
?>