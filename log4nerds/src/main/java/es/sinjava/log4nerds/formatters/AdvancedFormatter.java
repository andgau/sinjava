
package es.sinjava.log4nerds.formatters;

import java.util.List;
import java.util.logging.LogRecord;

import es.sinjava.log4nerds.utils.FieldEnum;
import es.sinjava.log4nerds.utils.MatcherField;

public class AdvancedFormatter extends DefaultFormatter implements IFormatter {

	private List<FieldEnum> fieldList;

	private String separator = " | ";

	public AdvancedFormatter(boolean local, String separatorIn, List<FieldEnum> fieldListIn) {
		setLocalized(local);
		fieldList = fieldListIn;
		separator = (separatorIn != null) ? separatorIn : separator;
	}

	private StringBuilder bodyRecord(LogRecord record) {
		StringBuilder sb = new StringBuilder();
		MatcherField matcher = MatcherField.getInstance(isLocalized(), dtf);
		for (FieldEnum field : fieldList) {
			sb.append(matcher.getValue(field, record)).append(separator);
		}
		return sb;
	}

	@Override
	public String format(LogRecord record) {

		StringBuilder sb = bodyRecord(record);
		sb.append(record.getMessage()).append("\n");

		return sb.toString();
	}

}
