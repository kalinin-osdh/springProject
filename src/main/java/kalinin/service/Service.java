package kalinin.service;

import java.util.List;

public interface Service<Entity, Dto, Integer> {

    Dto insert(Entity entity);

    Dto update(Integer id, Entity entity);

    Dto deleteById(Integer id);

    List<Dto> findAll();

    Dto findById(Integer id);

}
