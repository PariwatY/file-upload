package com.cpn.fileuploadcpn.config;

import com.cpn.fileuploadcpn.entity.ConfigEntity;
import com.cpn.fileuploadcpn.repository.ConfigRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Optional;
import java.util.Properties;

@Configuration
@RequiredArgsConstructor
public class EmailConfig {
    private final ConfigRepository configRepository;

    @Bean
    public JavaMailSender javaMailSender() {
        Optional<ConfigEntity> optSmtpUsername = configRepository.findById("SMTP_USERNAME");
        Optional<ConfigEntity> optSmtpPassword = configRepository.findById("SMTP_PASSWORD");
        String smtpUsername = "";
        if (optSmtpUsername.isPresent()) {
            smtpUsername = optSmtpUsername.get().getConfigValue();
        }

        String smtpPassword = "";
        if (optSmtpPassword.isPresent()) {
            smtpPassword = optSmtpPassword.get().getConfigValue();
        }

        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);

        mailSender.setUsername(smtpUsername);
        mailSender.setPassword(smtpPassword);

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "false");

        return mailSender;
    }
}
