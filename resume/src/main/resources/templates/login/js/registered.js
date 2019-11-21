function registered() {
    var password = document.getElementById("PASSWORD").value;
    var passwordcheck = document.getElementById("PASSWORDCHECK").value;
    if (password != passwordcheck) {
        $.jGrowl("两次输入密码不一致！", {header: '警告'});
    } else {
        AjaxFuncReg();
    }
}

function AjaxFuncReg() {
    var username = document.getElementById("ID").value;
    var password = document.getElementById("PASSWORD").value;
    $.ajax({
        url: "/user/saveUser",
        type: "POST",
        dataType: "json",
        data: {"username": username, "password": password},
        success: function (data) {
            console.log(data)
            if (data.code == 1) {
                window.location.href = '/login/login.html';
            } else {
                $.jGrowl("注册失败！", {header: '提醒'});
            }
        },
        error: function (xhr, type) {
            console.log(xhr);
        }
    });
}

function nameCheck() {
    var username = document.getElementById("ID").value;
    var regExp = new RegExp("^[a-zA-Z0-9_]{4,15}$");
    if (username == "") {
        $.jGrowl("用户名不能为空!", {header: '警告'});
    } else if (!regExp.test(username)) {
        $.jGrowl("用户名必须为4-15位以下的字母或数字!", {header: '警告'});
    } else {
        console.log(username);
    }
}

function passCheck() {
    var password = document.getElementById("PASSWORD").value;
    var regExpPass = new RegExp("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$");
    if (password == "") {
        $.jGrowl("密码不能为空！", {header: '警告'});
    }else if(!regExpPass.test(password)){
        $.jGrowl("密码必须是6-16位数字和字母组合!", {header: '警告'});
    }else {
        console.log(password);
    }
}
function passCheckTwo() {
    var passwordcheck = document.getElementById("PASSWORDCHECK").value;
    if (passwordcheck == "") {
        $.jGrowl("密码不能为空！", {header: '警告'});
    }else {
        console.log(passwordcheck);
    }
}