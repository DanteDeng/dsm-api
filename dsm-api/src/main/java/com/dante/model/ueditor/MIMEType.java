package com.dante.model.ueditor;

import java.util.HashMap;
import java.util.Map;

public class MIMEType {

	public static final Map<String, String> types = new HashMap<String, String>() {
		/**
		* 
		*/
		private static final long serialVersionUID = 3788628035168727342L;

		{
			put("image/gif", ".gif");
			put("image/jpeg", ".jpg");
			put("image/jpg", ".jpg");
			put("image/png", ".png");
			put("image/bmp", ".bmp");
		}
	};

	public static String getSuffix(String mime) {
		return MIMEType.types.get(mime);
	}

}
