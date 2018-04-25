/*
 * Copyright (c) 2018.
 *  Author : Julien Creach.
 */

package com.julienCreach.utils;

import java.io.File;

/**
 * Classe path.
 * @author Julien Creach
 * @version 1.0
 */
public final class Path
{
    /**
     * Constructeur par defaut.
     */
    private Path()
    {

    }

    /**
     * Combine deux path.
     * @param path1 premier path
     * @param path2 second path
     * @return value des path combinés
     */
    public static String combine(String path1, String path2)
    {
        File file = new File(path1,path2);
        String toReturn = file.getPath().replace("\\","\\\\");
        return toReturn;
    }
}
