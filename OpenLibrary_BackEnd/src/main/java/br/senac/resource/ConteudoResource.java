package br.senac.resource;

import br.senac.dto.ConteudoDTO;
import br.senac.service.ConteudoService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.util.List;

@Path("/conteudo")
@Tag(name = "Conteudo Resource", description = "Endpoints para gerenciar conteudos")
public class ConteudoResource {

    @Inject
    ConteudoService service;


    @GET
    public List<ConteudoDTO> listarConteudo() throws Exception{
        return service.listarConteudo();
    }

}
