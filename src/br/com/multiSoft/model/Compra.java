package br.com.multiSoft.model;

import java.util.Date;
import java.util.List;

public class Compra {
	private Vendedor vendedor;

	private List<Item> itens;

	private Date dataCompra;

	/**
	 * @return the vendedor
	 */
	public Vendedor getVendedor() {
		return vendedor;
	}

	/**
	 * @param vendedor
	 *            the vendedor to set
	 */
	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	/**
	 * @return the itens
	 */
	public List<Item> getItens() {
		return itens;
	}

	/**
	 * @param itens
	 *            the itens to set
	 */
	public void setItens(List<Item> itens) {
		this.itens = itens;
	}

	/**
	 * @return the dataCompra
	 */
	public Date getDataCompra() {
		return dataCompra;
	}

	/**
	 * @param dataCompra
	 *            the dataCompra to set
	 */
	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}

}
