$(document).ready( function () {
    alert("tableList.js called!");
    console.log("local storage data : ",localStorage.getItem("data"));
    getAllTables();
});
function getAllTables(){
    $.ajax({
        url: '/app/findAll',
        type: 'GET',
        dataType: 'json',
        success: function (data) {
            addValueToMasterTableList(data)
        }
    });
}

function addValueToMasterTableList(data){

	var i = 0;
	jQuery(function($) {
		$('#masterTableForTableList')
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
                // data : null,
                "render" : function(data, meta, full) {
                    return "<a href='/app/addDataToTable' onClick='addDataToDynamicTable("
                    + JSON.stringify(full)
                    + ")'>Add Data </a> "
                }
            }
            ]
        });
	})
}

function addDataToDynamicTable(data){
    console.log("data : ",data);
    localStorage.setItem("data",data);
    sessionStorage.setItem("mydata",data);
    console.log("test : ",localStorage['data']);
    alert("hold!");
}