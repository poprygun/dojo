package io.pivotal.tg;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
/**
 *  http://localhost:8080/techniques/search/findByDiscipline?discipline=judo
 */
interface TechniqueRepo extends JpaRepository<Technique, Long>{
    List<Technique> findByDiscipline(@Param("discipline") String discipline);
}
