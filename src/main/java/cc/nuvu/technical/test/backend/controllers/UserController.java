package cc.nuvu.technical.test.backend.controllers;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.*;

import cc.nuvu.technical.test.backend.models.UserModel;
import cc.nuvu.technical.test.backend.services.UserService;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping("/usuario")
public class UserController {
	
    @Autowired
    UserService userService;

    @GetMapping()
    public ArrayList<UserModel> obtenerUsuarios(){
        return this.userService.findAllUser();
    }
    
    @GetMapping( path = "/{id}")
    public Optional<UserModel> obtenerUsuarioPorId(@PathVariable("id") Long id) {
        return this.userService.findUserById(id);
    }

    @PostMapping()
    public UserModel crearUsuario(@RequestBody UserModel usuario){
    	//usuario.setPassword(new BCryptPasswordEncoder().encode(usuario.getPassword()));
        return this.userService.saveUser(usuario);
    }

    @PutMapping()
    public String modificarUsuario(@RequestBody UserModel usuario){
    	//usuario.setPassword(new BCryptPasswordEncoder().encode(usuario.getPassword()));
        return this.userService.updateUser(usuario);
    }
    
    @DeleteMapping( path = "/{id}")
	public String borrarUsuario(@PathVariable Long id){
		return this.userService.deleteUser(id);
		}
    
	@PostMapping( path = "/login")
	public Map<String, String> login(@RequestParam("user") String username, @RequestParam("password") String pwd) {
		if (this.userService.validateUser(username, pwd)) {
			Map<String, String> token = new HashMap<>();
			token.put("Token", getJWTToken(username));
			return token;
		}
		Map<String, String> error = new HashMap<>();
		error.put("Error:", "Usuario no existe / Contraseña incorrecta");
		return error;
	}

	private String getJWTToken(String username) {
		String secretKey = "mySecretKey";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ROLE_USER");
		
		String token = Jwts
				.builder()
				.setId("softtekJWT")
				.setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(SignatureAlgorithm.HS512,
						secretKey.getBytes()).compact();

		return "Bearer " + token;
	}
}