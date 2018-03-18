package com.example.briancunningham.gardenbeta.feature;

/**
 * Created by briancunningham on 3/18/2018.
 */

import java.io.PrintWriter;
import java.net.Socket;

        import java.io.*;
        import java.net.Socket;
        import java.net.UnknownHostException;

public class CClient
        implements Runnable
{
    private Socket socket;
    private String ServerIP = "<my server ip goes here>";
    private static final int ServerPort = 8546;

    @Override
    public void run()
    {
        try
        {
            socket = new Socket(ServerIP, ServerPort);
        }
        catch(Exception e)
        {
            System.out.print("Whoops! It didn't work!:");
            System.out.print(e.getLocalizedMessage());
            System.out.print("\n");
        }
    }

    public void Send(String s)
    {
        try
        {
            PrintWriter outToServer = new PrintWriter(
                    new OutputStreamWriter(
                            socket.getOutputStream()));
            outToServer.print(s + "\n");
            outToServer.flush();


        }
        catch (UnknownHostException e) {
            System.out.print(e.toString());
        } catch (IOException e) {
            System.out.print(e.toString());
        }catch (Exception e) {
            System.out.print(e.toString());
        }

    }
}