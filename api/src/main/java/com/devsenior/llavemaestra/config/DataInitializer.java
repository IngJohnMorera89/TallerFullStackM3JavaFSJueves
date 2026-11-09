package com.devsenior.llavemaestra.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.devsenior.llavemaestra.model.Categoria;
import com.devsenior.llavemaestra.model.Herramienta;
import com.devsenior.llavemaestra.model.Rol;
import com.devsenior.llavemaestra.model.Usuario;
import com.devsenior.llavemaestra.repository.HerramientaRepository;
import com.devsenior.llavemaestra.repository.UsuarioRepository;

@Component
public class DataInitializer implements CommandLineRunner {

    private static final String CLAVE_DEMO = "llave123";

    private final UsuarioRepository usuarioRepository;
    private final HerramientaRepository herramientaRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(UsuarioRepository usuarioRepository, HerramientaRepository herramientaRepository,
            PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.herramientaRepository = herramientaRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        if (usuarioRepository.count() > 0) {
            return;
        }



        // ---------- Usuarios ----------
        usuario("Hernán Rojas", "admin@llavemaestra.co", Rol.ADMIN, true);
        usuario("Pedro Salazar", "pedro@correo.com", Rol.CLIENTE, true);
        usuario("Diana Mejía", "diana@correo.com", Rol.CLIENTE, true);
        usuario("Jorge Pinzón", "jorge@correo.com", Rol.CLIENTE, false);

        // ---------- Herramientas ----------
        herramienta("Taladro percutor", Categoria.ELECTRICA, 25000, 100000, 3, true,
                "Taladro percutor para concreto y mampostería",
                "https://loremflickr.com/400/300/drill,tool");
        herramienta("Pulidora angular", Categoria.ELECTRICA, 22000, 80000, 2, true,
                "Pulidora angular de 4 1/2 pulgadas",
                "https://loremflickr.com/400/300/grinder,tool");
        herramienta("Mezcladora de concreto", Categoria.CONSTRUCCION, 60000, 300000, 1, true,
                "Mezcladora de concreto para obra",
                "https://loremflickr.com/400/300/concrete,mixer");
        herramienta("Andamio tubular", Categoria.CONSTRUCCION, 15000, 120000, 4, true,
                "Andamio tubular para alturas",
                "https://loremflickr.com/400/300/scaffold");
        herramienta("Guadañadora", Categoria.JARDIN, 35000, 150000, 2, true,
                "Guadañadora para jardín y lote",
                "https://loremflickr.com/400/300/trimmer,garden");
        herramienta("Nivel láser", Categoria.MEDICION, 30000, 200000, 1, false,
                "Nivel láser en mantenimiento",
                "https://loremflickr.com/400/300/laser,level");
    }

    private void usuario(String nombre, String email, Rol rol, boolean activo) {
        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setEmail(email);
        usuario.setPassword(passwordEncoder.encode(CLAVE_DEMO));
        usuario.setRol(rol);
        usuario.setActivo(activo);
        usuarioRepository.save(usuario);
    }

    private void herramienta(String nombre, Categoria categoria, int precioDia, int deposito,
            int unidades, boolean activa, String descripcion, String imagenUrl) {
        Herramienta herramienta = new Herramienta();
        herramienta.setNombre(nombre);
        herramienta.setCategoria(categoria);
        herramienta.setPrecioDia(precioDia);
        herramienta.setDeposito(deposito);
        herramienta.setUnidades(unidades);
        herramienta.setActiva(activa);
        herramienta.setDescripcion(descripcion);
        herramienta.setImagenUrl(imagenUrl);
        herramientaRepository.save(herramienta);
    }
}
