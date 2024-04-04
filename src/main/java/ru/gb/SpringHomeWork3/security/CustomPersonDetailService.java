package ru.gb.SpringHomeWork3.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import ru.gb.SpringHomeWork3.entity.Person;
import ru.gb.SpringHomeWork3.repository.PersonRepository;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CustomPersonDetailService implements UserDetailsService {

    private final PersonRepository personRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Person person = personRepository.findByLogin(username).orElseThrow(
                () -> new UsernameNotFoundException("Пользователь с таким логином: " + username + " не найден!")
        );

        return new User(person.getLogin(), person.getPassword(), List.of(
                new SimpleGrantedAuthority(person.getRole())
        ));
    }
}
