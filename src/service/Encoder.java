package service;

public interface Encoder {

    String encodeMsg(String msg, int key);
    String decodeMsg(String msg, int key);
}
