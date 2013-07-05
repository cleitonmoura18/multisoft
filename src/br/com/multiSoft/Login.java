package br.com.multiSoft;

import java.sql.SQLException;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import br.com.multiSoft.model.Produto;
import br.com.multiSoft.repository.DatabaseHelper;
import br.com.multiSoft.repository.ProdutoDAO;

@SuppressLint("ShowToast")
public class Login extends Activity {
	private DatabaseHelper helper;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		helper = new DatabaseHelper(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}

	/**
	 * Limpa os campos de Login e senha
	 * 
	 * @param view
	 */
	public void limparTela(View view) {
		Log.i("Limpando a tela", "Limpando campos");
		EditText textLogin = (EditText) findViewById(R.id.etxtLogin);
		EditText textSenha = (EditText) findViewById(R.id.etxtSenha);
		textLogin.setText("");
		textSenha.setText("");

	}

	public void persistirExemplo() throws SQLException {
		Log.i("Salvando Produto", "TESTE");
		ProdutoDAO produtoDAO = new ProdutoDAO(helper.getConnectionSource());
		Produto produto = new Produto();
		produto.setNome("Arroz");
		produto.setValor(10);
		produtoDAO.create(produto);
		Log.i("Produto Salvo", produto.toString());
		Log.i("Numero de Produtos", Long.toString(produtoDAO.countOf()));

	}

	public void login(View view) {
		Log.i("Fazendo Login na Aplicação", "Logando na aplicação");
		EditText textLogin = (EditText) findViewById(R.id.etxtLogin);
		EditText textSenha = (EditText) findViewById(R.id.etxtSenha);
		String login = textLogin.getText().toString();
		String senha = textSenha.getText().toString();
		irParaTelaPrincipal("Cleitom");
		if (login.equals("") || senha.equals("")) {
			Toast.makeText(Login.this, "Campo em branco", Toast.LENGTH_SHORT)
					.show();
			return;
		}
		Log.i("Login", login);
		Log.i("Senha", senha);
		boolean isLogado = true;
		if (!isLogado) {
			Toast.makeText(Login.this, "Usuário ou senha inválido",
					Toast.LENGTH_LONG).show();
		} else {
			irParaTelaPrincipal("Cleitom");
		}

	}

	public void irParaTelaPrincipal(String nomeUsuario) {
		Intent intent = new Intent(this, ListaEmpresas.class);
		// Passa como paramentro o nome do Usuário para a tela seguinte
		intent.putExtra("name", nomeUsuario);
		startActivity(intent);
		// this.finish();
	}

}
