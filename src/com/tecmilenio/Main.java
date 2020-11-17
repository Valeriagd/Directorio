package com.tecmilenio;
import java.util.HashMap;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    AdressBook Contactos = new AdressBook();
    Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        AdressBook adressBook = new AdressBook();
        Main Menu = new Main();
        Menu.Menu();
    }


        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        boolean salir = false;


        public void Menu ()throws IOException{

            while (!salir) {

                System.out.println("Escriba el numero de opcion");
                System.out.println("1. Ver lista de contactos");
                System.out.println("2. Añadir nuevo contacto");
                System.out.println("3. Eliminar contacto");
                System.out.println("0. Salir");

                try {
                    opcion = scanner.nextInt();

                    switch (opcion) {

                        case 1:
                            enseñarContacto();
                            break;

                        case 2:
                            agregarContacto();
                            break;

                        case 3:
                            eliminarContacto();
                            break;

                        case 0:
                            salir=true;
                            System.out.println("adios");
                            break;

                        default:
                            throw new IllegalStateException("Opcion invalida: " + opcion);
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Ingresa una opcion valida");
                    scanner.next();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        private void enseñarContacto()throws IOException{
            Contactos.list();
        }

        private void agregarContacto() throws IOException {
            System.out.println("Ingresa el nombre");
            var nombre = entrada.next();
            System.out.println("Ingresa el numero");
            var numero = entrada.next();
            Contactos.create(numero,nombre);
            System.out.println("listo");
        }

        private void eliminarContacto() throws IOException {
            System.out.println("Ingresa el numero");
            var eliminar = entrada.next();
            Contactos.delete(eliminar);

        }

}
