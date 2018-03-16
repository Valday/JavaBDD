package com.valday;

import java.io.File;

public class Path
{
    private Path()
    {

    }

    public static String combine(String path1, String path2)
    {
        File file = new File(path1,path2);
        String toReturn = file.getPath().replace("\\","\\\\");
        return toReturn;
    }
}
