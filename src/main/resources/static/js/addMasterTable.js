$(document).ready( function () {
    $.ajax({
        url: '/app/findAll',
        type: 'GET',
        dataType: 'json',
        success: function (data) {
            addValueToMasterTableList(data)
        }
    });

    /*$.ajax({
        type: "GET",
        url: concatenatedUrl,
        data: {input:input},
        success: function (data) {
          $result.val(newValue);
        }
    });*/

	/*ajax("/app/findAll" , "" , function(response){

		addValueToMasterTableList(data)
	}, "GET");*/
});

function addValueToMasterTableList(data){

	var i = 0;
	jQuery(function($) {
		var roleTable = $('#masterTableForTableList')
        .DataTable
        ({
            "responsive" : true,
            "lengthChange": false,
            "destroy": true,

            /* "paging": false, */

            data : data,


            "columns" : [{
                "render" : function(data, type, row) {
                    i+=1;
                    return i
                }
            }, {
                "data" : "tableName"
            },
            {
                "data" : "nameOfMaster"
            },
            {
                "data" : "active"
            },
            {
                "data" : "createdBy"
            },

            {
                data : null,
                "render" : function(data, meta, full) {
                    return "<a href='/app/addMasterTable' onClick='addDataToDynamicTable("
                    + JSON.stringify(full)
                    + ")'>Add Data </a> "
                }
            }
            ]
        });
	})
}

function addDataToDynamicTable(data){
    console.log("*******************************");
    console.log(data);
    console.log("*******************************");
}

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
            console.log(response)
       }
    });
}