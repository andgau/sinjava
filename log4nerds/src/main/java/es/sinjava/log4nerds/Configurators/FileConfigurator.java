/*
 * Copyright 2018-2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * @ Author: Andres Gaudioso Simon mailto:andgau@gmail.com
 */

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
