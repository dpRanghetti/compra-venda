package br.unialfa.compra_venda.api;

import br.unialfa.compra_venda.model.Compra;
import br.unialfa.compra_venda.service.CompraService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/compra")
@AllArgsConstructor
public class CompraApi {

    private final CompraService service;


    @GetMapping()
    public ResponseEntity<List<Compra>> listarCompras() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("{id}")
    public ResponseEntity<Compra> listarComprasPorId(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping()
    public ResponseEntity salvar(@RequestBody Compra compra) {
        service.salvar(compra);
        return ResponseEntity.ok().build();
    }

    @PutMapping()
    public ResponseEntity alterar(@RequestBody Compra compra) {
        service.salvar(compra);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity deletar(@PathVariable(name = "id") Long id) {
        service.deletarPorId(id);
        return ResponseEntity.ok().build();
    }
}
