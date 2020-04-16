/**
 * Created by alexeyba on 09.11.15.
 */
package com.github.aantonello.tiffbitmapfactory.exceptions;

public class CantOpenFileException extends RuntimeException {
    private String fileName;

    public CantOpenFileException(String fileName){
        super("Can\'t open file " + fileName);
        this.fileName = fileName;
    }

    public String getFileName(){
        return fileName;
    }
}
