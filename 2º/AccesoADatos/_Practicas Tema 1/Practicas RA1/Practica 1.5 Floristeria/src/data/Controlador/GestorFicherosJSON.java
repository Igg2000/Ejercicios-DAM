/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.Controlador;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import data.Modelo.Flor;
import data.Modelo.Floristeria;
import data.Modelo.Planta;
import data.Modelo.Producto;
import java.io.File;
import java.io.FileReader;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect.Type;
import javax.swing.JOptionPane;

/**
 * Clase que maneja la serializacion y deserializacion 
 * de la floristeria en un json usando la libreria gson
 * @author Nacho
 */
public class GestorFicherosJSON {
    private File rutaArchivo = new File(".//src//res//floristeria.json");
    
    /**
     * Serializa una instancia de Floristeria y la guarda en un archivo JSON.
     * @param floristeria La floristería a serializar.
     */
    public void serializarFloristeria(Floristeria floristeria) {
        
        if(floristeria.getInventario().isEmpty() && floristeria.getVentas().isEmpty()){
            JOptionPane.showMessageDialog(null, "La floristeria no tiene datos ahora mismo, no tiene sentido guardar");
            return;
        }
   
        Gson gson = new GsonBuilder()
            .registerTypeAdapter(Producto.class, new ProductoTypeAdapter())
            .setPrettyPrinting()
            .create();
        
        try (FileWriter writer = new FileWriter(rutaArchivo)) {
            String json = gson.toJson(floristeria);
            writer.write(json);
            System.out.println("Floristería serializada correctamente en: " + rutaArchivo.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Error al serializar la floristería: " + e.getMessage());
        }
    }
    
    /**
     * Deserializa una instancia de Floristeria desde un archivo JSON.
     * 
     * @return Una instancia de Floristeria deserializada o null si ocurre un error.
     */
    public Floristeria deserializarFloristeria() {
        Gson gson = new GsonBuilder()
            .registerTypeAdapter(Producto.class, new ProductoTypeAdapter())
            .create();
        
        try (FileReader reader = new FileReader(rutaArchivo)) {        
            Floristeria floristeria = gson.fromJson(reader, Floristeria.class);
            System.out.println("Floristería deserializada correctamente desde: " + rutaArchivo.getAbsolutePath());
            return floristeria;
        } catch (IOException e) {
            System.err.println("Error al deserializar la floristería: " + e.getMessage());
            return null;
        }
    }

    public File getRutaArchivo() {
        return rutaArchivo;
    }
    
    /**
     * He tenido que hacer esta clase ya que productos es una clase abstracta
     * y sin esta clase no se sabria de que tipo es cada producto
     */
    class ProductoTypeAdapter implements JsonDeserializer<Producto>, JsonSerializer<Producto> {
       @Override
        public JsonElement serialize(Producto src, java.lang.reflect.Type type, JsonSerializationContext context) {
            JsonObject jsonObject = context.serialize(src).getAsJsonObject();
            if (src instanceof Flor) {
                jsonObject.addProperty("tipo", "Flor");
            } else if (src instanceof Planta) {
                jsonObject.addProperty("tipo", "Planta");
            }
            return jsonObject;
        }

        @Override
        public Producto deserialize(JsonElement json, java.lang.reflect.Type type, JsonDeserializationContext context) throws JsonParseException {
            JsonObject jsonObject = json.getAsJsonObject();
            String tipo = jsonObject.get("tipo").getAsString();

            switch (tipo) {
                case "Flor":
                    return context.deserialize(json, Flor.class);
                case "Planta":
                    return context.deserialize(json, Planta.class);
                default:
                    throw new JsonParseException("Tipo desconocido: " + tipo);
            }
        }

    }

}
