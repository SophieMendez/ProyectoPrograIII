package com.api.api.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.api.api.Notas;
import com.api.api.User;

@Service
public class DatabaseService {// inicio de llaves class
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public DatabaseService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
     public List<Notas> getAllNotes() {
        try {
            String query = "SELECT * FROM finalproject.notas"; // Define la consulta SQL
            List<Map<String, Object>> respNotes = jdbcTemplate.queryForList(query); //Ejecutar la consulta y obtener los resultados
            List<Notas> notes = new ArrayList<>(); //Prcesa los resultados y mapearlos a objetos Notas
 
            for (Map<String, Object> row : respNotes) { //Obtiene los valores de cada columna en la fila
                int id_nota = (int) row.get("id_nota");
                String nombre_nota = (String) row.get("nombre_nota");
                String estado_nota = (String) row.get("estado_nota");
                String descripcion_nota = (String) row.get("descripcion_nota");
                Notas notas = new Notas(id_nota, nombre_nota, estado_nota, descripcion_nota); //Crea objeto Notas con los valores de la fila
                notes.add(notas); //Agrega el objeto Notas a la lista
            }
            return notes; //devuelve
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public Notas getNotas(int id){  // Pide el id
        System.out.println("logId = " + id);
        try {
            String query = "SELECT * FROM notas WHERE id_nota = ?"; //Definir la consulta SQL con un parámetro de id

           // Ejecuta la consulta y mapear el resultado a un objeto Notas
 
            return jdbcTemplate.queryForObject(query, (rs, rowNum) -> {
                int id_nota = (int)rs.getInt("id_nota");
                String nombre_nota = rs.getString("nombre_nota");
                String estado_nota = rs.getString("estado_nota");
                String descripcion_nota = rs.getString("descripcion_nota");
              
                //Crea y devuelve un objeto Notas con los valores obtenidos
                return new Notas(id_nota, nombre_nota, estado_nota, descripcion_nota);
            }, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void updateNotas(Notas notas) {
        try {
            String query = "UPDATE notas SET nombre_nota = ?, estado_nota = ?, descripcion_nota = ? WHERE id_nota = ?";
            jdbcTemplate.update(query, notas.getNombre_nota(),notas.getEstado_nota(),notas.getDescripcion_nota(), notas.getId_nota());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertNotas(Notas notas) {
        try {
            String query = "INSERT notas SET nombre_nota = ?, estado_nota = ?, descripcion_nota = ? ";
            jdbcTemplate.update(query, notas.getNombre_nota(),notas.getEstado_nota(),notas.getDescripcion_nota(), notas.getId_nota());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int deleteNotas(int id) {
        try {
            String query = "DELETE FROM notas WHERE id_nota = ?";
            jdbcTemplate.update(query, id);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    public User authenticate(String username, String password) {
        try {
            String query = "SELECT * FROM usuarios WHERE username = ? AND password = ?";
            return jdbcTemplate.queryForObject(query, (rs, rowNum) -> {
                String storedUsername = rs.getString("username");
                String storedPassword = rs.getString("password");
                return new User(storedUsername, storedPassword);
            }, username, password);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
}//Final de la llave class
