<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Result Page</title>
    <style>
        .result-box {
            display: flex;
            flex-direction: row;
            justify-content: center;
            align-items: center;
            border: 1px solid #ccc;
            padding: 10px;
            text-align: center;
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
        }

        .result-box #result {
            font-size: 24px;
        }

        .label {
            font-weight: bold;
            margin-right: 5px;
        }
    </style>
</head>
<body>
<form action="back" method="post">
    <input type="hidden" name="fileName" value="data">
    <button type="submit">Back</button>
</form>
<div class="result-box">
    <div class="label">Result:</div>
    <div id="result">${result}</div>
</div>
</body>
</html>