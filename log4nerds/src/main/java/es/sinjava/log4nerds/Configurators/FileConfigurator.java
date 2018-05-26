package es.sinjava.log4nerds.Configurators;

public class FileConfigurator {

	private String fileName;
	private boolean isLocalized;
	private boolean isTemp;

	private FileConfigurator(String file, boolean temp, boolean local) {
		fileName = file;
		isTemp = temp;
		setLocalized(local);
	}

	public static FileConfigurator getInstance(String file, boolean isTemp, boolean local) {
		return new FileConfigurator(file, isTemp, local);

	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public boolean isTemp() {
		return isTemp;
	}

	public void setTemp(boolean isTemp) {
		this.isTemp = isTemp;
	}

	public boolean isLocalized() {
		return isLocalized;
	}

	public void setLocalized(boolean isLocalized) {
		this.isLocalized = isLocalized;
	}

}
