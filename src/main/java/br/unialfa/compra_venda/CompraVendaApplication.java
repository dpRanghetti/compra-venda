package br.unialfa.compra_venda;

import br.unialfa.compra_venda.model.Compra;
import br.unialfa.compra_venda.model.ItemCompra;
import br.unialfa.compra_venda.model.Usuario;
import br.unialfa.compra_venda.repository.UsuarioRepository;
import br.unialfa.compra_venda.service.CompraService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;

@SpringBootApplication
public class CompraVendaApplication {

    public static void main(String[] args) {
        SpringApplication.run(CompraVendaApplication.class, args);
    }

    @Bean
    public CommandLineRunner initDataBase(CompraService service, UsuarioRepository usuarioRepository) {
        return args -> {
            for (int i = 1; i <= 10; i++) {
                var itemA = new ItemCompra(null, null, 10, 10F, "Item A");
                var itemB = new ItemCompra(null, null, 10, 10F, "Item B");
                var compra = new Compra(null, "Fornecedor " + i, Arrays.asList(itemA, itemB));
                service.salvar(compra);
            }

            usuarioRepository.save(new Usuario(null, "admin", new BCryptPasswordEncoder().encode("admin"), "Admin", "ADMIN"));
            usuarioRepository.save(new Usuario(null, "user", new BCryptPasswordEncoder().encode("user"), "user", "USER"));
        };
    }

}
