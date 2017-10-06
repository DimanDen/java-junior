package com.acme.edu;

import com.acme.edu.Exceptions.FacadeLoggerException;
import com.acme.edu.Exceptions.LoggerControllerException;
import com.acme.edu.formatter.*;
import com.acme.edu.message.*;

public class Logger {
    private static LoggerController loggerController = new LoggerController();

    public static void log(Object message) throws FacadeLoggerException {
        try {
            loggerController.parseMessage(new ReferenceMessage(new StringBuilder(String.valueOf(message)),
                    new ReferenceFormatter()));
        } catch (LoggerControllerException e) {
            throw new FacadeLoggerException("facade exception", e);
        }
    }

    public static void log(boolean message) throws FacadeLoggerException {
        try {
            loggerController.parseMessage(new BooleanMessage(new StringBuilder(String.valueOf(message)),
                    new BooleanFormatter()));
        } catch (LoggerControllerException e) {
            throw new FacadeLoggerException("facade exception", e);
        }
    }

    public static void log(char message) throws FacadeLoggerException {
        try {
            loggerController.parseMessage(new CharMessage(new StringBuilder(String.valueOf(message)),
                    new CharFormatter()));
        } catch (LoggerControllerException e) {
            throw new FacadeLoggerException("facade exception", e);
        }
    }

    public static void log(int[] message) throws FacadeLoggerException {
        StringBuilder tempString = new StringBuilder("{");
        for(int i : message) {
            tempString.append(i + ", ");
        }
        tempString.setLength(tempString.length() - 2);
        tempString.append("}");

        try {
            loggerController.parseMessage(new ArrayOfIntMessage(new StringBuilder(tempString),
                    new ArrayOfIntFormatter()));
        } catch (LoggerControllerException e) {
            throw new FacadeLoggerException("facade exception", e);
        }
    }

    public static void log(int message) throws FacadeLoggerException {
        try {
            loggerController.parseMessage(new IntMessage(new StringBuilder(String.valueOf(message)),
                    new IntFormatter()));
        } catch (LoggerControllerException e) {
            throw new FacadeLoggerException("facade exception", e);
        }
    }

    public static void log(String message) throws FacadeLoggerException {
        try {
            loggerController.parseMessage(new StringMessage(new StringBuilder(String.valueOf(message)),
                    new StringFormatter()));
        } catch (LoggerControllerException e) {
            throw new FacadeLoggerException("facade exception", e);
        }
    }

    public static void log(byte message) throws FacadeLoggerException {
        try {
            loggerController.parseMessage(new ByteMessage(new StringBuilder(String.valueOf(message)),
                    new ByteFormatter()));
        } catch (LoggerControllerException e) {
            throw new FacadeLoggerException("facade exception", e);
        }
    }

    public static void loggerStop() throws FacadeLoggerException {
        try {
            loggerController.parseMessage(new StopMessage(new StringBuilder(""),
                    new StringFormatter()));
        } catch (LoggerControllerException e) {
            throw new FacadeLoggerException("facade exception", e);
        }
    }

    public static void main(String[] args) {
    }
}

