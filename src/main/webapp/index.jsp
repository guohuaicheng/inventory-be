<html>
<body>
<h2>Hello World!</h2>
</body>
<%--<form action="dd">--%>
<%--<input name="j_username"/>--%>
<%--<input name="j_password"/>--%>
<%--<input type="submit"/>--%>
<%--</form>--%>
<button onclick="A()">AAA</button>
<button onclick="login()">A</button>
<button onclick="login2()">B</button>
<button onclick="login3()">C</button>
<button onclick="login4()">D</button>
<script src="jquery.js"></script>
<script>
    function A() {
        $.ajax({
            url: "tenants",
            method: "post",
            contentType: "application/json",
            data: JSON.stringify({
                name: "xx"
            }),
            success: function (a) {
                debugger;
            },
            error: function (a) {
                debugger;
            }
        })
    }

    function login() {
        $.ajax({
            url: "login",
            method: "post",
            contentType: "application/json",
            data: JSON.stringify({
                username: "sysadmin",
                password: "123456",
                domainUrl:"aaa"
            }),
            success: function (a) {
                debugger;
            },
            error: function (a) {
                debugger;
            }
        })
    }

    function login2() {
        $.ajax({
            url: "login",
            method: "post",
            contentType: "application/json",
            data: JSON.stringify({
                username: "platadmin",
                password: "123456"
            }),
            success: function (a,b,c) {
                var token = c.getResponseHeader("token");
                sessionStorage.setItem("token", token);
            },
            error: function (a) {
                debugger;
            }
        })
    }

    function login3() {
        $.ajax({
            url: "login",
            method: "post",
            contentType: "application/json",
            data: JSON.stringify({
                username: "ttt",
                password: "ttt"
            }),
            beforeSend: function(request) {
                request.setRequestHeader("token", sessionStorage.getItem("token"));
            },
            success: function (a) {
                debugger;
            },
            error: function (a) {
                debugger;
            }
        })
    }

    function login4() {
        $.ajax({
            url: "order",
            method: "post",
            contentType: "application/json",
            data: JSON.stringify({
                id: "xxx"
            }),
            success: function (a) {
                debugger;
            },
            error: function (a) {
                debugger;
            }
        })
    }
</script>
</html>
