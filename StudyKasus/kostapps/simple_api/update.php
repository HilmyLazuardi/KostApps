<?php
	include "connect.php";
	
	$id_users 	= $_POST['id_users'];
	$nama 	= $_POST['nama'];
	$alamat = $_POST['alamat'];
	$status = $_POST['status'];
	
	class emp{}
	
	if (empty($id_users) || empty($nama) || empty($alamat) || empty($status)) { 
		$response = new emp();
		$response->success = 0;
		$response->message = "Kolom isian tidak boleh kosong"; 
		die(json_encode($response));
	} else {
		$query = mysqli_query($con, "UPDATE users SET nama='".$nama."', alamat='".$alamat."', status='".$status."' WHERE id_users='".$id_users."'");
		
		if ($query) {
			$response = new emp();
			$response->success = 1;
			$response->message = "Data berhasil di update";
			die(json_encode($response));
		} else{ 
			$response = new emp();
			$response->success = 0;
			$response->message = "Error update Data";
			die(json_encode($response)); 
		}	
	}
?>