<?php
include 'function.php';
 
$response = array();
 
$db = new connect();
 
if(isset($_POST['tag'])){
	$tag = $_POST['tag'];
	if($tag=="login"){
		if(isset($_POST['username']) && isset($_POST['password'])){
			$username = $_POST['username'];
			$password = $_POST['password'];
			login($username,$password);
		}else{
			$response["kode"] = 0;
			$response["pesan"] = "Username atau password tidak boleh kosong!";
			echo json_encode($response);
		}
	}else if($tag=="signUp"){
		if(isset($_POST['username']) && isset($_POST['password'])){
			$username = $_POST['username'];
			$password = $_POST['password'];
			signUp($username,$password);
		}else{
			$response["kode"] = 0;
			$response["pesan"] = "Username atau password tidak boleh kosong!";
			echo json_encode($response);
		}
	}else if($tag=="update"){
		if(isset($_POST['usernameBefore'])){
			$usernameBefore = $_POST['usernameBefore'];
			$usernameAfter = $_POST['username'];
			$passwordAfter = $_POST['password'];
			update($usernameBefore, $usernameAfter, $passwordAfter);
		}else{
			$response["kode"] = 0;
			$response["pesan"] = "Username apa yang ingin diubah?";
			echo json_encode($response);
		}
	}else if($tag=="find"){
		if(isset($_POST['username'])){
			$username = $_POST['username'];
			find($username);
		}else{
			$response["kode"] = 0;
			$response["pesan"] = "Username tidak boleh kosong!";
			echo json_encode($response);
		}
	}else if($tag=="delete"){
		if(isset($_POST['username'])){
			$username = $_POST['username'];
			delete($username);
		}else{
			$response["kode"] = 0;
			$response["pesan"] = "Username tidak boleh kosong!";
			echo json_encode($response);
		}
	}
}else{
	$response["kode"] = 0;
	$response["pesan"] = "Membutuhkan tag untuk proses selanjutnya";
	echo json_encode($response);
}
 
?>