/*
 * Copyright (c) 2018.
 *  Author : Julien Creach.
 */

package com.julienCreach.utils;

import javafx.scene.control.Alert;

/**
 * Classe messagebox.
 * @author Julien Creach
 * @version 1.0
 */
public final class MessageBox
{
    /**
     * Constructeur par defaut.
     */
    private MessageBox()
    {

    }

    /**
     * Ouvre une messagebox.
     * @param type type de messagebox
     * @param titleText titre de la messagebox.
     * @param contentText contenu de la messagebox
     * @param headerText header de la messagebox
     */
    public static void Show( Alert.AlertType type, String titleText, String contentText, String headerText)
    {
        Alert alert = new Alert(type);
        alert.setTitle(titleText);
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);

        alert.showAndWait();
    }

}
