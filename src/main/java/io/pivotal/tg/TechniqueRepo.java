package io.pivotal.tg;


import io.swagger.annotations.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
/**
 *  http://localhost:8080/techniques/search/findByDiscipline?discipline=judo
 */
interface TechniqueRepo extends JpaRepository<Technique, Long> {
    @ApiOperation(value = "findByDiscipline", nickname = "findByDiscipline")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "discipline", value = "Technique's name", required = true, dataType = "string", paramType = "query", defaultValue = "bjj")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Technique.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    List<Technique> findByDiscipline(@Param("discipline") String discipline);
}
