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
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

/**
 *
 * @author Naoghuman
 */
public class DefaultFontConverter implements Converter<Font> {

    @Override
    public String convertToString(Font value) {
        DefaultConverterValidator.getDefault().requireNonNull(value);
        
        final StringBuilder sb = new StringBuilder();
        sb.append(value.getFamily()); // String family
        sb.append(";"); // NOI18N
        sb.append(value.getName()); // FontWeight weight
        sb.append(";"); // NOI18N
        sb.append(value.getStyle()); // FontPosture posture
        sb.append(";"); // NOI18N
        sb.append(value.getSize()); // double size

        return sb.toString();
    }

    @Override
    public Font convertFromString(String value) {
        DefaultConverterValidator.getDefault().validate(value);

        final String[] fontParts = value.split(";"); // NOI18N
        Font convertedFont = Font.font("System", FontWeight.NORMAL, FontPosture.REGULAR, 10); // NOI18N
        try {
            final String family       =                        fontParts[0];
            final FontWeight weight   = FontWeight.findByName( fontParts[1]);
            final FontPosture posture = FontPosture.findByName(fontParts[2]);
            final double size         = Double.parseDouble(    fontParts[3]);
            convertedFont = Font.font(family, weight, posture, size);
        } catch (NumberFormatException ex) {
            throw new UnsupportedOperationException("Can't convert parameter value [" 
                    + value + "] from type [String] to type [Font]"); // NOI18N
        }

        return convertedFont;
    }
    
}
