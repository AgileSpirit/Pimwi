package io.pimwi.infra.util;

import org.springframework.web.multipart.MultipartFile;

/**
 * User: OCTO-JBU
 * Date: 07/04/2014
 * Time: 18:41
 */
public class FileUpload {

    private MultipartFile file;

    /*
     * GETTERS / SETTERS
     */

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
