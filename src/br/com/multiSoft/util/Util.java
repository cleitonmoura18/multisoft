package br.com.multiSoft.util;

import junit.framework.Assert;
import android.content.Context;

public class Util {
	/**
	 * Obtem o numero da imagem que � passado o nome
	 * 
	 * @param context
	 * @param name
	 *            Nome da imagem que � buscada
	 * @return o n�mero da imagem
	 */
	public static int getDrawable(Context context, String name) {
		Assert.assertNotNull(context);
		Assert.assertNotNull(name);

		return context.getResources().getIdentifier(name, "drawable",
				context.getPackageName());
	}
}
