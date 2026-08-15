package com.duban.dao;
import com.duban.model.Estudiante;
public interface EstudianteDao {
    Estudiante findById(int id);
    void save(Estudiante estudiante);
    void update(Estudiante estudiante);
    void delete(int id);

}
