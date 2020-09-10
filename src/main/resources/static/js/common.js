var currentPath = window.location.href;
currentPath = currentPath.replace("http://localhost:8081/", "");
$( 'a[href="/' + currentPath + '"]' ).parent().addClass("active");

var main = {
    ajax: function (options) {
        var config = {
            ruta: '',
            data: [],
            dataType: 'json',
            type: 'POST',
            async: true,
            processData: true,
            contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
            fnDone: function (res) {
            },
            fnError: function (e) {
                console.log(e);
            }
        };
        $.extend(config, options);
        $.ajax({
            url: ruta_inicial + config.ruta,
            dataType: config.dataType,
            data: config.data,
            type: config.type,
            async: config.async,
            processData: config.processData,
            contentType: config.contentType
        }).done(function (res) {
            config.fnDone(res);
            if (typeof options.showLoading === "undefined" || options.showLoading) {
                $(".loading").hide();
            }
        }).error(function (e) {
            config.fnError();
            if (typeof options.showLoading === "undefined" || options.showLoading) {
                $(".loading").hide();
            }
        });
    }
};