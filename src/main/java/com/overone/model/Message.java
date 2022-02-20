package com.overone.model;

import java.util.Objects;

public class Message {
    private Long id;
    private String time;
    private String sender;
    private String text;

    public Message() {
    }

    public Message(Long id, String time, String sender, String text) {
        this.id = id;
        this.time = time;
        this.sender = sender;
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", time='" + time + '\'' +
                ", sender='" + sender + '\'' +
                ", text='" + text + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return Objects.equals(id, message.id) && Objects.equals(time, message.time) && Objects.equals(sender, message.sender) && Objects.equals(text, message.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, time, sender, text);
    }
}
