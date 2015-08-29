package de.codingdojo.dropwizard.tutorial.core;

import com.google.common.base.Optional;
import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;
import io.dropwizard.auth.basic.BasicCredentials;


public class SimpleAuthenticator implements Authenticator<BasicCredentials, User> {

    public Optional<User> authenticate(BasicCredentials credentials) throws AuthenticationException {

        if ("pass".equals(credentials.getPassword())) {
            return Optional.of(new User(credentials.getUsername()));
        }
        return Optional.absent();
    }

}