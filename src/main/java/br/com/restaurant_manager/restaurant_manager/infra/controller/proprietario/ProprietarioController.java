package br.com.restaurant_manager.restaurant_manager.infra.controller.proprietario;

import br.com.restaurant_manager.restaurant_manager.application.usecases.proprietario.*;
import br.com.restaurant_manager.restaurant_manager.infra.controller.request.UsuarioRequestDTO;
import br.com.restaurant_manager.restaurant_manager.infra.controller.response.UsuarioResponseDTO;
import br.com.restaurant_manager.restaurant_manager.model.entities.proprietario.Proprietario;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("proprietarios")
@Tag(name= "Proprietário", description = "CRUD de Proprietário e validação de login e senha")
public class ProprietarioController {

    private static final Logger logger = LoggerFactory.getLogger(ProprietarioController.class);

    private final CadastrarProprietario cadastrarProprietario;
    private final ListarProprietarios listarProprietarios;
    private final BuscarProprietarioPorId buscarProprietarioPorId;
    private final AtualizarProprietario atualizarProprietario;
    private final TrocarSenhaProprietario trocarSenhaProprietario;
    private final RemoverProprietario removerProprietario;
    private final ValidarAcessoProprietario validarAcessoProprietario;

    public ProprietarioController(CadastrarProprietario cadastrarProprietario, ListarProprietarios listarProprietarios, BuscarProprietarioPorId buscarProprietarioPorId, AtualizarProprietario atualizarProprietario, TrocarSenhaProprietario trocarSenhaProprietario, RemoverProprietario removerProprietario, ValidarAcessoProprietario validarAcessoProprietario) {
        this.cadastrarProprietario = cadastrarProprietario;
        this.listarProprietarios = listarProprietarios;
        this.buscarProprietarioPorId = buscarProprietarioPorId;
        this.atualizarProprietario = atualizarProprietario;
        this.trocarSenhaProprietario = trocarSenhaProprietario;
        this.removerProprietario = removerProprietario;
        this.validarAcessoProprietario = validarAcessoProprietario;
    }

    @PostMapping
    @Operation(summary = "Cadastro de proprietário", description = "Essa função é responsável por cadastrar um proprietário")
    public ResponseEntity<Object> cadastrarProprietario(@RequestBody UsuarioResponseDTO proprietarioDTO) {
        logger.info("POST -> /proprietarios");
        Proprietario proprietarioASerCadastrado = cadastrarProprietario.cadastrarProprietario(new Proprietario(proprietarioDTO.nome(), proprietarioDTO.email(), proprietarioDTO.login(), proprietarioDTO.senha(), proprietarioDTO.endereco()));
        return ResponseEntity.ok(new UsuarioResponseDTO(proprietarioASerCadastrado.getId(),
                proprietarioASerCadastrado.getNome(), proprietarioASerCadastrado.getEmail(), proprietarioASerCadastrado.getLogin(),
                proprietarioASerCadastrado.getSenha(), proprietarioASerCadastrado.getUltimaAlteracao(), proprietarioASerCadastrado.getEndereco()));
    }

    @GetMapping
    @Operation(summary = "Lista todos os proprietários", description = "Essa função é responsável por listar todos os proprietários cadastrados no sistema")
    public ResponseEntity<List<UsuarioResponseDTO>> listarProprietarios() {
        logger.info("GET -> /proprietarios");
        return ResponseEntity.ok(listarProprietarios.listarTodosOsProprietarios()
                .stream()
                .map(proprietario -> new UsuarioResponseDTO(proprietario.getId(),
                        proprietario.getNome(), proprietario.getEmail(), proprietario.getLogin(),
                        proprietario.getSenha(), proprietario.getUltimaAlteracao(), proprietario.getEndereco()))
                .collect(Collectors.toList()));
    }

    @GetMapping("{id}")
    @Operation(summary = "Busca o proprietário por Id", description = "Essa função é responsável por buscar um proprietário informando o seu id")
    public ResponseEntity<Object> buscarProprietarioPorId(@PathVariable("id")Long id) {
        logger.info("GET -> /proprietario/id", id);
        var proprietarioEncontrado = this.buscarProprietarioPorId.buscarProprietarioPorId(id);
        return ResponseEntity.ok(proprietarioEncontrado);
    }

    @PutMapping("{id}")
    @Operation(summary = "Atualiza o proprietario", description = "Essa função é responsável por atualizar um proprietario informando o seu id")
    public ResponseEntity<Object> atualizarProprietario(@PathVariable("id") Long id, @RequestBody UsuarioRequestDTO proprietarioDTO) {
        logger.info("PUT -> /proprietario/{id}", id);
        var proprietarioASerAtualizado = atualizarProprietario.atualizarProprietario(id, new Proprietario(proprietarioDTO.nome(), proprietarioDTO.email(),
                proprietarioDTO.login(), proprietarioDTO.senha(), proprietarioDTO.endereco()));
        return ResponseEntity.ok(proprietarioASerAtualizado);
    }

    @PatchMapping("{id}")
    @Operation(summary = "Troca a senha do proprietario", description = "Essa função é responsável por trocar a senha de um proprietario informando o seu id")
    public ResponseEntity<String> trocarSenhaDoProprietario(@PathVariable("id") Long id, @RequestBody UsuarioRequestDTO senhaDTO) {
        logger.info("PATCH -> /proprietario/id", id);
        return ResponseEntity.ok(this.trocarSenhaProprietario.trocarSenha(id, senhaDTO.senha()));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remove o proprietario", description = "Essa função é responsável por remover um proprietario informando o seu id")
    public ResponseEntity<String> removerProprietario(@PathVariable("id") Long id){
        logger.info("DELETE -> /proprietario/id", id);
        this.removerProprietario.removerProprietario(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/validar")
    @Operation(summary = "Valida o login e a senha", description = "Essa função é responsável por validar o login e a senha apenas informando um login cadastrado")
    public ResponseEntity<String> validarAcesso(@RequestParam("login") String login, @RequestParam("senha") String senha) {
        logger.info("GET -> /proprietario/validar");
        this.validarAcessoProprietario.validarAcessoProprietario(login, senha);
        return ResponseEntity.ok("Login realizado com sucesso");
    }

}
