<%-- 
    Document   : formInputData
    Created on : Dec 11, 2014, 5:52:02 PM
    Author     : arprast
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Input Data</title>
    </head>
    <body>
        <form method="post" action="formInputData">
        <table >
            <tr>
                <td>Npm </td><td><input type="text" name="npm" value="${mhs.npm}"></td>
            </tr>
            <tr>
                <td>Nama </td><td><input type="text" name="nama" value="${mhs.nama}"></td>
            </tr>
            <tr>
                <td><input type="submit" name="simpan" value="Simpan" > </td>
                <td><input type="reset" name="simpan" value="Reset" ></td>
            </tr>
            
        </table>
         </form>
    </body>
</html>
