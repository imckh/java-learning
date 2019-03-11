package java_multi_thread_programming.c1.s2.p3.threadsafe;

public class LoginServlet {
    private static String usernameRef;
    private static String passwordRef;

    // 这里加上synchronized
    public static void doPost(String username, String password) {
        try {
            usernameRef = username;
            if (username.equals("a")) {
                Thread.sleep(5000);
            }
            passwordRef = password;
            System.out.print("username = " + username + " password = " + password);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
