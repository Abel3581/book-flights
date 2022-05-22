package com.staff.flight.model.enums;

public enum EnumMailMessage {

    REGISTER_TITLE("Registro de cuenta: "),
    WELCOME_SUBJECT("Bienvenido/a a Ventas Online. !"),
    WELCOME_IMAGE("https://as2.ftcdn.net/v2/jpg/04/70/80/29/1000_F_470802908_cExbgJPYg6Cf8sxo7PXeh9w0rbuENkKh.jpg"),
    CONTACT_MAIL("Mail: somosTiendaOnline@gmail.com"),
    CONTACT_FACEBOOK("Tienda_Online"),
    CONTACT_INSTAGRAM("TiendaOnline"),
    CONTACT_PHONE("Teléfono de contacto: 1160112988"),
    DELETED_IMAGE("https://i.pinimg.com/474x/54/ab/11/54ab11ec94293420666c792ea821924f.jpg");

    private final String value;

    EnumMailMessage(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static String getWelcomeMsg(String firstName, String lastName){
        return "Bienvenido/a " + firstName + " " + lastName + ", gracias por haberte registrado en nuestro sitio web!";
    }
}
