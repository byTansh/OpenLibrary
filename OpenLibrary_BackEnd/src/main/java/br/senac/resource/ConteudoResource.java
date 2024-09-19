package br.senac.resource;

import br.senac.dto.ConteudoDTO;
import br.senac.service.ConteudoService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.net.URI;
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

    @POST
    public Response criarConteudo(ConteudoDTO conteudo) throws Exception{
        service.criarConteudo(conteudo);
        return Response.status(Response.Status.CREATED).build();
    }
}
