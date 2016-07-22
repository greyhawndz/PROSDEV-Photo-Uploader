
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
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
        <jsp:include page="/DisplayServlet" />
    </head>
    <body>
        <div>
             <form action="PhotoUploaderServlet" method="POST" enctype="multipart/form-data">
                    <br>
                    
                    <input type="file" name="uploadImage" accept="image/*"><br>
                    <br>
                    <input type="submit" name = "but" value="Upload New Picture"><br>
                    <br>
                    <input type="submit" name = "but" value="Delete"><br>
                    <br>
                </form>
            <br>
            <div>
                <h1>Gallery</h1>
                <br>
                <%
                    
                    String destination = "Images\\";
                    ArrayList<String> fileNames = (ArrayList)request.getAttribute("names");
                    if(fileNames != null){
                        Iterator<String> itr = fileNames.iterator();
                        while(itr.hasNext()){
                            out.println(" <img src=\"" +destination +itr.next()+"\" height=\"200\" width=\"200\"");
                            out.println("<br>");
                        }
                       
                    }
                %>
                <%--
                   <c:forEach items="${imagenames}" var="imagename">
                       <h1>TesT</h1>
                        <img src="${pageContext.request.contextPath}/DisplayServlet/${imagename}">
                        <br>
                        
                    </c:forEach>
                --%>
               
            </div>
        </div>
    </body>
</html>
