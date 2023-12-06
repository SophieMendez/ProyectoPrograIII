package com.api.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class DatabaseService {// inicio de llaves class

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Autowired
    public DatabaseService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

     public List<Notas> getAllNotes() {
        try {
            String query = "SELECT * FROM finalproject.notas";
            List<Map<String, Object>> respNotes = jdbcTemplate.queryForList(query);
            List<Notas> notes = new ArrayList<>();
 
            for (Map<String, Object> row : respNotes) {
                int id_nota = (int) row.get("id_nota");
                String nombre_nota = (String) row.get("nombre_nota");
                String estado_nota = (String) row.get("estado_nota");
                String descripcion_nota = (String) row.get("descripcion_nota");
 
                Notas notas = new Notas(id_nota, nombre_nota, estado_nota, descripcion_nota);
                notes.add(notas);
            }
            return notes;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Notas getNotas(int id){
        System.out.println("logId = " + id);
        try {
            String query = "SELECT * FROM notas WHERE id_nota = ?";
 
            return jdbcTemplate.queryForObject(query, (rs, rowNum) -> {
                int id_nota = (int)rs.getInt("id_nota");
                String nombre_nota = rs.getString("nombre_nota");
                String estado_nota = rs.getString("estado_nota");
                String descripcion_nota = rs.getString("descripcion_nota");
              
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
    
}//Final de la llave class
