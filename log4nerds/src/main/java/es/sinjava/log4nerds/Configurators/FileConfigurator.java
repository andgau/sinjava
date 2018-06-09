
package es.sinjava.log4nerds.Configurators;

public class FileConfigurator {

	public static FileConfigurator getInstance(String file, boolean isTemp, boolean local) {
		return new FileConfigurator(file, isTemp, local);

	}

	private String fileName;
	private boolean isLocalized;

	private boolean isTemp;

	private FileConfigurator(String file, boolean temp, boolean local) {
		fileName = file;
		isTemp = temp;
		setLocalized(local);
	}

	public String getFileName() {
		return fileName;
	}

	public boolean isLocalized() {
		return isLocalized;
	}

	public boolean isTemp() {
		return isTemp;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public void setLocalized(boolean isLocalized) {
		this.isLocalized = isLocalized;
	}

	public void setTemp(boolean isTemp) {
		this.isTemp = isTemp;
	}

}
