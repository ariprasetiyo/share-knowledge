<%-- 
    Document   : index
    Created on : Dec 11, 2014, 4:22:28 PM
    Author     : arprast
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crud </title>
    </head>
    <body>
        <table>
            <thead>
                 <tr>
                     <th>No</th> <th>Npm</th>  <th>Nama</th> <th>Edit</th><th>Delete</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="mhs" items="${daftarMhs}" varStatus="counter">
                <tr>
                    <th>${counter.index}</th> 
                    <th>${mhs.npm}</th>  
                    <th>${mhs.nama}</th> 
                    <th><a href="edit-mhs?edit=${mhs.npm}" >Edit</a></th>
                    <th><a href="hapus-mhs?hapus=${mhs.npm}" >Delete</a></th>
                </tr> 
                </c:forEach>
            </tbody>
           
        </table>
        <a href="formInputData"><h2>Tambah data</h2></a>
    </body>
</html>
