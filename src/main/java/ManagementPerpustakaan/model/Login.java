package ManagementPerpustakaan.model;

import java.util.Scanner;

public class Login {
    private Scanner input;

    public Login() {
        input = new Scanner(System.in);
    }

    public void startLogin() {
        boolean isLoggedIn = false;

        while (!isLoggedIn) {
            try {
                System.out.print("Username: ");
                String username = input.nextLine();
                System.out.print("Password: ");
                String password = input.nextLine();

                // Memeriksa kredensial login
                if (authenticate(username, password)) {
                    System.out.println("Login berhasil!");
                    isLoggedIn = true;
                } else {
                    throw new Exception("Kredensial login salah. Silakan coba lagi!");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private boolean authenticate(String username, String password) {
        // Logika autentikasi
        // Mengembalikan true jika kredensial benar, false jika tidak
        return username.equals("admin") && password.equals("password");
    }
}

//package ManagementPerpustakaan.model;
//
//
//import java.util.Scanner;
//
//
//public class Login {
//    /**
//     * @param args
//     */
//    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        boolean isLoggedIn = false;
//
//        while (!isLoggedIn) {
//            try {
//                System.out.print("Username: ");
//                String username = input.nextLine();
//                System.out.print("Password: ");
//                String password = input.nextLine();
//
//                // Memeriksa kredensial login
//                if (authenticate(username, password)) {
//                    System.out.println("Login berhasil!");
//                    isLoggedIn = true;
//                } else {
//                    throw new Exception("Kredensial login salah. Silakan coba lagi!");
//                }
//            } catch (Exception e) {
//                System.out.println("Error: " + e.getMessage());
//            }
//        }
//    }
//
//    private static boolean authenticate(String username, String password) {
//        // Logika autentikasi
//        // Mengembalikan true jika kredensial benar, false jika tidak
//        return username.equals("admin") && password.equals("password");
//    }
//}
