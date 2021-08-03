package alkemy.challenge.Challenge.Alkemy.controller;

import alkemy.challenge.Challenge.Alkemy.dto.views.OrganizationView;
import alkemy.challenge.Challenge.Alkemy.repository.OrganizationRepository;
import alkemy.challenge.Challenge.Alkemy.service.OrganizationService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/organization")
public class OrganizationController {

    @Autowired
    private OrganizationRepository organizationRepository;

    @Autowired
    private OrganizationService organizationService;

    @GetMapping(path = "/public/{id}")
    @JsonView({OrganizationView.Public.class})
    public ResponseEntity<?> getOrganizationById(@PathVariable("id") Integer id){
    try{
        return ResponseEntity.status(HttpStatus.OK).body(organizationService.getById(id));
    } catch (Exception e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron resultados, intente nuevamente");
    }
    }


}
