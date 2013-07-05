package br.com.multiSoft.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import br.com.multiSoft.R;
import br.com.multiSoft.util.Util;

public class ImageAdapter extends BaseAdapter {
	private Context context;
	private final String[] itensMenu;
	private final String padraoNomeImagens;

	/**
	 * 
	 * @param context
	 * @param itensMenu
	 *            Nome dos itens que tera no menu da aplicação
	 * @param padraoNomeImagens
	 *            Padrao do nome das imagens
	 */
	public ImageAdapter(Context context, String[] itensMenu,
			String padraoNomeImagens) {
		this.context = context;
		this.itensMenu = itensMenu;
		this.padraoNomeImagens = padraoNomeImagens;
	}

	public View getView(int position, View convertView, ViewGroup parent) {

		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		View gridView;

		if (convertView == null) {

			gridView = new View(context);

			// get layout from objetos_grid.xml
			gridView = inflater.inflate(R.layout.objetos_grid, null);

			// set value into textview
			TextView textView = (TextView) gridView
					.findViewById(R.id.grid_item_label);
			textView.setText(itensMenu[position]);

			// set image based on selected text
			ImageView imageView = (ImageView) gridView
					.findViewById(R.id.grid_item_image);
			String nameImage = padraoNomeImagens + "_" + position;
			imageView.setImageResource(Util.getDrawable(context, nameImage));

		} else {
			gridView = (View) convertView;
		}

		return gridView;
	}

	@Override
	public int getCount() {
		return itensMenu.length;
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

}
