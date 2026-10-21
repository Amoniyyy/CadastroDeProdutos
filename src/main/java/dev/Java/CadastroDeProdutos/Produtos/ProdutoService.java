package dev.Java.CadastroDeProdutos.Produtos;

import dev.Java.CadastroDeProdutos.dto.ProdutoDto;
import dev.Java.CadastroDeProdutos.exception.ProdutoNotFoundException;
import dev.Java.CadastroDeProdutos.mapper.ProdutoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoMapper produtoMapper;
    private final ProdutoRepository produtoRepository;

    @Transactional(readOnly = true)
    public ProdutoDto findById(Long id) {
        log.info("Produto with id : {}", id);
        return produtoMapper.toDto(produtoRepository.findById(id)
                .orElseThrow(() -> new ProdutoNotFoundException("Product not found")));
    }

    @Transactional
    public ProdutoDto create(ProdutoDto produtoDto) {
        log.info("Saving produto");
        produtoRepository.save(produtoMapper.toProduto(produtoDto));
        return produtoDto;
    }

    @Transactional
    public void deleteById(Long id) {
        if (produtoRepository.existsById(id)){
            log.info("Deleting produto with id : {}", id);
            produtoRepository.deleteById(id);
        }
    }

    @Transactional
    public ProdutoDto update(ProdutoDto dto, Long id) {
        log.info("Updating produto with id : {}" , id);
        ProdutoModel produtoModel = produtoRepository.findById(id)
            .orElseThrow(() -> new ProdutoNotFoundException("Produto not found"));
        produtoModel.setDescricao(dto.getDescricao());
        produtoModel.setNome(dto.getNome());
        produtoModel.setFornecedor(dto.getFornecedor());
        produtoModel.setQuantidade(dto.getQuantitade());
        produtoModel.setSerialnamber(dto.getSerialnamber());
        return produtoMapper.toDto(produtoRepository.save(produtoModel));
    }
}
