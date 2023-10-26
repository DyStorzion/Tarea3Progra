package org.example.modelos;

/**
 *Clase main para demostrar el correcto funcionamiento del programa
 *
 * @author Benjamin Espinoza
 */
public class Main {
    /**
     * desde el comprador 1 hasta el 8 se usa solamente el primer expendedor probando comprar todos los productos
     * y devolviendo el respectivo vuelto, los ultimos 2 compradores (Comprador 9 y 10) usan el segundo expendedor para
     * demostrar que un expendedor no tiene relacion con el otro
     */
    public static void main(String[] args) {
        //Creacion de una moneda y dos expendodres
        Moneda moneda = new Moneda1000();
        Expendedor expendedor1 = new Expendedor(1);
        Expendedor expendedor2 = new Expendedor(1);

        //Comprador 1
        System.out.println("comprador1: ");
        Comprador comprador1;
        try {
            comprador1 = new Comprador(moneda, InfoProducto.COCA, expendedor1);
            System.out.println(comprador1.queConsumiste());
            System.out.println(comprador1.cuantoVuelto());
        } catch (NoHayProductoException e) {
            System.out.println("No ingreso una opcion valida o no quedan productos en el expendedor");
        } catch (PagoInsuficienteException e) {
            System.out.println("El precio del producto escogido es mayor al valor de su moneda");
        } catch (PagoIncorrectoException e) {
            System.out.println("Moneda invalida");
        }

        //Comprador 2
        System.out.println("\ncomprador2: ");
        Comprador comprador2;
        moneda = new Moneda1000();
        try {
            comprador2 = new Comprador(moneda, InfoProducto.SPRITE, expendedor1);
            System.out.println(comprador2.queConsumiste());
            System.out.println(comprador2.cuantoVuelto());
        } catch (NoHayProductoException e) {
            System.out.println("No ingreso una opcion valida o no quedan productos en el expendedor");
        } catch (PagoInsuficienteException e) {
            System.out.println("El precio del producto escogido es mayor al valor de su moneda");
        } catch (PagoIncorrectoException e) {
            System.out.println("Moneda invalida");
        }

        //Comprador 3
        System.out.println("\ncomprador3: ");
        Comprador comprador3;
        try {
            comprador3 = new Comprador(moneda, InfoProducto.FANTA, expendedor1);
            System.out.println(comprador3.queConsumiste());
            System.out.println(comprador3.cuantoVuelto());
        } catch (NoHayProductoException e) {
            System.out.println("No ingreso una opcion valida o no quedan productos en el expendedor");
        } catch (PagoInsuficienteException e) {
            System.out.println("El precio del producto escogido es mayor al valor de su moneda");
        } catch (PagoIncorrectoException e) {
            System.out.println("Moneda invalida");
        }

        //Comprador 4
        System.out.println("\ncomprador4: ");
        Comprador comprador4;
        try {
            comprador4 = new Comprador(moneda, InfoProducto.SNICKERS, expendedor1);
            System.out.println(comprador4.queConsumiste());
            System.out.println(comprador4.cuantoVuelto());
        } catch (NoHayProductoException e) {
            System.out.println("No ingreso una opcion valida o no quedan productos en el expendedor");
        } catch (PagoInsuficienteException e) {
            System.out.println("El precio del producto escogido es mayor al valor de su moneda");
        } catch (PagoIncorrectoException e) {
            System.out.println("Moneda invalida");
        }

        //Comprador 5
        System.out.println("\ncomprador5: ");
        Comprador comprador5;
        try {
            comprador5 = new Comprador(moneda, InfoProducto.SUPER8, expendedor1);
            System.out.println(comprador5.queConsumiste());
            System.out.println(comprador5.cuantoVuelto());
        } catch (NoHayProductoException e) {
            System.out.println("No ingreso una opcion valida o no quedan productos en el expendedor");
        } catch (PagoInsuficienteException e) {
            System.out.println("El precio del producto escogido es mayor al valor de su moneda");
        } catch (PagoIncorrectoException e) {
            System.out.println("Moneda invalida");
        }

        //Comprador 6
        System.out.println("\ncomprador6: ");
        Comprador comprador6;
        moneda = new Moneda1000();
        try {
            comprador6 = new Comprador(moneda, InfoProducto.COCA, expendedor1);
            System.out.println(comprador6.queConsumiste());
            System.out.println(comprador6.cuantoVuelto());
        } catch (NoHayProductoException e) {
            System.out.println("No ingreso una opcion valida o no quedan productos en el expendedor");
        } catch (PagoInsuficienteException e) {
            System.out.println("El precio del producto escogido es mayor al valor de su moneda");
        } catch (PagoIncorrectoException e) {
            System.out.println("Moneda invalida");
        }

        //Comprador 7
        System.out.println("\ncomprador7: ");
        Comprador comprador7;
        moneda = new Moneda100();
        try {
            comprador7 = new Comprador(moneda, InfoProducto.COCA, expendedor1);
            System.out.println(comprador7.queConsumiste());
            System.out.println(comprador7.cuantoVuelto());
        } catch (NoHayProductoException e) {
            System.out.println("No ingreso una opcion valida o no quedan productos en el expendedor");
        } catch (PagoInsuficienteException e) {
            System.out.println("El precio del producto escogido es mayor al valor de su moneda");
        } catch (PagoIncorrectoException e) {
            System.out.println("Moneda invalida");
        }

        //Comprador 8
        System.out.println("\ncomprador8:");
        Comprador comprador8;
        moneda = null;
        try {
            comprador8 = new Comprador(moneda, InfoProducto.COCA, expendedor1);
            System.out.println(comprador8.queConsumiste());
            System.out.println(comprador8.cuantoVuelto());
        } catch (NoHayProductoException e) {
            System.out.println("No ingreso una opcion valida o no quedan productos en el expendedor");
        } catch (PagoInsuficienteException e) {
            System.out.println("El precio del producto escogido es mayor al valor de su moneda");
        } catch (PagoIncorrectoException e) {
            System.out.println("Moneda invalida");
        }

        //Comprador 9
        System.out.println("\ncomprador9: ");
        Comprador comprador9;
        moneda = new Moneda1000();
        try {
            comprador9 = new Comprador(moneda, InfoProducto.COCA, expendedor2);
            System.out.println(comprador9.queConsumiste());
            System.out.println(comprador9.cuantoVuelto());
        } catch (NoHayProductoException e) {
            System.out.println("No ingreso una opcion valida o no quedan productos en el expendedor");
        } catch (PagoInsuficienteException e) {
            System.out.println("El precio del producto escogido es mayor al valor de su moneda");
        } catch (PagoIncorrectoException e) {
            System.out.println("Moneda invalida");
        }

        //Comprador 10
        System.out.println("\ncomprador10: ");
        Comprador comprador10;
        moneda = new Moneda1000();
        try {
            comprador10 = new Comprador(moneda, InfoProducto.SPRITE, expendedor2);
            System.out.println(comprador10.queConsumiste());
            System.out.println(comprador10.cuantoVuelto());
        } catch (NoHayProductoException e) {
            System.out.println("No ingreso una opcion valida o no quedan productos en el expendedor");
        } catch (PagoInsuficienteException e) {
            System.out.println("El precio del producto escogido es mayor al valor de su moneda");
        } catch (PagoIncorrectoException e) {
            System.out.println("Moneda invalida");
        }
    }
}