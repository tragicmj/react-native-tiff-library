/**
 * Created by beyka on 13.3.17.
 */
package com.github.aantonello.tiffbitmapfactory;

public enum ResolutionUnit {
    NONE(1),
    INCH(2),
    CENTIMETER(3);

    final int ordinal;

    ResolutionUnit(int ordinal) {
        this.ordinal = ordinal;
    }
}
