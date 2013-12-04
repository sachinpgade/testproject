// Decompiled by DJ v3.12.12.96 Copyright 2011 Atanas Neshkov  Date: 25-06-2013 PM 05:11:41
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   ConnectionFactory.java

package com.openperception;

import com.openperception.dao.ConnectionManager;

public class ConnectionFactory
{

    public ConnectionFactory()
    {
    }

    public static ConnectionManager getConnectionManager()
    {
        return ConnectionManager.getInstance();
    }
}
