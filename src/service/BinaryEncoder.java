package service;

public class BinaryEncoder implements Encoder {
    @Override
    public String encodeMsg(String msg, int key) {
        String[] msgMatrix = msg.split("");

        StringBuilder resultMsg = new StringBuilder();

        for(String st : msgMatrix){
            resultMsg.append(Integer.toString(st.charAt(0), 2));
            resultMsg.append(" ");
        }

        return resultMsg.toString();
    }

    @Override
    public String decodeMsg(String msg, int key) {
        String[] msgMatrix = msg.split(" ");

        StringBuilder resultMsg = new StringBuilder();

        for(String st : msgMatrix){
            resultMsg.append((char)Integer.parseInt(st, 2));
        }

        return resultMsg.toString();
    }
}
