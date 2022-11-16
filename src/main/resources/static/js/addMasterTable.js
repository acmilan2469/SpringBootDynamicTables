function addRows() {
	var table = document.getElementById('column-table');
	var rowCount = table.rows.length;
	var cellCount = table.rows[0].cells.length;
	var row = table.insertRow(rowCount);
	for (var i = 0; i <= cellCount; i++) {
		var cell = 'cell' + i;
		cell = row.insertCell(i);
		var copycel = document.getElementById('col' + i).innerHTML;
		cell.innerHTML = copycel;
		/*if (i == 8 || i == 9)  {
			var radioinput = document.getElementById('col8').getElementsByTagName('input');
			for (var j = 0; j <= radioinput.length; j++) {
				if (radioinput[j].type == 'radio') {
					var rownum = rowCount;
					radioinput[j].name = 'is-mandatory[' + rownum + ']';
				}
			}
		}*/
	}
}
function deleteRows() {
	var table = document.getElementById('column-table');
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

    var myRows = [];
    var data = $('#column-table tr').map(function() {
        var obj = {};
        $(this).find('input, select').each(function() {
            obj[this.name] = $(this).val();
        });
        return obj;
    }).get();
    console.log(data);






	//for getting dynamic employee
	//var nameValue = document.getElementById("regForm").value;
//	console.log(document.getElementById("tableName").value);
//	var data = {
//		tableName: tableName.value,
//		nameOfMaster: nameOfMaster.value,
//		active: active.value,
//		nameOfMaster: nameOfMaster.value,
//		dbType: dbType.value,
//
//	};
//	console.log(data);
//
	



}

function saveMasterTable1() {

    let res = [];
    let columnName = document.getElementsByName("column-name");
    let dataType = document.getElementsByName("data-type");
    let columnValidations = document.getElementsByName("col-validation");
    let customValidations = document.getElementsByName("custom-validation");
    let fieldType = document.getElementsByName("field-type");
    let fieldText = document.getElementsByName("field-text");
    let columnMinLength = document.getElementsByName("col-min-length");
    let columnMaxLength = document.getElementsByName("col-max-length");
    let mandatory = document.getElementsByName("is-mandatory");
    let primaryKey = document.getElementsByName("primary-key");

    for (let i = 0; i < columnName.length; i++) {
      let obj = {
        "columnName": columnName[i].value,
        "dataType": dataType[i].value,
        "columnValidations": columnValidations[i].value,
        "customValidations": customValidations[i].value,
        "fieldType": fieldType[i].value,
        "fieldText": fieldText[i].value,
        "columnMinLength": columnMinLength[i].value,
        "columnMaxLength": columnMaxLength[i].value,
        "mandatory": mandatory[i].value,
        "primaryKey": primaryKey[i].value
      }
      res.push(obj);
    }
    console.log(res);

    let tableName =  $('#tableName').val();
    let nameOfMaster =  $('#nameOfMaster').val();
    let active =  $('#active').val();
    let applicationRole = $('3applicationRole').val();
    let dbType = $('#dbType').val();

    var dataVal = {
        tableName: tableName,
        nameOfMaster: nameOfMaster,
        active: active,
        applicationRole: applicationRole,
        dbType: dbType,
        masterTableColumnDetails : res
    }

    console.log(dataVal);

    $.ajax({
        contentType: 'application/json',
        url: '/app/save',
        type: 'post',
        data: JSON.stringify(dataVal),
        success: function(response){
            console.log("++++++++++++++++++++++++");
            console.log(response)
            console.log("++++++++++++++++++++++++");
       }
    });

}

