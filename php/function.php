<?php
include 'connect.php';
 
 
$response = array();
 
function login($username, $password){
	$db = new connect();
	$query = mysql_query("SELECT * FROM user WHERE username = '$username'");
	if(mysql_num_rows($query)>0){
		$query = mysql_query("SELECT * FROM user WHERE username = '$username' AND password = '$password'");
		if(mysql_num_rows($query)>0){
			$response["kode"] = 2;
			$response["pesan"] = "Login berhasil";
			echo json_encode($response);
		}else{
			$response["kode"] = 1;
			$response["pesan"] = "Password tidak cocok";
			echo json_encode($response);
		}
	}else{
		$response["kode"] = 1;
		$response["pesan"] = "Username tidak ditemukan";
		echo json_encode($response);
	}
}
 
function signUp($username, $password){
	$db = new connect();
	$query = mysql_query("SELECT * FROM user WHERE username = '$username' ");
	if(mysql_num_rows($query)>0){
		$response["kode"] = 1;
		$response["pesan"] = "Username sudah terdaftar";
		echo json_encode($response);
	}else{
		$query = mysql_query("INSERT INTO user (username,password) VALUES ('$username','$password')");
		if($query){
			$response["kode"] = 2;
			$response["pesan"] = "SignUp berhasil";
			echo json_encode($response);	
		}else{
			$response["kode"] = 1;
			$response["pesan"] = "Database down";
			echo json_encode($response);
		}
	}
}
 
function update($usernameBefore, $usernameAfter, $passwordAfter){
	$db = new connect();
	$query = mysql_query("SELECT * FROM user WHERE username = '$usernameAfter' ");
	if(mysql_num_rows($query)>0){
		$response["kode"] = 1;
		$response["pesan"] = "Username sudah terdaftar";
		echo json_encode($response);
	}else{
		if($usernameAfter == "" && $passwordAfter == ""){
			$response["kode"] = 2;
			$response["pesan"] = "Tidak ada yang dirubah";
			echo json_encode($response);
		}else if($usernameAfter == ""){
			$query = mysql_query("UPDATE user set password = '$passwordAfter' WHERE username='$usernameBefore'");
			if($query>0){
				$response["kode"] = 2;
				$response["pesan"] = "Password berhasil diubah";
				echo json_encode($response);	
			}else{
				$response["kode"] = 1;
				$response["pesan"] = "Database down";
				echo json_encode($response);
			}
		}else if($passwordAfter == ""){
			$query = mysql_query("UPDATE user set username = '$usernameAfter' WHERE username='$usernameBefore'");
			if($query>0){
				$response["kode"] = 2;
				$response["pesan"] = "Username berhasil diubah";
				echo json_encode($response);	
			}else{
				$response["kode"] = 1;
				$response["pesan"] = "Database down";
				echo json_encode($response);
			}
		}else{
			$query = mysql_query("UPDATE user set username = '$usernameAfter', password = '$passwordAfter' WHERE username='$usernameBefore'");
			if($query>0){
				$response["kode"] = 2;
				$response["pesan"] = "Username dan password berhasil diubah";
				echo json_encode($response);	
			}else{
				$response["kode"] = 1;
				$response["pesan"] = "Database down";
				echo json_encode($response);
			}
		}	
	}
	
}
 
function find($username){
	
	$db = new connect();
	$query = mysql_query("SELECT * FROM user WHERE username = '$username'");
	if(mysql_num_rows($query)>0){
		$response["kode"] = 2;
		$response["pesan"] = "Username tersedia";
		echo json_encode($response);
	}else{
		$response["kode"] = 1;
		$response["pesan"] = "Username tidak ditemukan";
		echo json_encode($response);
	}
}
 
function delete($username){
	
	$db = new connect();
	$query = mysql_query("DELETE FROM user WHERE username = '$username'");
	if($query){
		$response["kode"] = 2;
		$response["pesan"] = "Username berhasil dihapus";
		echo json_encode($response);
	}else{
		$response["kode"] = 1;
		$response["pesan"] = "Database down";
		echo json_encode($response);
	}
}
 
?>