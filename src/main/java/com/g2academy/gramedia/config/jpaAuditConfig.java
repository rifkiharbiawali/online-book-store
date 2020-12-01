package com.g2academy.gramedia.config;

import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class jpaAuditConfig {
}
