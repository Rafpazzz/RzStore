package com.RzStore.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "notas_fiscais")
public class NotaFiscal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "numero", nullable = false, unique = true)
    private String numero;

    @Column(name = "data_emissao", nullable = false)
    private LocalDateTime dataEmissao;

    @Column(name = "valor_total", nullable = false)
    private BigDecimal valorTotal;

    @OneToOne
    @JoinColumn(
            name = "email_cliente",           // nome da coluna na tabela nota_fiscal
            referencedColumnName = "email",   // referência no cliente
            nullable = false,
            unique = true
    )
    private Usuario cliente;

    @ManyToMany
    @JoinTable(
            name = "nota_fiscal_produto",
            joinColumns = @JoinColumn(name = "nota_fiscal_id"),
            inverseJoinColumns = @JoinColumn(name = "produto_id")
    )
    private Set<Produto> produtos = new HashSet<>();
}
