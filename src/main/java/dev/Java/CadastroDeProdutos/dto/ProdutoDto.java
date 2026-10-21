package dev.Java.CadastroDeProdutos.dto;

import dev.Java.CadastroDeProdutos.Fornecedor.FornecedorModel;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ProdutoDto {
    // add validation
    private String nome;
    private String descricao;
    private double preco;
    private int quantitade;
    private String serialnamber;
    private FornecedorModel fornecedor;
}
