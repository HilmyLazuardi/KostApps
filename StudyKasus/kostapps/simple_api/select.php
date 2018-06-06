<?php
	include"connect.php";

	$query = mysqli_query($con,"SELECT * FROM users ORDER BY id_users DESC LIMIT 1");	
	$json = array();	

	while($row = mysqli_fetch_assoc($query)){
		/*array_push($json, array(
			"id_users" => $row ['id_users'],	
			"nama" => $row ['nama'],		
			"alamat" => $row ['alamat'],
			"status" => $row ['status'],
			));*/
			$json[] = $row;
	}
	/*$row = mysqli_fetch_assoc($query);	
	echo 'Nama: ' . $row['nama'] . '</br>';
	echo ' Alamat: ' . $row['alamat'] . '</br>';
	echo ' Status: ' . $row['status'] . '</br>';*/
	echo json_encode($json);	

	mysqli_close($con);
?>