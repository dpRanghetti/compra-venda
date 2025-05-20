package br.unialfa.compra_venda.repository;

import br.unialfa.compra_venda.model.Compra;
import br.unialfa.compra_venda.model.ItemCompra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemCompraRepository extends JpaRepository<ItemCompra, Long> {
}
