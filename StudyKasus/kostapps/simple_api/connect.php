<?php
	$server		= "localhost"; //sesuaikan dengan nama server
	$user		= "root"; //sesuaikan username
	$password	= ""; //sesuaikan password
	$database	= "kostapps"; //sesuaikan target databese
	
	/*$connect = mysql_connect($server, $user, $password) or die ("Koneksi gagal!");
	mysql_select_db($database) or die ("Database belum siap!");*/

	/* ====== UNTUK MENGGUNAKAN MYSQLI DI UNREMARK YANG INI, YANG MYSQL_CONNECT DI REMARK ======= */
	 $con = mysqli_connect($server, $user, $password, $database);
	 if (mysqli_connect_errno()) {
	 	echo "Gagal terhubung MySQL: " . mysqli_connect_error();
	 }

	 @$operasi = $_GET['operasi'];

	 switch ($operasi) {
	 	case "view":
	 		/* Source code untuk Menampilkan Biodata */

	        $tampil_biodata = mysqli_query($con,"SELECT * FROM users") or die(mysqli_error($con));
	        $data_array = array();
	        while ($data = mysqli_fetch_assoc($tampil_biodata)) {
	            $data_array[] = $data;
	        }
	        echo json_encode($data_array);

	        //print json_encode($data_array);
	 		break;
	 	case "biodata_by_id":
	        /* Source code untuk Edit data dan mengirim data berdasarkan id yang diminta */
	        @$id_users = $_GET['id_users'];

	        $tampil_biodata = mysqli_query($con, "SELECT * FROM users WHERE id_users='$id_users'") or die(mysqli_error($con));
	        $data_array = array();
	        $data_array = mysqli_fetch_assoc($tampil_biodata);
	        echo "[" . json_encode($data_array) . "]";
			break;
		case "update":
	        /* Source code untuk Update Biodata */
	        @$nama = $_GET['nama'];
	        @$alamat = $_GET['alamat'];
	        @$status = $_GET['status'];
	        @$id_users = $_GET['id_users'];
	        $update_biodata = mysqli_query($con,"UPDATE users SET nama='$nama', alamat='$alamat', status='$status' WHERE id_users='$id_users'");
	        if ($update_biodata) {
	            echo "Update Data Berhasil";
	        } else {
	            echo mysqli_error($con);
	        }
	        break;
	 	default:
	 		break;
	 }

?>