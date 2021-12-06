/*------------GET-------------------*/
function getCommunity() {
    $.ajax({
        url: "http://localhost:8080/api/community/all",
        type: "GET",
        datatype: "JSON",
        success: function (resultCommunity) {
            console.log(resultCommunity);
            boardCommunity(resultCommunity);
            
        }
    });
}

function boardCommunity(resultCommunity) {

    let tableCommunity = "<table>";
    for (i = 0; i < resultCommunity.length; i++) {
        tableCommunity += "<tr>";
        tableCommunity += "<td>" + resultCommunity[i].idCommunity + "</td>";
        tableCommunity += "<td>" + resultCommunity[i].nickCommunity + "</td>";
        tableCommunity += "<td>" + resultCommunity[i].sectorCommunity + "</td>";
        tableCommunity += "<td>" + resultCommunity[i].nameCommunity + "</td>";
        tableCommunity += "<td>" + <button onclick='separarComunidad(" + +resultCommunity[i].idCommunity + ")'>Ver Usuarios</button>"
        //tableCommunity += "<td>" + <input type="button" onclick="location.href = 'bike.html'">Ver Usuarios</button>"
        //tableCommunity += "<td>" +<button onclick="window.location.href = 'bike.html'">Ver Usuarios</button>"
        //tableCommunity += "<td>" +<input type="button" onclick="window.location = 'bike.html';">
        tableCommunity += "<td><button onclick='cargarDatosCommunity(" + resultCommunity[i].idCommunity + ")'>Actualizar</button>";

        tableCommunity += "</tr>";
    }
    tableCommunity += "</table>";
    $("#community").html(tableCommunity);
}
getCommunity();
/*------------POST-------------------*/
function postCommunity() {
    //if ($("#serialNumber").val().length == 0 || $("#brand").val().length == 0 || $("#image").val().length == 0 || $("#condition").val().length == 0) {
    if ($("#nickCommunity").val().length == 0 || $("#sectorCommunity").val().length == 0 || $("#nameCommunity").val().length == 0) {
        alert("Todos los campos son obligatorios");
    } else {

        let community = {
            nickCommunity: $("#nickCommunity").val(),
            sectorCommunity: $("#sectorCommunity").val(),
            nameCommunity: $("#nameCommunity").val()

        };
        $.ajax({
            type: 'POST',
            contentType: "application/json; charset=utf-8",
            dataType: 'JSON',
            data: JSON.stringify(community),
            url: "http://localhost:8080/api/community/save",
            success: function (response) {
                console.log(response);
                console.log("Se guardo correctamente");
                alert("Se guardo correctamente");
                window.location.reload();
            },
            error: function (jqXHR, textStatus, errorThrown) {
                window.location.reload();
                alert("No se guardo correctamente");
            }
        });
    }
    getCommunity();
}
/*------------DELETE------------------*/
function deleteCommunity(idElemento) {
    var elemento = {
        id: idElemento
    };

    var dataToSend = JSON.stringify(elemento);
    console.log(dataToSend);
    $.ajax(
            {
                dataType: 'json',
                data: dataToSend,
                url: "http://localhost:8080/api/community/" + idElemento,
                type: 'DELETE',
                contentType: "application/JSON",
                success: function (response) {
                    console.log(response);
                    $("#tableCommunity").empty();

                    alert("se ha Eliminado Correctamente!");
                },

                error: function (jqXHR, textStatus, errorThrown) {
                    alert("No se Elimino Correctamente!");
                }
            });
    getCommunity();
}
/*------------PUT-------------------*/
function updateCommunity(idElemento) {

//    if ($("#serialNumber").val().length == 0 || $("#brand").val().length == 0 || $("#image").val().length == 0 || $("#condition").val().length == 0) {
//        alert("Todos los campos son obligatorios")
//    } else {
    let elemento = {

        idCommunity: $("#idCommunity").val(),
        nickCommunity: $("#nickCommunity").val(),
        sectorCommunity: $("#sectorCommunity").val(),
        nameCommunity: $("#nameCommunity").val()

    };

    console.log(elemento);
    let dataToSend = JSON.stringify(elemento);

    $.ajax({
        datatype: 'json',
        data: dataToSend,
        contentType: "application/JSON",
        url: "http://localhost:8080/api/community/update",
        type: "PUT",

        success: function (response) {
            console.log(response);
            $("#tableCommunity1").empty();
            alert("se ha Actualizado Correctamente!")
            getBike();

            //Limpiar Campos
            $("#idCommunity").val("");
            $("#nickCommunity").val("");
            $("#sectorCommunity").val("");
            $("#nameCommunity").val("");
        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert("No se Actualizo Correctamente!");
        }
    });
}
//}

//Cargar datos para actualizar
function cargarDatosCommunity(id) {
    $.ajax({
        dataType: 'json',
        url: "http://localhost:8080/api/community/" + id,
        type: 'GET',

        success: function (response) {
            console.log(response);
            var item = response;


            $("#idCommunity").val(item.idCommunity);
            $("#nickCommunity").val(item.nickCommunity);
            $("#sectorCommunity").val(item.sectorCommunity);
            $("#nameCommunity").val(item.nameCommunity);

        },

        error: function (jqXHR, textStatus, errorThrown) {

        }
    });

    function separarComunidad(id) {

        <script type="text/javascript">
        window.location.href = "http://localhost:8080/profile";
        </script>
        
    }
}
