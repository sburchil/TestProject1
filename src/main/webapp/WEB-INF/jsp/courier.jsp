<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet"
			href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
			integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
			crossorigin="anonymous">
		<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
			integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
			crossorigin="anonymous"></script>
		<script
			src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
			integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
			crossorigin="anonymous"></script>
		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
			integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
			crossorigin="anonymous"></script>
		<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.12.1/css/jquery.dataTables.css">
		<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.js"></script>
		<title>Courier Information</title>
		<style>
			.no-border{
				border:0;
				box-shadow: none;
			}		
		</style>
		<script type="text/javascript" src="js/courier.js"></script>
	</head>
<body>
	<div style="padding:2rem;">
		<div class="accordion" id="accordionExample">
		  <div class="card">
		    <div class="card-header" id="headingOne">
		      <h2 class="mb-0">
		        <button class="btn btn-link btn-block text-left" type="button" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
					<c:if test="${showUpdate}">
						Update Courier
					</c:if>
					<c:if test="${not showUpdate}">
						Add Courier
					</c:if>
		        </button>
		      </h2>
		    </div>
		
		    <div id="collapseOne" class="collapse" aria-labelledby="headingOne" data-parent="#accordionExample">
		      <div class="card-body">
				<c:if test="${not empty addMessage}">
					<div class="alert alert-warning" role="alert">
						<p>${addMessage}</p>
					</div>
				</c:if>
				<c:if test="${not empty updateMessage}">
					<div class="alert alert-warning" role="alert">
						<p>${updateMessage}</p>
					</div>
				</c:if>
				<c:if test="${showUpdate}">
					<form id="updateCourier" action="<%=request.getContextPath()%>/updatecourier" method="post">
						<input type="hidden" name="courierId" value="${courierId}"/>
						<div class="form-control no-border">
							<div class="form-group">
								<div class="form-row">
									<label for="" class="text-center col-sm-2">Courier Name</label>
									<input type="text" name="CourierName" class="form-control col-sm-2" value="${Courier.courierName}" required/>
									<label for="" class="text-center col-sm-2">Courier Code</label>
									<input type="text" name="CourierCode" class="form-control col-sm-2" value="${Courier.courierCode}" required/>
								</div>
								<br>
								<div class="form-row">
									<label for="" class="text-center col-sm-2">Courier Contact Name</label>
									<input type="text" name="CourierContactName" class="form-control col-sm-2" value="${Courier.courierContactName}" required/>
									<label for="" class="text-center col-sm-2">Courier Contact Number</label>
									<input type="tel" pattern="[0-9]{3}-[0-9]{3}-[0-9]{4}" id="CourierContactNumber" name="CourierContactNumber" class="form-control col-sm-2" value="${Courier.courierContactNumber}" required/>
								</div>
								<br>
								<div class="form-row">
									<label for="" class="text-center col-sm-2">Courier WebSite</label>
									<input type="text" name="CourierWebSite"class="form-control col-sm-2" value="${Courier.courierWebSite}"/>
									<label for="" class="text-center col-sm-2">Courier Contact Email</label>
									<input type="text" name="CourierContactEmail" class="form-control col-sm-2" value="${Courier.courierContactEmail}"/>
								</div>
								<br>
								<div class="form-row">
									<label for="" class="text-center col-sm-2">Courier Address</label>
									<textarea name="CourierAddress" class="form-control col-6" required>${Courier.courierAddress}</textarea>
								</div>
								<br>
								<div class="form-row">
									<label for="" class="text-center col-sm-2">Courier Notes</label>
									<textarea name="CourierNotes" class="form-control col-6" >${Courier.courierNotes}</textarea>
								</div>
								<br>
								<div class="form-row">
									<label for="" class="text-center col-sm-2">Courier Status</label>
									<select id="CourierStatus" name="CourierStatus" class="custom-select col-sm-2" required>
										<c:if test="${empty Courier.courierStatus}">
											<option value="" selected disabled hidden>Select Status...</option>
											<option value="Active">Active</option>
											<option value="Inactive">Inactive</option>
											<option value="Unknown">Unknown</option>
										</c:if>
										<c:if test="${not empty Courier.courierStatus}">
											<c:forEach var="status" items="${StatusCodes}">
												<c:if test="${status.shortDescription eq Courier.courierStatus}">
													<option value="${status.shortDescription}" selected>${status.shortDescription}</option>
												</c:if>
												<c:if test="${status.shortDescription ne Courier.courierStatus}">
													<option value="${status.shortDescription}">${status.shortDescription}</option>
												</c:if>
											</c:forEach>
										</c:if>
									</select>
									<label for="" class="text-center col-sm-2">Courier SLA</label>
									<input type="text" name="CourierSLA" class="form-control col-sm-2" />
								</div>
								<br>
								<div class="form-row">
									<label for="" class="text-center col-sm-2">Courier Tracking Format</label>
									<input type="text" name="CourierTrackingFormat" class="form-control col-sm-2"/>
									<label for="" class="text-center col-sm-2">Courier Tracking Msg</label>
									<input type="text" name="CourierTrackingMsg" class="form-control col-sm-2" />
								</div>
								<br>
								<div class="form-row">
									<label for="" class="text-center col-sm-2">Created Date: </label>
									<label class="text-center col-sm-2" name="CreatedDate" id="CreatedDate">${Courier.createdDate}</label>
									<label for="" class="text-center col-sm-2">Modified Date: </label>
									<label class="text-center col-sm-2" name="ModifiedDate" id="ModifiedDate">${Courier.modifiedDate}</label>
								</div>
								<br>
								<div class="form-row">
									<label for="" class="col-sm-2"></label>
									<input type="submit" class="btn btn-primary col-sm-1 mr-1"/ value="Update">
									<a type="button" class="btn btn-secondary col-sm-1" href="<%=request.getContextPath()%>/courier">Add new</a>
									<label for="" class="col-sm-3"></label>
									<a type="button" class="btn btn-secondary col-sm-1" href="<%=request.getContextPath()%>/deletecourier">Delete</a>
								</div>
							</div>
						</div>				        	
					</form>
				</c:if>
				<c:if test="${not showUpdate}">
					<form id="addCourier" action="<%=request.getContextPath()%>/addcourier" method="post">
						<div class="form-control no-border">
							<div class="form-group">
								<div class="form-row">
									<label for="" class="text-center col-sm-2" >Courier Name</label>
									<input type="text" name="CourierName" class="form-control col-sm-2" required/>
									<label for="" class="text-center col-sm-2">Courier Code</label>
									<input type="text" name="CourierCode" class="form-control col-sm-2" required/>
								</div>
							<br>
							<div class="form-row">
								<label for="" class="text-center col-sm-2">Courier Contact Name</label>
								<input type="text" name="CourierContactName" class="form-control col-sm-2" required/>
								<label for="" class="text-center col-sm-2">Courier Contact Number</label>
								<input type="tel" pattern="[0-9]{3}-[0-9]{3}-[0-9]{4}" id="CourierContactNumber" name="CourierContactNumber" class="form-control col-sm-2" required/>
							</div>
							<br>
							<div class="form-row">
								<label for="" class="text-center col-sm-2">Courier WebSite</label>
								<input type="text" name="CourierWebSite"class="form-control col-sm-2" />
								<label for="" class="text-center col-sm-2">Courier Contact Email</label>
								<input type="text" name="CourierContactEmail" class="form-control col-sm-2" />
							</div>
							<br>
							<div class="form-row">
								<label for="" class="text-center col-sm-2">Courier Address</label>
								<textarea name="CourierAddress" class="form-control col-6" required></textarea>
							</div>
							<br>
							<div class="form-row">
								<label for="" class="text-center col-sm-2">Courier Notes</label>
								<textarea name="CourierNotes" class="form-control col-6" ></textarea>
							</div>
							<br>
							<div class="form-row">
								<label for="" class="text-center col-sm-2" >Courier Status</label>
								<select id="" name="CourierStatus" class="custom-select col-sm-2" required>
									<option value="" selected disabled hidden>Select status...</option>
									<option value="Unknown">Unknown</option>
									<option value="Active">Active</option>
									<option value="Inactive">Inactive</option>
								</select>
								<label for="" class="text-center col-sm-2">Courier SLA</label>
								<input type="text" name="CourierSLA" class="form-control col-sm-2" />
							</div>
							<br>
							<div class="form-row">
								<label for="" class="text-center col-sm-2">Courier Tracking Format</label>
								<input type="text" name="CourierTrackingFormat" class="form-control col-sm-2"/>
								<label for="" class="text-center col-sm-2">Courier Tracking Msg</label>
								<input type="text" name="CourierTrackingMsg" class="form-control col-sm-2" />
							</div>
							<br>
							<div class="form-row">
								<label for="" class="col-sm-2"></label>
								<input type="submit" class="btn btn-primary col-sm-1 mr-1"/>
								<input type="button" class="btn btn-secondary col-sm-1" value="Clear" onclick="ClearFormFields()"/>
							</div>
						</div>
					</div>				        	
				</form>
			</c:if>
			</div>
		</div>
	</div>
		  <div class="card">
		    <div class="card-header" id="headingTwo">
		      <h2 class="mb-0">
		        <button class="btn btn-link btn-block text-left collapsed" type="button" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
					Search Courier
		        </button>
		      </h2>
		    </div>
		    <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionExample">
		      <div class="card-body">
				<c:if test="${failedSearch}">
					<div class="alert alert-warning" role="alert">
						<p>${searchMessage}</p>
					</div>
				</c:if>
		        <form action="<%=request.getContextPath()%>/searchcouriers" method="post">
					<div class="form-control no-border">
						<div class="form-group">
							<div class="form-row">
								<label for="" class="text-center col-sm-2">Courier name: </label>
								<input type="text" name="SearchedQuery" id="SearchedQuery" class="form-control col-sm-2"/>
								<label for="" style="padding-right: 1.3rem"></label>
								<button class="btn btn-primary col-sm-2 mr-2">Search</button>
							</div>
						</div>
					</div>
				</form>
		      </div>
		    </div>
		  </div>
		  <div class="card">
		    <div class="card-header" id="headingThree">
		      <h2 class="mb-0">
		        <button class="btn btn-link btn-block text-left collapsed" type="button" data-toggle="collapse" data-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
		          Search Results
		        </button>
		      </h2>
		    </div>
		    <div id="collapseThree" class="collapse" aria-labelledby="headingThree" data-parent="#accordionExample">
		      <div class="card-body">
				<c:if test="${searchResult}">
					<div class="alert alert-warning" role="alert">
						${searchCrit}
					</div>
				</c:if>
		        <table id="courierSearchResults" class="table table-striped table-hover">
					<thead>
						<th>Courier Name</th>
						<th>Courier Address</th>
						<th>Courier WebSite</th>
						<th>Courier Status</th>
					</thead>

				</table>
		      </div>
		    </div>
		  </div>
		</div>
	</div>
<script>
	var phone_input = document.getElementById('CourierContactNumber');

	phone_input.addEventListener('input', () =>{
		phone_input.setCustomValidity('');
		phone_input.checkValidity();
	});

	phone_input.addEventListener('invalid', () =>{
		if(phone_input.value === ''){
			phone_input.setCustomValidity('Please enter a phone number');
		}
		else{
			phone_input.setCustomValidity('Please enter a valid phone number in this format: XXX-XXX-XXXX');
		}
	});

	$(document).ready(function (){
		$('#courierSearchResults').DataTable({
			pageLength: 5,
			ajax: {
				url: "<%=request.getContextPath()%>/searchresults",
				dataSrc: ""
			},
			columns: [
				{
					title: 'Courier Name',
					data: 'courierName'
				},
				{
					title: 'Courier Address',
					data: 'courierAddress'
				},
				{
					title: 'Courier WebSite',
					data: 'courierWebSite'
				},
				{
					title: 'Courier Status',
					data: 'courierStatus'
				}
			]
		});
	});


</script>
</body>
</html>