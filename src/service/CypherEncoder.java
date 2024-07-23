package service;

public class CypherEncoder implements Encoder {
    @Override
    public String encodeMsg(String msg, int key) {
        String[] msgMatrix = msg.split("");

        StringBuilder resultMsg = new StringBuilder();

        for(String st : msgMatrix){
            if(Character.isSpaceChar(st.charAt(0))){
                resultMsg.append(st.charAt(0));
                resultMsg.append(" ");
            } else {
                int resultChar = st.charAt(0) + key;
                if (Character.isLowerCase(st.charAt(0))) {
                    if (resultChar > 122) {
                        resultChar -= 26;
                    }
                } else if (Character.isUpperCase(st.charAt(0))) {
                    if (resultChar > 90) {
                        resultChar -= 26;
                    }
                }

                resultMsg.append((char) resultChar);
            }
        }

        return resultMsg.toString();
    }

    @Override
    public String decodeMsg(String msg, int key) {
        String[] msgMatrix = msg.split("");

        StringBuilder resultMsg = new StringBuilder();

        for(String st : msgMatrix){
            if(Character.isSpaceChar(st.charAt(0))){
                resultMsg.append(st.charAt(0));
                resultMsg.append(" ");
            } else {
                int resultChar = st.charAt(0) - key;
                if (Character.isLowerCase(st.charAt(0))) {
                    if (resultChar < 97) {
                        resultChar += 26;
                    }
                } else if (Character.isUpperCase(st.charAt(0))) {
                    if (resultChar < 65) {
                        resultChar += 26;
                    }
                }

                resultMsg.append((char) resultChar);
            }
        }

        return resultMsg.toString();
    }
}
