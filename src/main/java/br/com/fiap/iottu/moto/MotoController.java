package br.com.fiap.iottu.moto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/")
public class MotoController {

    @Autowired
    private MotoService motoService;

    @GetMapping
    public String listarMotos(Model model) {
        model.addAttribute("motos", motoService.buscarTodas());
        return "moto/lista";
    }

    @GetMapping("/cadastrar")
    public String mostrarFormularioCadastro(Model model) {
        model.addAttribute("moto", new Moto());
        return "moto/cadastrar";
    }

    @PostMapping("/cadastrar")
    public String salvarMoto(Moto moto, RedirectAttributes attributes) {
        motoService.salvarMoto(moto);
        attributes.addFlashAttribute("mensagem", "Moto cadastrada com sucesso!");
        return "redirect:/";
    }
}