 package br.edu.exemplo;

 import java.util.List;

 public class PedidoService {
  private final EstoqueService estoqueService;

  public PedidoService(EstoqueService estoqueService) {
   this.estoqueService = estoqueService;
  }

  public boolean realizarPedido(List<PedidoEntity> pedidos) {
   for (PedidoEntity pedido : pedidos) {
    if (!estoqueService.temEstoque(pedido.getProduto().getId(), pedido.getQuantidade())) {
     return false;
    }
   }
   for (PedidoEntity pedido : pedidos) {
    estoqueService.retirar(pedido.getProduto().getId(), pedido.getQuantidade());
   }
   return true;
  }
 }