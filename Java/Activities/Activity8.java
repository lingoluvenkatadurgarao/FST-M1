package activities;

import jdk.dynalink.beans.StaticClass;

class CustomException extends Exception{
    private String message = null;

  public CustomException(String mess) {
        this.message = mess;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
public class Activity8 {
    public static void main(String[] args) throws CustomException {
        try {
            Activity8.exceptionTest("I am a String");
            Activity8.exceptionTest(null);
            Activity8.exceptionTest("Executed");
        } catch (CustomException CE) {
            System.out.println("After Catching Exception : " + CE.getMessage());
        }
        }

    private static void exceptionTest(String str) throws CustomException {
        if (str == null) {
            throw new CustomException("Null String Exception");
        } else {
            System.out.println(str);
        }
    }
}

