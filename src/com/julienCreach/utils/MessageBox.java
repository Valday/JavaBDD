/*
 * Copyright (c) 2018.
 *  Author : Julien Creach.
 */

package com.julienCreach.utils;

import javafx.scene.control.Alert;

public final class MessageBox
{
    private MessageBox()
    {

    }

    public static void Show( Alert.AlertType type, String titleText, String contentText, String headerText)
    {
        Alert alert = new Alert(type);
        alert.setTitle(titleText);
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);

        alert.showAndWait();
    }

}
