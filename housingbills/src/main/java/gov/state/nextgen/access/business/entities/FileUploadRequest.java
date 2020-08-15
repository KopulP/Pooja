package gov.state.nextgen.access.business.entities;

import java.io.File;
import java.io.Serializable;

public class FileUploadRequest implements Serializable {
    private static final long serialVersionUID = -3312888866825615208L;

    private String fileName;

//    private File file;

    private String fileType;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

//    public File getFile() {
//        return file;
//    }
//
//    public void setFile(File file) {
//        this.file = file;
//    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }
}
