package serialization;

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class PresentationFileFilter extends FileFilter {
	
	
	@Override
	public boolean accept(File f) { /// koji su fajlovi prihvatljivi
		return (f.isDirectory() || f.getName().toLowerCase().endsWith(".prz"));
			
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "U klasi MyFileFilter (*prz)";
	}

}
