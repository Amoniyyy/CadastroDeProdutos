package dev.Java.CadastroDeProdutos.Produtos;


import dev.Java.CadastroDeProdutos.dto.ProdutoDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/produtos")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoService produtoService;

    @GetMapping("/boasvindas")
    public String boasVindas() {
        return "Primeira mensagem dessa rota";
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK) // u can also use ResponseEntity
    public ProdutoDto findById(@PathVariable("id") Long id){
        return produtoService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProdutoDto create(@RequestBody ProdutoDto produtoDto) {
        return produtoService.create(produtoDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("id") Long id) {
        produtoService.deleteById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProdutoDto update(@RequestBody ProdutoDto dto, @PathVariable Long id) {
        return produtoService.update(dto, id);
    }
}
