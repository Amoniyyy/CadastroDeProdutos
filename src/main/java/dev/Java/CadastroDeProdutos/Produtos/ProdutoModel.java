package dev.Java.CadastroDeProdutos.Produtos;


import dev.Java.CadastroDeProdutos.Fornecedor.FornecedorModel;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

// Entity transforma uma classe em uma entidade do DB
@Entity
@Table(name = "tb_cadastro")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;   // git commit --amend -> serve para refatorar uma modificação feita no ultimo commit
    private String nome;
    private String descricao;
    private double preco;
    private int quantidade;

    // @ManyToOne - um produto tem apenas um fornecedor
    @ManyToOne
    @JoinColumn(name = "forncedor_id") // Foreing Key ou chave estrangeira
    private FornecedorModel fornecedor;
}
