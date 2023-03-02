/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diagnostico;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author 416pc10
 */
public class ComponentePractico {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Scanner leer = new Scanner(System.in);
        int opcion;
        String mensaje = null;
        do {
            System.out.println("Bienvenidos al Menu Estructuras Basica."
                    + "\n 1 = Condicional Simple"
                    + "\n 2 = Condicional Doble"
                    + "\n 3 = Condicional Multiple"
                    + "\n 4 = Condicional Anidado"
                    + "\n 5 = Estructura Switch"
                    + "\n 6 = Estructura Ciclica"
                    + "\n 7 = Estructura Ciclica y Condicional"
                    + "\n 0 = Salir"
                    + "\n Digite una opción ->\040)");
            opcion = leer.nextInt();

            switch (opcion) {
                case 1:
                    JOptionPane.showMessageDialog(null, condicionalSimple());
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, condicionalDoble());
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, condicionalMultiple());
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, condicionalAnidado());
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, estructuraSwitch());
                    break;
                case 6:
                    JOptionPane.showMessageDialog(null, estructuraCiclica());
                    break;
                case 7:
                    JOptionPane.showMessageDialog(null, estructuraCiclicayCond());
                    break;
            }
        } while (opcion != 0);

        JOptionPane.showMessageDialog(null, mensaje);
    }

    public static String condicionalSimple() {
        Scanner leer = new Scanner(System.in);

        int cantB;
        int cantM;
        String mensaje = null;
        System.out.println("Ingrese la cantidad minima");
        cantM = leer.nextInt();
        System.out.println("Ingrese la cantidad en bodega");
        cantB = leer.nextInt();

        if (cantM > cantB) {
            mensaje = "Debe solicitar pedido al proveedor";
        } else if (cantM < cantB) {
            mensaje = "No es necesario solicitar pedido al proveedor";
        }
        return mensaje;
    }

    public static String condicionalDoble() {
        Scanner leer = new Scanner(System.in);

        int cantB;
        int cantM;
        System.out.println("Ingrese la cantidad minima");
        cantM = leer.nextInt();
        System.out.println("Ingrese la cantidad en bodega");
        cantB = leer.nextInt();

        return cantM > cantB ? "Es necesario realizar el pedido al proveedor." : "No es necesario realizar el pedido al proveedor.";
    }

    public static String condicionalMultiple() {
        Scanner leer = new Scanner(System.in);

        int cantB;
        int cantM;
        int resul = 0;
        String mensaje = null;

        System.out.println("Ingrese la cantidad minima");
        cantM = leer.nextInt();
        System.out.println("Ingrese la cantidad en bodega");
        cantB = leer.nextInt();

        resul = cantB - cantM;
        if (resul > 0 && resul < 5) {
            mensaje = "No es necesario realizar el pedido al proveedor. Unidades que hacen falta vender %.2f. Alerta generada" + resul;
        } else if (resul > 0) {
            mensaje = "No es necesario realizar el pedido al proveedor. Unidades que hacen falta vender %.2f" + resul;
        } else {
            mensaje = "Es necesario realizar pedido";
        }
        return mensaje;
    }

    public static String condicionalAnidado() {

        Scanner leer = new Scanner(System.in);

        int unidadesAComprar;
        double valorProducto;
        double dineroEnCaja;
        double valorTotal;
        int cantB;
        int cantM;
        String mensaje = null;

        System.out.println("Ingrese la cantidad minima");
        cantM = leer.nextInt();
        System.out.println("Ingrese la cantidad en bodega");
        cantB = leer.nextInt();

        if (cantM > cantB) {

            System.out.println("Es necesario solicitar pedido al proveedor");
            System.out.println("Ingrese la cantidad a comprar");
            unidadesAComprar = leer.nextInt();
            System.out.println("Ingrese el valor del producto");
            valorProducto = leer.nextInt();
            System.out.println("Ingrese el dinero en caja");
            dineroEnCaja = leer.nextInt();

            valorTotal = unidadesAComprar * valorProducto;

            if (valorTotal > dineroEnCaja) {
                mensaje = "Cantidad deseada: " + unidadesAComprar
                        + ".\n Valor de compra: " + valorTotal + ".\n Valor en caja: " + dineroEnCaja + "\n 'NO ES POSIBLE"
                        + " REALIZAR EL PEDIDO'";

            } else {
                mensaje = "Cantidad deseada: " + unidadesAComprar
                        + ".\n Valor de compra: " + valorTotal + ".\n Valor en caja: " + dineroEnCaja + "\n 'SI ES POSIBLE"
                        + " REALIZAR LA COMPRA'";
            }

        } else {
            int unidades = cantB - cantM;
            if (unidades <= 10) {
                mensaje = "Unidades que hacen falta vender: " + unidades + " 'ALERTA GENERADA' ";
            } else {
                mensaje = "Unidades que hacen falta vender: " + unidades;
            }
        }

        return mensaje;
    }

    public static String estructuraSwitch() {

        Scanner leer = new Scanner(System.in);
        double valorDesc = 0;
        System.out.print("Ingrese el total a pagar -> ");
        double valorPagar = Double.parseDouble(leer.nextLine());
        System.out.println("Escoja el dia."
                + "\n lunes"
                + "\n martes"
                + "\n miercoles"
                + "\n jueves"
                + "\n viernes"
                + "\n sabado"
                + "\n domingo");
        String dia = leer.nextLine().toLowerCase();
        switch (dia) {
            case "lunes":
                valorDesc = valorPagar * 0.05;
            case "martes":
                valorDesc = valorPagar * 0.03;
            case "miercoles":
                valorDesc = valorPagar * 0.1;
            case "jueves":
                valorDesc = valorPagar * 0.04;
            case "viernes":
                valorDesc = valorPagar * 0.06;
            case "sabado":
                valorDesc = valorPagar * 0.02;
            case "domingo":
                valorDesc = valorPagar * 0.01;
            default:
                System.out.println("ingrese un dia valido");
        }

        double pagoTotal = valorPagar - valorDesc;
        String mensaje = "Dia: " + dia + "\n Valor Descuento: " + valorDesc + "\n Pago Inicial: " + valorPagar + "\n Total con descuento: "
                + pagoTotal;
        return mensaje;

    }

    public static String estructuraCiclica() {
        Scanner leer = new Scanner(System.in);

        int cantP;
        int cantU;
        double valP, valT, valTaP = 0;
        System.out.print("Ingrese la cantidad de productos -> ");
        cantP = Integer.parseInt(leer.nextLine());
        for (int i = 0; i < cantP; i++) {
            System.out.printf("Ingrese la cantidad del producto %d -> ", i + 1);
            cantU = Integer.parseInt(leer.nextLine());
            System.out.printf("Ingrese el valor del producto %d -> ", i + 1);
            valP = Double.parseDouble(leer.nextLine());
            valT = cantU * valP;
            valTaP += valT;
        }
        return "El valor total a pagar es " + valTaP;
    }

    public static String estructuraCiclicayCond() {
        Scanner leer = new Scanner(System.in);
        int cantU, cantP, cantC, i, y = 0;
        double valP, valT, valTaP, sumTot = 0;
        System.out.print("Ingrese la cantidad de clientes -> ");
        cantC = Integer.parseInt(leer.nextLine());
        while (y < cantC) {
            y++;
            valTaP = 0;
            System.out.println("Cliente " + y);
            System.out.print("Ingrese la cantidad de productos -> ");
            cantP = Integer.parseInt(leer.nextLine());
            for (i = 0; i < cantP; i++) {
                System.out.printf("Ingrese la cantidad del producto %d -> ", i + 1);
                cantU = Integer.parseInt(leer.nextLine());
                System.out.printf("Ingrese el valor del producto %d -> ", i + 1);
                valP = Double.parseDouble(leer.nextLine());
                valT = cantU * valP;
                valTaP += valT;
            }
            if (valTaP > 100000) {
                sumTot = valTaP * 0.1;
                System.out.println("El valor total a pagar es " + sumTot);
            } else {
                sumTot = valTaP;
                System.out.println("El valor total a pagar es " + sumTot);
            }
            sumTot += sumTot;
        }
        return "Total vendido: " + sumTot;
    }
}
