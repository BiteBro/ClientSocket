package edu.clientSocket;

public class NameClientSetter {
    private static String nameClient;
        
    public static String getCommandArgsName(String[] args){
        StringBuilder name = new StringBuilder();
        if (args.length != 0) {
             for (int i = 0; i < args.length; i++) {
                 name.append(args[i]);
            }
            nameClient = name.toString();
        } else nameClient = "Unknown";
        return nameClient;        
    }

    public static String getNameClient() {
        return nameClient;
    }    
}
