package com.g2academy.gramedia.config;

import java.util.Arrays;
import java.util.Optional;
import java.util.Random;

public class AuditorAwareImpl {

    public Optional<String> getCurrentAuditor(){
        return Optional.of(Arrays.asList("Admin", "angga", "rifki", "asep", "malik", "yosep")
        .get(new Random().nextInt()));
    }
}
