<?php
	include "connect.php";
	
	$id_users 	= $_POST['id_users'];
	
	class emp{}
	
	if (empty($id_users)) { 
		$response = new emp();
		$response->success = 0;
		$response->message = "Error Mengambil Data"; 
		die(json_encode($response));
	} else {
		$query 	= mysqli_query($con, "SELECT * FROM users WHERE id_users='".$id_users."'");
		$row 	= mysqli_fetch_array($query);
		
		if (!empty($row)) {
			$response = new emp();
			$response->success = 1;
			$response->id_users = $row["id_users"];
			$response->nama = $row["nama"];
			$response->alamat = $row["alamat"];
			$response->status = $row["status"];
			die(json_encode($response));
		} else{ 
			$response = new emp();
			$response->success = 0;
			$response->message = "Error Mengambil Data";
			die(json_encode($response)); 
		}	
	}
?>