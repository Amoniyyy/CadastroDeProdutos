package dev.Java.CadastroDeProdutos.mapper;

import dev.Java.CadastroDeProdutos.Produtos.ProdutoModel;
import dev.Java.CadastroDeProdutos.dto.ProdutoDto;
import org.springframework.stereotype.Component;

@Component
public class ProdutoMapper {

    public ProdutoDto toDto(ProdutoModel produtoModel) {
        return ProdutoDto.builder()
                .nome(produtoModel.getNome())
                .descricao(produtoModel.getDescricao())
                .preco(produtoModel.getPreco())
                .fornecedor(produtoModel.getFornecedor())
                .serialnamber(produtoModel.getSerialnamber())
                .quantitade(produtoModel.getQuantidade())
                .build();
    }

    public ProdutoModel toProduto(ProdutoDto dto) {
        return ProdutoModel.builder()
                .preco(dto.getPreco())
                .nome(dto.getNome())
                .descricao(dto.getDescricao())
                .fornecedor(dto.getFornecedor())
                .serialnamber(dto.getSerialnamber())
                .quantidade(dto.getQuantitade())
                .build();
    }
}
