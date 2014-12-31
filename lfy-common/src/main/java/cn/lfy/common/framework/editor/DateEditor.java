package cn.lfy.common.framework.editor;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;

import org.springframework.util.StringUtils;

import cn.lfy.common.utils.DateUtils;

public class DateEditor extends PropertyEditorSupport {
	@Override
	public void setAsText(String text) throws IllegalArgumentException {

		if (!StringUtils.hasText(text)) {
			setValue(null);
		} else {
			try {
				setValue(DateUtils.getStringFormData(text, "yyyy-MM-dd"));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public String getAsText() {

		return getValue().toString();
	}
}
