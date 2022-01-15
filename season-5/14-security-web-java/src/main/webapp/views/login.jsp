<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Form</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

</head>
<body>
	
	<div class="container pt-4">
	
		
		<div class="row">
			<div class="col-4">
				
				<div class="card">
				
					<h5 class="card-header">Login Form</h5>
					
					<form action="/login" method="post" class="card-body">
						
						<div class="mb-3">
							<label for="loginId" class="form-label">Login ID</label>
							<input type="text" name="loginId" placeholder="Enter Login Id" id="loginId" class="form-control" />
						</div>
						
						<div class="mb-3">
							<label for="password" class="form-label">Password</label>
							<input type="password" name="password" placeholder="Enter Passsword" id="password" class="form-control" />
						</div>
						
						<div>
							<button type="submit" class="btn btn-primary">Login</button>
						</div>
					
					</form>
				</div>
			
			</div>
		</div>
		
	</div>
</body>
</html>