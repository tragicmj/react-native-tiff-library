/**
 * Created by beyka on 4/26/17.
 */
package com.github.aantonello.tiffbitmapfactory;

public interface IProgressListener {
    public void reportProgress(long processedPixels, long totalPixels);
}
