package com.tecmilenio;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class AdressBook {

    private static HashMap<String,String> Contactos = new HashMap<String, String>();


    public static void load() throws IOException {
        String separator = FileSystems.getDefault().getSeparator();
        String filename = String.format("src%scom%stecmilenio%scontactos.csv", separator,separator, separator);
        Path path = Paths.get(filename);
        ArrayList<String> lines = new ArrayList<>();

        if(!Files.exists(path)){
            File file = new File(String.valueOf(path));
            file.createNewFile();
        }

        lines = (ArrayList<String>) Files.readAllLines(path);

        for (var contact : lines){
            var infoContact = contact.split(",");
            Contactos.put(infoContact[0].trim(),infoContact[1].trim());
        }
    }

    public static void save() throws IOException{
        String separator = FileSystems.getDefault().getSeparator();
        String filename = String.format("src%scom%stecmilenio%scontactos.csv", separator,separator, separator);
        Path path = Paths.get(filename);

        ArrayList<String> saveContacts = new ArrayList<>();
        for (var contacto : Contactos.entrySet()){
            saveContacts.add(contacto.getKey()+", "+ contacto.getValue());
        }
        Files.write(path,saveContacts);
    }



    public void list(){
        for (var contact : Contactos.entrySet()){
            System.out.println(String.format("Numero: %s, Nombre: %s",contact.getKey(),contact.getValue()));
        }
    }

    public static void create(String telefono, String nombre) throws IOException {
        Contactos.put(telefono, nombre);

        save();
        load();
    }



        public static void delete (String telefono) throws IOException {

            var p = Contactos.remove(telefono);
            save();
            load();
        }
}
