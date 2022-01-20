<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  isELIgnored="false"
 %>
 <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <style>
    
      #container {
        width: 100%;
        margin: 0px auto;
          
        border: 0px solid #bcbcbc;
      }
      
      #header {
        width: 100%;
        text-align:center;
      }
      
      #sidebar-left {
      	text-align:center;
        width: 15%;
        height:700px;
        margin-right: 5px;
        margin-bottom: 5px;
        float: left;
        border: 0px solid #bcbcbc;
      }
     
      #content {
        width: 75%;
        padding: 5px;
        margin-right: 5px;
        float: left;
        border: 0px solid #bcbcbc;
      }
      
    </style>
    <title><tiles:insertAttribute name="title" /></title>
  </head>
    <body>
    <div id="container">
      <div id="header">
         <tiles:insertAttribute name="header"/>
      </div>
      <div id="sidebar-left">
          <tiles:insertAttribute name="side"/> 
      </div>
      <div id="content">
          <tiles:insertAttribute name="body"/>
      </div>
    </div>
  </body>
</html>