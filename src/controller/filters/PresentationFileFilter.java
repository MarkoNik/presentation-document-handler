package controller.filters;

import javax.swing.filechooser.FileFilter;
import java.io.File;

public class PresentationFileFilter extends FileFilter {

    @Override
    public boolean accept(File f) {
        return (f.isDirectory() || f.getName().toLowerCase().endsWith(".pnf"));
    }

    @Override
    public String getDescription() {
        return "Presentation Files (*.pnf)";
    }
}
