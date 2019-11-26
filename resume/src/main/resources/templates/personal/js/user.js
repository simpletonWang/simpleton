function info() {
    $.ajax({
        url: "/info/selectUserInfo",
        type: 'GET',
        dataType: "json",
        success: function (data) {
            $("#user_name").html(data.data.alias);
            $("#about_me").html(data.data.about);
            $("#full-name").html(data.data.fullName);
            $("#birth").html(data.data.dateOfBirth);
            $("#address").html(data.data.address);
            $("#email").html(data.data.email);
            $("#phone").html(data.data.phone);
            $("#state").html(data.data.state);
           var hobby = data.data.hobby;
           var string = hobby.toString();
            $("#hobby-1").html(string.substring(0,string.indexOf(",")));
            $("#hobby-2").html(string.substring(string.indexOf(",")+1,string.lastIndexOf(",")));
            $("#hobby-3").html(string.substring(string.lastIndexOf(",")+1));
            var strs= new Array(); //定义一数组
            strs = data.data.features.toString().split(",")
            for (i=0;i<strs.length ;i++ ){
                strs[i]
            }
        },
        error: function (xhr, type) {
            console.log(xhr);
        }
    });
}