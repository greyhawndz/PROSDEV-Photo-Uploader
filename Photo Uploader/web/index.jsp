
<%@page import="java.io.File"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Photo Upload</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div>
             <form action="PhotoUploaderServlet" method="POST" enctype="multipart/form-data">
                    <br>
                    
                    <input type="file" name="uploadImage" accept="image/*"><br>
                    <br>
                    <input type="submit" value="Upload New Picture"><br>
                    
                </form>
            <br>
            <div>
                <h1>Gallery</h1>
                <br> 
                   <c:forEach items="${imagenames}" var="imagename">
                       <h1>TesT</h1>
                        <img src="${pageContext.request.contextPath}/DisplayServlet/${imagename}">
                        <br>
                        
                    </c:forEach>
                
               
            </div>
        </div>
    </body>
</html>
