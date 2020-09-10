//Al dar click en el boton Nuevo registro
$("#btnNuevoRegistro").click(function() {
    $("#tituloModal").html("Registrar");
    $("#nombre").val("");
    $("#accion").val("INSERTAR");
    $("#id").val("");
    $('#modalEdicion').modal('show');
});

$("#btnAceptarModal").click(function() {
    //validar
    if($("#nombre").val() == ""){
        alert("El nombre es obligatorio");
    } else {
        var accion = $("#accion").val();
        var registro = {'id' : $("#id").val(), 'nombre' : $("#nombre").val()};
        let data = new FormData();
        data.append('registro', JSON.stringify(registro));
        let url = "";
        if(accion == "ACTUALIZAR"){
            url = "http://localhost:8081/tallas/actualizar";
        } else {
            url = "http://localhost:8081/tallas/nuevo";
        }

        $.ajax({
            url: url,
            dataType: 'html',
            data: data,
            type: 'POST',
            async: false,
            processData: false,
            contentType: false,
        }).done(function (res) {
            if(res == "OK"){
                if(accion == "ACTUALIZAR"){
                    alert("Talla actualizada");
                } else {
                    alert("Talla registrada");
                }
                location.reload();
            } else {
                alert("Ocurrio un error al procesar la peticion");
            }
        }).fail(function (e) {
            alert("Ocurrio un error al procesar la peticion");
            console.error(e);
        });

    }

});


//Al editar un registro
$("body").on("click", ".editar", function() {
    $("#id").val("");
    let id = $(this).attr("data-id");
    $.ajax({
        url: "http://localhost:8081/tallas/tallaXId?id=" + id,
        dataType: 'html',
        data: null,
        type: 'GET',
        async: false,
        processData: false,
        contentType: false
    }).done(function (res) {
        //Mostarr el modal con el de edicion
        console.log(res);
        let responseObject = JSON.parse(res);
        $("#tituloModal").html("Editar");
        $("#nombre").val(responseObject.nombre);
        $("#accion").val("ACTUALIZAR");
        $("#id").val(id);
        $('#modalEdicion').modal('show');
    }).fail(function (e) {
        alert("Ocurrio un error al obtener el registro a modificar");
        console.error(e);
    });
});

//Al deshabilitar un registro
$("body").on("click", ".deshabilitar", function() {
        var data = new FormData();
        data.append('id', $(this).attr("data-id"));

        $.ajax({
            url: "http://localhost:8081/tallas/deshabilitar",
            dataType: 'html',
            data: data,
            type: 'POST',
            async: false,
            processData: false,
            contentType: false,
        }).done(function (res) {
            if(res == "OK"){
                alert("Color deshabilitado");
                location.reload();
            } else {
                alert("Ocurrio un error al intentar deshabilitar el registro");
            }
        }).fail(function (e) {
            alert("Ocurrio un error al intentar deshabilitar el registro");
            console.error(e);
        });
});

//Al habilitar un registro
$("body").on("click", ".habilitar", function() {
        var data = new FormData();
        data.append('id', $(this).attr("data-id"));

        $.ajax({
            url: "http://localhost:8081/tallas/habilitar",
            dataType: 'html',
            data: data,
            type: 'POST',
            async: false,
            processData: false,
            contentType: false,
        }).done(function (res) {
            //Mostarr el modal con el de edicion
            if(res == "OK"){
                alert("Color habilitado");
                location.reload();
            } else {
                alert("Ocurrio un error al intentar habilitar el registro");
            }
        }).fail(function (e) {
            alert("Ocurrio un error al intentar habilitar el registro");
            console.error(e);
        });
});