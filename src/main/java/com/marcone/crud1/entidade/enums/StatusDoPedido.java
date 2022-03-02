package com.marcone.crud1.entidade.enums;

public enum StatusDoPedido {
	
	AGUARDANDO_PAGAMENTO(1),
	PAGO(2),
	ENVIADO(3),
	ENTREGUE(4),
	CANCELADO(5);
	
	private int code;
	
	private StatusDoPedido(int code) {
		this.code = code;
	}
	
	public int  getCode() {
		return code;
	}
	
	public static StatusDoPedido valueOf(int code) {
		for (StatusDoPedido value : StatusDoPedido.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Status Do Pedido invalido");
	}

}
