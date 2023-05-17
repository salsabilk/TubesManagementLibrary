package ManagementPerpustakaan.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    /**
     * @return
     */
    @RequestMapping(" ")
    public String showLoginForm() {
        return ""; // Mengembalikan nama halaman login
    }

    /**
     * @param request
     * @return
     */
    @PostMapping(" ")
    public String processLogin(HttpServletRequest request) {
        final String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Proses verifikasi username dan password
        if (username.equals("admin") && password.equals("password")) {
            return "redirect:"; // Jika berhasil, redirect ke halaman dashboard
        } else {
            return "redirect:/index?error"; // Jika gagal, redirect kembali ke halaman login dengan parameter error
        }
    }

    @RequestMapping("/home")
    public String showLogin() {
        return "/home"; // Mengembalikan nama halaman dashboard
    }

}