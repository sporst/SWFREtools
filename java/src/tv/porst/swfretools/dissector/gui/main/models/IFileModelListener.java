package tv.porst.swfretools.dissector.gui.main.models;

/**
 * Interface to be implemented by objects that want to keep track
 * of the open files.
 */
public interface IFileModelListener {

	/**
	 * Invoked after a new file was opened.
	 * 
	 * @param fileModel The model where the new file was opened.
	 * @param file Thew newly opened file.
	 */
	void openedFile(FileModel fileModel, LoadedFile file);
}
