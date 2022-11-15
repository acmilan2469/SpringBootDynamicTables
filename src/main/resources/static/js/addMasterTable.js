function addRows() {
	var table = document.getElementById('columntable');
	var rowCount = table.rows.length;
	var cellCount = table.rows[0].cells.length;
	var row = table.insertRow(rowCount);
	for (var i = 0; i <= cellCount; i++) {
		var cell = 'cell' + i;
		cell = row.insertCell(i);
		var copycel = document.getElementById('col' + i).innerHTML;
		cell.innerHTML = copycel;
		if (i == 8) {
			var radioinput = document.getElementById('col8').getElementsByTagName('input');
			for (var j = 0; j <= radioinput.length; j++) {
				if (radioinput[j].type == 'radio') {
					var rownum = rowCount;
					radioinput[j].name = 'is-mandatory[' + rownum + ']';
				}
			}
		}
	}
}
function deleteRows() {
	var table = document.getElementById('columntable');
	var rowCount = table.rows.length;
	if (rowCount > '2') {
		var row = table.deleteRow(rowCount - 1);
		rowCount--;
	}
	else {
		alert('There should be at least one row');
	}
}

function saveMasterTable() {

    console.log("==============================================");

	//for getting dynamic employee
	//var nameValue = document.getElementById("regForm").value;
	console.log(document.getElementById("tableName").value);
	var data = {
		tableName: tableName.value,
		nameOfMaster: nameOfMaster.value,
		active: active.value,
		nameOfMaster: nameOfMaster.value,
		dbType: dbType.value,
		
	};
	console.log(data);
	
	



}

