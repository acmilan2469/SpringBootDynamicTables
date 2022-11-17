$(document).ready( function () {
    alert("tableData.js called!");
    console.log("local storage data : ",localStorage['data']);
    console.log("session storage : ",sessionStorage.getItem("mydata"));
    getTableDetails(localStorage['data']);
});

function getTableDetails(data){
    console.log("data 1 : ",data);

}