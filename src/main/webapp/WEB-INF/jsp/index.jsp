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
		<title>Title</title>
	</head>
	<body>
		<!-- Button trigger modal -->
		<button type="button" class="btn btn-primary" id="myModal">Launch
			demo modal</button>
		<!-- Modal -->
		<div class="modal fade" id="trackingModal" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-lg" role="document">
				<div class="modal-content"">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Order: ${OrderId}</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<form action="/submitform" method="post">
						<div class="modal-body">
							<table class="table table-striped table-hover">
								<thead>
									<tr>
										<th>Record Identifier</th>
										<th>Courier</th>
										<th>Tracking Number</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="item" items="${CartonItems}">
										<c:if test="${item.recordType eq 'Carton'}">
											<tr>
												<td>
													${item.recordIdentifier}
												</td>
												<td>
													<select class="custom-select" name="Courier${item.recordIdentifier}">
												<c:choose>
													<c:when test="${not empty item.courier}">
														<option value="${item.courier}" selected>${item.courier}</option>	
														<c:forEach var="courier" items="${Couriers}">
															<c:choose>
																<c:when test="${courier ne item.courier}">
																	<option value="${courier}">${courier}</option>
																</c:when>
																<c:otherwise></c:otherwise>
															</c:choose>
														</c:forEach>	
													</c:when>
													<c:otherwise>
														<option disabled selected>Select...</option>
														<c:forEach var="courier" items="${Couriers}">
															<option value="${courier}">${courier}</option>
														</c:forEach>
													</c:otherwise>
												</c:choose>
													</select>											
												</td>
												<td>
													<input class="form-control" type="text" name="TrackingNumber${item.recordIdentifier}" value="${item.trackingNumber}"/>
												</td>	
											</tr>									
										</c:if>
									</c:forEach>
								</tbody>
							</table>
							<div>
								<button type="submit" class="btn btn-primary col-2">Save changes</button>					
								<button type="button" class="btn btn-secondary col-2"
									data-dismiss="modal">Close</button>
							</div>
						</div>					
					</form>
				</div>
			</div>
		</div>
	
		<script>
			
		    $(document).ready(function(){	
		        $("#myModal").click(function(){
		        	$('#trackingModal').modal({backdrop: 'static', keyboard: false});
		            $("#trackingModal").modal('show');
		        });
		    });
		</script>
	</body>
</html>