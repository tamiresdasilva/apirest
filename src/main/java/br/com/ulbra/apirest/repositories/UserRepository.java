package br.com.ulbra.apirest.repositories;

import br.com.ulbra.apirest.models.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Repository
public class UserRepository {
    private List<User> list = new ArrayList<>();

    public UserRepository() {
        list.add(new User(1L, "Maria", "maria@rede.ulbra.br"));
        list.add(new User(2L, "João", "joao@rede.ulbra.br"));
        list.add(new User(3L, "Fernanda", "fernanda@rede.ulbra.br"));
    }

    public List<User> getUsers(){
        return list;
    }

    public User getUser(Long id){
        return list
                .stream()
                .filter(item -> Objects.equals(item.getId(), id))
                .findFirst()
                .orElseThrow();
    }

    public User createUser(User user){
        list.add(user);
        return user;
    }

    public void deleteUser(Long id){
        User user = list
                .stream()
                .filter(item -> Objects.equals(item.getId(), id))
                .findFirst()
                .orElseThrow();

        list.remove(user);
    }
}
