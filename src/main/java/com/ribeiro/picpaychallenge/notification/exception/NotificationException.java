package com.ribeiro.picpaychallenge.notification.exception;

public class NotificationException extends  RuntimeException{
    public NotificationException() {
        super("Error sending notification!");
    }
}
