function NotasController(opcion) {
	$("#msg").hide();
	$("#msg").removeClass("alert-success").addClass("alert-danger");
	
	switch(opcion){
	case "list":
		/*$.ajax({
			type : "post",
		    headers: {"X-CSRF-TOKEN": token}, //send CSRF token in header
			url : "/jobs/list",
			success : function(res) {
				result="<table name='jobsTable' id='jobsTable' class='table-striped'><thead>"
				result+="<tr><th>Job ID</th><th>Job Title</th><th>Min.Salary</th><th>Max.Salary</th></tr>";
				result+="</thead><tbody>"
				$.each(res, function(k,v) {
					result+="<tr>";
					result+="<td>"+v.job_id+"</td>";
					result+="<td>"+v.job_title+"</td>";
					result+="<td>"+v.min_salary+"</td>";
					result+="<td>"+v.max_salary+"</td>";
					result+="</tr>";
				});
				result+="</tbody></table>";
				$("#modalTable").html(result);
				$("#jobsTable tr").click(function() {
				$("#job_id").val($(this).find("td:eq(0)").text());
				$("#job_title").val($(this).find("td:eq(1)").text());
				$("#min_salary").val($(this).find("td:eq(2)").text());
				$("#max_salary").val($(this).find("td:eq(3)").text());
				$("#myModal .close").click()
	        });
			$("#myModal").modal({show:true});
			
			},
			error : function() {
				$("#msg").show();
				$("#msg").html("Error en busqueda de trabajos.")
			}
		});       			
		break;*/
	case "get":
		
		$.ajax({
			type : "post",
			url : "/notas/get",
			data : "alumno_rut="+$("#alumno_rut").val(),
			success : function(res) {
				console.log(res);
				if (res == null || res == "") {
					$("#msg").show();
					$("#msg").html("No se encontraron registros.");
				} else {
					result="<table>"
					result+="<tr>"
					result+="<th>MODULO</th>"
					result+="<th>NUMERO EVALUACION</th>"
					result+="<th>NOTA</th>"
					result+="</tr>"

					notas="";
					$.each(res, function(k,v) {
						$("#alumno_nombre").val(v.alumno_nombre);
						$("#curso_nom").val(v.curso_nom);
						result+="<tr>";
						result+="<td>"+v.nmodulo+"</td>";
						result+="<td>"+v.neval+"</td>";
						result+="<td>"+v.nota+"</td>";
						result+="</tr>";
						notas+=v.nota+",";
					});
	
					notas=notas.substr(0,notas.length-1)
					console.log(notas);

					
					result+="</table>"
					
					promedio="";
						
					$.ajax({
						type : "post",
						url : "/notas/avg",
						data : "lista_notas="+notas,
						async: false,
						success : function(resnotas) {
							console.log(resnotas);
							promedio = resnotas;

						}	
					});
					console.log(promedio);

					result+="<br><p>Promedio: "+promedio;

					
					$("#notas").html(result);
				}
			},
			error : function() {
				$("#msg").show();
				$("#msg").html("Error en busqueda.");
			}
		});       			
		break;
	/*case "insertJob":
		var jobJSON = 
			{
				'job_id': $("#job_id").val(),
				'job_title': $("#job_title").val(),
				'min_salary': $("#min_salary").val(),
				'max_salary': $("#max_salary").val()
			};
	
	    var postData = JSON.stringify(jobJSON);

	    $.ajax({
			type : "post",
		    headers: {"X-CSRF-TOKEN": token}, //send CSRF token in header
			url : "/jobs/insert",
			data : postData,
			contentType : "application/json; charset=utf-8",
	        dataType : "json",
			success : function(res) {
				if (res == 1) {
					$("#msg").removeClass("alert-danger").addClass("alert-success");
					$("#msg").show();
					$("#msg").html("Registro ingresado correctamente.");
				} else {
					$("#msg").show();
					$("#msg").html("No se pudo ingresar el registro.");
				}
			},
			error : function() {
				$("#msg").show();
				$("#msg").html("No se pudo ingresar el registro.");
			}
		});       	
	    break;
	case "updateJob":
		var jobJSON = 
			{
				'job_id': $("#job_id").val(),
				'job_title': $("#job_title").val(),
				'min_salary': $("#min_salary").val(),
				'max_salary': $("#max_salary").val()
			};

	    var postData = JSON.stringify(jobJSON);

		$.ajax({
			type : "post",
		    headers: {"X-CSRF-TOKEN": token}, //send CSRF token in header
			url : "/jobs/update",
			data : postData,
			contentType : "application/json; charset=utf-8",
			dataType : "json",
			success : function(res) {
				if (res == 1) {
					$("#msg").removeClass("alert-danger").addClass("alert-success");
					$("#msg").show();
					$("#msg").html("Registro modificado correctamente.");
				} else {
					$("#msg").show();
					$("#msg").html("No se pudo modificar el registro.");
				}
			},
			error : function() {
				$("#msg").show();
				$("#msg").html("No se pudo modificar el registro.");
			}
		});       	
    break;
	case "deleteJob":
		$.ajax({
			type : "post",
		    headers: {"X-CSRF-TOKEN": token}, //send CSRF token in header
			url : "/jobs/delete",
			data : "job_id="+$("#job_id").val(),
			success : function(res) {
				if (res == 1) {
					$("#msg").removeClass("alert-danger").addClass("alert-success");
					$("#msg").show();
					$("#msg").html("Registro eliminado correctamente.");
				} else {
					$("#msg").show();
					$("#msg").html("No se pudo eliminar el registro.");
				}
			},
			error : function() {
				$("#msg").show();
				$("#msg").html("No se pudo eliminar el registro.");
			}
		});
		break;*/
	default:
		$("#msg").show();
		$("#msg").html("Opción incorrecta.");
	}
}