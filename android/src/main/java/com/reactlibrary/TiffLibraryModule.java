package com.reactlibrary;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.File;

import android.util.Log;
import android.util.Base64;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;

import com.github.aantonello.tiffbitmapfactory.IProgressListener;
import com.github.aantonello.tiffbitmapfactory.TiffConverter;

public class TiffLibraryModule extends ReactContextBaseJavaModule {

    private final ReactApplicationContext reactContext;

    public TiffLibraryModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @Override
    public String getName() {
        return "TiffLibrary";
    }

    @ReactMethod
    public void tiffToPng(String base64, Callback callback) {
        File tempFile = File.createTempFile("react_", ".tiff");
        byte[] data   = Base64.decode(base64, 0);

        if (writeFile(data, tempFile)) {
            File destFile = File.createTempFile("react_", ".png");
            TiffToPngHandler handler = new TiffToPngHandler(callback);

            handler.convert(tempFile.getAbsolutePath(), destFile.getAbsolutePath());
        }
    }

    private boolean writeFile(byte[] data, File destFile) {
        try {
            FileOutputStream fos = new FileOutputStream(destFile, false);

            fos.write(data);
            fos.flush();
            fos.close();

            return true;
        }
        catch (Exception ex) {
            Log.e(TAG, ex, "Error writting the original TIFF file");
        }
        return false;
    }

    private class TiffToPngHandler implements IProgressListener {
        private static String TAG = "TIFF";
        private Callback m_callback;

        public TiffToPngHandler(Callback callback) {
            m_callback = callback;
        }

        public void convert(String srcFile, String destFile) {
            TiffConverter.ConverterOptions options = new TiffConverter.ConverterOptions();

            options.throwExceptions = false;
            options.availableMemory = 128 * 1024 * 1024;
            options.readTiffDirectory = 1;          // Just the first image

            if (TiffConverter.convertTiffPng(srcFile, destFile, this)) {
                String base64Result = readBase64(destFile);
                m_callback.invoke(base64Result);
            }
        }

        private String readBase64(String file) {
            try {
                FileInputStream fis = new FileInputStream(destFile);
                int byteSize = fis.available();
                byte[] buffer = new byte[byteSize];

                /* Read everything in one shot. */
                fis.read(buffer);
                fis.close();

                byte[] result = Base64.encode(buffer, Base64.NO_WRAP);
                return new String(result, 0, result.length, "UTF-8");

            } catch (Exception ex) {
                Log.e(TAG, ex, "Error on reading the converted PNG file");
            }
        }

        @Override
        public void reportProgress(long processedPixels, long totalPixels) {
            Log.v(TAG, "Processed "+processedPixels+"px from "+totalPixels+"px");
        }
    }
}
