package com.igrod.spring_study.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.igrod.spring_study.entity.Usuario;
import com.igrod.spring_study.repository.UsuarioRepository;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository repo;

    public List<Usuario> listarTodos() {
        return repo.findAll();
    }

    @Transactional
    public Usuario novo(Usuario usuario) {
        if(usuario == null || 
                usuario.getNome() == null ||
                usuario.getNome().isBlank() ||
                usuario.getSenha() == null ||
                usuario.getSenha().isBlank()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dados inválidos!");
        }
        return repo.save(usuario);
    }

    public Usuario buscarPorId(Long idUsuario) {
        Optional<Usuario> usuarioOp = repo.findById(idUsuario);
        if(usuarioOp.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado!");
        }
        return usuarioOp.get();
    }

}
