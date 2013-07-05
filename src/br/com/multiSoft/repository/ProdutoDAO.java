package br.com.multiSoft.repository;

import java.sql.SQLException;

import br.com.multiSoft.model.Produto;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

public class ProdutoDAO extends BaseDaoImpl<Produto, Integer> {

	public ProdutoDAO(ConnectionSource connectionSource) throws SQLException {
		super(Produto.class);
		setConnectionSource(connectionSource);
		initialize();
	}
}
