/*
 * Copyright (C) 2017 Naoghuman
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.github.naoghuman.lib.tag.core.internal;

import com.github.naoghuman.lib.tag.core.Converter;
import javafx.scene.paint.Color;

/**
 *
 * @author Naoghuman
 */
public class DefaultColorConverter implements Converter<Color> {

    @Override
    public String convertToString(Color value) {
        DefaultConverterValidator.getDefault().requireNonNull(value);

        final StringBuilder sb = new StringBuilder();
        sb.append(value.getRed());
        sb.append(";"); // NOI18N
        sb.append(value.getGreen());
        sb.append(";"); // NOI18N
        sb.append(value.getBlue());
        sb.append(";"); // NOI18N
        sb.append(value.getOpacity());

        return sb.toString();
    }

    @Override
    public Color convertFromString(String value) {
        DefaultConverterValidator.getDefault().validate(value);

        final String[] colorParts = value.split(";"); // NOI18N
        Color convertedColor = Color.BLACK;
        try {
            final double red     = Double.parseDouble(colorParts[0]);
            final double green   = Double.parseDouble(colorParts[1]);
            final double blue    = Double.parseDouble(colorParts[2]);
            final double opacity = Double.parseDouble(colorParts[3]);
            convertedColor = new Color(red, green, blue, opacity);
        } catch (NumberFormatException ex) {
            throw new UnsupportedOperationException("Can't convert parameter value [" 
                    + value + "] from type [String] to type [Color]"); // NOI18N
        }

        return convertedColor;
    }

}
