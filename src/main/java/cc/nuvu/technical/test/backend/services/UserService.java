package cc.nuvu.technical.test.backend.services;

import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import cc.nuvu.technical.test.backend.models.UserModel;
import cc.nuvu.technical.test.backend.repositories.UserRepository;

@Service
public class UserService {
	
    @Autowired
    UserRepository userRepository;
    
	public ArrayList<UserModel> findAllUser(){
		return (ArrayList<UserModel>) userRepository.findAll();
	}
	
	public Optional<UserModel> findUserById(Long id){
		return userRepository.findById(id);
	}
    
    public UserModel saveUser(UserModel user){
        return userRepository.save(user);
    }
    
	public String deleteUser(Long id){
		if (userRepository.findById(id).isPresent()){
			userRepository.deleteById(id);
			return "Usuario eliminado correctamente.";
			}
		return "Error! El usuario no existe.";
	}
	
	public String updateUser(UserModel userToUpdate){
		if (userRepository.findById(userToUpdate.getId()).isPresent()){
			userRepository.save(userToUpdate);
			return "Usuario modificado.";
			}
		return "Error al modificar el Usuario.";
	}
	
	public boolean validateUser(String user, String pasword) {
		UserModel userModel = userRepository.getValidUser(user, pasword);
		if (userModel != null) return true;
		else return false;
	}
}
