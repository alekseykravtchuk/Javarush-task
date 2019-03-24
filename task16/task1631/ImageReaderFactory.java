package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

public class ImageReaderFactory {
    public static ImageReader getImageReader (ImageTypes imageTypes) {
        ImageReader rd = null;
            if (imageTypes == ImageTypes.JPG) {
                return rd = new JpgReader();
            }
            else if (imageTypes == ImageTypes.BMP) {
                return rd = new BmpReader();
            }
            else if (imageTypes == ImageTypes.PNG) {
                return rd = new PngReader();
            }
            throw new IllegalArgumentException("Неизвестный тип картинки");
    }
}
