package util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import modelo.Contacto;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class ManejadorJSON {
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void guardar(ArrayList<Contacto> lista, String ruta) {
        try (FileWriter writer = new FileWriter(ruta)) {
            gson.toJson(lista, writer);
        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }

    public static void guardarConBackup(ArrayList<Contacto> lista, String ruta, String backup) {
        guardar(lista, ruta);
        guardar(lista, backup);
    }

    public static ArrayList<Contacto> cargar(String ruta) {
        File archivo = new File(ruta);
        if (!archivo.exists()) return new ArrayList<>();
        try (FileReader reader = new FileReader(archivo)) {
            Type tipoLista = new TypeToken<ArrayList<Contacto>>(){}.getType();
            ArrayList<Contacto> lista = gson.fromJson(reader, tipoLista);
            return (lista != null) ? lista : new ArrayList<>();
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }
}