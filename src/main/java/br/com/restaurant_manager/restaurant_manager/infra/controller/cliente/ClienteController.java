package br.com.restaurant_manager.restaurant_manager.infra.controller.cliente;

import br.com.restaurant_manager.restaurant_manager.application.usecases.cliente.*;
import br.com.restaurant_manager.restaurant_manager.infra.controller.request.UsuarioRequestDTO;
import br.com.restaurant_manager.restaurant_manager.infra.controller.response.UsuarioResponseDTO;
import br.com.restaurant_manager.restaurant_manager.model.entities.cliente.Cliente;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("clientes")
@Tag(name= "Cliente", description = "CRUD de Cliente e validação de login e senha")
public class ClienteController {

    private static final Logger logger = LoggerFactory.getLogger(ClienteController.class);

    private final CadastrarCliente cadastrarCliente;
    private final ListarClientes listarClientes;
    private final BuscarClientePorId buscarClientePorId;
    private final AtualizarCliente atualizarCliente;
    private final TrocarSenhaCliente trocarSenhaCliente;
    private final RemoverCliente removerCliente;
    private final ValidarAcessoCliente validarAcessoCliente;

    public ClienteController(CadastrarCliente cadastrarCliente, ListarClientes listarClientes, BuscarClientePorId buscarClientePorId,
                             AtualizarCliente atualizarCliente, TrocarSenhaCliente trocarSenhaCliente, RemoverCliente removerCliente, ValidarAcessoCliente validarAcessoCliente) {
        this.cadastrarCliente = cadastrarCliente;
        this.listarClientes = listarClientes;
        this.buscarClientePorId = buscarClientePorId;
        this.atualizarCliente = atualizarCliente;
        this.trocarSenhaCliente = trocarSenhaCliente;
        this.removerCliente = removerCliente;
        this.validarAcessoCliente = validarAcessoCliente;
    }

    @PostMapping
    @Operation(summary = "Cadastro de cliente", description = "Essa função é responsável por cadastrar um cliente")
    public ResponseEntity<Object> cadastrarCliente(@RequestBody UsuarioResponseDTO clienteDTO) {
        logger.info("POST -> /clientes");
        Cliente clienteASerCadastrado = cadastrarCliente.cadastrarCliente(new Cliente(clienteDTO.nome(), clienteDTO.email(), clienteDTO.login(), clienteDTO.senha(), clienteDTO.endereco()));
        return ResponseEntity.ok(new UsuarioResponseDTO(clienteASerCadastrado.getId(),
                    clienteASerCadastrado.getNome(), clienteASerCadastrado.getEmail(), clienteASerCadastrado.getLogin(),
                    clienteASerCadastrado.getSenha(), clienteASerCadastrado.getUltimaAlteracao(), clienteASerCadastrado.getEndereco()));
    }

    @GetMapping
    @Operation(summary = "Lista todos os clientes", description = "Essa função é responsável por listar todos os clientes cadastrados no sistema")
    public ResponseEntity<List<UsuarioResponseDTO>> listarClientes() {
        logger.info("GET -> /clientes");
        return ResponseEntity.ok(listarClientes.listarTodosOsClientes()
                .stream()
                .map(cliente -> new UsuarioResponseDTO(cliente.getId(),
                        cliente.getNome(), cliente.getEmail(), cliente.getLogin(),
                        cliente.getSenha(), cliente.getUltimaAlteracao(), cliente.getEndereco()))
                .collect(Collectors.toList()));
    }

    @GetMapping("{id}")
    @Operation(summary = "Busca o cliente por Id", description = "Essa função é responsável por buscar um cliente informando o seu id")
    public ResponseEntity<Object> buscarClientePorId(@PathVariable("id")Long id) {
        logger.info("GET -> /clientes/{id}", id);
        var clienteEncontrado = this.buscarClientePorId.buscarClientePorId(id);
        return ResponseEntity.ok(clienteEncontrado);
    }

    @PutMapping("{id}")
    @Operation(summary = "Atualiza o cliente", description = "Essa função é responsável por atualizar um cliente informando o seu id")
    public ResponseEntity<Object> atualizarCliente(@PathVariable("id") Long id, @RequestBody UsuarioRequestDTO clienteDTO) {
        logger.info("PUT -> /clientes/{id}", id);
        var clienteASerAtualizado = atualizarCliente.atualizarCliente(id, new Cliente(clienteDTO.nome(), clienteDTO.email(),
                    clienteDTO.login(), clienteDTO.senha(), clienteDTO.endereco()));
        return ResponseEntity.ok(clienteASerAtualizado);
    }

    @PatchMapping("{id}")
    @Operation(summary = "Troca a senha do cliente", description = "Essa função é responsável por trocar a senha de um cliente informando o seu id")
    public ResponseEntity<String> trocarSenhaDoCliente(@PathVariable("id") Long id, @RequestBody UsuarioRequestDTO senhaDTO) {
        logger.info("PATCH -> /clientes/{id}", id);
        return ResponseEntity.ok(this.trocarSenhaCliente.trocarSenhaCliente(id, senhaDTO.senha()));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remove o cliente", description = "Essa função é responsável por remover um cliente informando o seu id")
    public ResponseEntity<String> removerCliente(@PathVariable("id") Long id){
        logger.info("DELETE -> /clientes/{id}", id);
        this.removerCliente.removerCliente(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/validar")
    @Operation(summary = "Valida o login e a senha", description = "Essa função é responsável por validar o login e a senha apenas informando um login cadastrado")
    public ResponseEntity<String> validarAcesso(@RequestParam("login") String login, @RequestParam("senha") String senha) {
        logger.info("GET -> /clientes/validar");
        this.validarAcessoCliente.validarAcessoCliente(login, senha);
        return ResponseEntity.ok("Login realizado com sucesso");
    }
}
