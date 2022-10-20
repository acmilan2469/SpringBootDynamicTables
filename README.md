# SpringBootDynamicTables is used to create tables at runtime and dynamically generate pojos with the help of input given by user

## Pre requisites
- \>= Java 8
- \>= MySQL
- Create database with name test

## Setup Guide
1. Create database test in MySQL

2. Clone the repo and change the application.properties file
  - Change the \<username\> to your DB Username and \<password\> to DB Password

3. Run the Project **Port used: 8080**

4. Use Postman to explore the APIs.

## Main Table is 'MasterTable' and 'MasterTableDetails' which contains table name and columns details

## Brief Introduction of APIs 
1. APIs are present in TestController.java
2. JSON for MasterTable as follows : 
```
{
    "tableName": "employee",
    "masterTableDetails": [
        {
            "columnName": "id",
            "columnType": "int",
            "constraints": "NOT NULL AUTO_INCREMENT",
            "primaryKey": true
        },
        {
            "columnName": "name",
            "columnType": "varchar(255)",
            "constraints": "",
            "primaryKey": false
        },
        {
            "columnName": "address",
            "columnType": "varchar(255)",
            "constraints": "",
            "primaryKey": false
        },
        {
            "columnName": "phone",
            "columnType": "varchar(255)",
            "constraints": "",
            "primaryKey": false
        }

    ]
}
```

3. Check Out other Json files to confirm if tables are created at runtime or not.


## Entities are as follows
- MasterTable (id, tableName, dynamicTableCreated)
- MasterTableDetails (id,columnName,columnType,constraints,primaryKey)
