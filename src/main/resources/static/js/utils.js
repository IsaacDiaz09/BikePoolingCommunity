// Url del end-point rest
const urlbase = "http://localhost:8080/api";

// RegEx para validar un direccion de email
const regExEmail =
    /^(([^<>()\[\]\\.,;:\s@”]+(\.[^<>()\[\]\\.,;:\s@”]+)*)|(“.+”))@((\[[0–9]{1,3}\.[0–9]{1,3}\.[0–9]{1,3}\.[0–9]{1,3}])|(([a-zA-Z\-0–9]+\.)+[a-zA-Z]{2,}))$/;

// RegEx para validar url
const RegExUrl = /^(?:http(s)?:\/\/)?[\w.-]+(?:\.[\w\.-]+)+[\w\-\._~:/?#[\]@!\$&'\(\)\*\+,;=.]+$/;

// Se llama cada que se quiera mostrar mensaje de error/confirmacion emergente
const mostrarMensaje = (titulo, cuerpo, error) => {
    document.getElementById("titulomensaje").innerHTML = titulo;
    $("#cuerpomensaje").html(cuerpo);
    $("#myToast").removeClass();
    if (error) {
        $("#myToast").addClass("toast bg-danger");
    } else {
        $("#myToast").addClass("toast bg-primary");
    }

    $("#myToast").toast("show");
};

// Regresa boolean, verifica si un campo se dejo en blanco
function campoEstaVacio(valor) {
    return valor === "" || valor === null;
}

// Valida que el email sea valido, la obligatoriedad de los campos, que las contraseñas coincidan y su longitud
function validaUsuario(nombre, email, pass, passConfirmar, cell, gender, social, edad, direccion) {
    if (
        campoEstaVacio(nombre) === true ||
        campoEstaVacio(email) === true ||
        campoEstaVacio(pass) === true ||
        campoEstaVacio(passConfirmar) === true ||
        campoEstaVacio(cell) === true ||
        campoEstaVacio(edad) === true ||
        campoEstaVacio(direccion) === true
    ) {
        mostrarMensaje(
            "Error",
            "Hay campos requeridos vacios, verifique e intente nuevamente",
            true
        );
        return false;
    } else if (regExEmail.test(email) === false) {
        mostrarMensaje(
            "Error",
            "El formato de email es inválido, verifiquelo e intente de nuevo",
            true
        );
        return false;
    } else if (pass.length < 8 || passConfirmar.length < 8) {
        mostrarMensaje(
            "Error",
            "La contraseña debe tener minimo 8 caracteres",
            true
        );
        return false;
    } else if (pass !== passConfirmar) {
        mostrarMensaje("Error", "La contraseñas no coinciden", true);
        return false;
    }
    return true;
}

// Valida que la url de la imagen sea valida, obligatoriedad de campos, precio y cantidad no negativos
function validaProducto(nombre, idGadget, brand, category, description, price, quantity, photo) {
    if (
        campoEstaVacio(nombre) === true || campoEstaVacio(idGadget) === true ||
        campoEstaVacio(brand) === true || campoEstaVacio(category) === true ||
        campoEstaVacio(description) === true || campoEstaVacio(price) === true ||
        campoEstaVacio(quantity) === true || campoEstaVacio(photo) === true
    ) {
        mostrarMensaje(
            "Error",
            "Todos los campos son requeridos, verifique e intente nuevamente",
            true
        );
        return false;
    } else if (idGadget < 0) {
        mostrarMensaje(
            "Error",
            "El ID no puede ser negativo",
            true
        );
        return false;
    } else if (price < 0) {
        mostrarMensaje(
            "Error",
            "El precio no puede ser negativo",
            true
        );
        return false;
    } else if (quantity < 0) {
        mostrarMensaje(
            "Error",
            "La cantidad no puede ser negativo",
            true
        );
        return false;
    } else if (RegExUrl.test(photo) === false) {
        mostrarMensaje(
            "Error",
            "El formato de la url de la imagen es invalido, verifiquelo en intente de nuevo",
            true
        );
        return false;
    }
    return true;
}

// Limpia los campos del formulario usuarios
const limpiarCamposUser = () => {
    $("#name").val("");
    $("#email").val("");
    $("#cellphone").val("");
    $(pass).val("")
    $(pass2).val("")
    $(cellphone).val("")
    $(solcialNetwork).val("")
    $(age).val("")
}

// Limpia los campos del formulario productos
const limpiaCamposGadget = () => {
    $("#name").val("");
    $("#idGadget").val("");
    $("#brand").val("");
    $("#category").val("");
    $("#description").val("");
    $("#price").val("");
    $("#quantity").val("");
    $("#photo").val("");
}

export { mostrarMensaje, campoEstaVacio, urlbase, regExEmail, limpiarCamposUser, limpiaCamposGadget, validaUsuario, validaProducto };