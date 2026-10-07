package dev.Java.CadastroDeProdutos.Fornecedor;

import dev.Java.CadastroDeProdutos.Produtos.ProdutoModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_forncedor")
public class FornecedorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String setor;

    // @OneToMany - um fornecedor pode ter varios produtos
    @OneToMany(mappedBy = "fornecedor")
    private List<ProdutoModel> produto;

}
