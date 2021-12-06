alert("hola");
console.log("javascript");
/*------------GET-------------------*/
function getBike() {
    $.ajax({
        url: "http://localhost:8080/api/bike/all",
        type: "GET",
        datatype: "JSON",
        success: function (resultBike) {
            console.log(resultBike);
            boardBike(resultBike);
        }
    });
}
function boardBike(resultBike) {

    let tableBike = "<table>";
    for (i = 0; i < resultBike.length; i++) {
        tableBike += "<tr>";
        tableBike += "<td>" + resultBike[i].serialNumber + "</td>";
        tableBike += "<td>" + resultBike[i].status + "</td>";
        tableBike += "<td><button onclick='cargarDatosBike(" + resultBike[i].idBike + ")'>Actualizar</button>";
        tableBike += "<td><button onclick='borrarBike(" + resultBike[i].idBike + ")'>Borrar</button>";
        tableBike += "</tr>";
    }
    tableBike += "</table>";
    $("#tablaBike1").html(tableBike);
}
/*------------POST-------------------*/
function postBike() {
    //if ($("#serialNumber").val().length == 0 || $("#brand").val().length == 0 || $("#image").val().length == 0 || $("#condition").val().length == 0) {
    if ($("#serialNumber").val().length == 0 || $("#brand").val().length == 0 || $("#condition").val().length == 0) {
        alert("Todos los campos son obligatorios")
    } else {

        let bike = {
            serialNumber: $("#serialNumber").val(),
            status:$("#status").val(),
            brand: $("#brand").val(),
            image: $("#image").val(),
            condition: $("#condition").val(),
            category: $("#category").val() ,
        };
        $.ajax({
            type: 'POST',
            contentType: "application/json; charset=utf-8",
            dataType: 'JSON',
            data: JSON.stringify(bike),
            url: "http://localhost:8080/api/bike/save",
            success: function (response) {
                console.log(response);
                console.log("Se guardo correctamente");
                alert("Se guardo correctamente");
                window.location.reload()
            },
            error: function (jqXHR, textStatus, errorThrown) {
                window.location.reload()
                alert("No se guardo correctamente");
            }
        });
    }

}
/*------------DELETE------------------*/
function borrarBike(idElemento) {
    var elemento = {
        id: idElemento
    }

    var dataToSend = JSON.stringify(elemento);
    console.log(dataToSend);
    $.ajax(
        {
            dataType: 'json',
            data: dataToSend,
            url: "http://localhost:8080/api/bike/" + idElemento,
            type: 'DELETE',
            contentType: "application/JSON",
            success: function (response) {
                console.log(response);
                $("#tablaBike1").empty();

                alert("se ha Eliminado Correctamente!")
            },

            error: function (jqXHR, textStatus, errorThrown) {
                alert("No se Elimino Correctamente!")
            }
        });
}
/*------------PUT-------------------*/
function actualizarBike(idElemento) {

//    if ($("#serialNumber").val().length == 0 || $("#brand").val().length == 0 || $("#image").val().length == 0 || $("#condition").val().length == 0) {
//        alert("Todos los campos son obligatorios")
//    } else {
        let elemento = {
            id: idElemento,
            serialNumber: $("#serialNumber").val(),
            status: $("#status").val(),
            brand: $("#brand").val(),
            image: $("#image").val(),
            condition: $("#condition").val(),
            category: $("#category").val()
        }

        console.log(elemento);
        let dataToSend = JSON.stringify(elemento);

        $.ajax({
            datatype: 'json',
            data: dataToSend,
            contentType: "application/JSON",
            url: "http://localhost:8080/api/bike/update",
            type: "PUT",

            success: function (response) {
                console.log(response);
                $("#tablaBike1").empty();
                listarSkate();
                alert("se ha Actualizado Correctamente!")

                //Limpiar Campos
                $("#serialNumber").val("");
                $("#brand") .val("");
                $("#condition").val("");



            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert("No se Actualizo Correctamente!")
            }
        });
    }
//}

//Cargar datos para actualizar
function cargarDatosBike(id) {
    $.ajax({
        dataType: 'json',
        url: "http://localhost:8080/api/bike/" + id,
        type: 'GET',

        success: function (response) {
            console.log(response);
            var item = response;


            $("#serialNumber").val(item.serialNumber);
            $("#status").val(item.status);
            $("#brand").val(item.name);
            $("#image").val(item.brand);
            $("#condition").val(item.year);
            $("#category").val(item.category);
            
        },

        error: function (jqXHR, textStatus, errorThrown) {

        }
    });
}
